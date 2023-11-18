package project.cpu;

import project.CPU;
import project.MemoryBlock;

/**
 * Control Unit
 */
public class CU {
    public static Register programCounter = new Register(0);

    public static void jump(int line){
        if (line > MemoryBlock.instructions.size())
            throw new IndexOutOfBoundsException("jumping to non existent line !");
        programCounter.setData(Math.max(line - 2, 0));
    }

    public static void jumpUntilZero(int line){
        if(CPU.generalPurposeRegisters[9].getData().getInt() != 0)
            jump(line);
    }
    public static void cycle(){
        for (; programCounter.getData().getInt() < MemoryBlock.instructions.size();
             programCounter.setData(ALU.increment(programCounter.getData()))) {

            OpCode instruction =  MemoryBlock.instructions.get(programCounter.getData().getInt());
            instruction.instruction.run(instruction.sender, instruction.receiver);
        }
    }
}
