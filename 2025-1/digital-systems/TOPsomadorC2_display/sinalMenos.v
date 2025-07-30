// Giovanni Estevam Dos Santos
// 12/06/2025
// projeto somador com complemento de 2 no display

module sinalMenos(bitSinal, seg);
	input bitSinal;
	output [6:0] seg;
	
	wire sega, segb, segc, segd, sege, segf, segg;

	assign sega = 1'b1;
	assign segb = 1'b1;
	assign segc = 1'b1;
	assign segd = 1'b1;
	assign sege = 1'b1;
	assign segf = 1'b1;
	assign segg = ~bitSinal;

	assign seg = {segg, segf, sege, segd, segc, segb, sega};
endmodule