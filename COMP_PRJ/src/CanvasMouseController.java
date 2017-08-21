import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class CanvasMouseController implements MouseMotionListener, MouseListener {
	private DrawingFrame bT;
	private Point p1, p2;
	
	public CanvasMouseController(DrawingFrame jF){
		
		bT = jF;
		p1 = new Point();
		p2 = new Point();
		
	}
	
	public void mouseDragged(MouseEvent arg0) {

		p2 = arg0.getPoint();
		bT.removeFrontShape();
		bT.addShape(p1, p2);	
	}

	public void mouseMoved(MouseEvent arg0) {

	}

	public void mouseClicked(MouseEvent arg0) {
		
		
		
	}

	public void mousePressed(MouseEvent arg0) {
		
		p1 = arg0.getPoint();
		p2 = arg0.getPoint();

		bT.addShape(p1, p2);
	}

	public void mouseReleased(MouseEvent arg0) {
		
		p2 = arg0.getPoint();
		bT.removeFrontShape();
		bT.addShape(p1, p2);	
	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}
}
