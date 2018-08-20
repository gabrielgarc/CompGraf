package primitivos;


public class Reta {		
	
	protected double calculaCoeficienteAngular(double pontoAX, double pontoAY, double pontoBX, double pontoBY) {
		return (pontoBY - pontoAY) /(pontoBX - pontoAX);
	}

	protected double calcularXPeloY(double coefAng, double pontoInicialX, double pontoInicialY, double coordenadaY) {
		return ((coordenadaY - pontoInicialY)/coefAng) + pontoInicialX;
	}

	protected double calcularYPeloX(double coefAng, double pontoInicialX, double pontoInicialY, double coordenadaX) {
		return (coefAng*(coordenadaX - pontoInicialX) + pontoInicialY);
	}
}
