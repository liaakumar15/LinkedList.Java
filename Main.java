//Written by: Vetriliaa Kumar for CS 3345.503
//Started on: September 22nd, 2023
//Project 1: MemLinkedList

//Project Description: This project allocates one megabyte of data and the user 
//can request the program to allocate and release blocks of memory 
//and view the current status of the memory in the linked list.

//File Name: This is the main file that calls methods described in MemLinkedList. 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemLinkedList memory = new MemLinkedList();
        Scanner scanner = new Scanner(System.in);

        //Prints out menu until user chooses to exit
        while (true) {
            System.out.println("1. Request memory");
            System.out.println("2. Release memory");
            System.out.println("3. Clear memory");
            System.out.println("4. Print memory status");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter size in kilobytes to request: ");
                        int requestSize = scanner.nextInt();
                        memory.request(requestSize);
                        break;
                    case 2:
                        System.out.print("Enter size in kilobytes to release: ");
                        int releaseSize = scanner.nextInt();
                        memory.release(releaseSize);
                        break;
                    case 3:
                        memory.clear();
                        System.out.println("Memory cleared");
                        break;
                    case 4:
                        memory.print();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
