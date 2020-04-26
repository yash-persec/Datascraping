package com.company;

import com.company.model.Codetriage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    public void writeFile(String fileName, List<Codetriage> data) throws IOException {
        FileWriter csvWriter = new FileWriter(fileName);
        csvWriter.append("title");
        csvWriter.append(",");
        csvWriter.append("issue");
        csvWriter.append(",");
        csvWriter.append("description");
        csvWriter.append(",");

        csvWriter.append("fullname");
        csvWriter.append(",");

        csvWriter.append("github_link");
        csvWriter.append("\n");

        for (Codetriage rowData : data) {

            csvWriter.append(rowData.getTitle() + "," +
                    rowData.getIssue() + "," +
                    rowData.getDescription() + "," +
                    rowData.getFullName() + "," +
                    rowData.getGithubLink()

            );
            csvWriter.append("\n");

        }

        csvWriter.flush();
        csvWriter.close();

    }
}
