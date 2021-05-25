import java.util.ArrayList;

//Made By Peter Johanni
public class ShuffleDeal 
{
	//variables
	private int numPlayers;
	private card[] shuffleDeck;
	private ArrayList<card> pile;
	private ArrayList<card> player1;
	private ArrayList<card> player2;
	private ArrayList<card> player3;
	private ArrayList<card> player4;
	private ArrayList<card> player5;
	private ArrayList<card> player6;
	//private playerDeck pile;
	private playerDeck hand1;
	private playerDeck hand2;
	private playerDeck hand3;
	private playerDeck hand4;
	private playerDeck hand5;
	private playerDeck hand6;
	private deckOfCards deckGetter;
	private int recFaceCard;
	
	//constructor ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public ShuffleDeal (int numPlayer)
	{
		numPlayers = numPlayer;
		deckGetter = new deckOfCards();
		deckGetter.createDeck();
		shuffleDeck = deckGetter.getDeck();
		pile = new ArrayList<card>();
		player1 = new ArrayList<card>();
		player2 = new ArrayList<card>();
		player3 = new ArrayList<card>();
		player4 = new ArrayList<card>();
		player5 = new ArrayList<card>();
		player6 = new ArrayList<card>();
		card temp = new card();
		int pos1;
		int pos2;
		for(int i = 0; i < 200; i++)
		{
			pos1 = (int)(Math.random()*52);
			pos2 = (int)(Math.random()*52);
			temp = shuffleDeck[pos1];
			shuffleDeck[pos1] = shuffleDeck[pos2];
			shuffleDeck[pos2] = temp;
		}
		if(numPlayer == 2)
			deal2();
		if(numPlayer == 3)
			deal3();
		if(numPlayer == 4)
			deal4();
		if(numPlayer == 5)
			deal5();
		if(numPlayer == 6)
			deal6();
		
	}
	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void deal2()
	{
		for(int i = 0; i < 52; i++)
		{
			player1.add(shuffleDeck[i]);
			i++;
			player2.add(shuffleDeck[i]);
		}
		hand1 = new playerDeck(player1, 1);
		hand2 = new playerDeck(player2, 2);
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void deal3()
	{
		for(int i = 0; i < 51; i++)
		{
			player1.add(shuffleDeck[i]); 
			i++;
			player2.add(shuffleDeck[i]); 
			i++;
			player3.add(shuffleDeck[i]);
		}
		hand1 = new playerDeck(player1, 1);
		hand2 = new playerDeck(player2, 2);
		hand3 = new playerDeck(player3, 3);
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void deal4()
	{
		for(int i = 0; i < 52; i++)
		{
			player1.add(shuffleDeck[i]); 
			i++;
			player2.add(shuffleDeck[i]); 
			i++;
			player3.add(shuffleDeck[i]);
			i++;
			player4.add(shuffleDeck[i]);
		}
		hand1 = new playerDeck(player1, 1);
		hand2 = new playerDeck(player2, 2);
		hand3 = new playerDeck(player3, 3);
		hand4 = new playerDeck(player4, 4);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void deal5()
	{
		for(int i = 0; i < 50; i++)
		{
			player1.add(shuffleDeck[i]); 
			i++;
			player2.add(shuffleDeck[i]); 
			i++;
			player3.add(shuffleDeck[i]);
			i++;
			player4.add(shuffleDeck[i]);
			i++;
			player5.add(shuffleDeck[i]);
		} 
		hand1 = new playerDeck(player1, 1);
		hand2 = new playerDeck(player2, 2);
		hand3 = new playerDeck(player3, 3);
		hand4 = new playerDeck(player1, 4);
		hand5 = new playerDeck(player2, 5);
	}
	
	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void deal6()
	{
		for(int i = 0; i < 48; i++)
		{
			player1.add(shuffleDeck[i]); 
			i++;
			player2.add(shuffleDeck[i]); 
			i++;
			player3.add(shuffleDeck[i]);
			i++;
			player4.add(shuffleDeck[i]);
			i++;
			player5.add(shuffleDeck[i]);
			i++;
			player6.add(shuffleDeck[i]);
		}
		hand1 = new playerDeck(player1, 1);
		hand2 = new playerDeck(player2, 2);
		hand3 = new playerDeck(player3, 3);
		hand4 = new playerDeck(player4, 4);
		hand5 = new playerDeck(player5, 5);
		hand6 = new playerDeck(player6, 5);
		
	}
	
	//playCard method -- checks to see if it is the player's turn and if so plays the top card from their deck onto the pile -----------------------------
	public card playCard(int playerTurn)
	{
		if(playerTurn == 1)
			pile.add(0, hand1.removeTopCard());
		else if(playerTurn== 2)
			pile.add(0, hand2.removeTopCard());
		else if(playerTurn == 3)
			pile.add(0, hand3.removeTopCard());
		else if(playerTurn == 4)
			pile.add(0, hand4.removeTopCard());
		else if(playerTurn == 5)
			pile.add(0, hand5.removeTopCard());
		else if(playerTurn == 6)
			pile.add(0, hand6.removeTopCard());
		return pile.get(0);
			//Need to update screen by having the screen display the top card from the pile
	}
	
	public boolean checkSlap()
	{
		if(pile.size() > 2 && pile.get(0).getValue() == pile.get(1).getValue()) //if top card value is equal to second from the top card value
				return true;
		else if(pile.size() > 3 && pile.get(0).getValue() == pile.get(2).getValue()) //if top card value is equal to third from the top card value
			return true;
		return false;
	}
	
	public boolean checkTake(int pSlapNumber, int playerTurn)
	{
		if (checkSlap())
			return true;
		else if ((playerTurn > numPlayers) && (pSlapNumber == recFaceCard))
			return true;
		return false;
	}
	
	public void slap(int playerNum)
	{
		if(playerNum == 1)		
		{
			while(0 < pile.size())
				hand1.addCard(pile.remove(0));
		}
		else if(playerNum == 2)
		{
			while(0 < pile.size())
				hand2.addCard(pile.remove(0));
		}
		else if(playerNum == 3)
		{
			while(0 < pile.size())
				hand3.addCard(pile.remove(0));
		}
		else if(playerNum == 4)
		{
			while(0 < pile.size())
				hand4.addCard(pile.remove(0));
		}
		else if(playerNum == 5)
		{
			while(0 < pile.size())
				hand5.addCard(pile.remove(0));
		}
		else if(playerNum == 6)
		{
			while(0 < pile.size())
				hand6.addCard(pile.remove(0));
		}			
	}
	
	public void faceTake(int playerNum)
	{
		if(playerNum == 1)		
		{
			while(0 < pile.size())
				hand1.addCard(pile.remove(0));
		}
		else if(playerNum == 2)
		{
			while(0 < pile.size())
				hand2.addCard(pile.remove(0));
		}
		else if(playerNum == 3)
		{
			while(0 < pile.size())
				hand3.addCard(pile.remove(0));
		}
		else if(playerNum == 4)
		{
			while(0 < pile.size())
				hand4.addCard(pile.remove(0));
		}
		else if(playerNum == 5)
		{
			while(0 < pile.size())
				hand5.addCard(pile.remove(0));
		}
		else if(playerNum == 6)
		{
			while(0 < pile.size())
				hand6.addCard(pile.remove(0));
		}			
	}
	
	public ArrayList<card> getPile()
	{
		return pile;
	}
	
	public playerDeck getHand(int num)
	{
		if(num == 1)
			return hand1;
		if(num == 2)
			return hand2;
		if(num == 3)
			return hand3;
		if(num == 4)
			return hand4;
		if(num == 5)
			return hand5;
		if(num == 6)
			return hand6;
		else
			return null;
	}
}