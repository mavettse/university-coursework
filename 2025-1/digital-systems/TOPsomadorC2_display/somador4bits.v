// Giovanni Estevam Dos Santos
// 12/06/2025
// projeto somador com complemento de 2 no display

module somador4bits(a, b, te0, s);
	input [3:0] a, b;
	input te0;
	output [5:0] s;
	
	wire [3:0] bT;
	assign bT[3] = b[3] ^ te0;
	assign bT[2] = b[2]	^ te0;
	assign bT[1] = b[1] ^ te0;
	assign bT[0] = b[0] ^ te0;

	wire [4:0] ts;
	wire tsf;
	
	// somador1bit   (a,    b,    te,     s,    ts);
	somador1bit bit0 (a[0], bT[0], te0,    s[0], ts[0]);
	somador1bit bit1 (a[1], bT[1], ts[0],  s[1], ts[1]); 
	somador1bit bit2 (a[2], bT[2], ts[1],  s[2], ts[2]); 
	somador1bit bit3 (a[3], bT[3], ts[2],  s[3], ts[3]);  
	somador1bit bit4 (1'b0, 1'b0 ^ te0,  ts[3],  s[4], ts[4]); 
	somador1bit bitS (1'b0, 1'b0 ^ te0,  ts[4],  s[5], tsf); 
	
endmodule