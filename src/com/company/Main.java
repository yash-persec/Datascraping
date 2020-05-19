package com.company;

import com.company.model.Codetriage;
import com.company.model.Mitra;
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

        
        List<Mitra> mitraArrayList =  new ArrayList<>();
        for (Element repository : repositories) {
            String star = repository.getElementsByClass("").text();
            String review = repository.getElementsByClass("").text();
            Mitra mitra =  new Mitra();
            mitra.setStar(star);
            mitra.setReview(review);
            mitraArrayList.add(mitra);
                  }
          WriteFile writeFile  =  new WriteFile();

        try {
            writeFile.writeFile("data.csv",mitraArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
