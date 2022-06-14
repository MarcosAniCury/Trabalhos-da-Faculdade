module mult2x1 (output exit,input s, input z, input w)
    wire a, b, ns;
    not invertes (ns, s);
    and chose1 (a, z, st);
    and chose2 (b, w, s);
    or yorx (exit, a, b);
endmodule

module mult4x1 (output exit, input s1, input s2, input x, input y, input z, input w)
    wire a, b;
    mult2x1 Mult1 (a, s1, x, y);
    mult2x1 Mult2 (b, s1, z, w);
    mult2x1 Mult3 (exit, s2, a, b);
endmodule

module Exemplo_0703;
    reg x, y, w, z, s, s2;
    wire a, b, c, d, exit;
    xor Mod1 (a, x, y);
    xnor Mod2 (b, x, y);
    or Mod3 (c, w, z);
    nor Mod4 (d, w, z);
    mult4x1 Mult4x1 (exit, s, s2, a, b, c, d);

    initial
    begin : main
        $display("Exemplo_0701 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    w    z    m");
        $monitor("%4b %4b %4b %4b %4b", x, y, w, z, exit);
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