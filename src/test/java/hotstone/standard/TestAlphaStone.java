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

/**
 * Skeleton class for AlphaStone test cases
 *
 *    This source code is from the book
 *      "Flexible, Reliable Software:
 *        Using Patterns and Agile Development"
 *      2nd Edition
 *    Author:
 *      Henrik Bærbak Christensen
 *      Department of Computer Science
 *      Aarhus University
 */

import hotstone.framework.Card;
import hotstone.framework.Player;
import hotstone.framework.Status;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import utility.TestHelper;

import hotstone.framework.Game;

/** Template for your own ongoing TDD process.
 * Fill it out until you have covered all
 * requirements for the alpha stone game.
 */
public class TestAlphaStone {
  private Game game;

  /** Fixture for AlphaStone testing. */
  @BeforeEach
  public void setUp() {
    game = new StandardHotStoneGame();
  }

  // Example of an early, simple test case:
  // Turn handling
  @Test
  public void shouldHaveFindusAsFirstPlayer() {
    // Given a game, initialized in 'beforeeach' method

    // When I ask for the player in turn
    Player player = game.getPlayerInTurn();
    // Then it should be Findus
    assertThat(player, is(Player.FINDUS));

    // NB: during development you can use the
    // following 'print full game state' helper
    // function, to ensure your assumptions
    // on game state is correct.
    // TestHelper.printGameState(game);
  }


  // Example of a later, more complex, test case:
  // Card handling

  // The HotStone specs are quite insisting on how
  // the cards, drawn from the deck, are organized
  // in the hand. So when drawing the top three cards
  // from the deck (uno, dos, tres) they have to
  // be organized in the hand as
  // index 0 = tres; index 1 = dos; index 2 = uno
  // That is, a newly drawn card is 'at the top'
  // of the hand - always entered at position 0
  // and pushing the rest of the cards 1 position
  // 'down'
  @Test
  public void shouldHaveUnoDosTresCardsInitially() {
    // Given a game, Findus has 3 cards in hand
    int count = game.getHandSize(Player.FINDUS);
    assertThat(count, is(3));
    // And these are ordered Tres, Dos, Uno in slot 0,1,2

    // When I pick card 0
    Card card0 = game.getCardInHand(Player.FINDUS, 0);
    // Then is it Tres
    // ENABLE TO START TDD'ing
    assertThat(card0.getName(), is(GameConstants.TRES_CARD));

    // When I pick card 1
      Card card1 = game.getCardInHand(Player.FINDUS, 1);
      // Then is it Dos
      assertThat(card1.getName(), is(GameConstants.DOS_CARD));

      // When I pick card 2
      Card card2 = game.getCardInHand(Player.FINDUS, 2);
      // Then is it Dos
      assertThat(card2.getName(), is(GameConstants.UNO_CARD));
  }

    @Test
    public void shouldHaveUnoDosTresCardsInitiallyForPeddersen() {
        // Given a game, PEDDERSEN has 3 cards in hand
        int count = game.getHandSize(Player.PEDDERSEN);
        assertThat(count, is(3));
        // And these are ordered Tres, Dos, Uno in slot 0,1,2

        // When I pick card 0
        Card card0 = game.getCardInHand(Player.PEDDERSEN, 0);
        // Then is it Tres
        // ENABLE TO START TDD'ing
        assertThat(card0.getName(), is(GameConstants.TRES_CARD));

        // When I pick card 1
        Card card1 = game.getCardInHand(Player.PEDDERSEN, 1);
        // Then is it Dos
        assertThat(card1.getName(), is(GameConstants.DOS_CARD));

        // When I pick card 2
        Card card2 = game.getCardInHand(Player.PEDDERSEN, 2);
        // Then is it Dos
        assertThat(card2.getName(), is(GameConstants.UNO_CARD));
    }

    @Test
    public void shouldBePeddersenTurnWhenFindusEndTurn() {
        // Given a game where Findus has turn. Turn of 0
        // When Findus ends his turn
        game.endTurn();
        // Then it is Peddersen's turn
        assertThat(game.getPlayerInTurn(), is(Player.PEDDERSEN));
    }

    @Test
    public void shouldBeBabyAsFindusHero(){
        // Given a game where Findus
        // When asking for Findus' hero
        // Then it is baby
        assertThat(game.getHero(Player.FINDUS).getType(), is(GameConstants.BABY_HERO_TYPE));
    }

    @Test
    public void shouldBeBabyAsPeddersenHero(){
        // Given a game
        // When asking for Findus' hero
        // Then it is baby
        assertThat(game.getHero(Player.PEDDERSEN).getType(), is(GameConstants.BABY_HERO_TYPE));
    }

    @Test
    public void shouldReturn21WhenAskingForHeroHealth() {
        assertThat(game.getHero(Player.FINDUS).getHealth(), is(21));
        assertThat(game.getHero(Player.PEDDERSEN).getHealth(), is(21));
    }

    @Test
    public void shouldReturnJustCuteWhenAskingForHeroEffectDescription() {
        assertThat(game.getHero(Player.FINDUS).getEffectDescription(), is(GameConstants.BABY_HERO_EFFECT_DESCRIPTION));
    }

    @Test
    public void shouldReturn1ManaCost1Health1AttackWhenAskingForCardUnoAttributes() {
        Card cardUno = game.getCardInHand(Player.FINDUS, 2);
        assertThat(cardUno.getName(), is("Uno"));
        assertThat(cardUno.getManaCost(), is(1));
        assertThat(cardUno.getAttack(), is(1));
        assertThat(cardUno.getHealth(), is(1));
    }

