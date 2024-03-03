class StackService {
    stack: Stack <- new Stack("");
    stackController: StackController <- new StackController;
    interpretCommand(commandString: String): Bool {
        let command: StackCommandAbstract <- stackController.chooseCommand(command);
        stackController.executeCommand(stack, command, commandString);
    };
};