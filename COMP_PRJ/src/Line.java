import java.awt.*;

import javax.swing.*;

public class Line extends Shape {
	public Line (Point a1, Point a2) {
		super (a1, a2);
		
	}
	public Object clone () {
		Line l = new Line (p1,p2);
		return l;
	}
	public void paint (Graphics g) {
		
		g.setColor(this.getColor());
		g.drawLine( p1.x, p1.y, p2.x, p2.y);
		
		// for overlapping with heavywheight shape
		super.paint(g);  
	}
}