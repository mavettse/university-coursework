module decodificador(SW, HEX0);
	input [17:14] SW;
	output [6:0] HEX0;
	
	wire A, B, C, D;
	wire sega, segb, segc, segd, sege, segf, segg;
	
	assign A = SW[17];
	assign B = SW[16];
	assign C = SW[15];
	assign D = SW[14];
	
	assign sega = (B & ~C & ~D) | (~A & ~B & ~C & D);
	assign segb = B & (C ^ D);
	assign segc = ~B & C & ~D;
	assign segd = (~A & ~B & ~C & D) | (B & (C ~^ D));
	assign sege = D | (B & ~C);
	assign segf = (C & D) | (~B & C) | (~A & ~B & D);
	assign segg = (~A & ~B & ~C) | (B & C & D);
	
	assign HEX0 = {segg, segf, sege, segd, segc, segb, sega};
	
endmodule