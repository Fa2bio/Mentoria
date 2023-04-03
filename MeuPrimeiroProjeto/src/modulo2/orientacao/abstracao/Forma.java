package modulo2.orientacao.abstracao;

public abstract class Forma {
	int altura;
	int largura;
	
	abstract double calcularArea(int altura, int largura);
	
	abstract double calcularVolume(int largura);
}
