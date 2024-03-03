class StackCommandExecute inherit StackCommandAbstract {
    stackCommandController: stackCommandController <- new stackCommandController;
    override method execute(stack: Stack, command: String): Bool { 
        let commandString <- stack.unstack();
        let commandClass <- stackCommandController.chooseCommand(commandString);

        if commandString = "s" or commandString = "+":
            commandClass.executeFunction(stack);
        else
            stack.pile(commandString)
        fi
        true;
    };
};