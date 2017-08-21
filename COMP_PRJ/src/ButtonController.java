import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController {
	private DrawingFrame bT;
	
	public ButtonController(DrawingFrame jF)
	{
		bT = jF;
		
		// Make Button instances
		Button lineButton = new Button("line");
		Button circleButton = new Button("circle");
		Button rectButton = new Button("rect");
		Button clearButton = new Button("clear All");
		
		// add buttons to buttonPanel
		jF.getButtonPanel().add(lineButton);
		jF.getButtonPanel().add(circleButton);
		jF.getButtonPanel().add(rectButton);
		jF.getButtonPanel().add(clearButton);
		
		
		LocalButtonHandler LBH = new LocalButtonHandler();
		
		
		// Set a action when button is clicked
		lineButton.addActionListener(LBH);
		circleButton.addActionListener(LBH);
		rectButton.addActionListener(LBH);
		clearButton.addActionListener(LBH);
		
	}
	
	private class LocalButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			
			if(ae.getActionCommand().equals("line")) 
			{
				bT.setCurrShape(new Shape().LINE);
			}
			else if(ae.getActionCommand().equals("circle"))
			{
				bT.setCurrShape(new Shape().CIRCLE);
			}
			else if(ae.getActionCommand().equals("rect"))
			{
				bT.setCurrShape(new Shape().RECT);
			}
			else if(ae.getActionCommand().equals("clear All"))
			{
				bT.removeAll();
			}
		}
	}
}