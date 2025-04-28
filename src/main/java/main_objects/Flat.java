package main_objects;

import enums.Transport;
import io_utilities.Printer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Flat {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long area; //Максимальное значение поля: 700, Значение поля должно быть больше 0
    private int numberOfRooms; //Значение поля должно быть больше 0
    private Long livingSpace; //Значение поля должно быть больше 0
    private boolean centralHeating;
    private Transport transport; //Поле не может быть null
    private House house; //Поле может быть null

    public Flat() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Long getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(Long livingSpace) {
        this.livingSpace = livingSpace;
    }

    public boolean isCentralHeating() {
        return centralHeating;
    }

    public void setCentralHeating(boolean centralHeating) {
        this.centralHeating = centralHeating;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void printEverything() {
        Printer.printCondition("*Flat's information*");
        Printer.printResult("ID: " + this.id);
        Printer.printResult("Name: " + this.name);
        Printer.printResult("Coordinate: " + this.coordinates.toString());
        Printer.printResult("Creation date: " + this.creationDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        Printer.printResult("Area: " + this.area);
        Printer.printResult("Number of rooms: " + this.numberOfRooms);
        Printer.printResult("Living space: " + this.livingSpace);
        Printer.printResult("Central heating: " + this.centralHeating);
        Printer.printResult("Transport: " + this.transport);
        if (house != null) {
            Printer.printResult("House (name, construction year, number of lifts): " + house.toString());
        } else {
            Printer.printResult("House: no information");
        }
    }

    public List<StringBuilder> getAllFields() {
        List<StringBuilder> fields = new LinkedList<>();
        fields.add(new StringBuilder(Integer.toString(this.id)));
        fields.add(new StringBuilder(this.name));
        fields.add(new StringBuilder(String.valueOf(this.coordinates.getX())));
        fields.add(new StringBuilder(String.valueOf(this.coordinates.getY())));
        fields.add(new StringBuilder(this.creationDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        fields.add(new StringBuilder(String.valueOf(this.area)));
        fields.add(new StringBuilder(String.valueOf(this.numberOfRooms)));
        fields.add(new StringBuilder(String.valueOf(this.livingSpace)));
        fields.add(new StringBuilder(String.valueOf(this.centralHeating)));
        fields.add(new StringBuilder(String.valueOf(this.transport)));
        if (this.house != null) {
            fields.add(new StringBuilder(String.valueOf(this.house.getName())));
            fields.add(new StringBuilder(String.valueOf(this.house.getYear())));
            fields.add(new StringBuilder(String.valueOf(this.house.getNumberOfLifts())));
        } else {
            for (int i = 0; i < 3; i++) fields.add(new StringBuilder("null"));
        }
        return fields;
    }
}
