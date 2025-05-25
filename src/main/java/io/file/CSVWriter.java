package io.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private final BufferedWriter bufferedWriter;

    public CSVWriter(String fileName) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
    }

    public void writeLines(List<StringBuilder> flat) throws IOException {
        for (int i = 0; i < flat.size() - 1; i++) {
            bufferedWriter.write(flat.get(i).append(",").toString());
        }
        bufferedWriter.write(flat.get(flat.size() - 1).toString() + "\n");
        bufferedWriter.flush();
    }
}