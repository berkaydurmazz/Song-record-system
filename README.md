# Song-record-system
Binary Search Tree Map based Music Song record system

In this project you will create a record system which allows insertion, search, and deletion of musical records. Existing musical records will be initially read from a text file where each line holds one song information as follows:
Song name;Artist;ID;Genre; Year
Each field has been separated by semicolon(;) from other fields
Example.,
İki keklik; Erkan Oğur; 1001; Türk Halk; 1996
You will prepare your songs.txt file yourself.
1. Firstly, build a song object class.
2. Your program should be able to search songs using name, artist, ID. For example, user should be able to search for a song with ID = 1003, or name = Summer Time. Searching will be done based on only one field, not a combination of fields.
3. The second search method allows the user to search and display all songs of a given genre. For example list all “Türk Halk” songs or “Rock” songs.
4. Your program will let users to search ranges by giving lover and upper bounds of an interval for keys (only the ID field), For example: ID: 1001-1010 displays the list of users with IDs from 1001 to 1010.
5. You can design your interactive menu by yourself.
6. You must create several binary tree maps (at least three BSTs based on song name, or ID, or artist) to allow searching via different keys, such as name, id, or age. So, there should be one BST to storesong namekeys, another to store with IDs, and one for artist.
7. Each of these BST maps must not store a copy of the whole song object since this is very an inefficient use of memory. They can just store an index (next to the key). This index can help your program find a specific song in an array where customers are stored. So you can create key-value pairs for different keys where value is an integer index.
8. You can choose any BST implementation or AVL implementation. You can even use java tree map.
9. Let the user to insert new songs with required fields (Song name;Artist;ID;Genre; Year) and to delete an existing record based only on its ID field. You can design your interactive menu by yourself.
10. You must also let user delete any song with given id.
11. Note: In order to test your program, read a few records from a file and build the tree, then apply the tasks mentioned above on the generated tree.
