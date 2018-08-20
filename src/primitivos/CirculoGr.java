package primitivos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CirculoGr extends Circulo{
	
	GraphicsContext g;
	
	public CirculoGr(GraphicsContext g) {
		this.g = g;
	}
	
	public void desenharCirculo(Color cor, PontoGr pontoA, PontoGr pontoB) {
		
		double raio = calcularRaio(pontoA.getx(), pontoA.getY() , pontoB.getx(), pontoB.getY());
		
		double i = 0;
		while(i < Math.PI/2) {
			
			int x = (int)Math.ceil(calcularX(pontoB.getx(), i, raio));
			int y = (int)Math.ceil(calcularY(pontoB.gety(), i, raio));
			
			PontoGr ponto = new PontoGr(x,y, cor, "", 1);	
			ponto.desenharPonto(this.g);
			
			x = (int)Math.ceil(calcularX(pontoB.getx(), i, -raio));
			y = (int)Math.ceil(calcularY(pontoB.gety(), i, -raio));
			
			PontoGr ponto1 = new PontoGr(x,y, cor, "", 1);	
			ponto1.desenharPonto(this.g);
			
			x = (int)Math.ceil(calcularX(pontoB.getx(), i, raio));
			y = (int)Math.ceil(calcularY(pontoB.gety(), i, -raio));
			
			PontoGr ponto2 = new PontoGr(x,y, cor, "", 1);	
			ponto2.desenharPonto(this.g);
			
			x = (int)Math.ceil(calcularX(pontoB.getx(), i, -raio));
			y = (int)Math.ceil(calcularY(pontoB.gety(), i, raio));
			
			PontoGr ponto3 = new PontoGr(x,y, cor, "", 1);	
			ponto3.desenharPonto(this.g);
			
			i = i + 0.0008;
		}
	}
}
