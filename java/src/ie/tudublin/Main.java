package ie.tudublin;

import D19123917.JinasVisual;


public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch(a, new JinasVisual());		
	} // end starUI()

	public static void main(String[] args)
	{
		Main main = new Main();   
		main.startUI();	
	} // end main()
	
} // end Main