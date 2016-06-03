import org.junit.Test;
import cs3500.hw02.*;
import cs3500.hw03.WhistModel;
import cs3500.hw04.*;
import static org.junit.Assert.*;
import java.util.*;

/**
 * Created by bahar on 5/31/16.
 */
public class WhistTrumpModelTest {
  List<StandardCard> basicDeck;
  List<StandardCard> trumpStandOffDeck;
  List<StandardCard> oneTrumpDeck;
  List<StandardCard> trumpAfterTrickSuit;
  //the Trump Suit will be clubs in this game
  //tests forfeit without trump in the last round, and tests basic trump trick in the first round
  //all the other rounds are basic rounds
  WhistModel basicTrick;
  //the Trump Suit will be clubs in this game
  WhistModel oneTrump;
  WhistModel trumpStandOff;
  WhistModel trumpAfterTrick;


  public void initData() {
    this.basicDeck = new ArrayList<>();
    this.oneTrumpDeck = new ArrayList<>();
    this.trumpStandOffDeck = new ArrayList<>();
    this.trumpAfterTrickSuit = new ArrayList<>();

    //testBasicTrumpTrick: the Trump suit is clubs and player 1 wins the first trick
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Ace));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.King));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Queen));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Jack));

    //A basic trick: The trick suit is diamonds and player 1 wins
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Ace));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.King));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Queen));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Jack));

    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Ace));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.King));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Queen));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Jack));

    basicDeck.add(new StandardCard(Suit.Spades, Rank.Ace));
    basicDeck.add(new StandardCard(Suit.Spades, Rank.King));
    basicDeck.add(new StandardCard(Suit.Spades, Rank.Queen));
    basicDeck.add(new StandardCard(Suit.Spades, Rank.Jack));

    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Ten));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Nine));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Eight));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Seven));

    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Ten));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Nine));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Eight));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Seven));

    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Ten));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Nine));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Eight));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Seven));

    basicDeck.add(new StandardCard(Suit.Spades, Rank.Ten));
    basicDeck.add(new StandardCard(Suit.Spades, Rank.Nine));
    basicDeck.add(new StandardCard(Suit.Spades, Rank.Eight));
    basicDeck.add(new StandardCard(Suit.Spades, Rank.Seven));

    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Six));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Five));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Four));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Three));

    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Six));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Five));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Four));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Three));

    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Six));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Five));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Four));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Three));

    basicDeck.add(new StandardCard(Suit.Spades, Rank.Six));
    basicDeck.add(new StandardCard(Suit.Spades, Rank.Five));
    basicDeck.add(new StandardCard(Suit.Spades, Rank.Four));
    basicDeck.add(new StandardCard(Suit.Spades, Rank.Three));

    //Player 1 Should win: not a good example of Trump card beating everything
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Two));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Two));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Two));
    basicDeck.add(new StandardCard(Suit.Spades, Rank.Two));

    //new deck
    //Play 1 wins and the trump is set to Clubs, the trickSuit is clubs
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Ace));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.King));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Ace));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Ace));

    //player 1 wins, the trickSuit is diamonds
    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Ace));
    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.King));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.King));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.King));

    //player 2 wins, the trickSuit is diamonds, the trumpSuit is clubs
      oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Queen));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Queen));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Queen));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Queen));

    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Jack));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Jack));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Jack));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Jack));

    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Ten));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Ten));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Ten));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Ten));

    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Nine));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Nine));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Nine));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Nine));

    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Eight));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Eight));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Eight));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Eight));

    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Seven));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Seven));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Seven));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Seven));

    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Six));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Six));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Six));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Six));

    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Five));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Five));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Five));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Five));

    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Four));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Four));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Four));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Four));

    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Three));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Three));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Three));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Three));

    oneTrumpDeck.add(new StandardCard(Suit.Diamonds, Rank.Two));
    oneTrumpDeck.add(new StandardCard(Suit.Clubs, Rank.Two));
    oneTrumpDeck.add(new StandardCard(Suit.Hearts, Rank.Two));
    oneTrumpDeck.add(new StandardCard(Suit.Spades, Rank.Two));

    //player 1 wins and the trumpSuit is set equal to spades
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Ace));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Ace));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Two));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs,  Rank.Ace));

    //player 3 wins
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Ace));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.King));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Three));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Two));

    //player 3 goes first and player 1 should win!!
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Eight));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.King));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Five));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.King));

    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Queen));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Jack));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Ten));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Nine));

    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Eight));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Seven));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Six));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Five));

    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Four));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Three));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Clubs, Rank.Two));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Six));

    //player 3 wins
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Queen));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Jack));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Four));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Ten));

    //player 1 wins
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.King));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Nine));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Six));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Eight));

    //EDITED: player 1 wins
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Queen));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Seven));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Jack));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Two));

    //player 1 wins
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Ten));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Queen));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Nine));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Jack));

    //player 1 wins
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Ten));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Five));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Four));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Seven));

    //player 3 wins
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Six));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Three));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Eight));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Three));

    //player 3 wins
    trumpAfterTrickSuit.add(new StandardCard(Suit.Hearts, Rank.Nine));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Four));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Spades, Rank.Seven));
    trumpAfterTrickSuit.add(new StandardCard(Suit.Diamonds, Rank.Five));

    this.basicTrick = new WhistTrumpModel();
    this.oneTrump = new WhistTrumpModel();
    this.trumpAfterTrick = new WhistTrumpModel();
  }

  //A Test without the trump cards: base case
  @Test
  public void testBasicTrick() {
    this.initData();
    this.basicTrick.startPlay(4, this.basicDeck);
    for(int i = 0; i < 13; i++) {
      for (int j = 0; j < 4; j++) {
        this.basicTrick.play(j, 0);
      }
    }

    String [] splitByTrump = this.basicTrick.getGameState().split("suit");
    char trumpSuit = splitByTrump[1].charAt(2);
    assertEquals('♣', trumpSuit);
    assertEquals(1, this.getWinner(this.basicTrick, 4));
    assertEquals(13, this.playerScore(1, this.basicTrick, 4));
    assertEquals(0, this.playerScore(2, this.basicTrick, 4));
    assertEquals(0, this.playerScore(3, this.basicTrick, 4));
    assertEquals(0, this.playerScore(4, this.basicTrick, 4));

  }

  @Test
  public void testOneTrump() {
    this.initData();
    this.oneTrump.startPlay(4, this.oneTrumpDeck);


    oneTrump.play(0, 0);
    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);

    oneTrump.play(0, 0);
    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);

    oneTrump.play(0, 0);
    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);

    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);
    oneTrump.play(0, 0);

    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);
    oneTrump.play(0, 0);

    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);
    oneTrump.play(0, 0);

    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);
    oneTrump.play(0, 0);

    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);
    oneTrump.play(0, 0);

    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);
    oneTrump.play(0, 0);

    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);
    oneTrump.play(0, 0);

    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);
    oneTrump.play(0, 0);

    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);
    oneTrump.play(0, 0);

    oneTrump.play(1, 0);
    oneTrump.play(2, 0);
    oneTrump.play(3, 0);
    oneTrump.play(0, 0);


    String [] splitByTrump = this.oneTrump.getGameState().split("suit");
    char trumpSuit = splitByTrump[1].charAt(2);
    assertEquals('♣', trumpSuit);

    assertEquals(2, this.getWinner(this.oneTrump, 4));
    assertEquals(2, this.playerScore(1, this.oneTrump, 4));
    assertEquals(11, this.playerScore(2, this.oneTrump, 4));
    assertEquals(0, this.playerScore(3, this.oneTrump, 4));
    assertEquals(0, this.playerScore(4, this.oneTrump, 4));

  }

  @Test
  public void testMoreTrumps() {
    this.initData();
    this.trumpAfterTrick.startPlay(4, this.trumpAfterTrickSuit);

    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);
    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);

    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);
    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);

    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);
    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);

    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);
    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);

    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);
    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);

    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);
    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);

    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);
    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);

    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);
    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);

    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);
    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);

    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);
    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);

    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);
    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);

    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);
    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);

    trumpAfterTrick.play(2, 0);
    trumpAfterTrick.play(3, 0);
    trumpAfterTrick.play(0, 0);
    trumpAfterTrick.play(1, 0);

    String [] splitByTrump = this.trumpAfterTrick.getGameState().split("suit");
    char trumpSuit = splitByTrump[1].charAt(2);
    assertEquals('♠', trumpSuit);

    assertEquals(1, this.getWinner(this.trumpAfterTrick, 4));

    assertEquals(9, this.playerScore(1, this.trumpAfterTrick, 4));
    assertEquals(0, this.playerScore(2, this.trumpAfterTrick, 4));
    assertEquals(4, this.playerScore(3, this.trumpAfterTrick, 4));
    assertEquals(0, this.playerScore(4, this.trumpAfterTrick, 4));

  }


  /**
   * Gets the winner of the given game
   *
   * @param model           the model
   * @param modelPlayerSize the number of players
   * @return the winner
   */
  private int getWinner(WhistModel model, int modelPlayerSize) {
    if (!model.isGameOver()) {
      throw new IllegalArgumentException("Game is not over and cannot get winner");
    }

    String[] modelParts = model.getGameState().split("Player");

    String lineWinner = modelParts[(modelPlayerSize * 2) + 1];

    return Integer.parseInt(Character.toString(lineWinner.charAt(1)));
  }

  /**
   * Gets the given player's score given a model and the number of players
   *
   * @param playerNo        the player to get the score from
   * @param model           the model to get it from
   * @param modelPlayerSize the number of player's in the model
   * @return the given player's score
   */
  private int playerScore(int playerNo, WhistModel model, int modelPlayerSize) {

    if (playerNo > modelPlayerSize || playerNo < 1) {
      throw new IllegalArgumentException("illegal player number");
    }
    String[] modelParts = model.getGameState().split("Player");

    String lineScore = modelParts[modelPlayerSize + playerNo];

    String[] scoreAsArray = lineScore.split(":");

    String score = scoreAsArray[1];

    if (score.charAt(2) != '\n') {
      return Integer.parseInt(Character.toString(score.charAt(1))
              + Character.toString(score.charAt(2)));
    } else {
      return Integer.parseInt(Character.toString(score.charAt(1)));
    }
  }

}

