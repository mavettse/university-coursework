module farol(f,p,c,s);

	input f,p,c;
	output s;
	
	assign s = f&~p | f&~c;
	
endmodule