import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Dish {

    private int id;
    private String title;
    private BigDecimal price;
    private int preparationTime;
    private String image;

    public Dish(int id, String title, BigDecimal price, int preparationTime, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.preparationTime = preparationTime;
        this.image = image;
    }

    public Dish(int orderId, int dishId, String dishTitle, int dishQuantity, int amount, int tableId, LocalDateTime orderedTime, LocalDateTime fulfilmentTime, boolean paid) {
    }

    public Dish() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        this.price = price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        if (preparationTime <= 0) {
            throw new IllegalArgumentException("Preparation time must be greater than zero.");
        }
        this.preparationTime = preparationTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) throws GetFoodException {
        if (image.isBlank()) {
            throw new GetFoodException("Item must have an image assigned.");
            }
        this.image = image;
    }

    // Method to add default photo is there is none
    public String getDefaultImage(){
        return "blank";
    }

    public void loadContentFromFile(String FoodList) {
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id =" + id +
                ", title=" + title + '\'' +
                '}';
    }

    public void remove(Dish dish) {
    }
}
