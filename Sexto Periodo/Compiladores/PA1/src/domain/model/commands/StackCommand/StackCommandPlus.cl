class StackCommandPlus inherit StackCommandAbstract {
    atoi: A2I <- new A2I;
    override method executeFunction(stack: Stack): Object {
        let sumPile: Int <- atoi.a2i(stack.unstack()) + atoi.a2i(stack.unstack());
        stack.pile(atoi.i2a(sumPile));
    };
};