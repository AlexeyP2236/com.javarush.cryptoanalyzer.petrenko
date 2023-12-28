import java.nio.file.Path;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите число\n" +
                    "1 - Сделать шифровку;\n" +
                    "2 - Расшифровать файл;\n" +
                    "3 - ;\n" +
                    "4 - exit");
            String console = in.nextLine();
            if (console.equals("1")) {
                int mode = 1;
//                System.out.println("\nВведите путь к файлу:");
//                String nameFile = in.nextLine();
                // "C:\code\";
                String directory;
                //проверка о существовании директории
                String url = "C:\\code\\";
                while (true) {
                    System.out.println("\nВведите путь к файлу: (пример C:\\code\\file, exit чтобы вернутся в меню)");
                    directory = in.nextLine();
                    if (Path.of(directory).isAbsolute()) {
                        url = directory + ".txt";
                        break;
                    } else if (directory.equals("exit")) {
                        break;
                    } else System.out.println("Некорректный ввод");
                }
                TextEncryption encryption = new TextEncryption();
                System.out.println("Введите числовой ключ:");
                if (in.hasNextInt()) {
                    int key = in.nextInt();
                    WorkingWithFile.writeFile(directory, encryption.readerFile(url, key, mode), mode);
                    System.out.println("Шифровка завершена\n" + "-".repeat(100));
                } else {
                    System.out.println("Некорректный ввод\n");
                }


            } else if (console.equals("2")) {
//                int mode = 2;
//                String nameFile = "file-code";
//                String directory = "C:\\code\\";
//                String url = directory + nameFile + ".txt";
//                TextEncryption encryption = new TextEncryption();
//                WorkingWithFile.writeFile(directory, encryption.readerFile(url, 17, mode), mode);
//                System.out.println("Расшифровка завершена\n");

            } else if (console.equals("3")) {

            } else if (console.equals("4") || console.equals("exit")) break;
            else System.out.println("Неверный ввод");
        }
    }
}