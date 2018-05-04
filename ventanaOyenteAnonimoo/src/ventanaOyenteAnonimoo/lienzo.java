package ventanaOyenteAnonimoo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;



public class lienzo extends JPanel{

	
	private Color colorFondo;
	private int XOrigen=200, YOrigen=150;
	private int FiguraX = XOrigen - 200;
    private int FiguraY = YOrigen -250;
    private Graphics g;
	
	private accionesRaton oyenteRaton;
	
	   public void setCoordXOrig(int XOrigen){
	        this.XOrigen = XOrigen;
	    }

	    public void setCoordYOrig(int YOrigen){
	        this.YOrigen = YOrigen;
	    }
	
  public lienzo(){
  
	  super();
	  
	  //Obtener el ancho y alto del JFrame
	  this.setPreferredSize(new Dimension(800,400));
	  this.colorFondo = Color.BLACK;
	  this.setBackground(colorFondo);
	  
	  accionesRaton oyenteRaton = new accionesRaton();
	  this.addMouseListener(oyenteRaton);
	  this.addMouseMotionListener(oyenteRaton);
	  
	  this.addKeyListener(new KeyListener() {

          @Override
          public void keyPressed(KeyEvent e) {
              if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            	  FiguraX = FiguraX + 30;
                  repaint();
              }

              if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            	  FiguraX = FiguraX - 30;
                  repaint();
              }

              if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                  FiguraY = FiguraY + 30;
                  repaint();
              }

              if(e.getKeyCode() == KeyEvent.VK_UP) {
                  FiguraY = FiguraY - 30;
                  repaint();
              }
          }

          @Override
          public void keyReleased(KeyEvent e) {
          }

          @Override
          public void keyTyped(KeyEvent e) {
          }

      });
      this.setFocusable(true);
      this.requestFocusInWindow();
  }
  
  @Override
  public void paintComponent(Graphics g){
  
	  super.paintComponent(g);
	  
	    XOrigen = this.getWidth()/2;
		YOrigen = this.getHeight()/2;
		
	  //Colorear el fondo de la pantalla
	  g.setColor(this.colorFondo);
	  g.fillRect(0, 0, this.getWidth(), this.getHeight());
	  //XOrigen = this.getWidth()/2;
	  //YOrigen = this.getHeight()/2;
	  
	  //Creacion de la linea en X y Y
	  g.setColor(Color.RED);
	  g.drawLine(0, YOrigen,this.getWidth(), YOrigen);
	  g.drawLine(XOrigen, 0, XOrigen, this.getHeight());
	  
	  repaint();
	  
	  int nValoresNegY = (YOrigen/40)*-1;
	  int nValoresPosY = (this.getHeight()-YOrigen/40);
	  
	  //Dibujar la marca de eje Y
	  for(int valorY=nValoresNegY; valorY<=nValoresPosY;valorY++){
	  
	  g.drawLine(XOrigen+10, YOrigen+(valorY*40),XOrigen-10 ,YOrigen+(valorY*40));
	  if(valorY!=0)
	  g.drawString( ""+valorY*-1,XOrigen+20,YOrigen+(valorY*40));  
	  
	 
	  }
	  
	  //Calculos
	  int nValoresNeg = (XOrigen/40)*-1;
	  int nValoresPos = (this.getWidth()-XOrigen/40);
	  
	  //Dibujar la marca de eje x
	  for(int valorX=nValoresNeg; valorX<=nValoresPos;valorX++)
	  {
	  g.drawLine(XOrigen+(valorX*40), YOrigen-10, XOrigen+(valorX*40),YOrigen+10);
	  g.drawString(""+valorX, XOrigen+(valorX*40), YOrigen+30);
	  
	  /*g.drawLine(XOrigen-(valorX*40), YOrigen-10, XOrigen-(valorX*40),YOrigen+10);
	  g.drawString("-"+valorX, XOrigen-(valorX*40), YOrigen+30);
	  */
	  }
	  
	  /* int numValores = (int)(XOrigen/40+1);
      int XActual = XOrigen - numValores *40;
      for(int valor = 0 - numValores; valor <= ((this.getWidth()/2)/40); valor++) {
          g.drawLine(XActual, YOrigen - 5, XActual, YOrigen + 5);
         g.drawString("" +valor, XActual-10, YOrigen + 20);
          //para ubicar el texto 5 pixeles debajo de la línea y centrado hay que cálculo
          XActual += 40;
      }*/
      
      
      //graficarSeno(g, XOrigen, YOrigen);
	  
	  //dibujaGraficaSeno(g);
	  graficarFigura(g);
	  
  }
  
  //public void dibujaGraficaSeno(Graphics g){
  
	//  int factorX=1, factorY=100;
	  //int coordPantX, coordPantY;
	  //double gradRad,seno;
	  //g.setColor(Color.YELLOW);
	  
	  //for(int grad = 0; grad<361; grad++){
		//  gradRad = Math.toRadians(grad);
		  
		  //seno = Math.sin(gradRad);
		  
		  //coordPantX = XOrigen +(grad * factorX);
		  //coordPantY = (int) (YOrigen -(seno * factorY));
		  
		  //Dibujar el punto (x,y)
		  //g.fillRect(coordPantX,  coordPantY,  5, 5);
	  //}
  //}
  
  
  /*public void graficarSeno(Graphics g, int x, int y ){
      float gradRad;
      float sinGrad;
      int XActual = x, YActual = y;
      g.setColor(Color.red);
      for(int grad = 0; grad < 361; grad++){
          gradRad = (float) Math.toRadians(0);
          sinGrad = (float) Math.sin(gradRad);
          g.fillRect(XActual, YActual, 5,5);
          XActual +=  grad * 3;
          YActual += sinGrad *200;
      }
  }*/

public Color getColorFondo() {
	return colorFondo;
}

public void setColorFondo(Color colorFondo) {
	this.colorFondo = colorFondo;
}

class accionesRaton extends MouseAdapter implements  MouseMotionListener{

	boolean bandMueveOrigen=false;
	@Override
	public void mouseClicked(MouseEvent e){
	
		//Click derecho activa modificacion de coord origen
		if(e.getButton() == MouseEvent.BUTTON3){
		
			if(((e.getX()>= XOrigen-20)&& (e.getX()<= XOrigen+20) )&&((e.getY()>= YOrigen-20)&& (e.getY()<= YOrigen+20) )){
			
				bandMueveOrigen = true;
				
			}
			
		}//Click derecho desactiva modificacion de coord origen
		else if(e.getButton() == MouseEvent.BUTTON1){
		
			bandMueveOrigen = false;
		}
		//System.out.println(" X= "+e.getX() +" Y= "+e.getY()+" Origen= ("+XOrigen+","+ YOrigen+")"+" Boton= "+e.getButton()+" mover= "+ bandMueveOrigen);
			
	}
	

	@Override
	public void mouseMoved(MouseEvent e){
	
		//System.out.println("Pos ("+e.getX() +","+e.getY()+")"+" Origen= ("+XOrigen+","+ YOrigen+")"+" Boton= "+e.getButton()+" mover= "+ bandMueveOrigen);
		
		//Si la bandMueveOrigen esta activa
		//Cambiar x,y del origen con la posicion actual de cursor
		if(bandMueveOrigen){
		
			XOrigen=e.getX();
			YOrigen=e.getY();
			repaint();
		}
	}
}//Donde puedo asignar el valor de XOrigen y YOrigen

public void graficarFigura(Graphics g){
    g.setColor(Color.BLUE);
    g.drawOval(FiguraX+300,FiguraY+230,100,100);

}
}