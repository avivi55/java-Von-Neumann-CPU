package project.cpu;

public class GeneralPurposeRegister extends Register{

    public int index;
    public GeneralPurposeRegister(Integer data, int index) {
        super(data);
        this.index = index;
    }
}
