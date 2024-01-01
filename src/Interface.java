import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Interface {
    public static void interfaceEncryption(int mode){
        Scanner in = new Scanner(System.in);
        String fileName;
        TextEncryption encryption = new TextEncryption();
        String url = "";
        while (true) {
            System.out.println("\nВведите имя и путь к текстовому файлу: (пример C:\\code\\file, exit чтобы вернутся в меню)");
            fileName = in.nextLine();
            if (Path.of(fileName).isAbsolute()) {
                url = fileName + ".txt";
                if (Files.isRegularFile(Path.of(url))) break;
                else System.out.println("С таким именем файла не существует");
            } else if (fileName.equals("exit")) {
                break;
            } else System.out.println("Некорректный ввод");
        }
        if (mode == 3) {
            WorkingWithFile.writeFile(fileName, encryption.readerFileBruteForce(url), mode);
            System.out.println("Файл создан\n" + "-".repeat(100));
        } else {
            System.out.println("Введите числовой ключ:");
            if (in.hasNextInt()) {
                int key = in.nextInt();
                WorkingWithFile.writeFile(fileName, encryption.readerFile(url, key, mode), mode);
                if (mode == 1) System.out.println("Шифровка завершена\n" + "-".repeat(100));
                if (mode == 2) System.out.println("Расшифровка завершена\n" + "-".repeat(100));
            } else {
                System.out.println("Некорректный ввод\n");
            }
        }

    }
}
