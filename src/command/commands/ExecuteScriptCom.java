package src.command.commands;

import src.command.Invoker;
import src.command.Receiver;
import src.command.Utility.FileUtil;
import src.command.Utility.ScriptUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class ExecuteScriptCom implements BasicCommand{
    @Override
    public void execute(String[] args) {
        String path = System.getenv("FILE_PATH") + "\\" + args[1];
        try {
            FileUtil.setFileMode(true);
            ScriptUtil.pushFile(path);
            for (String line = ScriptUtil.readfile(); line != null; line = ScriptUtil.readfile()) {
                try{
                    String[] cmd = (line + " ").split(" ", 2);
                    if (cmd[0].isBlank()) return;
                    if (cmd[0].equals("execute_script")) {
                        if (ScriptUtil.fileReapeting(cmd[1])){
                            System.err.println("Found recursion in " + new File(cmd[1]).getAbsolutePath());
                            continue;
                        }

                    }
                    System.out.println("Executing command " + cmd[0]);
                    Invoker.startExecuting(cmd[0]);
                    if (cmd[0].equals("execute_script")){
                        ScriptUtil.popfile();
                    }
                } catch (NoSuchElementException ignored) {
                }
            }
            ScriptUtil.popfile();
        }
        catch (FileNotFoundException fileNotFoundException){
            System.err.println("No such file exists");
        } catch (IOException e) {
            System.err.println("Input output error");
        }catch (NoSuchElementException ignored) {
        }
        FileUtil.setFileMode(false);
    }

    @Override
    public String getName() {
        return "Execute_script";
    }

    @Override
    public String getDescription() {
        return "execute the script from the provided file";
    }
}
