import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Програма для створення зубчатого масиву символів та запису його у текстовий файл.
 */
public class Lab1VorobeyKI305 {
    /**
     * Головний метод програми, який приймає введення від користувача, створює зубчатий масив символів,
     * виводить його на екран та записує у текстовий файл.
     *
     * @param args аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        // Створюємо зубчатий масив
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ціле число: ");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.print("Введіть символ: ");
        String symbol = scanner.next();
        scanner.close();
        char[][] zubchatiyMasiv = new char[size][];

        // Заповнюємо зубчатий масив символами
        for (int i = 0; i < size; i++) {
            zubchatiyMasiv[i] = new char[i + 1];
                for (int j = 0; j < i + 1; j++) {
                    if(i < size/2)
                    {
                        zubchatiyMasiv[i][j] = symbol.charAt(0);
                    }
                    else {
                        if(j<size/2)
                        {
                            zubchatiyMasiv[i][j] = ' ';
                        }
                        else {
                            zubchatiyMasiv[i][j] = symbol.charAt(0);
                        }
                    }
                }
        }



        // Виводимо зубчатий масив на екран
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < zubchatiyMasiv[i].length; j++) {
                System.out.print(zubchatiyMasiv[i][j] + " ");
            }
            System.out.println();
        }

        // Записуємо зубчатий масив у текстовий файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Massive.txt"))) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < zubchatiyMasiv[i].length; j++) {
                    writer.write(zubchatiyMasiv[i][j] + " ");
                }
                writer.newLine(); // Перехід на новий рядок
            }
            System.out.println("Зубчатий масив було записано у файл 'Massive.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
