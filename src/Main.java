import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static <ordersList> void main(String[] args) {


        CookBook cookBook = new CookBook();


        new CookBook.saveFileCookBook();


        Dish kure = null;
        Dish hran = null;
        Dish pstruh = null;
        Dish kofola = null;
        List<Dish> dishList = null;
        try {
            RestaurantManager restaurantManager = new RestaurantManager();
            kure = new Dish(1, "Kuřecí řízek obalovaný 150 g", BigDecimal.valueOf(150), 20, "rizek");
            hran = new Dish(2, "Hranolky 150 g", BigDecimal.valueOf(50), 10, "hranolky");
            pstruh = new Dish(3, "Pstruh na víně 200 g", BigDecimal.valueOf(200), 20, "pstruh");
            kofola = new Dish(4, "Kofola 0,5 l", BigDecimal.valueOf(20), 20, "kofola");
            dishList = new ArrayList<>();
            dishList.add(kure);
            dishList.add(hran);
            dishList.add(pstruh);
            dishList.add(kofola);
        } catch (Exception e) {
            System.out.println("An error occurred while adding new dish.");
        }


        List<Order> ordersList = new ArrayList<>();
        Order order1 = new Order(1, 1, "Kuřecí řízek obalovaný 150 g", 2, 300, 15, LocalDateTime.of(2024, 6, 11, 12, 45, 24, 532), null, false);
        Order order2 = new Order(1, 2, "Hranolky 150 g", 2, 100, 15, LocalDateTime.of(2024, 6, 11, 12, 45, 24, 532), null, false);
        Order order3 = new Order(1, 4, "Kofola 0,5 l", 2, 100, 15, LocalDateTime.of(2024, 6, 11, 12, 45, 24, 532), LocalDateTime.of(2024, 6, 11, 12, 53, 37, 253), false);
        Order order4 = new Order(2, 3, "Pstruh na víně 200 g", 1, 200, 11, LocalDateTime.of(2024, 6, 11, 11, 26, 55, 351), LocalDateTime.of(2024, 6, 11, 11, 56, 44, 514), true);
        Order order5 = new Order(3, 2, "Hranolky 150 g", 1, 50, 13, LocalDateTime.of(2024, 6, 11, 12, 38, 11, 132), null, false);


        RestaurantManager restaurantManager = new RestaurantManager();
        restaurantManager.ordersExport(ordersList,15);


        restaurantManager.ordersInProgress();
        restaurantManager.averageFulfilmentTime();
        restaurantManager.dishesOrderedToday();
        restaurantManager.ordersInProgress();
        restaurantManager.ordersExport();


        public static void saveFiles() throw Exception {
            new CookBook.saveFileCookBook();
            new Order.saveFileOrders();
        }
    }
}