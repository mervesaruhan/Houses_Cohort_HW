package Repository;

import Model.Home;
import Model.SummerHouse;
import Model.Villa;

import java.util.ArrayList;
import java.util.List;

public class HouseRepository {

    private  final List<Home> homes = new ArrayList<>();
    private  final List<SummerHouse> summerHouses = new ArrayList<>();
    private  final List<Villa> villas = new ArrayList<>();

    public HouseRepository() {
        homes.add(new Home(500_000,110,3,1));
        homes.add(new Home(600_000,130,4,1));
        homes.add(new Home(900_000,200,6,2));

        villas.add(new Villa(1_000_000,250,4,2));
        villas.add(new Villa(1_200_000,280,5,2));
        villas.add(new Villa(1_500_000,330,7,3));

        summerHouses.add(new SummerHouse(400_000,90,2,1));
        summerHouses.add(new SummerHouse(600_000,120,3,1));
        summerHouses.add(new SummerHouse(800_000,150,4,2));

    }

    public List<Home> getHomeList(){
        return homes;
    }

    public List<Villa> getVillaList(){
        return villas;
    }

    public List<SummerHouse> getSummerHouseList(){
        return summerHouses;
    }


}
