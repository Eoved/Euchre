//Andrew DeVoe

import javax.swing.*;

public class card
{
	private int value;
	private JLabel image;
	
	public card()
	{
		value = 0;
		image = new JLabel();
	}
	
	public card(int val, JLabel im)
	{
		value = val;
		image = im;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public JLabel getImage()
	{
		return image;
	}
}
