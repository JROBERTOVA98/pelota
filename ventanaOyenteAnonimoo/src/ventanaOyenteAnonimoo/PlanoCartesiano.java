package ventanaOyenteAnonimoo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PlanoCartesiano extends JFrame 
{

	
	public PlanoCartesiano(){
	
		Container contenedorPrinc = getContentPane();
		contenedorPrinc.setLayout(new BoxLayout(contenedorPrinc,BoxLayout.Y_AXIS));
		
		
		lienzo primero = new lienzo();
		
		contenedorPrinc.add(primero);
		
		
		JPanel segundo = new JPanel();
		segundo.setLayout(new FlowLayout());
		//Agregamos Botones al panel
		JLabel lblAncho = new JLabel("Ancho");
		lblAncho.setPreferredSize(new Dimension(50,20));
		
		JTextField edtAncho = new JTextField();
		edtAncho.setPreferredSize(new Dimension(100,20));
		
		JLabel lblAlto = new JLabel("Alto");
		lblAlto.setPreferredSize(new Dimension(50,20));
		
		JTextField edtAlto = new JTextField();
		edtAlto.setPreferredSize(new Dimension(100,20));
		
		JButton btnTamanioSegundo = new JButton("Establecer");
		
		
		TitledBorder segundo2= BorderFactory.createTitledBorder("Pixeles");
		segundo2.setTitleColor(Color.RED);
		segundo.setBorder(segundo2);
		segundo.add(lblAncho);
		segundo.add(edtAncho);
		segundo.add(lblAlto);
		segundo.add(edtAlto);
		segundo.add(btnTamanioSegundo);
		contenedorPrinc.add(segundo);
		
		JButton btnColorPanel = new JButton("CambiarColor");
		segundo.add(btnColorPanel);
		
		btnColorPanel.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Color ColorPanel = JColorChooser.showDialog(btnColorPanel, "Seleccionra color",primero.getBackground());
							
						 if (ColorPanel != null){
							 primero.setBackground(ColorPanel);
						 }
					
					}
				}
			
		);
		
		btnTamanioSegundo.addActionListener(
				//class MiClase implements ActionListener
				new ActionListener(){
				
			       public void actionPerformed(ActionEvent event){
			       
			    	   //primero.setPreferredSize(new Dimension(Integer.parseInt(edtAncho.getText()), Integer.parseInt(edtAncho.getText())));
			    	   PlanoCartesiano.this.setSize(Integer.parseInt(edtAncho.getText()),Integer.parseInt(edtAlto.getText()));
			    	   
			       }
				});
	}
	
	public static void main(String[] args){
	
		PlanoCartesiano plano2D = new PlanoCartesiano();
		
		plano2D.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		plano2D.setSize(600,600);
		plano2D.setResizable(false);
		plano2D.setVisible(true);
	}
}