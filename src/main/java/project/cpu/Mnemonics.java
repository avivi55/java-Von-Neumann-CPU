package project.cpu;

import java.util.List;

public enum Mnemonics {
    // Arithmetics
    ADD((r, r1) -> ALU.addition(r.getData(), r1.getData())),
    SUB((r, r1) -> ALU.subtraction(r.getData(), r1.getData())),
    MUL((r, r1) -> ALU.multiplication(r.getData(), r1.getData())),
    DIV((r, r1) -> ALU.division(r.getData(), r1.getData())),
    MOD((r, r1) -> ALU.modulo(r.getData(), r1.getData())),
    INC((r, r1) -> r.setData(ALU.increment(r.getData()))),
    DEC((r, r1) -> r.setData(ALU.decrement(r.getData()))),

    // Logical
    AND((r, r1) -> ALU.and(r.getData(), r1.getData())),
    NOT((r, r1) -> ALU.not(r.getData())),
    OR((r, r1) -> ALU.or(r.getData(), r1.getData())),
    LS((r, r1) -> ALU.leftShift(r.getData())),
    RS((r, r1) -> ALU.rightShift(r.getData())),

    // Memory
    MOV((r, r1) -> r1.setData(r.getData())),

    // Programming
    JMP((r, r1) -> CU.jump(r.getData().getInt())),
    JZ((r, r1) -> CU.jumpUntilZero(r.getData().getInt())),
    OUT((r, r1) -> System.out.print(r.getData().getInt())),
    OUTC((r, r1) -> System.out.print(r.getData().getChar())),

    NOTHING((r, r1) -> {});

    static final List<Mnemonics> oneArgument = List.of(JMP, JZ, LS, RS, OUT, OUTC, INC, DEC);
    static final List<Mnemonics> twoArgument = List.of(MOV, MUL, ADD, AND, SUB, DIV, OR);

    private final Operation operation;

    Mnemonics(Operation operation) {
        this.operation = operation;
    }

    public void run(Register sender, Register receiver){
        operation.run(sender, receiver);
    }
}

@FunctionalInterface
interface Operation{
    void run(Register sender, Register receiver);
}
