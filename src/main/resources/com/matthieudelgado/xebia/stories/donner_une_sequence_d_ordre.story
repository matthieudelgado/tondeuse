
Scenario: Donner une sequence d'ordre

Given un terrain de taille 5, 5
Given une tondeuse avec la position 1, 2, N
When on donne l'ordre G,A,G,A,G,A,G,A,A a la tondeuse 1
Then la position de la tondeuse 1 est 1, 3, N

Scenario: Donner une sequence d'ordre avec collision avec les bords

Given un terrain de taille 5, 5
Given une tondeuse avec la position 1, 2, N
When on donne l'ordre G,A,A,A,G,A,G,A,G,A,A a la tondeuse 1
Then la position de la tondeuse 1 est 1, 3, N