    @Test
    public void shouldReturn2ManaCost2Health2AttackWhenAskingForCardUnoAttributes() {
        // Given a game where Findus has card Dos at indexInHand1
        Card cardDos = game.getCardInHand(Player.FINDUS, 1);
        // When checking the attributes
        assertThat(cardDos.getName(), is("Dos"));
        assertThat(cardDos.getManaCost(), is(2));
        assertThat(cardDos.getAttack(), is(2));
        assertThat(cardDos.getHealth(), is(2));
    }

    @Test
    public void shouldReturnOKAndCardBeFoundInFieldAtIndex0WhenFindusPlaysUnoAtIndex0InRound1() {
        // Given game started and cardUno in Findus' hand at index 2
        Card cardUno = game.getCardInHand(Player.FINDUS, 2);
        // When card Uno is played at index 0 the Status should be OK
        assertThat(game.playCard(Player.FINDUS, cardUno, 0), is(Status.OK));
        // And the card should be found in the field at index 0
        assertThat(game.getCardInField(Player.FINDUS, 0), is(cardUno));
    }

    @Test
    public void shouldRemoveUnoFromFindusHandWhenUnoPlayed () {
        // Given game started and cardUno in Findus' hand at index 2
        Card cardUno = game.getCardInHand(Player.FINDUS, 2);
        // When card Uno is played at index 0 the Status should be OK
        assertThat(game.playCard(Player.FINDUS, cardUno, 0), is(Status.OK));
        // Then the card should be removed from Findus' hand
        assertThat(game.getHandSize(Player.FINDUS), is(2));
    }

    @Test
    public void shouldMoveDosFromIndex0To1WhenUnoInsertedAtIndex0 () {
        Card cardUno = game.getCardInHand(Player.FINDUS, 2);
        game.playCard(Player.FINDUS, cardUno, 0);
        Card cardDos = game.getCardInHand(Player.FINDUS, 1);
        game.playCard(Player.FINDUS, cardDos, 0);
        assertThat(game.getCardInField(Player.FINDUS, 0), is(cardDos));
        assertThat(game.getCardInField(Player.FINDUS, 1), is(cardUno));
    }

    @Test
    public void shouldReturn3ManaWhenAskingForPlayerHeroManaAtStart () {
      assertThat(game.getHero(Player.FINDUS).getMana(), is(3));
      assertThat(game.getHero(Player.PEDDERSEN).getMana(), is(3));
    }

    @Test
    public void shouldHave2LessManaWhenDosIsPlayed () {
        Card cardDos = game.getCardInHand(Player.FINDUS, 1);
        game.playCard(Player.FINDUS, cardDos, 0);
        assertThat(game.getHero(Player.FINDUS).getMana(), is(1));
    }

    @Test
    public void shouldHaveDeckSize4AtGameInitializationForFindus(){
        // given a game
        // When asking for Findus' deck size
        // Then it should return 4
        assertThat(game.getDeckSize(Player.FINDUS), is(4));
    }

    @Test
    public void shouldDrawQuatroAtRound2ForFindus(){
        // Given a game, where Findus has yet not played a card
        // When Findus has not played any card and begins round 2
        game.endTurn(); // Findus
        game.endTurn(); // Peddersen
        // Then turnnumber is two, he has 4 cards and Cuatro is at index 0
        assertThat(game.getTurnNumber(), is(2));
        assertThat(game.getHandSize(Player.FINDUS), is(4));
        Card card0 = game.getCardInHand(Player.FINDUS, 0);
        assertThat(card0.getName(), is(GameConstants.CUATRO_CARD));
    }

    @Test
    public void shouldDrawSieteAtRound8ForFindus(){
        // Given a game, where Findus has yet not played a card
        // When Findus has not played any card and begins round 8
        for (int i = 0; i<8; i++) {
            game.endTurn();
        }
        assertThat(game.getTurnNumber(), is(8));
        // Then card SIETE is at index 0
        Card card0 = game.getCardInHand(Player.FINDUS, 0);
        assertThat(card0.getName(), is(GameConstants.SIETE_CARD));
    }

    @Test
    public void shouldReturnStatusNOT_ENOUGH_MANAWhenDosAndTresPlayedInRoundOne () {
      // When Findus plays card Dos
      Card cardDos = game.getCardInHand(Player.FINDUS, 1);
      Status firstStatus = game.playCard(Player.FINDUS, cardDos, 0);
      // Then the status should be OK
      assertThat(firstStatus, is(Status.OK));
      // But when Tres also played in round 1
      Card cardTres = game.getCardInHand(Player.FINDUS, 0);
      Status secondStatus = game.playCard(Player.FINDUS, cardTres, 0);
      // Then Status returned should be NOT ENOUGH MANA
      assertThat(secondStatus, is(Status.NOT_ENOUGH_MANA));
    }

    @Test
    public void shouldReturnStatusOKAndManaDrops2WhenFindusUsesPowerInRound0 () {
        //Given a game, when Findus uses power;
        Status status = game.usePower(Player.FINDUS);
        // Then it returns ok and his mana drops 2
        assertThat(status, is(Status.OK));
        assertThat(game.getHero(Player.FINDUS).getMana(), is(1));
    }
}



