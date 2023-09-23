# LinkedList.Java
//Completed for Data Structures and Algorithms Course: Fall 2023
//Written in Java

Project Summary: This Java program allows the user to allocate and release blocks of memory from a megabyte of memory stored in a linked list.

MemLinkedList.java:
1. MemLinkedList class is initalized with 1 megabyte of memory.
2. It uses nodes to store a flag (F or A) to represent a Free or Allocated block
   of memory, along with the size of the block of memory.
3. The class implements the following methods:
   a.  request(int size)
        allocates a block of this size, receives a size in kilobytes 

   b.  release(int size)
        frees a block of this size (and repeatedly merges with free neighbors), receives a size in kilobytes 

   c.  clear()
        resets to the initial 1M free list

   d.  print()
        prints each node's status (A or F) and size

   e.  main()
        demonstrates each of your methods

4. The class performs checking of the parameters and throw exceptions where 
   appropriate.

Main.java:
1. Prints a menu for the user to request, release, clear and print from memory. 



