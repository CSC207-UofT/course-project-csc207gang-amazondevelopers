-The command line will prompt the program's user through the loginOptionsController asking for the user if they want to
sign in or sign up. 

If the user wishes to sign up, createUserController prompts them to input their username to sign up.
This creates a new user via userManager and adds it to the Master user dictionary via masterManager. 

If the user wishes to sign in, they input their username via signing Controller and it checks if it is a username that
is already created. If it is valid it brings them to loginOptionsController. The validity of the username is checked
through masterManager. If it is valid, it runs the userOptionsController and prompts the user to search, post, or
browse,buy.

If the user wishes to search, it calls searchController and prompts them to input the tag of the product that they want
to search for. It searches the data based for products that match this tag from the masterManager. It adds the list to
the user's currentSearches via userManager. If the tag does not exist, an empty list is returned. It prompts the user
via cartManager if they want to add any products from their currentSearchList to their cart.

If the user wishes to Post, the user is prompted to input information about the post and about the product, and from
there, it calls postManager to create the post, and productManager to create the product, userManager to add the post
to the user's post list, masterManager to add the product to the 2 hashmaps in the Master that saves the product under
 the tags list and the product dictionary.

If the user wishes to browse, it calls browseController which gets all the posts of the user's feed which is populated
with the posts that the user's following list have posted.This implementation of feed is one that our group will be
working on in the future. The browse option displays the posts in their feed, and prompts the user if they want to buy
 any of the products inside the posts. If they do, it calls cartController, and it adds the specific product to their
 cart.

If the user wants to buy, it calls userManager, which empties their cart.