package project.cpu;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Register {
    private Binary32 data;

    public Register(Integer i) {
        setData(i);
    }

    public Register(Character c) {
        setData(c);
    }

    public Binary32 getData() {
        return data;
    }

    public void setData(Binary32 b32) {
        data = b32;
    }

    public void setData(Integer i) {
        data = new Binary32(i);
    }

    public void setData(Character c) {
        data = new Binary32(c);
    }
}
