// Giovanni Estevam Dos Santos
// 12/06/2025
// projeto somador com complemento de 2 no display

module somador1bit(a, b, te, s, ts);
	input a, b, te;
	output s, ts;
		
	assign s = (a^b^te);
	assign ts = ((a & b) | (te & (a ^ b)));
	
endmodule