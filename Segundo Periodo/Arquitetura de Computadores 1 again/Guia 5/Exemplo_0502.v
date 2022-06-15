// -------------------------
// Exemplo_0502
// Nome: Marcos Ani Cury Vinagre Silva
// Matricula: 684903   
// -------------------------

module nor1(output exit, input x, input y);
    wire not_exit;
    nor NOR1(not_exit,x,y);
    nor NOR2(exit,not_exit,not_exit);
endmodule

module nor2(output exit, input x, input y);
    assign exit = x | y;
endmodule

module Exemplo_0502;

    reg x;
    reg y;
    wire a, b;
    nor1 moduloA ( a, x, y );
    nor2 moduloB ( b, x, y );

    initial
    begin : main
        $display("Exemplo_0502 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    a    b");
        $monitor("%4b %4b %4b %4b", x, y, a, b);
        x = 1'b0; y = 1'b0;
        #1 x = 1'b0; y = 1'b1;
        #1 x = 1'b1; y = 1'b0;
        #1 x = 1'b1; y = 1'b1;
    end
endmodule 