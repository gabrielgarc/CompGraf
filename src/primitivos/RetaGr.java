package primitivos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RetaGr extends Reta{

	GraphicsContext g;
	
	public RetaGr(GraphicsContext g) {
		this.g = g;
		// TODO Auto-generated constructor stub
	}
	
	public void desenharReta(Color cor, PontoGr pontoA, PontoGr pontoB){
		
		double pontoContinuo;
		PontoGr pontoInicial;
		PontoGr pontoFinal;
		
		double coefAng = calculaCoeficienteAngular(pontoA.getx(),pontoA.gety(), pontoB.getx(), pontoB.gety());
		
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
			
			for(pontoContinuo = pontoInicial.getX() + 1; pontoContinuo < pontoFinal.getX(); pontoContinuo++){
				
				double y = calcularYPeloX(coefAng, pontoA.getx(), pontoA.gety(), pontoContinuo);
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
			
			for(pontoContinuo = pontoInicial.getY() + 1; pontoContinuo < pontoFinal.getY(); pontoContinuo++){
				
				double x = calcularXPeloY(coefAng, pontoA.getx(), pontoA.gety(), pontoContinuo);
				desenharPonto(x, pontoContinuo, cor);	
			}
		}			
}
	
	private void desenharPonto(double x, double y, Color cor) {		
		PontoGr ponto = new PontoGr((int)x, (int)y, cor, "", 3);		
		
		ponto.desenharPonto(this.g);
	}

}
