// Giovanni Estevam Dos Santos
// 12/06/2025
// projeto somador com complemento de 2 no display

module somador6bits(a, te0, s);
	input [5:0] a;
	input te0;
	output [5:0] s;
	
	// o somador sera usado somente para pegar o módulo de um número
	wire [5:0] ts;
	wire tsf;
	
	// somador1bit   (a,    b,    te,     s,    ts);
	somador1bit bit0 (a[0], 1'b0, te0,    s[0], ts[0]);
	somador1bit bit1 (a[1], 1'b0, ts[0],  s[1], ts[1]); 
	somador1bit bit2 (a[2], 1'b0, ts[1],  s[2], ts[2]); 
	somador1bit bit3 (a[3], 1'b0, ts[2],  s[3], ts[3]);  
	somador1bit bit4 (a[4], 1'b0, ts[3],  s[4], ts[4]); 
	somador1bit bit5 (a[5], 1'b0, ts[4],  s[5], ts[5]); 
	
endmodule