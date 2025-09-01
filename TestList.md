Testlist for AlphaStone
====

* [OK] Given an initialized game, Then Findus is player in turn
* [] When Findus ends its turn, Then it is Peddersen in turn
* [OK] When game starts Then Findus should have three cards in hand, Tres at index 0, Dos at index 1, and Uno at index 2.
  * [OK] Has three cards
  * [OK] return "Tres" when getCardInHand is called with Findus at index 0
  * [OK] return "Dos" / "Uno" then getCardInHand is called with Findus at index 1, 2, respectively.
* [OK] When game starts Then Peddersen should have three cards in hand, Tres at index 0, Dos at index 1, and Uno at index 2.
* Given Card Uno Then it has attributes (1,1,1)
* Given Card Dos Then it has attributes (2,2,2)
* Given a game When Findus plays Uno at index 0, Then it is allowed (Status.OK), and Then minion Uno appears at index 0 on the player's own field.
* When Peddersen plays Dos, Then the mana available is two less.
* When Findus plays a card, Then Peddersen still has 3 cards in his hand.
* When Findus plays a card, then it becomes active after one round
