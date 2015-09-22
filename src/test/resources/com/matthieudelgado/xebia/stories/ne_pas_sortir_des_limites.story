Scenario: Verifier l'effet de l'ordre avancer lorsque l'on atteint la limite nord

Given un terrain dont le coin superieur droit est 5, 5
Given une tondeuse avec la position 5, 5, N
When on donne l'ordre A a la tondeuse 1
Then la position de la tondeuse 1 est 5, 5, N

Scenario: Verifier l'effet de l'ordre avancer lorsque l'on atteint la limite est

Given un terrain dont le coin superieur droit est 5, 5
Given une tondeuse avec la position 5, 2, E
When on donne l'ordre A a la tondeuse 1
Then la position de la tondeuse 1 est 5, 2, E

Scenario: Verifier l'effet de l'ordre avancer lorsque l'on atteint la limite sud

Given un terrain dont le coin superieur droit est 5, 5
Given une tondeuse avec la position 3, 0, S
When on donne l'ordre A a la tondeuse 1
Then la position de la tondeuse 1 est 3, 0, S

Scenario: Verifier l'effet de l'ordre avancer lorsque l'on atteint la limite ouest

Given un terrain dont le coin superieur droit est 5, 5
Given une tondeuse avec la position 0, 2, W
When on donne l'ordre A a la tondeuse 1
Then la position de la tondeuse 1 est 0, 2, W