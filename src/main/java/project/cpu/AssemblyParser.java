package project.cpu;

import project.CPU;

public class AssemblyParser {

    private final String assemblyLine;

    public AssemblyParser(String assemblyLine) {
        this.assemblyLine = assemblyLine;
    }

    public OpCode parse() {
        if (isNonSignificant(assemblyLine))
            return new OpCode(Mnemonics.NOTHING, null, null);

        String[] lineParts = assemblyLine.split(" ");

        if (hasMoreThanTwoOperands(lineParts))
            throw new IllegalArgumentException("To much operands!");

        if (isIncorrectInstruction(lineParts[0]))
            throw new IllegalArgumentException("Incorrect Instruction!");

        Mnemonics instruction = Mnemonics.valueOf(lineParts[0].toUpperCase());

        if (hasNoOperands(lineParts))
            return new OpCode(instruction, CPU.generalPurposeRegisters[0], CPU.generalPurposeRegisters[1]);

        Register sender;
        if(hasOneOperands(lineParts)){
            sender = processFirstOperand(lineParts[1]);
            return new OpCode(instruction, sender, CPU.generalPurposeRegisters[0]);
        }

        Register receiver;
        if (hasTwoOperands(lineParts)){
            sender = processFirstOperand(lineParts[1]);
            receiver = processSecondOperand(lineParts[2]);
            return new OpCode(instruction, sender, receiver);
        }
        throw new IllegalArgumentException("Should never happen: line unreadable!");
    }

    boolean isNonSignificant(String line) {
        return line.isEmpty() || line.charAt(0) == '#';
    }

    boolean hasMoreThanTwoOperands(String[] lineParts) {
        return lineParts.length > 3;
    }

    boolean isIncorrectInstruction(String supposedInstruction){
        if(supposedInstruction.isEmpty())
            return true;

        try {
            Mnemonics.valueOf(supposedInstruction.toUpperCase());

            return false;
        } catch (IllegalArgumentException notAValidInstruction){
            return true;
        }
    }

    boolean hasNoOperands(String[] lineParts){
        return lineParts.length == 1;
    }
    boolean hasOneOperands(String[] lineParts){
        return lineParts.length == 2;
    }
    boolean hasTwoOperands(String[] lineParts){
        return lineParts.length == 3;
    }

    Register processFirstOperand(String supposedFirstOperand){
        if (supposedFirstOperand.isEmpty())
            throw new IllegalArgumentException("Not a valid first operand for some odd reason!");

        switch (supposedFirstOperand.charAt(0)) {
            case 'R','r' -> {
                int registerNumber;
                try{
                    registerNumber = Integer.parseInt(supposedFirstOperand.substring(1));
                } catch (NumberFormatException notANumber){
                    throw new IllegalArgumentException("First Operand: A register number MUST be a numeral.");
                }

                if (registerNumber > CPU.generalPurposeRegisters.length || registerNumber < 0)
                    throw new IllegalArgumentException("First Operand: Register number invalid!");

                return CPU.generalPurposeRegisters[registerNumber];
            }
            case '$' -> {
                int immediate;
                if (supposedFirstOperand.charAt(1) == '\'')
                    immediate = processCharacterImmediate(supposedFirstOperand);
                else
                    immediate = processNumberImmediate(supposedFirstOperand);

                return new Register(immediate);
            }
            default -> throw new IllegalArgumentException("First operand must start with `$` or `R`");
        }
    }

    int processNumberImmediate(String secondOperand){
        try{
            return Integer.parseInt(secondOperand.substring(1));
        } catch (NumberFormatException notANumber){
            throw new IllegalArgumentException("First Operand: An immediate number MUST be a numeral.");
        }
    }
    int processCharacterImmediate(String secondOperand){
        if (secondOperand.equals("$'\\n'"))
            return '\n';
        if (secondOperand.equals("$'\\s'"))
            return ' ';
        if (secondOperand.charAt(3) != '\'')
            throw new IllegalArgumentException("Invalid formatting for character immediate!");
        return secondOperand.charAt(2);
    }
    Register processSecondOperand(String supposedSecondOperand){
        if (supposedSecondOperand.isEmpty())
            throw new IllegalArgumentException("Not a valid second operand for some odd reason!");

        if (supposedSecondOperand.charAt(0) != 'R' && supposedSecondOperand.charAt(0) != 'r')
            throw new IllegalArgumentException("A second operand must be a register!");

        int registerNumber;
        try{
            registerNumber = Integer.parseInt(supposedSecondOperand.substring(1));
        } catch (NumberFormatException notANumber){
            throw new IllegalArgumentException("Second Operand: A register number MUST be a numeral.");
        }

        if (registerNumber > CPU.generalPurposeRegisters.length || registerNumber < 0)
            throw new IllegalArgumentException("Second Operand: Register number invalid!");

        return CPU.generalPurposeRegisters[registerNumber];
    }
}
