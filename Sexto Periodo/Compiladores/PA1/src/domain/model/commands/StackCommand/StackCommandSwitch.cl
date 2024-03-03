class StackCommandSwitch inherit StackCommandAbstract {
    override method executeFunction(stack: Stack): Object {
        let firstItem: String <- stack.unstack();
        let secondItem: String <- stack.unstack();
        stack.pile(firstItem);
        stack.pile(secondItem);
    };
};