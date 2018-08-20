package primitivos;

public class Circulo {
	
	public double calcularRaio(double centroX, double centroY, double pontoCircX, double pontoCircY) {
		return Math.sqrt(((centroX-pontoCircX)*(centroX-pontoCircX)) + ((centroY-pontoCircY)*(centroY-pontoCircY)));
	}
	
	public double calcularX(double centroX, double grau, double raio) {
		return centroX + (Math.cos(grau)*raio);
	}
	
	public double calcularY(double centroY, double grau, double raio) {
		return centroY + (Math.sin(grau)*raio);
	}


}
