module comparador1bit (a, b, habilita, maior, igual, menor);
	input a, b, habilita;
	output maior, igual, menor;

	assign maior = (a & ~b) & habilita;
	assign igual = (a ~^ b) & habilita;
	assign menor = (~a & b) & habilita;

endmodule