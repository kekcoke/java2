Author: Kevin Oane
Submission for a2a.

Fixing known bugs.
1. Premature (incomplete) iteration to selected methods.
       getHerbivores early termination caused by infinite looping inside,
           which was caused getAdjacentCells returning 15 adjacent 
 	       cells. On cell row 8 col 0.
           getAdjacentCells retrieves correct number of cells prior 
               to the currrent problem.

2. Cells not coloring on either swapEntities, eat methods.
       Lessened usage of local variables. 
       Cells should update colors that already have been iterated,
          even with problem #1 existing.

Priority is to fix adjacentCells at that particular instance,
prior to solving 2 and implementing cell containing instance 
variables of 