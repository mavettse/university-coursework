module TOPsomador_display(SW, HEX0, HEX1);
	input [17:0] SW;
	output [6:0] HEX0, HEX1;
		
	wire [3:0] A, B;
	wire TE0;
	
	assign A = SW[17:14];
	assign B = SW[3:0];
	assign TE0 = SW[10];
	
	wire [5:0] S;
	wire [3:0] bcd_unidade, bcd_dezena;
	
	// somador4bits  (a, b, te0,  s);
	somador4bits soma(A, B, TE0, S);
	
	assign bcd_dezena = S / 10;
	assign bcd_unidade = S % 10;
	
	// decodificador(bcd, seg);
	decodificador(bcd_dezena, HEX1);
	decodificador(bcd_unidade, HEX0);
	
endmodule