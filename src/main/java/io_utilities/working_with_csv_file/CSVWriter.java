package io_utilities.working_with_csv_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private final BufferedWriter bufferedWriter;

    public CSVWriter(String fileName) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
    }

    public void writeLines(List<StringBuilder> flats) throws IOException {
        for (int i = 0; i < flats.size() - 1; i++) {
            if (i < flats.size() - 1) {
                bufferedWriter.write(flats.get(i).append(',').toString());
                bufferedWriter.flush();
            } else {
                bufferedWriter.write(flats.get(i).append(System.lineSeparator()).toString());
                bufferedWriter.flush();
            }
        }
    }
}
