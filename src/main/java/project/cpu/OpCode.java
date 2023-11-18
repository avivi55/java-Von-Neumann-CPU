package project.cpu;

public class OpCode {
    Mnemonics instruction;
    Register sender;
    Register receiver;

    public OpCode(String assemblyLine){
        this(new AssemblyParser(assemblyLine).parse());
    }

    public OpCode(Mnemonics instruction, Register sender, Register receiver) {
        this.instruction = instruction;
        this.sender = sender;
        this.receiver = receiver;
    }

    public OpCode(OpCode other) {
        this.instruction = other.instruction;
        this.sender = other.sender;
        this.receiver = other.receiver;
    }
}
