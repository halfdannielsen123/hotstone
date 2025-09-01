Testlist for AlphaStone
====

* [OK] Given an initialized game, Then Findus is player in turn
* [OK] When Findus ends his turn in turn 0, Then it is Peddersen in turn
* [OK] When game starts Then Findus should have three cards in hand, Tres at index 0, Dos at index 1, and Uno at index 2.
  * [OK] Has three cards
  * [OK] return "Tres" when getCardInHand is called with Findus at index 0
  * [OK] return "Dos" / "Uno" then getCardInHand is called with Findus at index 1, 2, respectively.
* [OK] When game starts Then Peddersen should have three cards in hand, Tres at index 0, Dos at index 1, and Uno at index 2.
* Given Card Uno Then it has attributes (1,1,1)
* Given Card Dos Then it has attributes (2,2,2)
* Findus draws card Quatro by beginning of round 2
* When Findus tries to play both Dos and Tres in round 1, he is not allowed since he's out of mana
* When Findus does not play any card in round 0, he has 4 cards in his hand in round 2
* When Findus plays a card, then it becomes active after one round
* When Findus tries to attack Peddersen's hero with a none-active card, he's not allowed
* When Findus tries to attack a card on index 0 with a none-active card, he's not allowed
* When Findus tries to attack a card on Peddersen's index 0, nothing happens if there is no card at index 0
* Given a game When Findus plays Uno at index 0, Then it is allowed (Status.OK), and Then minion Uno appears at index 0 on the player's own field.
* When Findus has played a card at index 0, and in next turn tries to play another card at index 0, then it is not allowed. He has to play it in another index on the table
* When Peddersen plays Dos, Then the mana available is two less.
* When Findus plays a card, Then Peddersen still has 3 cards in his hand.
* When Findus attacks Peddersen with Card Uno, Peddersen's health drops with one
* When Findus attacks Peddersen's hero with Card Uno, it becomes inactive
* When game starts, Findus should have "Baby" as hero
* When asking for Findus' hero description, it should return "Just Cute"
* When asking for Findus' power, it should return "Cute"
* When Findus plays his power, his mana should drop two
* When Findus plays Uno in round 0, in beginning of round 2, he should have 3 mana

What's missing(not finished test cases, just a brainstorm)
* "The field is an
  ordered sequence, and a minion can be placed anywhere in that sequence (like at
  start, at end, or at positions in the middle), potentially moving other minions to new
  positions. Example: Assume the field has two minions, A and B, ordered like (A,B),
  then fielding C at the start (index 0) would leave the field like (C,A,B); if fielding C at
  index 1 would leave the field like (A,C,B); and if fielding C at the end (index 2) would
  result in a field (A,B,C)."
* "If an attacking minion, A, attacks a defending minion, D, then D’s health is reduced
  by the amount of A’s attack value. Similar, A’s health is reduced by the value of D’s
  attack. If any of the minions’ health becomes 0 or less, the minion is defeated and the
  minion is removed from the field. Note that the attack and counter attack happens at
  the same time—the attacker does not leave the battle without a health loss even if the
  defender is defeated by the attack."
* End of game
  * Somebody dies
  * Findus wins in beginning of round 8.
