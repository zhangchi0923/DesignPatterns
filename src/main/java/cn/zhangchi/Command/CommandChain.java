package cn.zhangchi.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandChain {
    List<Command> commands = new ArrayList<>();
    int index = 0;

    public CommandChain add(Command command){
        commands.add(command);
        return this;
    }

    public void execute(){
        if(index == commands.size()) return;
        Command c = commands.get(index);
        index++;

        c.execute(this);
    }

    public void undo(){
        if(index == -1) return;
        Command c = commands.get(index);
        index--;

        c.undo(this);
    }
}
