//Andrew DeVoe

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CasinoGUI extends JFrame
{
	private int numPlayers, p1, p2, p3, p4, p5, p6, cardNum;
	private JPanel background, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
	private JLabel cardBack, cardBack1, cardBack2, cardBack3, cardBack4, cardBack5, cardBack6;
	private JFrame frame;
	private ShuffleDeal deck;
	
	public CasinoGUI(int num)
	{
		background = new JPanel();
		numPlayers = num;
		cardNum = 0;
		
		background.setLayout(new GridLayout(3, 3));
		
		/* Instantiates Panels ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 * Format:
		 *         1  2  3
		 *         4  5  6
		 *         7  8  9
		 */
		
		Color table = new Color(0x5304B5);
		Color border = new Color(0xA852FF);
		Color mBorder = new Color(0xFFDF00);
		Font script = new Font("Zapfino", Font.BOLD, 45);
		
		panel1 = new JPanel();
		panel1.setBackground(table);
		panel1.setBorder(BorderFactory.createLineBorder(border, 7));
		
		panel2 = new JPanel();
		panel2.setBackground(table);
		panel2.setBorder(BorderFactory.createLineBorder(border, 7));
		
		panel3 = new JPanel();
		panel3.setBackground(table);
		panel3.setBorder(BorderFactory.createLineBorder(border, 7));
		
		panel4 = new JPanel();
		panel4.setLayout(new GridBagLayout());
		panel4.setBackground(table);
		JLabel casino1 = new JLabel("Casino ERS");
		casino1.setFont(script);
		casino1.setForeground(mBorder);
		panel4.add(casino1);
		
		panel5 = new JPanel();
		panel5.setLayout(new GridBagLayout());
		panel5.setBackground(table);
		panel5.setBorder(BorderFactory.createLineBorder(mBorder, 7));
		JButton start = new JButton("Start Game");
		start.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		start.addActionListener(a -> {
			panel5.remove(start);
			frame.revalidate();
			frame.repaint();
			
			//Randomizes which player gets to play first
			Random play = new Random();
			int playNum = play.nextInt(num) + 1;
			playTurn(playNum);
		});
		panel5.add(start);
		
		panel6 = new JPanel();
		panel6.setLayout(new GridBagLayout());
		panel6.setBackground(table);
		JLabel casino2 = new JLabel("Casino ERS");
		casino2.setFont(script);
		casino2.setForeground(mBorder);
		panel6.add(casino2);
		
		panel7 = new JPanel();
		panel7.setBackground(table);
		panel7.setBorder(BorderFactory.createLineBorder(border, 7));
		
		panel8 = new JPanel();
		panel8.setBackground(table);
		panel8.setBorder(BorderFactory.createLineBorder(border, 7));
		
		panel9 = new JPanel();
		panel9.setBackground(table);
		panel9.setBorder(BorderFactory.createLineBorder(border, 7));
		
		//Reads image of card back -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		try 
		{
			BufferedImage back = ImageIO.read(new File("cardBack1.png"));
			ImageIcon icon = new ImageIcon(back);
			cardBack = new JLabel(icon);
			cardBack1 = new JLabel(icon);
			cardBack2 = new JLabel(icon);
			cardBack3 = new JLabel(icon);
			cardBack4 = new JLabel(icon);
			cardBack5 = new JLabel(icon);
			cardBack6 = new JLabel(icon);
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
		//Makes board for two players ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		if(numPlayers == 2)
		{
			panel2.add(cardBack1);
			panel8.add(cardBack2);
		}
		
		//Makes board for three players --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		if(numPlayers == 3)
		{
			panel2.add(cardBack1);
			panel7.add(cardBack2);
			panel9.add(cardBack3);
		}
		
		/* NOT IMPLEMENTED YET
		//Makes board for four players ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		if(numPlayers == 4)
		{
			panel1.add(cardBack1);
			panel3.add(cardBack2);
			panel7.add(cardBack3);
			panel9.add(cardBack4);
		}
		//Makes board for five players ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		if(numPlayers == 5)
		{
			panel1.add(cardBack1);
			panel3.add(cardBack2);
			panel7.add(cardBack3);
			panel8.add(cardBack4);
			panel9.add(cardBack5);
		}
		
		//Makes board for six players ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		if(numPlayers == 6)
		{
			panel1.add(cardBack1);
			panel2.add(cardBack2);
			panel3.add(cardBack3);
			panel7.add(cardBack4);
			panel8.add(cardBack5);
			panel9.add(cardBack6);
		}
		*/
		
		//Adds Panels to layout ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		background.add(panel1);
		background.add(panel2);
		background.add(panel3);
		background.add(panel4);
		background.add(panel5);
		background.add(panel6);
		background.add(panel7);
		background.add(panel8);
		background.add(panel9);
		
		//Sets amount of cards in pile ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		deck = new ShuffleDeal(numPlayers);
		
	}
	
	//Makes frame
	public void makeFrame(JFrame f)
	{
		frame = f;
		frame.setSize(1400, 700);
		frame.add(background);
		frame.setVisible(true);
		
	}
	
	public boolean keepPlaying()
	{
		if(numPlayers == 2)
		{
			if(deck.getHand(1).getDeckSize() == 52)
				return false;
			else if(deck.getHand(2).getDeckSize() == 52)
				return false;
		}
		else if(numPlayers == 3)
		{
			if(deck.getHand(1).getDeckSize() == 52)
				return false;
			else if(deck.getHand(2).getDeckSize() == 52)
				return false;
			else if(deck.getHand(3).getDeckSize() == 52)
				return false;
		}
		return true;
	}
	
	public int getWinner()
	{
		if(deck.getHand(1).getDeckSize() == 52)
			return 1;
		else if(deck.getHand(2).getDeckSize() == 52)
			return 2;
		else if(deck.getHand(3).getDeckSize() == 52)
			return 3;
		else if(deck.getHand(4).getDeckSize() == 52)
			return 4;
		else if(deck.getHand(5).getDeckSize() == 52)
			return 5;
		else if(deck.getHand(6).getDeckSize() == 52)
			return 6;
		return 0;
	}
	
	public int incTurn(int num)
	{
		if(num < numPlayers)
			num++;
		else
			num = 1;
		return num;
	}
	
	public int decTurn(int num)
	{
		if(num > 1)
			num--;
		else
			num = numPlayers;
		return num;
	}
	
	//Plays one card and is recursively called
	public void playTurn(int play)
	{	
		int winner = -1;
		ArrayList<card> pile = deck.getPile();
		
		//Makes sure the player can play
		if(deck.getHand(play).getDeckSize() == 0)
		{
			if(numPlayers == 2)
			{
				if(play == 1)
					panel2.removeAll();
				if(play == 2)
					panel8.removeAll();
			}
			else if(numPlayers == 3)
			{
				if(play == 1)
					panel2.removeAll();
				if(play == 2)
					panel7.removeAll();
				if(play == 3)
					panel9.removeAll();
			}
			JOptionPane.showMessageDialog(frame, "Player " + play + " is out of cards.");
			playTurn(incTurn(play));
		}
		else
		{	
			card top = deck.playCard(play);
			//Graphics for card playing
			//Two players ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			if(numPlayers == 2)
			{
				
				if(play == 1)
				{
					Timer pause = new Timer(500, e -> {
						panel5.removeAll();
						panel2.remove(top.getImage());
						panel5.add(top.getImage());
						frame.revalidate();
						frame.repaint();
					});
					pause.setRepeats(false);
					panel2.add(top.getImage());
					frame.revalidate();
					frame.repaint();
					pause.start();
				}
				else if(play == 2)
				{
					Timer pause = new Timer(500, e -> {
						panel5.removeAll();
						panel8.remove(top.getImage());
						panel5.add(top.getImage());
						frame.revalidate();
						frame.repaint();
					});
					pause.setRepeats(false);
					panel8.add(top.getImage());
					frame.revalidate();
					frame.repaint();
					pause.start();
				}
				frame.revalidate();
				frame.repaint();
			}
			
			//Three players --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			if(numPlayers == 3)
			{
				if(play == 1)
				{
					Timer pause = new Timer(500, e -> {
						panel5.removeAll();
						panel2.remove(top.getImage());
						panel5.add(top.getImage());
						frame.revalidate();
						frame.repaint();
					});
					pause.setRepeats(false);
					panel2.add(top.getImage());
					frame.revalidate();
					frame.repaint();
					pause.start();
				}
				if(play == 2)
				{
					Timer pause = new Timer(500, e -> {
						panel5.removeAll();
						panel7.remove(top.getImage());
						panel5.add(top.getImage());
						frame.revalidate();
						frame.repaint();
					});
					pause.setRepeats(false);
					panel7.add(top.getImage());
					frame.revalidate();
					frame.repaint();
					pause.start();
				}
				if(play == 3)
				{
					Timer pause = new Timer(500, e -> {
						panel5.removeAll();
						panel9.remove(top.getImage());
						panel5.add(top.getImage());
						frame.revalidate();
						frame.repaint();
					});
					pause.setRepeats(false);
					panel9.add(top.getImage());
					frame.revalidate();
					frame.repaint();
					pause.start();
				}
			}
			
			/* NOT IMPLEMENTED
			Four players ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			if(numPlayers == 4)
			{
				
			}
			//Five players ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			if(numPlayers == 5)
			{
				panel1.add(cardBack1);
				panel3.add(cardBack2);
				panel7.add(cardBack3);
				panel8.add(cardBack4);
				panel9.add(cardBack5);
			}
			
			//Six players ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			if(numPlayers == 6)
			{
				panel1.add(cardBack1);
				panel2.add(cardBack2);
				panel3.add(cardBack3);
				panel7.add(cardBack4);
				panel8.add(cardBack5);
				panel9.add(cardBack6);
			} */
			
			//Slap ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			int slapTurn = 0;
			if(deck.checkSlap())
			{
				cardNum = 0;
				panel5.removeAll();
				if(numPlayers == 2)
				{
					winner = (int)(Math.random()*2)+1;
					slapTurn = winner;
					deck.slap(winner);
					if(winner == 1)
					{
						Timer pause = new Timer(500, e -> {
							panel2.remove(cardBack);
							frame.revalidate();
							frame.repaint();
						});
						pause.setRepeats(false);
						panel2.add(cardBack);
						frame.revalidate();
						frame.repaint();
						JOptionPane.showMessageDialog(frame, "Player " + winner + " took the pile with a slap.");
						panel2.removeAll();
						panel2.add(cardBack1);
						panel2.add(cardBack);
						pause.start();
					}
					if(winner == 2)
					{
						Timer pause = new Timer(500, e -> {
							panel8.remove(cardBack);
							frame.revalidate();
							frame.repaint();
						});
						pause.setRepeats(false);
						panel8.add(cardBack);
						frame.revalidate();
						frame.repaint();
						JOptionPane.showMessageDialog(frame, "Player " + winner + " took the pile with a slap.");
						panel8.removeAll();
						panel8.add(cardBack2);
						panel8.add(cardBack);
						pause.start();
					}
				}
				if(numPlayers == 3)
				{
					winner = (int)(Math.random()*3)+1;
					slapTurn = winner;
					deck.slap(winner);
					if(winner == 1)
					{
						Timer pause = new Timer(500, e -> {
							panel2.remove(cardBack);
							frame.revalidate();
							frame.repaint();
						});
						pause.setRepeats(false);
						panel2.add(cardBack);
						frame.revalidate();
						frame.repaint();
						JOptionPane.showMessageDialog(frame, "Player " + winner + " took the pile with a slap.");
						panel2.removeAll();
						panel2.add(cardBack1);
						panel2.add(cardBack);
						pause.start();
					}
					if(winner == 2)
					{
						Timer pause = new Timer(500, e -> {
							panel7.remove(cardBack);
							frame.revalidate();
							frame.repaint();
						});
						pause.setRepeats(false);
						panel7.add(cardBack);
						frame.revalidate();
						frame.repaint();
						JOptionPane.showMessageDialog(frame, "Player " + winner + " took the pile with a slap.");
						panel7.removeAll();
						panel7.add(cardBack2);
						panel7.add(cardBack);
						pause.start();
					}
					if(winner == 3)
					{
						Timer pause = new Timer(500, e -> {
							panel9.remove(cardBack);
							frame.revalidate();
							frame.repaint();
						});
						pause.setRepeats(false);
						panel9.add(cardBack);
						frame.revalidate();
						frame.repaint();
						JOptionPane.showMessageDialog(frame, "Player " + winner + " took the pile with a slap.");
						panel9.removeAll();
						panel9.add(cardBack3);
						panel9.add(cardBack);
						pause.start();
					}
				}
				//ADD MORE PLAYERS WHEN IMPLEMENTED
			}
			
			//Face Card Logic ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			int faceTurn = 0;
			int faceTake = 0;
			if(cardNum != 0)
			{
				if(!pile.isEmpty() && (pile.get(0).getValue() == 11 || pile.get(0).getValue() == 12 || pile.get(0).getValue() == 13 || pile.get(0).getValue() == 14))
					cardNum = -1;
				else
				{
					cardNum--;
					faceTurn = play;
				}
				if(cardNum == 0)
				{
					//Face Card Graphics
					faceTake = decTurn(play);
					panel5.removeAll();
					if(numPlayers == 2)
					{
						if(play == 1)
						{
							Timer pause = new Timer(500, e -> {
								panel2.remove(cardBack);
								frame.revalidate();
								frame.repaint();
							});
							pause.setRepeats(false);
							panel2.add(cardBack);
							frame.revalidate();
							frame.repaint();
							JOptionPane.showMessageDialog(frame, "Player " + play + " took the pile with a face card.");
							panel2.removeAll();
							panel2.add(cardBack1);
							panel2.add(cardBack);
							pause.start();
						}
						if(play == 2)
						{
							Timer pause = new Timer(500, e -> {
								panel8.remove(cardBack);
								frame.revalidate();
								frame.repaint();
							});
							pause.setRepeats(false);
							panel8.add(cardBack);
							frame.revalidate();
							frame.repaint();
							JOptionPane.showMessageDialog(frame, "Player " + play + " took the pile with a face card.");
							panel8.removeAll();
							panel8.add(cardBack2);
							panel8.add(cardBack);
							pause.start();
						}
					}
					if(numPlayers == 3)
					{
						if(play == 1)
						{
							Timer pause = new Timer(500, e -> {
								panel2.remove(cardBack);
								frame.revalidate();
								frame.repaint();
							});
							pause.setRepeats(false);
							panel2.add(cardBack);
							frame.revalidate();
							frame.repaint();
							JOptionPane.showMessageDialog(frame, "Player " + play + " took the pile with a face card.");
							panel2.removeAll();
							panel2.add(cardBack1);
							panel2.add(cardBack);
							pause.start();
						}
						if(play == 2)
						{
							Timer pause = new Timer(500, e -> {
								panel7.remove(cardBack);
								frame.revalidate();
								frame.repaint();
							});
							pause.setRepeats(false);
							panel7.add(cardBack);
							frame.revalidate();
							frame.repaint();
							JOptionPane.showMessageDialog(frame, "Player " + play + " took the pile with a face card.");
							panel7.removeAll();
							panel7.add(cardBack2);
							panel7.add(cardBack);
							pause.start();
						}
						if(play == 3)
						{
							Timer pause = new Timer(500, e -> {
								panel9.remove(cardBack);
								frame.revalidate();
								frame.repaint();
							});
							pause.setRepeats(false);
							panel9.add(cardBack);
							frame.revalidate();
							frame.repaint();
							JOptionPane.showMessageDialog(frame, "Player " + play + " took the pile with a face card.");
							panel9.removeAll();
							panel9.add(cardBack3);
							panel9.add(cardBack);
							pause.start();
						}
					}
					deck.faceTake(play);
					while(!pile.isEmpty())
						pile.remove(0);
				}
				if(cardNum == -1)
					cardNum = 0;
			}
			if(cardNum == 0 && pile.size() > 0)
			{
				if(pile.get(0).getValue() == 11)
					cardNum = 1;
				else if(pile.get(0).getValue() == 12)
					cardNum = 2;
				else if(pile.get(0).getValue() == 13)
					cardNum = 3;
				else if(pile.get(0).getValue() == 14)
					cardNum = 4;
				faceTurn = incTurn(play);
			}
		
			//Recursively plays cards with the right player turn number ----------------------------------------------------------------------------------------------------------------------------------
			final int slapPlayNum = slapTurn;
			final int facePlayNum = faceTurn;
			final int faceTakeNum = faceTake;
			Timer stop = new Timer(1000, e -> {
				if(slapPlayNum != 0 && keepPlaying())
					playTurn(slapPlayNum);
				else if(facePlayNum != 0 && keepPlaying())
					playTurn(facePlayNum);
				else if(faceTakeNum != 0 && keepPlaying())
					playTurn(faceTakeNum);
				else if(keepPlaying())
					playTurn(incTurn(play));
				else
				{
					int win = getWinner();
					JOptionPane.showMessageDialog(frame, "The Winner is Player " + win);
					frame.dispose();
				}
			});
			stop.setRepeats(false);
			stop.start();
		}
	}
	
}