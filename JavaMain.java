import java.io.*;
import java.util.*;

public class JavaMain {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String to look for: ");
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