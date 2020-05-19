package com.company;

import com.company.model.Codetriage;
import com.company.model.Mitra;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    public void writeFile(String fileName, List<Mitra> data) throws IOException {
        FileWriter csvWriter = new FileWriter(fileName);
        csvWriter.append("star");
        csvWriter.append("review");

        csvWriter.append("\n");

        for (Mitra rowData : data) {

            csvWriter.append(rowData.getStar() + "," +
                    rowData.getReview()

            );
            csvWriter.append("\n");

        }

        csvWriter.flush();
        csvWriter.close();

    }
}
