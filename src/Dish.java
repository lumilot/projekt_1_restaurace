import java.math.BigDecimal;

public class Dish {

    private int id;
    private String title;
    private BigDecimal price;
    private int preparationTime;
    private String image;


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

    public void setImage(String image) {
        this.image = image;
    }

    public void loadContentFromFile(String FoodList) {
    }
}
