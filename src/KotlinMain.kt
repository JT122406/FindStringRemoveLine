import java.io.*
import java.util.*

object KotlinMain {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val scan = Scanner(System.`in`)
        println("Enter String to look for: ")
        val look = scan.nextLine()
        println("Enter Folder Path Name: ")
        val path = scan.nextLine()
        scan.close()
        val files = findFiles(path)
        var reader: BufferedReader
        for (file in files) {
            var content = ""
            reader = BufferedReader(FileReader(file))
            var line = reader.readLine()
            while (line != null) {
                if (!line.contains(look)) content = content + line + System.lineSeparator()
                line = reader.readLine()
            }
            val writer = FileWriter(file)
            writer.write(content)
            reader.close()
            writer.close()
        }
        println("Finished!")
    }

    private fun findFiles(path: String): List<File> {
        val folder = File(path)
        return Arrays.stream(Objects.requireNonNull(folder.listFiles())).toList()
    }
}