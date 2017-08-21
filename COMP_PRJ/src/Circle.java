import java.awt.*;

public class Circle extends Shape {

	public Circle (Point a1, Point a2) {
		super (a1, a2);
		
	}
	public Object clone () {
		Circle l = new Circle (p1,p2);
		return l;
	}
	public void paint (Graphics g) {
		
		g.setColor(this.getColor());
		
		
		if(this.fill == true){
		
			if(p1.x < p2.x)
			{
				if(p1.y < p2.y){
					g.fillOval( p1.x, p1.y, (p2.x - p1.x), p2.y - p1.y);
				}
				else{
					g.fillOval( p1.x, p2.y, (p2.x - p1.x), p1.y - p2.y);
				}
			}
			else
			{
				if(p1.y < p2.y){
					g.fillOval( p2.x, p1.y, (p1.x - p2.x), p2.y - p1.y);
				}
				else{
					g.fillOval( p2.x, p2.y, (p1.x - p2.x), p1.y - p2.y);
				}
			}
			
		}
		else{
			if(p1.x < p2.x)
			{
				if(p1.y < p2.y){
					g.drawOval( p1.x, p1.y, (p2.x - p1.x), p2.y - p1.y);
				}
				else{
					g.drawOval( p1.x, p2.y, (p2.x - p1.x), p1.y - p2.y);
				}
			}
			else
			{
				if(p1.y < p2.y){
					g.drawOval( p2.x, p1.y, (p1.x - p2.x), p2.y - p1.y);
				}
				else{
					g.drawOval( p2.x, p2.y, (p1.x - p2.x), p1.y - p2.y);
				}
			}
		}
		
		// for overlapping with heavywheight shape
		super.paint(g);
		
	 }
}