// Giovanni Estevam Dos Santos
// Projeto decodificador com descrição comportamental utilizando case

module decod_case(SW, HEX0, HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7);
	input [3:0] SW;
	output reg [0:6] HEX0;
	output [0:6] HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7;
	
	assign {HEX7, HEX6, HEX5, HEX4, HEX3, HEX2, HEX1} = {7{7'b1111111}};
	
	always @(SW[3:0]) 
	begin
		case ({SW[3:0]})
			4'b0000: HEX0 = 7'b0000001;
			4'b0001: HEX0 = 7'b1001111;
			4'b0010: HEX0 = 7'b0010010;
			4'b0011: HEX0 = 7'b0000110;
			4'b0100: HEX0 = 7'b1001100;
			4'b0101: HEX0 = 7'b0100100;
			4'b0110: HEX0 = 7'b0100000;
			4'b0111: HEX0 = 7'b0001111;
			4'b1000: HEX0 = 7'b0000000;
			4'b1001: HEX0 = 7'b0000100;
			default: HEX0 = 7'b1111111;
		endcase;
	end
	
endmodule