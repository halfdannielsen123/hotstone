Testlist for AlphaStone
====

Game initialization:
* [OK] Given an initialized game, Then Findus is player in turn
* [OK] When Findus ends his turn in turn 0, Then it is Peddersen in turn
* [OK] When game starts Then Findus should have three cards in hand, Tres at index 0, Dos at index 1, and Uno at index 2.
  * [OK] Has three cards
  * [OK] return "Tres" when getCardInHand is called with Findus at index 0
  * [OK] return "Dos" / "Uno" then getCardInHand is called with Findus at index 1, 2, respectively.
* [OK] When game starts Then Peddersen should have three cards in hand, Tres at index 0, Dos at index 1, and Uno at index 2.
* [OK] When Findus ends his turn in turn 0, Then it is Peddersen in turn
* [OK] When asking for Findus' hero description, it should return "Just Cute"
* [OK] Game starts with both heroes at 21 health
* [OK]When game starts, Findus should have "Baby" as hero
* [OK] When game starts, Peddersen should have "Baby" as hero
* [OK] When game starts, Findus should have Decksize 4

Cards:
* [OK] Given Card Uno Then it has attributes (1,1,1)
* [OK] Given Card Dos Then it has attributes (2,2,2)

Drawing:
* [OK] When Findus does not play any card in round 0, he has 4 cards and draws card Cuatro by beginning of round 2
* [OK] Findus draws card Siete by beginning of round 8

Turns:
* When Peddersen tries to play UNO at index 0 in turn 0, NOT_PLAYER_IN_TURN is returned
* When Peddersen tries to use his power in turn 0, NOT_PLAYER_IN_TURN is returned

Mana:
* When Findus tries to play both Dos and Tres in round 1, he is not allowed since he's out of mana
* [OK] When Peddersen plays Dos, Then the mana available is two less.
* When Findus plays his power, his mana should drop two
* When Findus plays Uno in round 0, in beginning of round 2, he should have 3 mana
* [OK]Findus should have 3 mana in the beginning of round 1-4.

Playing cards:
* [OK] Given a game When Findus plays Uno at index 0, Then it is allowed (Status.OK), and Then minion Uno appears at index 0 on the player's own field.
* [OK] Given a game When Findus plays Uno at index 0, then it should be removed from Findus' hand at handSize should be 2.
* [OK] Given a game When Findus plays Uno at index 0, then Dos at index 0 then Dos appears at index 0 and Uno moves to index 1 on the player's own field.
* When Findus plays a card, then it becomes active after one round
* When Findus plays a card, Then Peddersen still has 3 cards in his hand.
* When Findus has played a card at index 0, and in next turn tries to play another card at index 0, then it is not allowed. He has to play it in another index on the table

Attacks:
* When Findus’ Uno (1,1) attacks Peddersen’s Dos (2,2), Findus' Uno should be removed and Peddersen's Dos' Health should be 1.
* When Findus’ Dos (2,2) attacks Peddersen’s Dos (2,2), Both cards should be removed.
* When Findus tries to attack Peddersen's hero with a non-active card, he's not allowed
* When Findus tries to attack a card on index 0 with a non-active card, he's not allowed
* When Peddersen tries to attack with one of Findus' cards, NOT_OWNER returned.
* When Findus tries to attack a card on Peddersen's index 0, nothing happens if there is no card at index 0
* When Findus attacks Peddersen with Card Uno, Peddersen's health drops with one
* When Findus attacks Peddersen's hero with Card Uno, it becomes inactive
* A minion can only attack once per turn
* When Findus plays UNO and DOS in round 0, and in round 2 tries to attack his own UNO with DOS, ATTACK_NOT_ALLOWED_ON_OWN_MINION is returned.

Power:
* When Findus plays his power in turn 0, and then tries to play it again, POWER_USE_NOT_ALLOWED_TWICE_PR_ROUND is returned

End of game:
* Player Findus wins after 4 rounds (that is, each of the two players have 4 turns completed, after which Findus is winner at the start of turn number 8).

What's missing(not finished test cases, just a brainstorm)
* "The field is an
  ordered sequence, and a minion can be placed anywhere in that sequence (like at
  start, at end, or at positions in the middle), potentially moving other minions to new
  positions. Example: Assume the field has two minions, A and B, ordered like (A,B),
  then fielding C at the start (index 0) would leave the field like (C,A,B); if fielding C at
  index 1 would leave the field like (A,C,B); and if fielding C at the end (index 2) would
  result in a field (A,B,C)."

* End of game
  * Somebody dies
