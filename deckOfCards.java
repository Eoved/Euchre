//Andrew DeVoe

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class deckOfCards 
{
	
	private card[] deck;
	
	public deckOfCards()
	{
		deck = new card[52];
	}
	
	public void createDeck()
	{
		try 
		{
			int spot = 0;
			//Creates spades
			for(int i = 2; i < 15; i++)
			{
				BufferedImage image = ImageIO.read(new File("spades" + i + ".png"));
				ImageIcon icon = new ImageIcon(image);
				JLabel label = new JLabel(icon);
				card spade = new card(i, label);
				deck[spot] = spade;
				spot++;
			}
			//Creates diamonds
			for(int i = 2; i < 15; i++)
			{
				BufferedImage image = ImageIO.read(new File("diamonds" + i + ".png"));
				ImageIcon icon = new ImageIcon(image);
				JLabel label = new JLabel(icon);
				card diamond = new card(i, label);
				deck[spot] = diamond;
				spot++;
			}
			//Creates clubs
			for(int i = 2; i < 15; i++)
			{
				BufferedImage image = ImageIO.read(new File("clubs" + i + ".png"));
				ImageIcon icon = new ImageIcon(image);
				JLabel label = new JLabel(icon);
				card club = new card(i, label);
				deck[spot] = club;
				spot++;
			}
			//Creates hearts
			for(int i = 2; i < 15; i++)
			{
				BufferedImage image = ImageIO.read(new File("hearts" + i + ".png"));
				ImageIcon icon = new ImageIcon(image);
				JLabel label = new JLabel(icon);
				card heart = new card(i, label);
				deck[spot] = heart;
				spot++;
			}
		} catch(Exception e)
		{
			System.out.println("Reading in cards" + e);
		}
	}
	
	public card[] getDeck()
	{
		return deck;
	}
}
