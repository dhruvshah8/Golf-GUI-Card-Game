# Golf-GUI-Card-Game

## Description
"Golf" is a graphical user interface game for 2 players. It is a 2 player game which implements algorithimsstrong> to calculate the score at the end of the game. The game uses functional object oriented code to allow custumiability for features such as player names and background colours. It also uses a responsive and adaptabile UIstrong> with a pleasent user experience.



![](http://dhruvshah.tech/img/projects/golf-game-mockup.png)


## Game Rules 
Each player is dealt 6 cards face down from the deck. The remainder of the cards are placed face down, and the top card is turned up to start the discard pile beside it.The object is for players to have the lowest value of the cards in front of them by either swapping them for lesser value cards or by pairing them up with cards of equal rank. Players take turns drawing single cards from either the stock or discard piles. The drawn card may either be swapped for one of that player's 6 cards, or discarded. If the card is swapped for one of the face down cards, the card swapped in remains face up. The round ends when all of a player's cards are face-up.

Each ace counts 1 point.
Each 2 counts minus 2 points.
Each numeral card from 3 to 10 scores face value.
Each jack or queen scores 10 points.
Each king scores zero points.
A pair of equal cards in the same column scores zero points for the column (even if the equal cards are 2s).

## Features 


**1. Customizability** 
  * modular code design through effective code architecture 
  * the user is able to change appearance of the by changing the backgorund colour as well as player display names in the option panel 

**2. Scoring & Logic** 
  * using a custom algorithm to calculates each players score with the distinct scoring rules of the game 
  * Logic: keep track over which player's turn it is along with objects to verify player moves as valid or not 
  * Player move validation displayed to user through error message box 

**3. UI/UX** 
  * Sleep graphical user interface (GUI) hard coded 
  * Easy to use user experience through simple design and very clear objectives and instructions 
  * Unit Tested to imrpove any bugs and overall user experience 
 
**4. Score Page** 
  * Allows the users to see both players scores 
  * Keeps track of past games and the overall winners 
  * Allow the player to restart the game and start a new round 
  
  
## Challenges 

Some challenges I faced in this large project was firstly keeping track of which cards the players had. As the player is constantly swapping cards with the deck and discard pile, it was quite difficult to keep track of what card they have as well as change the image the user see regarding their card. To tackle this challenge, I created public arrays to store the values of the cards in the discard pile, the deck, as well as both players. Thus I was able to interchange and coordinate the position of all 52 cards in the game. Furthermore, to change the pictures the user sees, each card was associated with an <Int> value which was then corresponded to an image in the Assets. 

Through this project I was able to get a strong understanding of objects, classes and methods. However I still had a lot more to learn as you can see in my next steps. 

## Next Steps 

Currently all the code in embodied into one file with all of the classes, however to improve the readability and functionality of the code, it should be divided up into multiple files and more use of custom objects. 

This can help more people  contribute to the code due to the readability of it and have more customizability and overall improve the performance of the game. 
