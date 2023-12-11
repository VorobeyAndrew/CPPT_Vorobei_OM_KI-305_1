import java.io.*;

/**
 * Клас для читання/запису результатів роботи класу CtgCalculator у текстовому і двійковому форматах.
 */
public class Main {

    /**
     * Запис результату у текстовий файл.
     *
     * @param fileName Ім'я файлу для запису.
     * @param result Рядок з результатом.
     * @throws IOException Якщо виникла помилка при записі у файл.
     */
    public static void writeTextFile(String fileName, String result) throws IOException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(result);
        }
    }

    /**
     * Запис результату у двійковий файл.
     *
     * @param fileName Ім'я файлу для запису.
     * @param result Рядок з результатом.
     * @throws IOException Якщо виникла помилка при записі у файл.
     */
    public static void writeBinaryFile(String fileName, String result) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(result);
        }
    }

    /**
     * Читання результату з текстового файлу.
     *
     * @param fileName Ім'я файлу для читання.
     * @return Рядок з результатом.
     * @throws IOException Якщо виникла помилка при читанні з файлу.
     */
    public static String readTextFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            return result.toString().trim();
        }
    }

    /**
     * Читання результату з двійкового файлу.
     *
     * @param fileName Ім'я файлу для читання.
     * @return Рядок з результатом.
     * @throws IOException Якщо виникла помилка при читанні з файлу.
     * @throws ClassNotFoundException Якщо клас не знайдений під час десеріалізації.
     */
    public static String readBinaryFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (String) ois.readObject();
        }
    }

    public static void main(String[] args) {
        try {
            double angle = Math.toRadians(45);
            String fileNameText = "result_text.txt";
            String fileNameBinary = "result_binary.dat";

            double tangentValue = Math.tan(angle);

            // Обчисліть котангенс як обернений тангенс
            double cotangentValue = 1.0 / tangentValue;
            // Запис результату у текстовий файл
            String result = 1/tangentValue + "";
            writeTextFile(fileNameText, result);
            System.out.println("Результати записані у текстовий файл " + fileNameText);

            // Запис результату у двійковий файл
            writeBinaryFile(fileNameBinary, result);
            System.out.println("Результати записані у двійковий файл " + fileNameBinary);

            // Читання результату з текстового файлу
            String textResult = readTextFile(fileNameText);
            System.out.println("Результат з текстового файлу: " + textResult);

            // Читання результату з двійкового файлу
            String binaryResult = readBinaryFile(fileNameBinary);
            System.out.println("Результат з двійкового файлу: " + binaryResult);


            File file = new File("D:/123.txt");
            String mode = "rw";
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, mode);

            // Читання даних з файлу
            randomAccessFile.seek(0);
            String data = randomAccessFile.readLine();
            System.out.println("Зчитані дані: " + data);

            // Запис нових даних в файл
            randomAccessFile.seek(0);
            randomAccessFile.writeBytes(result);
            System.out.println("Дані записано у файл.");

            // Знову читання даних після запису
            randomAccessFile.seek(0);
            data = randomAccessFile.readLine();
            System.out.println("Зчитані дані з файлу: " + data);

            // Закриття файлу
            randomAccessFile.close();


        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}