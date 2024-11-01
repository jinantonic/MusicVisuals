# Music Visuals Project (Java Processing)
It has been over a year since the pandemic hit the whole world and here we are still living our lives, wasting our youth. Even though it has been such a devastating experience, as a Korean poet Sang-Wha Lee said, Spring comes to the lost land. This assignment represents the eagerness for the joy that we used to appreciate, and the hope that we soon will be able to reunite with it. Since I am a huge music fan who barely turns off the music, I wanted to create an art piece that reacts to the music, so that it could enlighten my time while listening to the tunes. My all-time favourite character is Elmo, so he was chosen as the main actor in the program. He starts dancing with his two friends and as time goes by, mini Elmos are generated vibing together.

# Instructions
It is a very simple program that responds to the music, so the music and the movement stop when you press the space bar and it resumes when you hit a space bar again. 

# How it works
This project is consist of 5 classes which are **Main**, **Visual**, **JinasVisual**, **Star** and **Monster**. 
Through the main class, the other three classes start executing and sharing the visualisation. 

When you are partying, nothing boosts up the vibe more than the disco ball light. Star class contains constructors and 2 methods called **update()** and **show()** which calculate the star points using the map function and draw them on the screen.

Now the rainbow lights are ready, it is time to bring the dancers to the stage. **Monster class** is created to form the figure and it is efficient to have it as a separate class, so that multiple Elmos can be created easily and quickly. Monster class has the **constructor**, **update()**, **render()**, **getters** and **setters**. Through the update method, it eliminates the number of miniatures that are created by the lerped average and through the draw method, it creates the figure of the character. Getters and setters are in the class monster as well to pass the variables that are used in the Monster class to JinasVisual class. 

**JinasVisual class** creates the array of **Star** and **Monster** so that their contained methods can be called. In **settings()**, it sets the screen size and the variables of half-width and half-height which will be often used in the drawing method. Through the for loop in here, it will run 50 times, creating the new star. In **setup()**, it sets the colourMode as HSB and loads the audio file. Monster objects are created in their position. Minimies are created on the screen using **spawnMonster()** and **keyPressed()** controls the music pause using the space bar. Lastly, the **draw()** calls the functions from monster, star, and the visual class. It first contains the for loop which iterates over all the elements of the audio buffer. It calculates the sum and average for the lerped average to make the visual clear and smoother. 

The party without the disco ball is like the tortoise without the shell. The **disco ball** and the **spotlights** are drawn and set to change the shade between the grey shades for the dramatic effect. And then stars have been updated and shown using the for loop and translated to show as if the lights are coming from the disco ball at the top middle point of the screen. Monsters are being rendered and updated in the for loop as well and mini monsters are drawn after them. 

# What I am most proud of this project
It was a challenge since I am not familiar with the Java language and my coding skill was not enough to implement my imagination. However, as time goes by, I was able to execute functions that I planned and gained so much knowledge discovering the methods and techniques for each situation. I never thought I could create a project that reacts to the music and now I have a satisfying result that can remind me of the song that helped me to go through a hard time. My sincere gratitude to Brayn that I was able to earn professional knowledge through this assignment and confidence as well as motivation in coding. I am mainly proud of:


- Visualising the Elmo using java processing
- Unique visual of the program
- Simple and not hardcoded project
- The rainbow HSB colour shades using two lines of if-else statement
- Usage of the lerped average of the song to calculate the timing of mini Elmos appearing
- Inspection of the average value to control the spotlight timing 


I may not have good coding skill yet, but I tried my best to implement the visualisation and succeeded to make them working without using fancy techniques. Based on this accomplishment, I am now ready to step up as a baby developer and create a masterpiece with the best efficiency.

[![YouTube](https://i.ytimg.com/vi/xY2zeKEhhEc/maxresdefault.jpg)](https://youtu.be/xY2zeKEhhEc)
