package cn.zhangchi.visitor;

public class Main {
    public static void main(String[] args) {
        PersonalVisitor p = new PersonalVisitor();
        CorpVisitor c = new CorpVisitor();
        p.visitBoard(new Board());
        System.out.println(p.totalPrice);
    }
}
interface Visitor{
    void visitCpu(Cpu cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board board);
}
abstract class ComputerPart{
    abstract void accept(Visitor v);
    abstract double getPrice();
}

class Cpu extends ComputerPart{
    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 800;
    }
}

class Memory extends ComputerPart{
    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 600;
    }
}

class Board extends ComputerPart{
    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 1000;
    }
}

class PersonalVisitor implements Visitor{
    double totalPrice;
    @Override
    public void visitCpu(Cpu cpu) {
        totalPrice += cpu.getPrice()*0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.8;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.7;
    }
}

class CorpVisitor implements Visitor{
    double totalPrice;
    @Override
    public void visitCpu(Cpu cpu) {
        totalPrice += cpu.getPrice()*0.7;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice()*0.75;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.82;
    }
}