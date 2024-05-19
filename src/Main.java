import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть назву файлу: ");
        String fileName = scanner.nextLine();

        createNewFile(fileName);

        System.out.print("Введіть мінімальне значення: ");
        int minValue = scanner.nextInt();

        System.out.print("Введіть максимальне значення: ");
        int maxValue = scanner.nextInt();

        System.out.print("Введіть мінімальну кількість чисел: ");
        int minNumbers = scanner.nextInt();

        System.out.print("Введіть максимальну кількість чисел: ");
        int maxNumbers = scanner.nextInt();

        int numNumbers = generateRandomNumber(minNumbers, maxNumbers);

        String numbers = generateRandomNumbers(minValue, maxValue, numNumbers);

        writeToFile(fileName, numbers);

        readFromFile(fileName);

        scanner.close();
    }

    public static void createNewFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("Файл створено: " + file.getName());
            } else {
                System.out.println("Файл вже існує.");
            }
        } catch (IOException e) {
            System.out.println("Сталася помилка при створенні файлу.");
        }
    }

    public static void writeToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Речення успішно записано в файл.");
        } catch (IOException e) {
            System.out.println("Сталася помилка при записі в файл.");
        }
    }

    public static void readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            System.out.println("Зміст файлу " + fileName + ":");

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено.");
        }
    }

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static String generateRandomNumbers(int minValue, int maxValue, int numNumbers) {
        Random random = new Random();
        StringBuilder numbers = new StringBuilder();

        for (int i = 0; i < numNumbers; i++) {
            int number = random.nextInt(maxValue - minValue + 1) + minValue;
            numbers.append(number);
            if (i != numNumbers - 1) {
                numbers.append(" ");
            }
        }

        return numbers.toString();
    }
}