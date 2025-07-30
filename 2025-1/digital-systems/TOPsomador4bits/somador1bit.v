module somador1bit(a, b, te, s, ts);
	input a, b, te;
	output s, ts;
	
	assign s = (a^b^te);
	assign ts = ((a & b) | (te & (a ^ b)));
	
endmodule
