package cn.zhangchi.Command;

public class CopyCommand extends Command {
    Content c;
    CommandChain chain;
    public CopyCommand(Content c, CommandChain commandChain) {
        this.c = c;
        this.chain = commandChain;
    }

    @Override
    public void execute(CommandChain commandChain) {
        c.msg = c.msg + c.msg;
        commandChain.execute();
    }

    @Override
    public void undo(CommandChain commandChain) {
        c.msg = c.msg.substring(0, c.msg.length()/2);
        commandChain.undo();
    }
}
