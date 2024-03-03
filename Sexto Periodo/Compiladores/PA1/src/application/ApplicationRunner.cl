class ApplicationRunner {
    stackService: StackService <- new StackService;
    commandLine: CommandLineInterface <- new CommandLineInterface;
    run(): Object {
        let commandLine: String <- commandLine.getNextLine() in
            if not stackService.interpretCommand(commandLine) then
                commandLine.outputText("\nFinalizando a pilha, obrigado pelo uso.");
            fi
    };
};