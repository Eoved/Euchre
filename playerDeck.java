import java.util.ArrayList;

//Made by Peter Johanni
public class playerDeck 
{
	private ArrayList<card> deck;
	private int playerNumber;
	
	public playerDeck(ArrayList<card> input, int pNumIn)
	{
		deck = input;
		playerNumber = pNumIn;
	}
	
	public int getPlayerNumber()
	{
		return playerNumber;
	}
	
	public int getDeckSize()
	{
		return deck.size();
	}
	
	public card getCardAtIndex(int pos)
	{
		return deck.get(pos);
	}
	
	public card removeCardAtIndex(int pos)
	{
		return deck.remove(pos);
	}
	public void addCard(card c)
	{
		deck.add(c);
	}

	public card removeTopCard() {
		card temp = deck.get(0);
		deck.remove(0);
		return temp;
	}
}
