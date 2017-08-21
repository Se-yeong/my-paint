import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DrawingFrame extends JFrame {
	private ShapeContainer shapeContainer;
	private Panel buttonPanel; 
	private Panel choicePanel;
	
	private int currentShape;
	private Color currentColor;
	
	private boolean fillState;
	
	private WhiteBoardService rmiModule;
	private String entity;
	
	
	public DrawingFrame(String title, WhiteBoardService rmi)
	{
		super(title);
		entity = title;
		
		
		/*	button starts		*/
		
		
		// Make a Panel instance in Constructor of DrawingFrame 
		buttonPanel = new Panel();
		
		// Make a button controller and make buttons in buttonController
		ButtonController buttonController = new ButtonController(this);

		// align panel at South 
		this.getContentPane().add("South", buttonPanel);
		
		
		
		/*	button ends		*/
		
		
		
		
		
		/*	choice starts		*/
		
		
		choicePanel = new Panel();
		
		ChoiceController choiceController = new ChoiceController(this);
		
		// align panel at East
		this.getContentPane().add("East", choicePanel);
		
		
		/*	choice ends			*/
		

		
		/*	label starts		*/
		
		
		Panel namePanel = new Panel(); 		// Make Panel
		
		Label drawingLabel = new Label();	// Make Label
		drawingLabel.setText("±×¸²ÆÇ ");
		
		// set layout of Panel to the label locates left upside.
		namePanel.setLayout(new BorderLayout());	 
		namePanel.add("West",drawingLabel);
		
		this.getContentPane().add("North", namePanel);
		
		
		/*	label ends			*/		
		
		
		
		
		/*	shapeContainer starts		*/
		
		
		shapeContainer = new ShapeContainer();
		
		this.getContentPane().add("Center", shapeContainer);
		
		
		/*	shapeContainer ends			*/
		

		
		/* Mouse control starts */
		
		CanvasMouseController CMouseC = new CanvasMouseController(this);
		
		shapeContainer.addMouseListener(CMouseC);			// to listen mouse clicked
		shapeContainer.addMouseMotionListener(CMouseC);		// to listen mouse dragging

		/* Mouse control ends */
		
		
		
		currentShape = new Shape().LINE;
		currentColor = Color.BLACK;
		fillState = false;

		rmiModule = rmi;

		addWindowListener(new LocalWindowListener());

		setSize(500,500);
		show();	
	}
	
	public Container getShapeContainer() { return shapeContainer; }
	public Panel getButtonPanel() { return buttonPanel; }
	public Panel getChoicePanel() { return choicePanel; }
	public void setCurrShape(int shape) { currentShape = shape; }
	public int getCurrShape() { return currentShape; }
	public void setShapeContainer(ShapeContainer s) { getContentPane().add(s); }
	
	public void addShape(Point p1, Point p2)
	{
		
		Shape newShape = new Line(p1,p2);
		
		if (getCurrShape() == new Shape().CIRCLE)
		{
			newShape = new Circle(p1,p2);
		}
		else if (getCurrShape() == new Shape().RECT)
		{
			newShape = new Rectangular(p1,p2);
		}
		
		
		newShape.setColor(getCurrentColor());
		newShape.setFill(getFillState());
		newShape.setBounds(0,0,getShapeContainer().getWidth(), getShapeContainer().getHeight());

		
		try {
			
			getShapeContainer().add(newShape);
			rmiModule.add(newShape,entity);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		repaint();
	}
	


	
	public void removeFrontShape()
	{
		try {
			rmiModule.removeFrontShape(entity);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	public void removeAll()
	{
		try {
			rmiModule.removeAll(entity);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	public void setCurrentColor(Color c) { currentColor = c; }
	public Color getCurrentColor() { return currentColor; }
	
	public void setFillState(boolean b) { fillState = b; }
	public boolean getFillState() { return fillState; }
	
	public WhiteBoardService getRmiModule() { return rmiModule; }
	public void setRmiModule(WhiteBoardServiceImpl m) { rmiModule = m; }
	
	private class LocalWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
	
	
	
	
}













