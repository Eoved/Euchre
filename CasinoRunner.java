//Andrew DeVoe

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.*;
import javax.swing.*;

public class CasinoRunner 
{
	public static void main(String[] args)
	{
		/* Checks what fonts are available
		 * 
		 * GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	     * Font[] fonts = e.getAllFonts(); // Get the fonts
	     * for (Font f : fonts) 
	     * {
	     * System.out.println(f.getFontName());
	     * }
	     */
		
		//Gets the number of players
		JFrame frame = new JFrame("CASINO");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boolean keepGoing = true;
		int num;
		do
		{
			//Eventually to be between 2-6
			String number = JOptionPane.showInputDialog(frame, "How many people are playing? (2-3)");
			num = Integer.parseInt(number);
			if(num == 2)
				keepGoing = false;
			if(num == 3)
				keepGoing = false;
			/* NOT IMPLEMENTED YET
			if(num == 4)
				keepGoing = false;
			if(num == 5)
				keepGoing = false;
			if(num == 6)
				keepGoing = false; */
			if(keepGoing)
				JOptionPane.showMessageDialog(frame, "Please enter a number between two and three");
		}while(keepGoing);
		
		//Creates GUI
		CasinoGUI run = new CasinoGUI(num);
		run.makeFrame(frame);
	}
}
