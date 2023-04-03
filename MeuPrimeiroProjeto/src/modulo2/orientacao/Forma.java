package modulo2.orientacao;

public abstract class Forma {
	int altura;
	int largura;
	
	abstract double calcularArea(int altura, int largura);
	
	abstract double calcularVolume(int largura);
}
