package project;

import project.cpu.OpCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MemoryBlock {
    public static List<OpCode> instructions = new ArrayList<>();

    static void loadAssemblyFile(Path path){
        try{
            instructions.addAll(Files.readAllLines(path)
                    .stream()
                    .map(OpCode::new)
                    .toList());
        }
        catch (IOException e){ e.printStackTrace(); }
    }

    static void clear(){
        instructions = new ArrayList<>();
    }
}
