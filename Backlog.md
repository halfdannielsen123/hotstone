Backlog for AlphaStone
====

* Skriv evt. deck op med 7 kort til at starte med, og lad spillerne trække uno, dos, dres i starten
* Inkludere manacost osv. under Gameconstants og ikke under StandardGame.
* Sørge for at vores DeductMana plus setPowerUsedThisTurn ikke fucker med interface

# Backlog til senere versioner

* Hvis der er flere af samme kort på hånden, skal vi sikre at de ikke begge bliver fjernet, når kortet spilles.
* Lave god opsætning med Hero-Effect-Effect Description som hænger logisk sammen
* Implementer usePower() med flere powers (lige nu Hardcoded til Baby)
* "When the deck is exhausted and no more cards can be drawn, the hero suffers a two
  health penalty per failed draw. This way, a game can never go on indefintely."
* Implementer ATTACK_NOT_ALLOWED_ON_NON_TAUNT_MINION i ThetaStone

