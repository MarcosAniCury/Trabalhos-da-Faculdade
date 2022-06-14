//------------------------------
//Exemplo_0502
//Nome: Victor Leite de Andrade
//Matricula: 656016
//------------------------------

module a(output s, input a,input b);//output == return && input == entrada de termos

wire not_a;// n conheço o tipo wire, mas pensei nele como um boolean
not NOT1(not_a,a);// envia o wire n declarado para ser colocado o valor de a negado
or OR1(s,not_a,b);// envia o wire e o b e é colocado o resultado no s

endmodule

module b(output s,input a,input b);

assign s = a | b;// Faz a comparação de a || b

endmodule

module Exemplo_0502;

reg x;
reg y;
wire a,b;
a moduloA(a,x,y);// Envia o a,x,y para a função a
b moduloB(b,x,y);// Envia o b,x,y para a função b

initial
begin:main
	$display("Exemplo_0502 - Victor Leite de Andrade - 656016");
	$display("   x    y    a    b");
	$monitor("%4b %4b %4b %4b",x,y,a,b);
	x = 1'b0; y = 1'b0;// declarando variáveis x e y
	#1 x = 1'b0; y = 1'b1;// Pelo que eu entendi isso é como se fosse recursividade
	#1 x = 1'b1; y = 1'b0;// são outros valores que x e y terão
	#1 x = 1'b1; y = 1'b1;// e dps o código será rodado de novo
end
endmodule
