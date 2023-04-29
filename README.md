# 2048sample
 

#Graphical Abstract
![1682771849434](https://user-images.githubusercontent.com/130884044/235302943-869d8e73-88f5-4b42-b5b1-6bbed3608eff.jpg)


#Introduction
 2048 is an easy and fun puzzle game. Even if you don't love numbers you will love this game. It is played on a 4x4 grid using the arrows or W, A, S, D keys alternatively. Every time you press a key - all tiles slide. Tiles with the same value that bump into one-another are merged. Although there might be an optimal strategy to play, there is always some level of chance. If you beat the game and would like to master it, try to finish with a smaller score. That would mean that you finished with less moves.
 
 
#Purpose
 We use waterfall software development process to do this project.The project requirements are well-defined and unlikely to change significantly during the development process. We have a clear understanding of the project requirements and can accurately estimate the time and resources needed to complete each phase of the project. Our project is relatively small, with a limited scope and a short development timeline. Our project is a sample of 2048, just help the new javafx learners to learn javafx.
 
#Software development plan
 ##Development Process
  1.Planning and Design: The first step in developing the game is to plan and design the game mechanics, the user interface, and the overall look and feel of the game. This involves deciding on the game rules, the scoring system, the game board layout, and the graphics and animation.

 2.Setting up the Development Environment: The next step is to set up the development environment, which involves installing the necessary software, such as Java Development Kit (JDK), JavaFX, and Integrated Development Environment (IDE), such as Eclipse or IntelliJ IDEA.

 3.Creating the Game Board: The game board is the primary interface of the game, and it is where the player interacts with the game. In JavaFX, the game board can be created using a GridPane layout, where each cell represents a tile on the game board.

 4.Implementing the Game Mechanics: The game mechanics are the rules that govern how the game works. In 2048, the player moves tiles on the game board by swiping left, right, up, or down. When two tiles with the same number collide, they merge into one tile with the sum of their values. Implementing the game mechanics involves writing the code that handles the user input and updates the game board accordingly.

 5.Adding Graphics and Animation: JavaFX provides a rich set of graphics and animation tools that can be used to enhance the user experience of the game. This includes adding sound effects, visual effects, and animations that make the game more engaging and enjoyable to play.

 6.Testing and Debugging: Once the game is developed, it is important to test it thoroughly to ensure that it works as expected and does not have any bugs or issues. This involves testing the game mechanics, user interface, graphics, and animation. Any issues that are identified should be addressed and fixed.

 7. The final step in the development process is to deploy the game to the target platform, which can be desktop, web, or mobile. 
 
 ##Members (Roles & Responsibilities & Portion)
  Abyss: Coder (responsible for development and maintenance) 30%

  Oscar: Developer (responsible for developing process planning and status design) 25%

  Jacky: Developer (responsible for schedule planning and do algorithm) 20%

  Frank: Video Maker (responsible for show our demo) 20%

  Andy: Developer (responsible for document changing) 5%
 
 ## Schedule
  23/04/01 Demand collection: Through the on-site questionnaire survey, we found that demanders want that can play some casual games with the minimal traffic, but also challenging games.

 *23/04/02 Design: After discussing it, we finally decided to make a stand-alone version of the 2048 mini-game.

 *23/04/04 Development: We created a 2048 game board with a 4x4 grid, and established a control direction that uses the up, down, left, and right of the arrow keys to slide blocks and merge blocks of the same color.

 *23/04/04 Test: When we are in the development stage, we will test each direction of movement is correct and the grid color is acceptable.

 *23/04/10 Deployment: After all the functions are completed, we will send a completed file to the requesters to ensure that the program can satisfy the requesters.

 *23/04/11 Maintenance: After the requesters have finished testing the function, we will continue to collect their feedback to ensure that the program has no problems and add the game sound and switch the game sound function and add switch color function.
 
 ##Algorithm
 1.At the start of the game, the game board is initialized with two tiles randomly placed on the board, each with a value of either 2 or 4.

 2.The player can move the tiles on the board by swiping left, right, up, or down. When a swipe is made, the tiles on the board move in the direction of the swipe until they reach the edge of the board or collide with another tile.

 3.When two tiles with the same value collide, they merge into a single tile with the sum of their values. For example, if two tiles with a value of 2 collide, they merge to form a single tile with a value of 4. If two tiles with a value of 4 collide, they merge to form a single tile with a value of 8, and so on.

 4.After each move, a new tile is added to the board at a random location, with a value of either 2 or 4.

 5.The game continues until the player is unable to make any more moves, either because the board is full and there are no more empty spaces, or because there are no more moves that can be made without merging tiles.

 6.The player's score is calculated based on the value of the tiles on the board. Each merged tile adds to the player's score, with higher-value tiles adding more points.
 
  ##Current status of your software
   The current status of the game in JavaFX is stable and functional, we successfully implemented the game using the JavaFX framework.
  
  ## Future plan
    After collecting market response, we would like to start a new development plan to make new sample similar to 2048 or better design to the market.
    
  
 #Environments
  The programming language which we use is Javafx, and this program can run except for iOS system phones, We recommend using IntelliJ IDEA to run the program. If you want to run this program, you need to download java version11 JDK and javafx support for require file.
  
#Demo
Demo:https://youtu.be/jdLoHEYn1rg
