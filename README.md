Notes:
maybe could have called them expectedWidth and expectedHeight
could probably move the safesquare stuff specific stuff to the safesquare instead of the abstract
Sean: Maybe better to name the test to be more specific to what is being tested (without the ands)
Maybe superfluous test in the player tests
squareIsAMine() is probably needed to be private
We could remove some duplication between playerfield and revealfield
can just return logical condition 
Mark: rename coordinate
Sean: use interfaces for the lists in tests
Mark: Naming of squareisamine - field.mineAt(Coordinate)
Sean: Don't shorten the name of coordinates
Sean: Pulling out the random from the RandomMindPlacer is using the strategy pattern
Sean: Why are their comments - Bianca: couldn't express intent very well, so added a comment for now but we discussed the naming of this could be better
Elena: By making decisions that weren't business rules - it has affected the code in a way where they need comments
Mark: The naming of the random could be NumberGenerator as opposed to Random
Mark: Name the upperBound in the random interface better
Sean: PredictableRandom nextInt method could be broken down into methods that would have revealed intent better through method naming
Sean: UpperBound could have been better named
Mark: The setup code in the tests could be refactored out into a setup method? Then it would be clear about the one thing that is changing
Sean: Could have but the random in the constructor (using constructor injection instead)
Sean: Could have used an interface of the square.
Sean+Mark: Could have used more of a top down approach rather than a bottom up approach
Sean: The field itself could have a better abstraction of arrays of array
Sean: really liked the using of coordinate and size
Could change the coordinates back to coordinate


Sean:
Interfaces of the left
Rename the Interfaces without the I 
Refactor the square itself
Mostly it was well put together
There are senior devs that make the same mistakes as these
Don't even need to reflect


Mark:
blown away by what she has learned in a small time
loved the test first approach
needs to work more on the revels intent in a concise way
Just needs a little a bit of polishing
From Mark it's an endorsement with a little refactoring but doesn't need to redemonstrate

Elena:
endorsement
liked the way she was able to explain her reasoning



Overall the process:
stopping as we went was better overall than leaving it all at the endorsement


Mark:
seems to be too much of a formal vocabulary around something that should be more fast feedback
call out rules earlier
knowing that there wasn't supposed to be any frameworks or mocking grameowrks 