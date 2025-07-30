// Giovanni Estevam Dos Santos
// 12/06/2025
// projeto somador com complemento de 2 no display

module modulo(s, sT, bitSinal);
		input [5:0] s;
		output [5:0] sT;
		output bitSinal;
		
		assign bitSinal = s[5];
		
		wire [5:0] invertido; 
		assign invertido[5] = s[5] ^ bitSinal;
		assign invertido[4] = s[4] ^ bitSinal;
		assign invertido[3] = s[3] ^ bitSinal;
		assign invertido[2] = s[2] ^ bitSinal;
		assign invertido[1] = s[1] ^ bitSinal;
		assign invertido[0] = s[0] ^ bitSinal;		
		
		somador6bits (invertido, bitSinal, sT);
		
endmodule
