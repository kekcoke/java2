Author: Kevin Oane
Submission for a2a.

Fixes:
1. Fixed infinite loops occurence on moveHerbivores, caused when 
herbivore is fully surrounded by empty cells.

Fixing known bugs.
1. Changes color but not entity. 'ON\OFF' happening. 
	Old cells moves becoming empty. 
	Herbivore where it goes is unknown.
2. Some herbivores remain as is. 

Limitations:
Restricting use of final modifiers.
seedPlants disabled until moveHerbivores is fixed.
removeHerbivores are working.
