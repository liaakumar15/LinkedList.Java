//Written by: Vetriliaa Kumar for CS 3345.503
//Started on: September 22nd, 2023
//Project 1: MemLinkedList

//Project Description: This project allocates one megabyte of data and the user 
//can request the program to allocate and release blocks of memory 
//and view the current status of the memory in the linked list.

//File Description: This file contains all the methods implemented in main. 
import java.util.LinkedList;

class MemNode {
    char status; // F or A flags
    int size; // in kilobytes!!

    MemNode(char status, int size) {
        this.status = status;
        this.size = size;
    }
}

public class MemLinkedList {
    LinkedList<MemNode> list;

    public MemLinkedList() {
        this.list = new LinkedList<>();
        this.list.add(new MemNode('F', 1000000)); // Allocates 1 megabyte of free memory at initialization
    }

    public void request(int size) throws Exception {
        //Makes size input in kilobytes
        size = size*1000;
    if (size <= 0) {
        throw new Exception("Size must be greater than 0");
    }
    for (MemNode node : list) {
        if (node.status == 'F' && node.size >= size) {
            node.size -= size;
            list.add(list.indexOf(node) + 1, new MemNode('A', size));
            if (node.size == 0) {
                list.remove(node);
            }
            return;
        }
    }
    throw new Exception("Not enough memory");
}


    public void release(int size) throws Exception {
        if (size <= 0) {
            throw new Exception("Size must be greater than 0");
        }
        for (MemNode node : list) {
            if (node.status == 'A' && node.size == size) {
                node.status = 'F';
                node.size += size;
                merge();
                return;
            }
        }
        throw new Exception("No such block to release");
    }

    private void merge() {
        for (int i = 0; i < list.size() - 1; i++) {
            MemNode current = list.get(i);
            MemNode next = list.get(i + 1);
            if (current.status == 'F' && next.status == 'F') {
                current.size += next.size;
                list.remove(next);
            }
        }
    }

    public void clear() {
        this.list.clear();
        this.list.add(new MemNode('F', 1000000)); // 1 megabyte of free memory
    }

    public void print() {
        for (MemNode node : list) {
            System.out.println("Status: " + node.status + ", Size: " + node.size);
        }
    }
}