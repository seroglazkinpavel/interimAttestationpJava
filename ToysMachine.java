import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ToysMachine {
    private HashMap<Integer, Toys> bd;
    private HashMap<Integer, Integer> toys;
    private Scanner scanner;

    public ToysMachine() {
        bd = new HashMap<>();
        toys = new HashMap<>();
        loadingToy();
        writing_to_file();
    }

    // Выдать случайную игрушку
    public Toys getRandomToy() {
        loadingToy();
        List<Toys> valuesList = new ArrayList<Toys>(bd.values());
        int randomIndex = new Random().nextInt(valuesList.size());
        Toys randomValue = valuesList.get(randomIndex);
        return randomValue;
    }

    public void console() {
        scanner = new Scanner(System.in);
        /*
         * System.out.println("Выберите участника: preschooler, schoolboy");
         * String player = scanner.nextLine();
         * switch (player) {
         * case "preschooler":
         */
        System.out.println("Выберите хищника: hare, cow, wolf");
        String animal = scanner.nextLine();
        switch (animal) {
            case "wolf":
                Toys randomValue = getRandomToy();
                try (FileWriter writer = new FileWriter("preschooler.txt", true)) {
                    // String name = randomValue.getName();
                    writer.write(randomValue + System.getProperty("line.separator"));
                    writer.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("Получи игрушку " + randomValue + ", молодец!");
                break;
            default:
                System.out.println("Не правильно!");
                break;
        }
        /*
         * break;
         * default:
         * System.out.println("Не правильно выбран участник!");
         * break;
         * }
         */

    }

    // Загрузка игрушек
    public HashMap<Integer, Toys> loadingToy() {
        int index = 0;
        Toys designer = new Toys(1, "Конструктор", 2);
        for (int i = 1; i <= designer.getMass(); i++) {
            bd.put(index, designer);
            toys.put(index++, 1);
        }
        Toys table_games = new Toys(2, "Настольные игры", 2);
        for (int i = 1; i <= table_games.getMass(); i++) {
            bd.put(index, table_games);
            toys.put(index++, 3);
        }
        Toys robot = new Toys(3, "Робот", 6);
        for (int i = 1; i <= robot.getMass(); i++) {
            bd.put(index, robot);
            toys.put(index++, 3);
        }
        return bd;
    }

    public void printAll() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Toys product : bd.values()) {
            stringBuilder.append(product.getId()).append(". -").append(product).append("\n");
        }
        System.out.println(stringBuilder);
    }

    // Запись игрушек в призовой файл
    public void writing_to_file() {
        try (FileWriter writer = new FileWriter("prizes.txt", false)) {
            for (Toys product : bd.values()) {
                Integer id = product.getId();
                String name = product.getName();
                Integer mass = product.getMass();
                writer.write(id + " " + name + " " + mass + " " + System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
