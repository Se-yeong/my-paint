import java.awt.*;

public class Rectangular extends Shape {

	public Rectangular (Point a1, Point a2) {
		super (a1, a2);
		
	}
	public Object clone () {
		Rectangular l = new Rectangular (p1,p2);
		return l;
	}
	public void paint (Graphics g) {
			
		g.setColor(this.getColor());
		
		if(this.fill == true){
			if(p1.x < p2.x)
			{
				if(p1.y < p2.y){
					g.fillRect( p1.x, p1.y, (p2.x - p1.x), p2.y - p1.y);
				}
				else{
					g.fillRect( p1.x, p2.y, (p2.x - p1.x), p1.y - p2.y);
				}
			}
			else
			{
				if(p1.y < p2.y){
					g.fillRect( p2.x, p1.y, (p1.x - p2.x), p2.y - p1.y);
				}
				else{
					g.fillRect( p2.x, p2.y, (p1.x - p2.x), p1.y - p2.y);
				}
			}
			
		}
		else{
			if(p1.x < p2.x)
			{
				if(p1.y < p2.y){
					g.drawRect( p1.x, p1.y, (p2.x - p1.x), p2.y - p1.y);
				}
				else{
					g.drawRect( p1.x, p2.y, (p2.x - p1.x), p1.y - p2.y);
				}
			}
			else
			{
				if(p1.y < p2.y){
					g.drawRect( p2.x, p1.y, (p1.x - p2.x), p2.y - p1.y);
				}
				else{
					g.drawRect( p2.x, p2.y, (p1.x - p2.x), p1.y - p2.y);
				}
			}
		}
		
		// for overlapping with heavywheight shape
		super.paint(g);

	}
}