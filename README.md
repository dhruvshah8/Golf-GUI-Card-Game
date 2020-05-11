# Golf-GUI-Card-Game

##Description
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
  * because of modular code, the user is able to change appearance by changing the backgorund colour of the game as well as player display names in the option panell 

Scoring - using an algorithm it calculates each players score with the distinct scoring rules of the game 

Sleep desing and easy to use interace resulting in good user experience - done through unit testing 

Score Page 
  allows user to see both player scores 
   allows user to restart the game 

## Challenges 

Some challneges were keeping track of the players cards and cordiating it with the image that displayed to comabt this an array was used store the Int value of their card which can help in calculating score and each number corresponded with an image name - using an algorithm to link an Int value with an Image to display to the user 

## Next Steps 
Currently all the code in emobied into one class however to imrpove the modularity of the code to allow for more people to contribute on it and have maore customizability, next step would be to split it into multiple classes with objects that are called when ever they are needed. Rather than one class with a lot of methods in it, this will help with the games performace. 
