package project.cpu;

import java.nio.ByteBuffer;

public class Binary32 {
    public byte[] byteArray;
    public Binary32(Integer i) {
        byteArray = ByteBuffer.allocate(4)
                .putInt(i)
                .array();
    }

    public Binary32(byte[] array){
        byteArray = array;
    }

    public Character getChar() {
        return (char) (int) getInt();
    }

    public Integer getInt() {
        return ByteBuffer.wrap(byteArray)
                .getInt();
    }
}
