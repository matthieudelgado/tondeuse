
Scenario: Ajouter une tondeuse à la place d'une autre tondeuse

Given un terrain dont le coin superieur droit est 5, 5
Given une tondeuse avec la position 1, 2, N
Given une autre tondeuse avec la position 1, 2, E
Then la tondeuse 2 n'est pas sur le terrain

