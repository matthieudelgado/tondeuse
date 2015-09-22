
Scenario: Donner une sequence d'ordre a plusieurs tondeuses

Given un terrain dont le coin superieur droit est 5, 5
Given une tondeuse avec la position 1, 2, N
Given une autre tondeuse avec la position 3, 3, E
When on donne l'ordre G,A,G,A,G,A,G,A,A a la tondeuse 1
When on donne l'ordre A,A,D,A,A,D,A,D,D,A a la tondeuse 2
Then la position de la tondeuse 1 est 1, 3, N
Then la position de la tondeuse 2 est 5, 1, E

Scenario: Donner une sequence d'ordre a plusieurs tondeuses bis

Given un terrain dont le coin superieur droit est 8, 5
Given une tondeuse avec la position 1, 2, N
Given une autre tondeuse avec la position 3, 3, E
When on donne l'ordre G,A,G,A,G,A,G,A,A a la tondeuse 1
When on donne l'ordre A,A,A,A,A,A,A,A,D,A,A,D,A,D,D,A a la tondeuse 2
Then la position de la tondeuse 1 est 1, 3, N
Then la position de la tondeuse 2 est 8, 1, E

Scenario: Collision entre deux tondeuses

Given un terrain dont le coin superieur droit est 5, 5
Given une tondeuse avec la position 1, 2, N
Given une autre tondeuse avec la position 1, 1, N
When on donne l'ordre G,A,G,A,G,A,G,A,A a la tondeuse 1
When on donne l'ordre A,G,A,G,A,G,A,G,A,A,G,A a la tondeuse 2
Then la position de la tondeuse 1 est 0, 3, N
Then la position de la tondeuse 2 est 1, 3, W