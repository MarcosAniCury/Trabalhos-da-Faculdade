class Stack {
    item: String;
    next: Stack;
    init(i: String): SELF_TYPE {
        item <- i;
        n <- void;
        self;
    }

    pile(i: String): SELF_TYPE {
        let n: self <- new Stack(i);
        n.next <- next;
        next <- n;
        self <- next;
        self;
    };

    unstack(): String {
        let i: String <- item;
        self <- next;
        i;
    }

    flatten(): String {
        let stackFlatten: String <- "";
        let current: Stack <- self;
        while current != void loop
            stackFlatten <- stackFlatten + item + "\n";
            current <- current.next;
        pool
        stackFlatten;
    }
};