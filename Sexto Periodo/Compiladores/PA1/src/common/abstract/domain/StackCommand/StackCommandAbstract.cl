class StackCommandAbstract {
    abstract method execute(stack: Stack, command: String): Bool { 
        stack.pile(command)
        true;
    };

    abstract method executeFunction(stack: Stack): Object {};
};