
Scenario: Verifier l'effet de l'ordre avancer

Given un terrain de taille 5, 5
Given une tondeuse avec la position 2, 2, N
When on donne l'ordre A a la tondeuse 1
Then la position de la tondeuse 1 est 2, 3, N

Scenario: Verifier l'effet de l'ordre gauche

Given un terrain de taille 5, 5
Given une tondeuse avec la position 2, 2, N
When on donne l'ordre G a la tondeuse 1
Then la position de la tondeuse 1 est 2, 2, W

Scenario: Verifier l'effet de l'ordre droite

Given un terrain de taille 5, 5
Given une tondeuse avec la position 2, 2, N
When on donne l'ordre D a la tondeuse 1
Then la position de la tondeuse 1 est 2, 2, E
