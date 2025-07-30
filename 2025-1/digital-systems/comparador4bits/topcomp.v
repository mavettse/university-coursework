module topmodule(SW, LEDR);
	input [17:0] SW;
	output [10:1] LEDR;

	wire auxma, auxig, auxme;

	// module comparador4bits (a,     b,       maior,    igual,   menor);
	comparador4bits bloco (SW[17:14], SW[3:0], auxma, auxig, auxme);

	assign LEDR[10] = auxma;
	assign LEDR[5] = auxig;
	assign LEDR[1] = auxme;

	assign LEDR[9:6] = 4'b0;
	assign LEDR[4:2] = 3'b0;

endmodule