// Giovanni Estevam Dos Santos
// 12/06/2025
// projeto somador com complemento de 2 no display

module TOPsomadorC2_display(SW, HEX0, HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7);
	input [17:0] SW;
	output [6:0] HEX0, HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7;
		
	wire [3:0] A, B;
	wire TE0;
	
	assign A = SW[17:14];
	assign B = SW[3:0];
	assign TE0 = SW[10];
	
	wire [5:0] S;
	wire [3:0] bcd_unidade, bcd_dezena;
	
	// somador4bits  (a, b, te0,  s);
	somador4bits soma(A, B, TE0, S);
	
	wire [5:0] sT;
	wire bitSinal;
	modulo somaTransformada(S, sT, bitSinal);
	
	assign bcd_dezena = sT / 4'b1010;
	assign bcd_unidade = sT % 4'b1010;
	
	assign HEX3 = 7'b1111111;
	assign HEX4 = 7'b1111111;
	assign HEX5 = 7'b1111111;
	assign HEX6 = 7'b1111111;
	assign HEX7 = 7'b1111111;
	
	// decodificador(bcd, seg);
	decodificador(bcd_dezena, HEX1);
	decodificador(bcd_unidade, HEX0);
	sinalMenos(bitSinal, HEX2);
	
endmodule