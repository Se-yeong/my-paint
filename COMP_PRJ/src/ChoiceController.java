import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ChoiceController {
	private DrawingFrame bT;
	
	public ChoiceController(DrawingFrame jF)
	{		
		bT = jF;
		
		
		// Make choice and initialize it
		Choice colorChoice = new Choice();
		colorChoice.add("Black");
		colorChoice.add("Red");
		colorChoice.add("Green");
		colorChoice.add("Blue");

		
		Choice fillChoice = new Choice();
		fillChoice.add("empty");
		fillChoice.add("fill");
		
		
		// add choices to buttonPanel
		jF.getChoicePanel().add(colorChoice);
		jF.getChoicePanel().add(fillChoice);
		
		
		// Set a action when choice is clicked
		LocalColorChoiceHandler LCChH = new LocalColorChoiceHandler();
		colorChoice.addItemListener(LCChH);
		
		
		LocalFillChoiceHandler LFChH = new LocalFillChoiceHandler();
		fillChoice.addItemListener(LFChH);
		
		
	}
	
	private class LocalColorChoiceHandler implements ItemListener{
		public void itemStateChanged(ItemEvent arg0) {
			
			if(arg0.getItem().toString().equals("Black"))
			{
				bT.setCurrentColor(Color.BLACK);
				
			}
			else if(arg0.getItem().toString().equals("Red"))
			{
				bT.setCurrentColor(Color.RED);
			}
			else if(arg0.getItem().toString().equals("Green"))
			{
				bT.setCurrentColor(Color.GREEN);
			}
			else if(arg0.getItem().toString().equals("Blue"))
			{
				bT.setCurrentColor(Color.BLUE);
			}
			

		}
	}
		
	private class LocalFillChoiceHandler implements ItemListener{
		public void itemStateChanged(ItemEvent arg0) {
			
			if(arg0.getItem().toString().equals("fill"))
			{
				bT.setFillState(true);
			}
			else if(arg0.getItem().toString().equals("empty"))
			{
				bT.setFillState(false);
			}

		}
	}
}