import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RestaurantManager {

    public static void ordersInProgress(List<Order> ordersList) {
        for (Order order : ordersList) {
            if (!order.orderFinished()) {
                System.out.println("The order " + order.getOrderId() + "has not been finished yet");
            }
        }
    }

    public static void sortOrdersByTime(List<Order> ordersList) {
        ordersList.sort(Comparator.comparing(Order::getOrderedTime));
        System.out.println("Find list of orders sorted by ordered time below: \n");
        for (Order orders : ordersList) {
            System.out.println(orders.getOrderId() + " " + orders.getDishId() + " " + orders.getDishQuantity() + " " + orders.getTableId() + " " + orders.getOrderedTime());
        }
    }

    public static void averageFulfilmentTime(List<Order> ordersList) {
        long fulfilmentTime = 0;
        int averageFulfilmentTime = 0;
        long timeBetween = 0;
        List<Order> fulfiledList = new ArrayList<>();
        for (Order orders : ordersList) {
            if (orders.orderFinished() == true) {
                timeBetween = ChronoUnit.MINUTES.between(orders.getOrderedTime(), orders.getFulfilmentTime());
                fulfilmentTime = fulfilmentTime + timeBetween;
                fulfiledList.add(orders);
            }
        }
        System.out.println("The average fulfilment time of the order is " + averageFulfilmentTime + " minutes\n");
    }

    public static void dishesOrderedToday(List<Order> ordersList) {
        System.out.println("Today's orders:");
        for (Order orders : ordersList) {
            System.out.println("Dish ID:" + orders.getDishId());
        }

    }
    public static String paid(Order orders){
        if (orders.isPaid() == true){
            return "Paid";
        }
        else {
            return "";
        }
    }

    public static void ordersExport(List<Order> ordersList, int tableId) {
        System.out.println("List of orders for specific table:");
        for (Order orders : ordersList) {
            System.out.println(orders.getDishId() + ". " + " "
            + orders.getDishTitle() + " "
            + orders.getDishQuantity() + " " + "(" + orders.getAmount() + " Kč" + ")"
            + " :" + "/t"
            + orders.getOrderedTime()
            + "-"
            + orders.getFulfilmentTime() + "/t"
            + paid(orders));
        }
    }
}


