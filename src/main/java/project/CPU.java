package project;

import project.cpu.CU;
import project.cpu.GeneralPurposeRegister;
import project.cpu.Register;

import java.io.IOException;
import java.nio.file.Path;

public class CPU {
    public static Register[] generalPurposeRegisters = new Register[10];

    static {
        for (int i = 0; i < generalPurposeRegisters.length; i++)
            generalPurposeRegisters[i] = new GeneralPurposeRegister(0, i);
    }

    public static void run(Path file) throws IOException {
        MemoryBlock.loadAssemblyFile(file);
        CU.cycle();
        MemoryBlock.clear();
        for (Register generalPurposeRegister : generalPurposeRegisters) generalPurposeRegister.setData(0);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        run(Path.of("assembly/hello_c.s"));
        run(Path.of("assembly/fibonacci.s"));
        run(Path.of("assembly/circle_area.s"));
    }
}
