module mult2x1 (output exit,input s, input z, input w)
    wire a, b, ns;
    not invertes (ns, s);
    and chose1 (a, z, st);
    and chose2 (b, w, s);
    or yorx (exit, a, b);
endmodule

module Exemplo_0703;
    reg x, y, w, z, s, s2;
    wire a, b, c, d, exit1, exit2, exit3;
    and Mod1 (a, x, y);
    nand Mod2 (b, x, y);
    or Mod3 (c, w, z);
    nor Mod4 (d, w, z);
    mult2x1 Mult (exit1, s, a, b);
    mult2x1 Mult1 (exit2, s, c, d);
    mult2x1 Junt (exit3, s2, exit1, exit2);

    initial
    begin : main
        $display("Exemplo_0701 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    w    z    m");
        $monitor("%4b %4b %4b %4b %4b", x, y, w, z, exit3);
        x = 1'b0; y = 1'b0; s = 1'b0; s2 = 1'b0; w = 1'b0; z = 1'b0;
        #1 x = 1'b0; y = 1'b0; w = 1'b0; z = 1'b1;
        #1 x = 1'b0; y = 1'b0; w = 1'b1; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b0; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b0; z = 1'b1;
        #1 x = 1'b0; y = 1'b1; w = 1'b1; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b1; z = 1'b1;
        #1 x = 1'b1; y = 1'b0; w = 1'b0; z = 1'b0;
        #1 x = 1'b1; y = 1'b0; w = 1'b0; z = 1'b1;
        #1 x = 1'b1; y = 1'b0; w = 1'b1; z = 1'b0;
        #1 x = 1'b1; y = 1'b0; w = 1'b1; z = 1'b1;
        #1 x = 1'b1; y = 1'b1; w = 1'b0; z = 1'b0;
        #1 x = 1'b1; y = 1'b1; w = 1'b0; z = 1'b1;
        #1 x = 1'b1; y = 1'b1; w = 1'b1; z = 1'b0;
        #1 x = 1'b1; y = 1'b1; w = 1'b1; z = 1'b1;
        x = 1'b0; y = 1'b0; s = 1'b0; s2 = 1'b1; w = 1'b0; z = 1'b0;
        #1 x = 1'b0; y = 1'b0; w = 1'b0; z = 1'b1;
        #1 x = 1'b0; y = 1'b0; w = 1'b1; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b0; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b0; z = 1'b1;
        #1 x = 1'b0; y = 1'b1; w = 1'b1; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b1; z = 1'b1;
        #1 x = 1'b1; y = 1'b0; w = 1'b0; z = 1'b0;
        #1 x = 1'b1; y = 1'b0; w = 1'b0; z = 1'b1;
        #1 x = 1'b1; y = 1'b0; w = 1'b1; z = 1'b0;
        #1 x = 1'b1; y = 1'b0; w = 1'b1; z = 1'b1;
        #1 x = 1'b1; y = 1'b1; w = 1'b0; z = 1'b0;
        #1 x = 1'b1; y = 1'b1; w = 1'b0; z = 1'b1;
        #1 x = 1'b1; y = 1'b1; w = 1'b1; z = 1'b0;
        #1 x = 1'b1; y = 1'b1; w = 1'b1; z = 1'b1;
        x = 1'b0; y = 1'b0; s = 1'b1; s2 = 1'b0; w = 1'b0; z = 1'b0;
        #1 x = 1'b0; y = 1'b0; w = 1'b0; z = 1'b1;
        #1 x = 1'b0; y = 1'b0; w = 1'b1; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b0; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b0; z = 1'b1;
        #1 x = 1'b0; y = 1'b1; w = 1'b1; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b1; z = 1'b1;
        #1 x = 1'b1; y = 1'b0; w = 1'b0; z = 1'b0;
        #1 x = 1'b1; y = 1'b0; w = 1'b0; z = 1'b1;
        #1 x = 1'b1; y = 1'b0; w = 1'b1; z = 1'b0;
        #1 x = 1'b1; y = 1'b0; w = 1'b1; z = 1'b1;
        #1 x = 1'b1; y = 1'b1; w = 1'b0; z = 1'b0;
        #1 x = 1'b1; y = 1'b1; w = 1'b0; z = 1'b1;
        #1 x = 1'b1; y = 1'b1; w = 1'b1; z = 1'b0;
        #1 x = 1'b1; y = 1'b1; w = 1'b1; z = 1'b1;
        x = 1'b0; y = 1'b0; s = 1'b1; s2 = 1'b1; w = 1'b0; z = 1'b0;
        #1 x = 1'b0; y = 1'b0; w = 1'b0; z = 1'b1;
        #1 x = 1'b0; y = 1'b0; w = 1'b1; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b0; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b0; z = 1'b1;
        #1 x = 1'b0; y = 1'b1; w = 1'b1; z = 1'b0;
        #1 x = 1'b0; y = 1'b1; w = 1'b1; z = 1'b1;
        #1 x = 1'b1; y = 1'b0; w = 1'b0; z = 1'b0;
        #1 x = 1'b1; y = 1'b0; w = 1'b0; z = 1'b1;
        #1 x = 1'b1; y = 1'b0; w = 1'b1; z = 1'b0;
        #1 x = 1'b1; y = 1'b0; w = 1'b1; z = 1'b1;
        #1 x = 1'b1; y = 1'b1; w = 1'b0; z = 1'b0;
        #1 x = 1'b1; y = 1'b1; w = 1'b0; z = 1'b1;
        #1 x = 1'b1; y = 1'b1; w = 1'b1; z = 1'b0;
        #1 x = 1'b1; y = 1'b1; w = 1'b1; z = 1'b1;
    end
endmodule