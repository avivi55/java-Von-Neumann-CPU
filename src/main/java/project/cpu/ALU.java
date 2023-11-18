package project.cpu;
import project.CPU;

/**
 * Arithmetical Logic Unit
 */
public class ALU {
    static Register accumulator = CPU.generalPurposeRegisters[0];

    // Arithmetic
    public static void addition(Binary32 a, Binary32 b) {
        accumulator.setData(a.getInt() + b.getInt());
    }

    public static void subtraction(Binary32 a, Binary32 b) {
        accumulator.setData(a.getInt() - b.getInt());
    }

    public static void multiplication(Binary32 a, Binary32 b){
        accumulator.setData(a.getInt() * b.getInt());
    }
    public static void division(Binary32 a, Binary32 b){
        accumulator.setData(a.getInt() / b.getInt());
    }
    public static void modulo(Binary32 a, Binary32 b){
        accumulator.setData(a.getInt() % b.getInt());
    }

    public static Binary32 decrement(Binary32 a){
        return new Binary32(a.getInt() - 1);
    }
    public static Binary32 increment(Binary32 a){
        return new Binary32(a.getInt() + 1);
    }

    // Logic
    public static void and(Binary32 a, Binary32 b){
        accumulator.setData(a.getInt() & b.getInt());
    }
    public static void or(Binary32 a, Binary32 b){
        accumulator.setData(a.getInt() | b.getInt());
    }
    public static void leftShift(Binary32 a){
        accumulator.setData(a.getInt() * 2);
    }
    public static void rightShift(Binary32 a){
        accumulator.setData(a.getInt() / 2);
    }
    public static void not(Binary32 b32){
        byte[] b = b32.byteArray.clone();
        for (int i = 0; i < b.length; i++)
            b[i] = (byte) ~b[i];

        accumulator.setData(new Binary32(b));
    }
}