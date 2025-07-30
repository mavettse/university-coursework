module comparador1bit (a, b, maior, igual, menor);
	input a, b;
	output maior, igual, menor;

	assign maior = a & ~b;
	assign igual = a ~^ b;
	assign menor = ~a & b;

endmodule
	