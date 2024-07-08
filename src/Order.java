import java.time.LocalDateTime;

public class Order {
    private int orderId;
    private int dishId;
    private String dishTitle;
    private int dishQuantity;
    private int amount;
    private int tableId;
    private LocalDateTime orderedTime;
    private LocalDateTime fulfilmentTime;
    private boolean paid;

    public Order(int orderId, int dishId, String dishTitle, int dishQuantity, int amount, int tableId, LocalDateTime orderedTime, LocalDateTime fulfilmentTime, boolean paid){
        this.orderId = orderId;
        this.dishId = dishId;
        this.dishTitle = dishTitle;
        this.dishQuantity = dishQuantity;
        this.tableId = tableId;
        this.orderedTime = orderedTime;
        this.fulfilmentTime = fulfilmentTime;
        this.paid = paid;
    }

    public void addDish(int orderId, int dishId, String dishTitle, int dishQuantity, int amount, int tableId, LocalDateTime orderedTime, LocalDateTime fulfilmentTime, boolean paid){
        Dish newDish = new Dish(orderId, dishId, dishTitle, dishQuantity, amount, tableId, orderedTime, fulfilmentTime, paid);
    }

    public boolean orderFinished(){
        return this.getFulfilmentTime() != null;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getDishQuantity() {
        return dishQuantity;
    }

    public void setDishQuantity(int dishQuantity) {
        this.dishQuantity = dishQuantity;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(LocalDateTime orderedTime) {
        this.orderedTime = orderedTime;
    }

    public LocalDateTime getFulfilmentTime() {
        return fulfilmentTime;
    }

    public void setFulfilmentTime(LocalDateTime fulfilmentTime) {
        this.fulfilmentTime = fulfilmentTime;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getDishTitle() {
        return dishTitle;
    }

    public void setDishTitle(String dishTitle) {
        this.dishTitle = dishTitle;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
