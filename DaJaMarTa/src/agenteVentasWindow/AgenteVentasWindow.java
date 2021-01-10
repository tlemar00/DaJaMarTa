package agenteVentasWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AgenteVentasWindow {

	public static void main(String[] args) {

		ListaPropiedades miMarco = new ListaPropiedades();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Lamina miLamina = new Lamina();
		miMarco.add(miLamina);
		
		
	}

}


class ListaPropiedades extends JFrame {
	
	public ListaPropiedades() {			
			
			setTitle("***NOMBRE DEL AGENTE DE VENTAS***");
			setBounds(700, 300, 500, 300);
			setBackground(new Color(127, 127, 200));
		}
}

class Lamina extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponents(g);
		
		int i=1, numPropiedades=8, nY=15;
		for(i=1;i<numPropiedades; i++) {
			g.drawString("Propiedad número " +i + ": BDD.name", 12, nY);
			nY+=20;
		}
	}
	
}



