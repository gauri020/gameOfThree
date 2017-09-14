Project Title
GameOfThree

Details:-
Game with two independent units – the players –communicating with each other using an API.
When a player starts, it incepts a random (whole) number and sends it to the second
player as an approach of starting the game.
The receiving player can now always choose between adding one of {1,
0, 1} to get
to a number that is divisible by 3 . Divide it by three. The resulting whole number is
then sent back to the original sender.
The same rules are applied until one player reaches the number 1 (after the division)..

Getting Started
step 1 : Install executable jar to system
Step 2 : java -jar <jarname with fill path > --server.port=<first player port> game.player2port=<second player port> game.playerName=<first player name>
Step 3 : java -jar <jarname with fill path > --server.port=<Second player port> game.player2port=<First player port> game.playerName=<Second player name>
step 4 : Start game by hitting URL 
			http://localhost:8082/gameofthree/game/play?number=<input your desired number>
	
examples: 

http://localhost:<firstplayerport>/gameofthree/game/play?number=3
Result will be Winner (Player Name)name in Simple text.
 For this scenario result will be : Player 2

	
Prerequisites
JDK8

Technology Stack
Spring  ,Rest webservice

current version:-0.0.1-SNAPSHOT
            

