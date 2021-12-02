#Progress Report

###Progress Summary
The specification entails our goals and some of the tasks regarding our project. Our specification talks about the goal 
of designing an e-commerce app that shares similar characteristics as social media platforms as Instagram. The 
specification also involves details of the actions and procedures that the program can execute and all the 
functionalities of the program such as how signing up works, following people, messaging, following, searching, buying 
etc.

The CRC model contains 17 classes adhering to the SOLID principles and clean architecture, presented with a clear 
identification of 4 entity classes (Master, User, Product, Post), 4 use cases (masterManager, userManager, postManager, 
productManger), 8 controllers (browseController, cartController, createUserController, createPostController, 
loginOptionsController, searchController, signInGUI, userOptionsController) and a command line interface 
(SystemInOut). The CRC model shows that all of these follow the dependency rule with data flow from command line 
interface to controllers to use cases to the entity.

Our walk-through explains the details of using the program and explains the usage of the program with the support of 
classes in the aforementioned CRC model, showing a concrete visualization of how the CRC model is implemented in our 
program. The walkthrough explains step by step how the program works, beginning with the command line asking users to 
sign in or sign up and ending with users buying objects and emptying their shopping cart.

Our skeleton program allows users to sign up (create new profile) or sign in, browse through posts made by other users, 
purchase products that are associated with what they post by adding it to their cart. Users are also able to search for products based on tags and even make their own posts to sell products. 

###Questions
Our group is still unsure about how we can get items in our cart to be purchased. Right now, our implementation just 
empties the cart but we want to find a method that can help users actual purchase an item. We are also wondering on how 
we can get multiple users to interact such as send each other messages, ratings, this question leeways into our other 
question which is about how we can get this messaging interaction between users. Evan explained that this could be done 
through cloud system or through databases such as Mongo DB Atlas, we are just wondering about how to get started 
with this?

###Strengths of design

So far, the strength of the design is that the instructions given by the command line interface makes the program 
very easy to use. The prompts given to the user are very easy to interpret and straightforward, allowing users to easily
make accounts, sign in, create posts, add to their cart, etc. 

###Current group work and goals for phase 0
Group members contributed equally to brainstorming and writing up specifications, CRC model, walkthrough and skeleton 
program. For the skeleton program, each group member worked on specific classes by themselves and some worked together 
on other classes. Albert worked on productFunctions, productManager and postManager classes. Yasmin worked on master, 
masterManager and searchcontroller classes. Jacqueline worked on createUserController, cartController, main, 
searchController classes. Diego worked on userOptionsController and browseController. Sam worked on post, 
postController, and createPostController classes. Finally, Umayrah worked on searchController, User, userManager, 
userOptionsController, signInGUI, and loginOptionsController classes.

We plan to implement more features such as connecting to banks for making purchases, chatting with other users, 
making reviews, liking posts, ability to display images, signing out without losing your profile information. 
Adding information to a cloud and chatting via cloud. We also noticed that for phase 0, we did implement as many tests 
as we could have due to time constraint, we plan on implementing more tests while we write code to allow for test 
driven development.
