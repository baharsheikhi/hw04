package cs3500.hw04;

import cs3500.hw03.*;
import cs3500.hw02.*;
import java.util.*;

/**
 * Created by bahar on 5/31/16.
 * A class to represent a whist model with a trump suit
 */
public class WhistTrumpModel extends WhistModel {

  @Override
  public void startPlay(int numPlayers, List<StandardCard> deck) {
    this.trump = deck.get(0).getSuit();
    super.startPlay(numPlayers, deck);

  }

  @Override
  protected int getWinner(List<StandardCard> cards) {
      int ret = this.getTrumpWinner(cards);
      if(ret != -1) {
          return ret;
      }
      else {
            ret = super.getWinner(cards);
            return ret;
        }
  }

  @Override
  public String getGameState() {
    String ret = "";
    ret = super.getGameState();
    ret+="\nTrump suit: "+this.trump.toString();
    return ret;
  }

  private Suit trump;

  public WhistTrumpModel() {
    super();
    this.trump = null;
  }

  public WhistTrumpModel(List<StandardCard> deck) {
    super(deck);
    this.trump = null;
  }


    /**
     * Determines the player who had the highest trump value, returns -1 if none exists
     * @param someCards the cards the method goes through
     * @return the player that had the highest trump value, if one exists, returns -1 otherwise
     */
    private int getTrumpWinner(List<StandardCard> someCards) {
      int winner = -1;
      for (StandardCard c : someCards) {
          if (c.getSuit() == this.trump) {
              winner = this.getCardsInPlay().get(c);
              break;
          }
      }
      return winner;
  }


}
