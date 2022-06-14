// -------------------------
// Exemplo_0507
// Nome: Marcos Ani Cury Vinagre Silva
// Matricula: 684903   
// -------------------------

module nandmultiplos(output exit, input x,input y);
    wire line1,not_y,not_x,line2;
    nand LINE1(line1,x,y);
    nand LINE2_1(not_x,x,x);
    nand LINE2_2(not_y,y,y);
    nand LINE2_3(line2,not_x,not_y);
    nand LINE1plusLINE2(exit,line1,line2);
endmodule

module ou(output exit,input x,input y);
    assign exit = ~(x ^ y);
endmodule

module Exemplo_0507;

    reg x;
    reg y;
    wire a, b;
    nandmultiplos moduloA ( a, x, y );
    ou moduloB ( b, x, y );

    initial
    begin : main
        $display("Exemplo_0507 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    a    b");
        $monitor("%4b %4b %4b %4b", x, y, a, b);
        x = 1'b0; y = 1'b0;
        #1 x = 1'b0; y = 1'b1;
        #1 x = 1'b1; y = 1'b0;
        #1 x = 1'b1; y = 1'b1;
    end
endmodule 