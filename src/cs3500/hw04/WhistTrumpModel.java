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

  }

  @Override
  protected int getWinner(List<StandardCard> cards) {
    return 0;
  }

  @Override
  public String getGameState() {
    return null;
  }

  private final Suit trump;

  public WhistTrumpModel() {
    super();
    this.trump = null;
  }


}
