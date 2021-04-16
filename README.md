#########################################################
#														#
#			Game: Tony In Needs of Pennies - TIP		#
#			Genere: Maze arcade							#
#			Platform: Java								#
#			Developers:									#
#				Chenkun Zhang							#
#				Lauren Bosman							#
#				Hong Quang Cung							#
#				Shenyu Gu								#
#														#
#########################################################

----------------------------------------------------------Compile Game Instruction----------------------------------------------------------------

#command to compile/build the game:
mvn package

#command to compile/build the test:
for test: mvn test


----------------------------------------------------------Execute Game Instruction----------------------------------------------------------------

#command to execute the game:
command: java -cp target/Game-1.0-SNAPSHOT.jar game.Game


------------------------------------------------------------GamePlay Instruction------------------------------------------------------------------

#Interface:
the game has 4 windows:
	- Main Menu: display at the beginning 
	- Map: display when use select option "START"
	- Winning Message: display the message when the player win the game. Users have 2 options: play again - "YES" option/exit the game - "NO"
	- Losing Message: display after the player "touch" enemy. Users have 2 option: play again - "YES"/exit the game - "NO"

#Game Features:

##Features in game:
- Map - the Maze
- Main character - Tony: 	Mario picture
- Moving enemy - Virus:		Flower picture
- Bonus: 					Big yellow circle
- Reward: 					Small blue circle	
- Door: 					Blue square (only appear when player collect enough Reward)

#Gameplay:

##Control instruction:
up arrow: 		moving up 
down arrow: 	moving down
left arrow: 	moving left
right arrow: 	moving right

##Gameplay instruction:
- Player will control the main character - Tony to move around the map to collect as much "Prize" as possible:
	+ Prize will be either "Bonnus" or "Reward"
	+ Player need a sufficient amount of "Reward" in order to open the Door 

- "Door" will open when player collect enough "Reward":
	+ Player can decide to enter the "Door" or keep playing
	+ if Player enter the "Door" the game will end, and the Winning window will open: player can either choose play again/quit

- Enemy will chase the Player if stay in the detection range of the enemy:
	+ "Tony" has to avoid the enemy
	+ if "Tony" touch the enemy - player lose the game, and the Losing window will open: player can either choose play again/quit
