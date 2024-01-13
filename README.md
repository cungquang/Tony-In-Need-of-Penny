# Tony In Needs of Pennies - TIP

## Project Information

- **Genre:** Game - Maze arcade
- **Language:** Java - Maven

## Project Description

### Description:

The project is developed for educational purposes, focusing on building a desktop game in Java and using Maven as the software management tool. The main character, "Tony," is a poor student in need of money to pay for his tuition. However, there are gangsters who want to rob him, so he must avoid enemies to protect his earnings.

### Purpose:

Educational purpose

### Target Audience:

Everyone

### Hosting:

Not applicable

### Tech Stack:

- Java
- Maven

## Compile Game Instruction

### Command to compile/build the game:

```bash
mvn package
Command to compile/build the test:
bash
Copy code
mvn test
Execute Game Instruction
Command to execute the game:
bash
Copy code
java -cp target/Game-1.0-SNAPSHOT.jar game.Game
Gameplay Instruction
Interface:
The game consists of four windows:

Main Menu: displayed at the beginning
Map: displayed when the user selects the "START" option
Winning Message: displayed when the player wins the game. Options: Play Again (YES) / Exit the Game (NO)
Losing Message: displayed after the player touches an enemy. Options: Play Again (YES) / Exit the Game (NO)
Game Features:
Features in the game:
Map - the Maze
Main character - Tony: Mario picture
Moving enemy - Virus: Flower picture
Bonus: Big yellow circle
Reward: Small blue circle
Door: Blue square (appears when the player collects enough Reward)
Gameplay:
Control instructions:
Up arrow: move up
Down arrow: move down
Left arrow: move left
Right arrow: move right
Gameplay instructions:
The player controls Tony to collect as much "Prize" as possible (either "Bonus" or "Reward").
A sufficient amount of "Reward" is required to open the "Door."
The "Door" will open, and the game will end if enough "Reward" is collected. The Winning window will appear, allowing the player to choose to play again or quit.
Enemies will chase Tony if within their detection range. Tony must avoid enemies, and touching an enemy results in losing the game. The Losing window will open, providing options to play again or quit.
