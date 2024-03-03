class CommandLineInterface inherit IO {
    getNextLine(): String {
        out_string(">").in_string();
    };
    outputText(text: String): Object {
        out_string(text);
    }
};