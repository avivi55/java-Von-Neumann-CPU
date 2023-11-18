package project;

import project.cpu.CU;
import project.cpu.GeneralPurposeRegister;
import project.cpu.Register;

import java.nio.file.Path;

public class CPU {
    public static Register[] generalPurposeRegisters = new Register[10];
    static {
        for (int i = 0; i < generalPurposeRegisters.length; i++)
            generalPurposeRegisters[i] = new GeneralPurposeRegister(0, i);
    }

    public static void main(String[] arg){
        MemoryBlock.loadAssemblyFile(Path.of("fibonacci.s"));
//        MemoryBlock.loadAssemblyFile(Path.of("test.s"));
        CU.cycle();
    }
}
