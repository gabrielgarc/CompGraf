package primitivos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Reta {
	
	private GraphicsContext g;
	
	public Reta(GraphicsContext g) {
		this.g = g;
	}

	public void desenharReta(Color cor, PontoGr pontoA, PontoGr pontoB){
			
			int pontoContinuo;
			PontoGr pontoInicial;
			PontoGr pontoFinal;
			
			double coefAng = calculaCoeficienteAngular(pontoA, pontoB);
			
			double deltaX = Math.abs(pontoA.getX() - pontoB.getX());
			double deltaY = Math.abs(pontoA.getY() - pontoB.getY());
			
			if(deltaX > deltaY){
			
				if(pontoA.getX() < pontoB.getX()){
					pontoInicial = pontoA;
					pontoFinal = pontoB;
					
				} else {
					pontoInicial = pontoB;
					pontoFinal = pontoA;
				}
				
				for(pontoContinuo = (int)pontoInicial.getX() + 1; pontoContinuo < pontoFinal.getX(); pontoContinuo++){
					
					int y = calcularYPeloX(coefAng, pontoA, pontoContinuo);
					desenharPonto(pontoContinuo, y, cor);					
				}
				
			} else {
				if(pontoA.getY() < pontoB.getY()){
					pontoInicial = pontoA;
					pontoFinal = pontoB;
				
				} else {
					pontoInicial = pontoB;
					pontoFinal = pontoA;					
				}
				
				for(pontoContinuo = (int)pontoInicial.getY() + 1; pontoContinuo < pontoFinal.getY(); pontoContinuo++){
					
					int x = calcularXPeloY(coefAng, pontoA, pontoContinuo);
					desenharPonto(x, pontoContinuo, cor);	
				}
			}			
	}
	
	private double calculaCoeficienteAngular(PontoGr pontoA, PontoGr pontoB) {
		return (pontoB.getY() - pontoA.getY()) /(pontoB.getX() - pontoA.getX());
	}
	
	private void desenharPonto(int x, int y, Color cor) {		
		PontoGr ponto = new PontoGr(x, y, cor, "", 1);		
		
		ponto.desenharPonto(this.g);
	}

	private int calcularXPeloY(double coefAng, PontoGr pontoInicial, int coordenadaY) {
		return (int)(((coordenadaY - pontoInicial.getY())/coefAng) + pontoInicial.getX());
	}

	private int calcularYPeloX(double coefAng, PontoGr pontoInicial, int coordenadaX) {
		return (int)(coefAng*(coordenadaX - pontoInicial.getX()) + pontoInicial.getY());
	}
}
