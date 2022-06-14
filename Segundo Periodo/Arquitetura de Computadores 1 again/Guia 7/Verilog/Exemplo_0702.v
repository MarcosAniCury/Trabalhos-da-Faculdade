module multiplex2x1 (output exit,input s, input z, input w)
    wire a, b,ns;
    not invertes (ns, s);
    and chose1 (a, z, st);
    and chose2 (b, w, s);
    or yorx (exit, a, b);
endmodule

module Exemplo_0702;
    reg x, y, s;
    wire w, z, e;
    or Modulo (z, x, y);
    nor Modulo2 (w, x, y);
    multiplex2x1 Mult (e, s, z, w);

    initial
    begin : main
        $display("Exemplo_0701 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    s    e");
        $monitor("%4b %4b %4b %4b", x, y, s, e);
        x = 1'b0; y = 1'b0; s = 1'b0;
        #1 x = 1'b0; y = 1'b1;
        #1 x = 1'b1; y = 1'b0;
        #1 x = 1'b1; y = 1'b1;
        #1 x = 1'b0; y = 1'b0; s = 1'b1;
        #1 x = 1'b0; y = 1'b1;
        #1 x = 1'b1; y = 1'b0;
        #1 x = 1'b1; y = 1'b1;
    end
endmodule