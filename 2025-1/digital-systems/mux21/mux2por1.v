// Giovanni Estevam
// Projeto Mux 2:1
// 18/06/2025

module mux2por1(I0, I1, sel, s);
	input I0, I1, sel;
	output s;
	
	assign s = (~sel & I0) | (sel & I1);
	
endmodule