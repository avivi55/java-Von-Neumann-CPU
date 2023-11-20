package project.cpu;

public class Register {
    private Binary32 data;

    public Register(Integer i) {
        setData(i);
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
}
