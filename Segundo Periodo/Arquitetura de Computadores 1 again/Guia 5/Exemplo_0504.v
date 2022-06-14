// -------------------------
// Exemplo_0504
// Nome: Marcos Ani Cury Vinagre Silva
// Matricula: 684903   
// -------------------------

module normultiplos(output exit, input x, input y);
    wire not_x,not_y;
    nor NOR1(not_x,x,x);
    nor NOR2(not_y,y,y);
    nor NOR3(exit,not_x,not_y);
endmodule

module e(output exit,input x, input y);
    assign exit = x & y;
endmodule

module Exemplo_0504;
    
    reg x;
    reg y;
    wire a,b;
    normultiplos moduloA(a,x,y);
    e moduloB(b,x,y);

    initial
    begin : main
        $display("Exemplo_0504 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    a    b");
        $monitor("%4b %4b %4b %4b", x, y, a, b);
        x = 1'b0; y = 1'b0;
        #1 x = 1'b0; y = 1'b1;
        #1 x = 1'b1; y = 1'b0;
        #1 x = 1'b1; y = 1'b1;
    end
endmodule