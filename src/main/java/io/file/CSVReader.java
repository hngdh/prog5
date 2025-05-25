package io.file;

import exceptions.LogException;
import exceptions.WrongDataException;
import io.input.Builder;
import main_objects.Flat;

import java.io.IOException;
import java.util.List;

public class CSVReader {
    private final FileProcessor processor;

    public CSVReader() throws IOException {
        processor = new FileProcessor();
    }

    public Flat loadObj(String str) throws WrongDataException, LogException {
        List<String> flatInfo = processor.checkFlatInfo(str);
        List<String> houseInfo = processor.checkHouseInfo(str);

        return Builder.buildFlat(flatInfo, houseInfo);
    }
}
