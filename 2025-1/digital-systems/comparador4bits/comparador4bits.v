module comparador4bits (a, b, maior, igual, menor);
	input [3:0] a, b; // entradas recebem o valor de fora
	output maior, igual, menor; // saídas recebem o valor de dentro e dirigem à saída

	wire [3:0] auxma, auxig, auxme;

	//module comparador1bit (a,  b,    habilita, maior,    igual,    menor);
	comparador1bit bit4 (a[3], b[3], 1'b1,     auxma[3], auxig[3], auxme[3]);
	comparador1bit bit3 (a[2], b[2], auxig[3], auxma[2], auxig[2], auxme[2]);
	comparador1bit bit2(a[1], b[1], auxig[2], auxma[1], auxig[1], auxme[1]);
	comparador1bit bit1 (a[0], b[0], auxig[1], auxma[0], auxig[0], auxme[0]);

	assign maior = |auxma;
	assign igual = auxig[0];
	assign menor = |auxme;

endmodule