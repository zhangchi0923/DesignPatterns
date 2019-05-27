package cn.zhangchi.Command;

public abstract class Command {
    abstract void execute(CommandChain commandChain);
    abstract void undo(CommandChain commandChain);
}
