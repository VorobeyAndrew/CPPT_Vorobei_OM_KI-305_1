import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас для обчислення виразу y = ctg(x).
 */
public class CtgCalculator
{

    /**
     * Метод для обчислення ctg(x).
     *
     * @param x Кут у радіанах.
     * @return Значення ctg(x).
     * @throws IllegalArgumentException Якщо x дорівнює кратному PI/2, бо ctg не визначений в таких точках.
     */
    public static double calculateCtg(double x) throws IllegalArgumentException
    {
        if (Math.abs(x % (Math.PI / 2)) < 1e-10)
        {
            throw new IllegalArgumentException("Ctg is undefined for x = n * PI/2");
        }
        return 1 / Math.tan(x);
    }

    /**
     * Метод для запису результатів обчислення у файл.
     *
     * @param fileName Ім'я файлу для запису.
     * @param x Кут у радіанах.
     * @throws IOException Якщо виникла помилка при записі у файл.
     */
    public static void writeResultToFile(String fileName, double x) throws IOException
    {
        try (FileWriter writer = new FileWriter(fileName))
        {
            double result = calculateCtg(x);
            writer.write(String.format("ctg(%.2f) = %.4f", x, result));
        }
    }

    public static void main(String[] args) {
        try
        {
            double angle = Math.toRadians(45); // Приклад: обчислення ctg(45 градусів)
            System.out.println("Результат " + angle);
            String fileName = "result.txt";
            writeResultToFile(fileName, angle);
            System.out.println("Результати обчислення записані у файл " + fileName);
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("Помилка: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.err.println("Помилка при записі у файл: " + e.getMessage());
        }
    }
}
