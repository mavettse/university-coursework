module contador_decada(CLOCK_50, SW, HEX7, HEX6, HEX5, HEX4, HEX3, HEX2, HEX1, HEX0);

	input CLOCK_50;
	input [17:16] SW;
	output [6:0] HEX7, HEX6, HEX5, HEX4, HEX3, HEX2, HEX1, HEX0;
	
	assign {HEX7, HEX6, HEX5, HEX4, HEX3, HEX2, HEX1} = {7{7'b1111111}};
	
	reg [3:0] Q;
	wire reset = SW[17];
	wire set = SW[16];
	wire novo_clock;
	
	divisor BLOCO1(CLOCK_50, reset, novo_clock);
	
	always @(posedge novo_clock or posedge reset or posedge set)
	begin
		if(reset == 1'b1)
			Q = 4'b0000;
		else if(set == 1'b1)
			Q = 4'b1001;
		else 
			Q = Q + 1;
	end
		
	decodificador BLOCO2(Q, HEX0);
	
endmodule