import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class JavaUpperMain {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter String to replace with uppercase version: ");
        String look = scan.nextLine();
        System.out.println("Enter Folder Path Name: ");
        String path = scan.nextLine();
        scan.close();
        List<File> files = findFiles(path);
        BufferedReader reader;
        for (File file : files) {
            String content = "";
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null){
                if (!line.contains(look))
                    content = content.concat(line + System.lineSeparator());
                else
                    content = content.concat(line.replace(look, look.toUpperCase()) + System.lineSeparator());
                line = reader.readLine();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            reader.close();
            writer.close();
        }
        System.out.println("Finished!");
    }

    private static List<File> findFiles(String path) {
        File folder = new File(path);
        return Arrays.stream(Objects.requireNonNull(folder.listFiles())).toList();
    }
}
