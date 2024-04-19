Hunter Metzloff
04/19/2024
Robert Whitnell
CTIS 210

Sewer Suffering
Program Description:
Control of the program is through buttons, and are labeled with what they are intended to do. The start button will bring the user to the screen where they choose their character, and the quit button will quit the program.
After arriving at the character choice screen, the player can use radio buttons to select which randomly generated character they want to play for the rest of the game. After pressing the button that says ‘enter the sewer’, players are pulled to a screen with a wizard that gives them instructions on how to do damage to enemies. Two enemies are randomly generated in the room, and the player must click on them and click on either the ‘attack’ or ‘use spell’ option. After the enemies are defeated, the wizard’s dialogue will change and let the player know how points are acquired and that they will be taking damage from enemies from then on. By pressing the ‘next room’ button, the player will be taken to a room where 2 more randomly generated enemies spawn and will fight them to be able to leave the room. The ‘large slime’ and ‘skeleton wizard’ enemies are worth 20 points, and the ‘slime’ and ‘skeleton’ enemies are worth 10 points. The large slime will take half damage from characters with physical damage and the skeleton wizard will take half damage from characters with magical damage. When pressing the attack button, the targeted enemy will do damage back to the player. If the player dies during this, the game brings the player to the end screen, which displays their score and a very large quit game button.
Challenges:

Known Bugs:
As you know Rob, there is a glitch concerning how interactable components are bleeding through the cards in the Card Layout. 

When attacking, sometimes characters will do more damage than they are supposed to.

Coding Challenges:
The initial problem I had was implementing code that would allow panels to run a method that would move to the next card in the layout, but that was quickly resolved with some setters and code in the game driver.

I initially had trouble getting the code to update after the player had chosen their main character because the panels in the card layout were preloaded, but by adding to the setmaincharacter() methods in each panel, I was able to fix this issue. 

Another issue I had was getting the health bars to update correctly. I had to expand the red rectangle by changing the width, but also change the x-value so it looked like it was encompassing the green rectangle to simulate damage. It was difficult necessarily to figure out, but it was tedious. I ended up setting all of the characters’ health pools to 100 to simplify how the math worked out when calculating the pixels needed to move. 

Game Design

Art and Story
In the state the game is in now, there is little for non-combat-based player stats to do. Ideally, with more time, I would be able to add scenarios that require players to use those non-combat-based stats. 
For the art, all art is made in Microsoft Paint using a laptop and trackpad. Regarding character representation, for each character, I just went across the basic colors that Microsoft Paint provides. For the randomly generated names, I asked random people who were around me for a name, often without context. This led to a mix of historical and biblical references, as well as the names of real people in real life such as ‘Hunter Metzloff’.
As of now, there is no real story to this game, other than that there is a random wizard who introduces you to the sewer, and that you are a ‘traveler’ of some kind. 
Because the setting is a sewer, the background is gray, and the initial meeting with the wizard shows a flow of sewage. 

Game Balance
In the state the game is now, there has not been a real attempt to balance. Some characters were given stats that were intended to be helpful in non-combat situations, but since those don’t exist they are weaker than characters who focus solely in combat. 


Future of the Game
Many of the decisions I made for the coding were proofs of concept for me. This is the first major coding project I have undertaken (that wasn’t an assignment with step-by-step instructions), and I wanted to use multiple techniques to do different things. I didn’t get to test all of the ideas I wanted to, so in the future, I may decide to use this program to test new types of code that I have learned. For example, I want to test different types of layouts, and in this project, I have used card layout, grid layout, null layout, flow layout, and border layout. By testing their limits, I have learned which ones I like to use. I like null layout because it allows me to place my components more accurately but placing each component can be tedious. 

I want to do more with mouse and keyboard listeners in the future, perhaps these can be used to navigate the various non-combat situations that could be added. I would also like to add some way to incorporate healing into this game since the game only ends once your character’s HP hits 0. Having the player be able to do more than 3 combat encounters would be ideal. 


