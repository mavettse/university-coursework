module somador4bits(a, b, te0, s);
	input [3:0] a, b;
	input te0;
	output [4:0] s;
	
	wire [3:0] ts;
	
	// somador1bit   (a,    b,    te,     s,    ts);
	somador1bit bit0 (a[0], b[0], te0,    s[0], ts[0]);
	somador1bit bit1 (a[1], b[1], ts[0],  s[1], ts[1]); 
	somador1bit bit2 (a[2], b[2], ts[1],  s[2], ts[2]); 
	somador1bit bit3 (a[3], b[3], ts[2],  s[3], ts[3]);  
	somador1bit bit4 (1'b0, 1'b0, ts[3],  s[4], ); 
	
endmodule