module Somador2 (output exit, output exit1, input x, input y)
    wire a;
    xor Seletor1 (exit , x, y);
    not NotSeletor1 (a, exit);
    and Vai1 (exit1, a, y);
endmodule

module Somador3 (output exit1, output exit2, input x, input y, input w)
    wire a, b, c, d, e, f;
    or Seletor1 (a, x, y);
    and ForSeletor2 (b ,x ,y);
    or Seletor2 (c, b, w);
    xor Somaemsi (d, a, c);
    not NotSomaemsi (e, d);
    and Vai1 (exit2, a, e);
    and AllInput (f , x, y, w);
    or SomaIfVai1 (exit, d, f);
endmodule

module Exemplo_0703;
    reg x, y, w, z, k, x1, y1, w1, z1, x2, y2, w2, z2;
    wire a, b, c, d; 
    Somador2 PrieSec (k, a, z1, z1);
    Somador3 SeceTer (z, b, a , w1, w2);
    Somador3 TereQua (w, c, b, y1, y2);
    Somador4 QuaeQui (y, x, c, x1, x2);
    initial
    begin : main
        $display("Exemplo_0801 - Marcos Ani Cury Vinagre Silva - 684903");
        $display("   x    y    w    z    k");
        $monitor("%4b %4b %4b %4b %4b", x, y, w, z, k);
        x1 = 1'b0; y1 = 1'b0; w1 = 1'b0; z1 = 1'b0; x2 = 1'b0; y2 = 1'b0; w2 = 1'b0; z2 = 1'b0;
        #1 x1 = 1'b0; y1 = 1'b0; w1 = 1'b0; z1 = 1'b1; #1 x2 = 1'b0; y2 = 1'b0; w2 = 1'b0; z2 = 1'b1;
        #1 x1 = 1'b0; y1 = 1'b0; w1 = 1'b1; z1 = 1'b0; #1 x2 = 1'b0; y2 = 1'b0; w2 = 1'b1; z2 = 1'b0;
        #1 x1 = 1'b0; y1 = 1'b1; w1 = 1'b0; z1 = 1'b0; #1 x2 = 1'b0; y2 = 1'b1; w2 = 1'b0; z2 = 1'b0;
    end
endmodule