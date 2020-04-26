package com.company;

import com.company.model.Codetriage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.codetriage.com/?language=Java").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // With the document fetched, we use JSoup's title() method to fetch the title
        System.out.printf("Title: %s\n", doc.title());

        // Get the list of repositories
        Elements repositories = doc.getElementsByClass("repo-item");

        /**
         * For each repository, extract the following information:
         * 1. Title
         * 2. Number of issues
         * 3. Description
         * 4. Full name on github
         */

        List<Codetriage> codetriageList =  new ArrayList<>();
        for (Element repository : repositories) {
            // Extract the title
            String repositoryTitle = repository.getElementsByClass("repo-item-title").text();

            // Extract the number of issues on the repository
            String repositoryIssues = repository.getElementsByClass("repo-item-issues").text();

            // Extract the description of the repository
            String repositoryDescription = repository.getElementsByClass("repo-item-description").text();

            // Get the full name of the repository
            String repositoryGithubName = repository.getElementsByClass("repo-item-full-name").text();

            // The reposiory full name contains brackets that we remove first before generating the valid Github link.
            String repositoryGithubLink = "https://github.com/" + repositoryGithubName.replaceAll("[()]", "");

            // Format and print the information to the console
            Codetriage codetriage  =  new Codetriage();
            codetriage.setTitle(repositoryTitle);
            codetriage.setIssue(repositoryIssues);
            codetriage.setDescription(repositoryDescription);
            codetriage.setFullName(repositoryGithubName);
            codetriage.setGithubLink(repositoryGithubLink);
            codetriageList.add(codetriage);
                  }
          WriteFile writeFile  =  new WriteFile();

        try {
            writeFile.writeFile("data.csv",codetriageList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
