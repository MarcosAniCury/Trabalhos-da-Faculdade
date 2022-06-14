// -------------------------
// Exemplo_0503
// Nome: Marcos Ani Cury Vinagre Silva
// Matricula: 684903   
// -------------------------
module nand1(output exit, input x, input y);
    wire not_exit;
    nand NAND1(not_exit,x,y);
    nand NAND2(exit,not_exit,not_exit);
endmodule

module nand2(output exit, input x, input y);
    assign exit = x & y;
endmodule

module Exemplo_0503;

    reg x;
    reg y;
    wire a,b;
    nand1 moduloA(a,x,y);
    nand2 moduloB(b,x,y);

    initial
    begin : main
        $display("Exemplo_0503 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    a    b");
        $monitor("%4b %4b %4b %4b", x, y, a, b);
        x = 1'b0; y = 1'b0;
        #1 x = 1'b0; y = 1'b1;
        #1 x = 1'b1; y = 1'b0;
        #1 x = 1'b1; y = 1'b1;
    end
endmodule 