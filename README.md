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

--------------------------Compile Instruction-------------------------

#command to compile/build the game:
mvn package

#command to compile/build the test:
for test: mvn test



-------------------------Run Game Instruction-------------------------

#command to execute the game:
command: java -cp target/Game-1.0-SNAPSHOT.jar game.Game


-------------------------Gameplay Instruction---------------------------------

#Interface:
the game has 4 windows:
	- Main Menu: display at the beginning 
	- Map: display when use select option "START"
	- Winning Message: display the message when the player win the game. Users have 2 options: play again - "YES" option/exit the game - "NO"
	- Losing Message: display after the player "touch" enemy. Users have 2 option: play again - "YES"/exit the game - "NO"


#GamePlay:

##control the main character by:
up arrow: 		moving up 
down arrow: 	moving down
left arrow: 	moving left
right arrow: 	moving right

##features of the game:
- Main character - Tony: 	Mario picture
- Moving enemy - Virus:		

##requirments:
- Player will control the main character - Tony to move around the map to collect the Prize: Bonus (big yellow circle) or Reward (small blue circle)
- Player has to avoide