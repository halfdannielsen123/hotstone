/*
 * Copyright (C) 2022 - 2025. Henrik Bærbak Christensen, Aarhus University.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package hotstone.standard;

import hotstone.framework.*;

import java.util.*;

/** This is the 'temporary test stub' in TDD
 * terms: the initial empty but compilable implementation
 * of the game interface.
 *
 * It already includes a bit of FAKE-IT code for the first
 * test case about hand management and player in turn.
 *
 * Start solving the AlphaStone exercise by
 * following the TDD rhythm: pick a one-step-test
 * from your test list, quickly add a test,
 * run it to see it fail, and then modify this
 * implementing class (and supporting classes)
 * to make your test case run. Refactor and repeat.
 *
 * While this is the implementation of Game for
 * the AlphaStone game, you will constantly
 * refactor it over the course of the exercises
 * to become the 'core implementation' which will
 * enable a lot of game variants. This is also
 * why it is not called 'AlphaGame'.
 */

public class StandardHotStoneGame implements Game {

    private int turnNumber = 0;
    private Map<Player, List <Card>> hands = new HashMap<>();
    private Map <Player, Hero> heroes = new HashMap<>();
    private Map <Player, List <Card>> fields = new HashMap<>();

    public StandardHotStoneGame(){

        // Because Player enum - for loop like following
        for (Player p : Player.values()) {
            List<Card> playerHand = new ArrayList<>();
            playerHand.add(new StandardCard(GameConstants.TRES_CARD, 3, 3, 3));
            playerHand.add(new StandardCard(GameConstants.DOS_CARD, 2, 2, 2));
            playerHand.add(new StandardCard(GameConstants.UNO_CARD, 1, 1, 1));
            hands.put(p, playerHand);

            heroes.put(p, new StandardHero());
            fields.put(p, new ArrayList<>());
        }
    }

  @Override
  public Player getPlayerInTurn() {
        // If turnNumber % 2 == 0 then return FINDUS else PEDDERSEN
      if (turnNumber % 2 == 0) {
          return Player.FINDUS;
      } else {
          return Player.PEDDERSEN;
      }
  }

  @Override
  public Hero getHero(Player who) {
        return heroes.get(who);
  }

  @Override
  public Player getWinner() {
    return null;
  }

  @Override
  public int getTurnNumber() {
    return turnNumber;
  }

  @Override
  public int getDeckSize(Player who) {
    return 0;
  }



  @Override
  public Card getCardInHand(Player who, int indexInHand) {
      List<Card> hand = hands.get(who);
      return hand.get(indexInHand);
  }

  @Override
  public Iterable<? extends Card> getHand(Player who) {
    return null;
  }

  @Override
  public int getHandSize(Player who) {
    return 3;
  } // FAKE-IT

  @Override
  public Card getCardInField(Player who, int indexInField) {
      List <Card> playerField = fields.get(who);
    return playerField.get(indexInField);
  }

  @Override
  public Iterable<? extends Card> getField(Player who) {
    return null;
  }

  @Override
  public int getFieldSize(Player who) {
    return 0;
  }

  @Override
  public void endTurn() {
        turnNumber += 1;
  }

  @Override
  public Status playCard(Player who, Card card, int atIndex) {
        List <Card> playerField = fields.get(who);
        playerField.add(atIndex, card);
        return Status.OK;
  }

  @Override
  public Status attackCard(Player playerAttacking, Card attackingCard, Card defendingCard) {
    return null;
  }

  @Override
  public Status attackHero(Player playerAttacking, Card attackingCard) {
    return null;
  }

  @Override
  public Status usePower(Player who) {
    return null;
  }
}
