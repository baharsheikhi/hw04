import org.junit.Test;
import cs3500.hw02.*;
import cs3500.hw04.*;
import static org.junit.Assert.*;
import java.util.*;

/**
 * Created by bahar on 5/31/16.
 */
public class WhistTrumpModelTest {
  List<StandardCard> basicDeck;
  //the Trump Suit will be clubs in this game
  GenericStandardDeckGame basicTrick;
  GenericStandardDeckGame forfeitWithoutTrump;
  GenericStandardDeckGame oneTrump;
  GenericStandardDeckGame trumpStandoff;
  GenericStandardDeckGame trumpBasicTrick;

  public void initData() {
    this.basicDeck = new ArrayList<>();

    //testBasicTrumpTrick: the Trump suit is clubs and player 4 wins the first trick
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Jack));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Queen));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.King));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Ace));

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

    //testOneTrump: player 3 should win
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Ten));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Nine));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Ten));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Eight));

    //testTrumpStandOff: player 2 should win
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Ten));
    basicDeck.add(new StandardCard(Suit.Clubs, Rank.Nine));
    basicDeck.add(new StandardCard(Suit.Diamonds, Rank.Seven));
    basicDeck.add(new StandardCard(Suit.Hearts, Rank.Nine));

    //TODO add cards to make this deck complete

    this.basicTrick = new WhistTrumpModel();
    this.forfeitWithoutTrump = new WhistTrumpModel();
    this.oneTrump = new WhistTrumpModel();
    this.trumpStandoff = new WhistTrumpModel();
    this.trumpBasicTrick = new WhistTrumpModel();
  }

  @Test
  public void testBasicTrick() {

  }

  @Test
  public void testForfeitWithoutTrump() {

  }

  @Test
  public void testOneTrump() {

  }

  @Test
  public void testTrumpStandoff() {

  }

  @Test
  public void testTrumpBasicTrick() {
    this.initData();

  }

}