-The command line will prompt the program's user through the loginOptionsController asking for the user if they want to
sign in or sign up. 

If the user wishes to sign up, createUserController prompts them to input their username to sign up.
This creates a new user via userManager and adds it to the Master user dictionary via masterManager. 

If the user wishes to sign in, they input their username via signing Controller and it checks if it is a username that
is already created. If it is valid it brings them to loginOptionsController. The validity of the username is checked
through masterManager. If it is valid, it runs the userOptionsController and prompts the user to search, options.post, or
options.browse,buy.

If the user wishes to search, it calls searchController and prompts them to input the tag of the productFunctions that they want
to search for. It searches the data based for products that match this tag from the masterManager. It adds the list to
the user's currentSearches via userManager. If the tag does not exist, an empty list is returned. It prompts the user
via cartManager if they want to add any products from their currentSearchList to their options.cart.

If the user wishes to Post, the user is prompted to input information about the options.post and about the productFunctions, and from
there, it calls postManager to create the options.post, and productManager to create the productFunctions, userManager to add the options.post
to the user's options.post list, masterManager to add the productFunctions to the 2 hashmaps in the Master that saves the productFunctions under
 the tags list and the productFunctions dictionary.

If the user wishes to options.browse, it calls browseController which gets all the posts of the user's feed which is populated
with the posts that the user's following list have posted.This implementation of feed is one that our group will be
working on in the future. The options.browse option displays the posts in their feed, and prompts the user if they want to buy
 any of the products inside the posts. If they do, it calls cartController, and it adds the specific productFunctions to their
 options.cart.

If the user wants to buy, it calls userManager, which empties their options.cart.