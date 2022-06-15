module Exemplo_0701;
    reg x, y;
    wire w, z;
    and Modulo ( z, x, y);
    nand Modulo2 (w, x, y);

    initial
    begin : main
        $display("Exemplo_0701 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    w    z");
        $monitor("%4b %4b %4b %4b", x, y, w, z);
        x = 1'b0; y = 1'b0;
        #1 x = 1'b0; y = 1'b1;
        #1 x = 1'b1; y = 1'b0;
        #1 x = 1'b1; y = 1'b1;
    end
endmodule