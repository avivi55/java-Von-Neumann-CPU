package project;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        for (String file : args) {
            CPU.run(Path.of(file));
        }
    }
}
