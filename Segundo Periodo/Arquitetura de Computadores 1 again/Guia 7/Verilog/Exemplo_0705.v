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

module mult7x1 (output exit, input s1, input s2, input s3, input x, input y, input z, input w, input l , input k, input p)
    mult2x1 ORNOR(a, s3,  y, z);
    mult2x1 NOT_ORNOR(b, s2, z, a);
    mult4x1 ANDNAND_XORXNOR(c, s3, s2, w, l, k, p);
    mult2x1 NOT_ORNOR_ANDNAND_XORXNOR(exit, s3, a, c);
endmodule

module Exemplo_0703;
    reg x, y, z , w, l, k, p, s, s2, s3;
    wire a, b, c, d, e, f, h, exit;
    not Mod1 (a, x);
    or Mod2 (b, y, z);
    nor Mod3 (c, y, z);
    and Mod4 (d, w, l);
    nand Mod5 (e , w, l);
    xor Mod6 (f, k, p);
    xnor Mod7 (h, k, p);
    mult7x1 Mult7x1 (exit, s, s2, s3, a, b, c, d, e, f, g, h);

    initial
    begin : main
        $display("Exemplo_0701 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    w    z    m");
        $monitor("%4b %4b %4b %4b %4b", x, y, w, z, exit);
        x = 1'b0; y = 1'b0; s = 1'b0; s2 = 1'b0; s3 = 1'b0; w = 1'b0; z = 1'b0; l = 1'b0; k = 1'b0; p = 1'b0; 
        #1 x = 1'b1; y = 1'b0; w = 1'b0; z = 1'b1; l = 1'b0; k = 1'b1; p = 1'b0;
        #1 x = 1'b0; y = 1'b0; s = 1'b0; s2 = 1'b1; s3 = 1'b1; w = 1'b0; z = 1'b0; l = 1'b0; k = 1'b0; p = 1'b0; 
    end
endmodule