package project;

import project.cpu.Register;

import java.util.Scanner;

public class IOBlock {
    public static void scan(Register r){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integer: ");
        r.setData(scanner.nextInt());
    }

    public static void print(Register r){
        System.out.print(r.getData().getInt());
    }

    public static void printAsCharacter(Register r){
        System.out.print(r.getData().getChar());
    }
}
