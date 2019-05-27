package cn.zhangchi.Command;

public class InsertCommand extends Command {
    Content c;
    String strToInsert = "http://www.mashibing.com";
    CommandChain chain;
    public InsertCommand(Content c, CommandChain commandChain) {
        this.c = c;
        this.chain = commandChain;
    }

    @Override
    public void execute(CommandChain commandChain) {
        c.msg = c.msg + strToInsert;
        commandChain.execute();
    }

    @Override
    public void undo(CommandChain commandChain) {
        c.msg = c.msg.substring(0, c.msg.length()-strToInsert.length());
        commandChain.undo();
    }
}
