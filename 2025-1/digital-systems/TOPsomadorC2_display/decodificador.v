// Giovanni Estevam Dos Santos
// 12/06/2025
// projeto somador com complemento de 2 no display

module decodificador(bcd, seg);
	input [3:0] bcd;
	output [6:0] seg;
		
	wire A, B, C, D;
	assign A = bcd[3];
   assign B = bcd[2];
   assign C = bcd[1];
   assign D = bcd[0];
	
   wire sega, segb, segc, segd, sege, segf, segg;

   assign sega = (B & ~C & ~D) | (~A & ~B & ~C & D);
   assign segb = B & (C ^ D);
   assign segc = ~B & C & ~D;
   assign segd = (~A & ~B & ~C & D) | (B & (C ~^ D));
   assign sege = D | (B & ~C);
   assign segf = (C & D) | (~B & C) | (~A & ~B & D);
   assign segg = (~A & ~B & ~C) | (B & C & D);

   assign seg = {segg, segf, sege, segd, segc, segb, sega};		
	
endmodule