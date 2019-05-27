package cn.zhangchi.Command;

public class Main {
    public static void main(String[] args) {
        CommandChain chain = new CommandChain();
        Content c = new Content();
        chain.add(new CopyCommand(c,chain)).add(new InsertCommand(c,chain)).add(new DeleteCommand(c,chain));

        chain.execute();
        System.out.println(c.msg);
    }
}
