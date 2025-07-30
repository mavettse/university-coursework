module divisor(CLOCK_50, reset, novo_clock);

	input CLOCK_50, reset;
	output novo_clock;
	
	reg [23:0] Q;
	
	always @(posedge CLOCK_50 or posedge reset)
	begin
		if(reset == 1'b1)
			Q = 24'b0000;
		else 
			Q = Q + 1;
	end
	
	assign novo_clock = Q[23];
	
endmodule