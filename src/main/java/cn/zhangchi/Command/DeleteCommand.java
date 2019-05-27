package cn.zhangchi.Command;

public class DeleteCommand extends Command {
    Content c;
    String deleted;
    CommandChain chain;
    public DeleteCommand(Content c,CommandChain commandChain) {
        this.c = c;
        this.chain = commandChain;
    }

    @Override
    public void execute(CommandChain commandChain) {
        deleted = c.msg.substring(0, 5);
        c.msg = c.msg.substring(5, c.msg.length());
        commandChain.execute();
    }

    @Override
    public void undo(CommandChain commandChain) {
        c.msg = deleted + c.msg;
        commandChain.undo();
    }
}
