import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class CookBook {

    private Dish dish;
    private List<CookBook> cookBook;

    public static class saveFileCookBook {
        public saveFileCookBook loadDish(String FoodList) throws ResException {
            int lineCounter = 0;
            try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(FoodList)))) {
                while (scanner.hasNextLine()) {
                    lineCounter++;
                    String line = scanner.nextLine();
                    String[] parts = line.split(Settings.getDelimiter());
                    if (parts.length != 5) throw new ResException(
                            "Incorrect item number on line nr.: "+lineCounter+" in file "+FoodList+" \n");
                    int dishID = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    BigDecimal price = new BigDecimal(parts[2]);
                    int preparationTime = Integer.parseInt(parts[3]);
                    String image = parts[4];

                }
            } catch (FileNotFoundException e) {
                throw new ResException("File " +FoodList+ " was not found\n"+ e.getLocalizedMessage());
            }

            String filename = Settings.getFoodList();
            Order list = new Order();
            list.loadContentFromFile(filename);
            return null;
        }
    }

    public static void addDish(String fileName, Dish[] dishes) throws ResException {
        int lineCounter = 0;
        String delimiter = Settings.getDelimiter();
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (Dish dish : dishes) {
                writer.println(
                        dish.getId() + delimiter
                                + dish.getTitle() + delimiter
                                + dish.getPrice() + delimiter
                                + dish.getPrice() + delimiter
                                + dish.getImage());
            }
        } catch (FileNotFoundException e) {
            throw new ResException(" File " +fileName+ " was not found.\n" + e.getLocalizedMessage());
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while adding new item to" +fileName+ ":\n" + e.getLocalizedMessage());
        }
    }

    public void removeDish(Dish dish){
        dish.remove(dish);
    }
}
