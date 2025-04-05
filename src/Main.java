import Model.BaseHouse;
import Model.Home;
import Model.SummerHouse;
import Model.Villa;
import Repository.HouseRepository;
import Service.HouseService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HouseRepository repository = new HouseRepository();
        HouseService service = new HouseService();

        List<Home> homes = repository.getHomeList();
        List<Villa>  villas = repository.getVillaList();
        List<SummerHouse> summerHouses =repository.getSummerHouseList();

        System.out.println("------ TOTAL PRICES ------");
        System.out.println("Total price of Homes: " + service.getTotalPriceOfHomes(homes));
        System.out.println("Total price of Villas: " + service.getTotalPriceOfVillas(villas));
        System.out.println("Total price of Summer Houses: " + service.getTotalPriceOfSummerHouses(summerHouses));
        System.out.println("Total price of ALL Houses: " + service.getTotalPriceOfAllHouses(homes, villas, summerHouses));

        System.out.println("\n------ AVERAGE AREAS ------");
        System.out.println("Average area of Homes: " + service.getAverageAreaOfHomes(homes));
        System.out.println("Average area of Villas: " + service.getAverageAreaOfVillas(villas));
        System.out.println("Average area of Summer Houses: " + service.getAverageAreaOfSummerHouses(summerHouses));
        System.out.println("Average area of ALL Houses: " + service.getAverageAreaOfAllHouses(homes, villas, summerHouses));

        System.out.println("\n------ FILTERED HOUSES ------");

        // Kullanıcıdan filtre değerlerini alma
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rooms: ");
        int rooms = scanner.nextInt();

        System.out.print("Enter number of living rooms: ");
        int livingRooms = scanner.nextInt();

        List<BaseHouse> filtered =service.filterByRoomsAndLivingRooms(homes, villas,summerHouses,rooms,livingRooms);
        System.out.println("Matching house count: " + filtered.size());
    }
}