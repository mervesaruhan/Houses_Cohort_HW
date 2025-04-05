package Model;

public class BaseHouse {
    private double price;
    private double  area;
    private int numberOfRooms;
    private int numberOfLivingRooms;

    public BaseHouse(double price, double  area, int numberOfRooms, int numberOfLivingRooms) {
        this.price = price;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.numberOfLivingRooms = numberOfLivingRooms;
    }

    public double getPrice() {return price;}
    public double getArea() {return area;}
    public int getNumberOfRooms() {return numberOfRooms;}
    public int getNumberOfLivingRooms() {return numberOfLivingRooms;}

}
