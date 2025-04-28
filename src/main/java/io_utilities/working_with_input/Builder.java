package io_utilities.working_with_input;

import enums.Transport;
import exceptions.LogException;
import io_utilities.LogUtil2;
import main_objects.Coordinates;
import main_objects.Flat;
import main_objects.House;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Builder {
    public static Flat buildFlat(List<String> flatInfo, List<String> houseInfo) throws LogException {
        Flat flat = new Flat();
        try {
            Integer id = Integer.parseInt(flatInfo.get(0));
            flat.setId(id);

            String name = flatInfo.get(1);
            flat.setName(name);

            float x = Float.parseFloat(flatInfo.get(2));
            float y = Float.parseFloat(flatInfo.get(3));
            Coordinates coordinates = new Coordinates(x, y);
            flat.setCoordinates(coordinates);

            LocalDate creationDate = LocalDate.parse(flatInfo.get(4), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            flat.setCreationDate(creationDate);

            long area = Long.parseLong(flatInfo.get(5));
            flat.setArea(area);

            int numberOfRooms = Integer.parseInt(flatInfo.get(6));
            flat.setNumberOfRooms(numberOfRooms);

            Long livingSpace = Long.parseLong(flatInfo.get(7));
            flat.setLivingSpace(livingSpace);

            boolean centralHeating = Boolean.parseBoolean(flatInfo.get(8));
            flat.setCentralHeating(centralHeating);

            Transport transport = Transport.valueOf(flatInfo.get(9).toUpperCase());
            flat.setTransport(transport);

            flat.setHouse(buildHouse(houseInfo));
        } catch (IllegalArgumentException e) {
            LogUtil2.log(e);
            throw new LogException();
        }
        return flat;
    }

    public static House buildHouse(List<String> houseInfo) throws LogException {
        House house = new House();
        try {
            if (houseInfo.get(1).equals("null") || houseInfo.get(2).equals("null")) {
                return null;
            } else {
                house.setName(houseInfo.get(0));
                house.setYear(Integer.parseInt(houseInfo.get(1)));
                house.setNumberOfLifts(Long.parseLong(houseInfo.get(2)));
            }
        } catch (Exception e) {
            LogUtil2.log(e);
            throw new LogException();
        }
        return house;
    }
}
