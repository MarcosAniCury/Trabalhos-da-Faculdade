// -------------------------
// Exemplo_0505
// Nome: Marcos Ani Cury Vinagre Silva
// Matricula: 684903   
// -------------------------

module nandmultiplos(output exit, input x,input y);
    wire not_x,not_y;
    nand NAND1(not_x,x,x);
    nand NAND2(not_y,y,y);
    nand NAND3(exit,not_x,not_y);
endmodule

module ou(output exit,input x,input y);
    assign exit = x | y;
endmodule

module Exemplo_0505;

    reg x;
    reg y;
    wire a, b;
    nandmultiplos moduloA ( a, x, y );
    ou moduloB ( b, x, y );

    initial
    begin : main
        $display("Exemplo_0505 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    a    b");
        $monitor("%4b %4b %4b %4b", x, y, a, b);
        x = 1'b0; y = 1'b0;
        #1 x = 1'b0; y = 1'b1;
        #1 x = 1'b1; y = 1'b0;
        #1 x = 1'b1; y = 1'b1;
    end
endmodule 