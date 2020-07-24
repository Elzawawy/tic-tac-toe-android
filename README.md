# A Rewrite of an Android Application: TicTacToe Game

So, I woke up today thinking of exploring old projects particulary **Android** ones that I did while I was learning (Year 2017) and attempting to re-write them with knowledge I have now (Year 2020). **(cough..cough..no judgement guys :smile:)**  
This application was one of my first android indulgments, it is a simple tic-tac-toe game I built following a Udemy online course.

## Why can this be useful ? 

- For beginners, you can **relate to mistakes** I made back then or take notes of **improvemnts I add** along the way.  
- I decided to even organize this in an **agile manner**, and will be adding a ticket issue for every problem I find and making a branch/issue to follow real work environment and make this repoistory more frutiful. 
- Exploring the **rewrite of an old project process**, and how can this be important for self-imporvement goals. (It's my new side project)

## First Thoughts: Identifying the Bugs
Oh my ! that's a mess :smile:, but hey no shame that was learning phase and am damn proud !  
So, I ran the application to see what we have in our hands and I found out that the game have **multiple bugs.**
I decided to **list the bugs** I found and **my fixes** to them. Note that I will not care right now about possible code imporvements but rather a working version of the game. 

- **Issue #1: Main Activity Buttons Mixed**
    - On the Main Screen of the game, it showed two buttons, one for solo-mode and another for multiplayer-mode. Functionality was mixed with buttons click.
    - **Fix:** Obviously that was a small fix, just switch code for Button OnClick Listeners will do the trick.
    
- **Issue #2: Solo-Mode Button does nothing**
  - The solo-mode button OnClickListener is now an empty function. Turns out I didn't add any code in that mode for some reason.
  - **Fix:** By adding similar code to that I used for Multiplayer mode but to open SoloplayerMode Activity Class instead and hope it works.
  
- **Issue #3: UI Player isn't really playing**
  - So, now we have functioning two buttons on the main screen and each redirecting to different screens/modes of game (soloplayer-mode, multiplayer-mode). I tried out the soloplayer-mode and guess what? I didn't implement the UI Player to play it's turn, it just goes into a stall waiting for it to make a move. :satisfied:
  - **Fix:** That wasn't a simple fix, nor a clean one at all. I noticed an empty else statemnt to fill in the Game soloplayer-mode function. I filled it (in the fastest way possible) to make it work for now.
  
- **Issue #4: Wait, Who won?**
  - Okay, we now have both modes working some what fine. But there are other problems still, when the game ends and one of the play wins, I close the window with no inidcation who even won the round. Let's fix this, a winner gotta celeberate . :fire:
  - **Fix:** Instead of closing the window on achieving the winner condition, we will show a toast with Player `X` won or Player `O` won for a while with a 1 second delay then go back to the main screen to play again.
  
- **Issue #5: It's a Tie, What now?**
  - Another issue I found is when a tie occurs, nothing happens, you have to go back manually to the main screen which is not a symmetric action with the winning condition. 
  - **Fix:** Exactly the same idea as the fix for Issue #4, show a message, delay for a second then go back automatically.
  
## Working isn't enough now ! Let's improve.
We now have a working version, but since I want to practice the re-write of projects thing more. I am going to take extra measures and clean that mess up into a better working game.  
Those are open issues currently and will be taken care of along my free time. README will be updated with each Issue Fix subsequently.

### Improvement #1: Re-design the code. 
The application was originally written as an MVC (Model View Controller) Architecture. However, the Objects/Classes design can be re-done in a much better way. Some problems I noticed in deisgn are listed below:

- **View:** There are two Activities, one for each game mode. Those can be treated as one screen and pass intent extra information to indicate the type of players to be initiated. For that issue, I opened `Issue #11: Unify the In-Game Activity`.

- **Model:** The Model classes are the Player class, and two children classes: UIPlayer, HumanPlayer. I noticed how I didn't adhere to naming conventions, encapsulation or polymorphism much back then but that's about to change. Also, a lot of boilerplate code can be saved from those classes. For that issue, I opened `Issue #12: Re-build Model And Controller`.

- **Controller**: The controller in that case is the **Game** class. The Game class code is a mess and can be totally refined and optimized. This is closely related to the Player Model Class being refined. So, it will be included also in the `Issue #12: Re-build Model And Controller`.

### Improvement #2: AI Player.
The Computer Player is currently a dummy player that just picks randomly it's choice, that was my knowledge back in 2017. Now, and since I know/built AI players for games before in the AI University course.  
I think it's time to build a proper AI TicTacToe Player using the one and only famous **Minimax algorithm.** Am not certain when I'll have time for this or not but it's definitely a good add to this side project. For that issue, I opened `Issue #13: Build Minimax Agent`.

### Improvement #3: UI/Code Clean-up. 
Things that should be modified but can be plugged into any issue internally. (No need for new issues for it)

- The Screens can be much improved especially the main window.
- Why didn't I write a single comment back in 2017? Add comments man!. 
