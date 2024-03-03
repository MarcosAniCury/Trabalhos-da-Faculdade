class StackCommandDisplay inherit StackCommandAbstract {
    override method execute(stack: Stack, command: String): Bool { 
        (new CommandLineInterface).outputText(stack.flatten())
        true;
    };
};