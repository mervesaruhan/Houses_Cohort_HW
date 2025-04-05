package Service;

import Model.BaseHouse;
import Model.Home;
import Model.SummerHouse;
import Model.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HouseService {

    // evlerin toplam fiyatını dönen metot
    public double getTotalPriceOfHomes(List<Home> homes){
        return getTotalPrice(homes);
    }

    //villaların toplam fiyatını dönen metot
    public double getTotalPriceOfVillas(List<Villa> villas){
        return getTotalPrice(villas);
    }

    //yazlık evlerin toplam fiyatını dönen metot
    public double getTotalPriceOfSummerHouses(List<SummerHouse> summerHouses){
        return getTotalPrice(summerHouses);
    }


    //tüm evlerin toplam fiyatını dönen metot
    public double getTotalPriceOfAllHouses(List<Home> homes, List<Villa> villas, List<SummerHouse> summerHouses){
        List<BaseHouse> allHouses = mergeAllHouses(homes,villas,summerHouses);
        return getTotalPrice(allHouses);
    }

    //evlerin ortalama büyüklüğünü hesaplayan metot
    public double getAverageAreaOfHomes(List<Home> homes){
        return getAverageArea(homes);
    }

    //villaların ortalama büyüklüğünü hesaplayan metot
    public double getAverageAreaOfVillas(List<Villa> villas){
        return getAverageArea(villas);
    }

    //yazlık evlerin ortalama büyüklüğünü hesaplayan metot
    public double getAverageAreaOfSummerHouses(List<SummerHouse> summerHouses){
        return getAverageArea(summerHouses);
    }

    //tüm evlerin ortalama büyklüğünü hesaplayan metot
    public double getAverageAreaOfAllHouses(List<Home> homes, List<Villa> villas, List<SummerHouse> summerHouses){
        List<BaseHouse> allHouses = mergeAllHouses(homes,villas,summerHouses);
        return getAverageArea(allHouses);
    }

    //Oda ve salon sayısına göre tüm tipteki evleri filtreleyip dönen metot
    public List<BaseHouse>  filterByRoomsAndLivingRooms(List<Home> homes, List<Villa> villas, List<SummerHouse> summerHouses, int room, int livingRoom){
        List<BaseHouse> allHouses = mergeAllHouses(homes,villas,summerHouses);

        List<BaseHouse> filtered = allHouses.stream()
                .filter(h -> h.getNumberOfRooms() == room  && h.getNumberOfLivingRooms() == livingRoom)
                .collect(Collectors.toList());

        printHouseDetails(filtered);

        return filtered;

    }


    //Basehouse'tan türeyen sınıfların toplam fiyatını hesaplayan metot
    public double getTotalPrice(List<? extends BaseHouse> houses){
        return houses.stream().mapToDouble(BaseHouse :: getPrice).sum();
    }

    //BaseHouse'tan türeyen sınıfların ortalama büyüklüğünü hesaplayan metot
    public double getAverageArea(List<? extends BaseHouse> houses){
        return houses.stream().mapToDouble(BaseHouse::getArea).average().orElse(0);
    }

    //tüm listeleri bir araya getiren metot
    public List<BaseHouse>  mergeAllHouses(List<Home> homes, List<Villa> villas, List<SummerHouse> summerHouses){
        List<BaseHouse> allHouses = new ArrayList<>();
        allHouses.addAll(homes);
        allHouses.addAll(villas);
        allHouses.addAll(summerHouses);
        return allHouses;
    }
    //Filte sonucu detay yazdırma
    public void printHouseDetails(List<? extends BaseHouse> houses) {
        houses.forEach(h -> System.out.println(
                "Type: " + h.getClass().getSimpleName() +
                        " | Price : " + h.getPrice() + " $" +
                        " | Area: " + h.getArea() + " m²" +
                        " | Rooms: " + h.getNumberOfRooms() +
                        " | Living Rooms: " + h.getNumberOfLivingRooms()
        ));
    }



}
