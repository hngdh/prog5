package io.input;

import enums.Transport;
import exceptions.LogException;
import io.LogUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import main_objects.Coordinates;
import main_objects.Flat;
import main_objects.House;

/**
 * The {@code Builder} class provides static methods for parsing data from a list of strings and
 * constructing {@link main_objects.Flat} and related objects ({@link main_objects.House}, {@link
 * main_objects.Coordinates}). It handles parsing and validation of data, including handling "null"
 * values from files and throwing appropriate exceptions if parsing fails or data is invalid.
 */
public class Builder {
  public static Flat buildFlat(List<String> flatInfo, List<String> houseInfo) throws LogException {
    Flat flat = new Flat();
    try {
      String name = flatInfo.get(0);
      flat.setName(name);

      float x = Float.parseFloat(flatInfo.get(1));
      float y = Float.parseFloat(flatInfo.get(2));
      Coordinates coordinates = new Coordinates(x, y);
      flat.setCoordinates(coordinates);

      LocalDate creationDate =
          LocalDate.parse(flatInfo.get(3), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
      flat.setCreationDate(creationDate);

      long area = Long.parseLong(flatInfo.get(4));
      flat.setArea(area);

      int numberOfRooms = Integer.parseInt(flatInfo.get(5));
      flat.setNumberOfRooms(numberOfRooms);

      Long livingSpace = Long.parseLong(flatInfo.get(6));
      flat.setLivingSpace(livingSpace);

      boolean centralHeating = Boolean.parseBoolean(flatInfo.get(7));
      flat.setCentralHeating(centralHeating);

      Transport transport = Transport.valueOf(flatInfo.get(8).toUpperCase());
      flat.setTransport(transport);

      flat.setHouse(buildHouse(houseInfo));
    } catch (IllegalArgumentException e) {
      LogUtil.log(e);
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
      LogUtil.log(e);
      throw new LogException();
    }
    return house;
  }
}
