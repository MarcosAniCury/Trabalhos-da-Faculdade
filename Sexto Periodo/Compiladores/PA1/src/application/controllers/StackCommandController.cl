class StackController {
    chooseCommand(command: String): StackCommandAbstract { 
        if command = "+" then
            new StackCommandPlus();
        fi 
        if command = "s" then
            new StackCommandSwitch();
        fi
        if command = "e" then
            new StackCommandExecute();
        fi
        if command = "d" then
            new StackCommandDisplay();
        fi
        if command = "x" then
            new StackCommandExit();
        fi
        StackCommandInt(); 
    };
    executeCommand(stack: Stack, stackCommand: StackCommandAbstract, command: String): Bool {
        stackCommand.execute(stack, command);
    };
};