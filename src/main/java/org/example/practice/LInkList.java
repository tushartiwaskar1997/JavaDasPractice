package org.example.practice;

import static org.example.practice.HashMpaPractice.longestPalindromeNumber;
import static org.example.practice.RecursionBasic.countDigitsInNumber;

import java.util.ArrayList;
import java.util.HashSet;

public class LInkList {

    public static Node creatLinkListFromArray(int[] arr, int caseValue) {
        if (arr.length == 0)
            return null;
        switch (caseValue) {
            case 1:
                Node node1 = new Node(arr[0]);
                Node curentNode = node1;
                for (int i = 1; i < arr.length; i++) {
                    curentNode.next = new Node(arr[i]);
                    curentNode = curentNode.next;
                }
                return node1;
            case 2:
                Node node2 = new Node(arr[0]);
                Node curentNode1 = node2;
                for (int i = 1; i < arr.length; i++) {
                    curentNode1.next = new Node(arr[i]);
                    curentNode = curentNode1.next;
                }
                return node2;
            case 3:
                Node node3 = new Node(arr[0]);
                Node head = node3;
                Node currentNode3 = node3;
                for (int i = 1; i < arr.length; i++) {
                    currentNode3.next = new Node(arr[i]);
                    currentNode3 = currentNode3.next;
                }
                currentNode3.next = head;
                return head;
            default:
                System.out.println("Invalid condition.");
                break;
        }
        return null;
    }

    public static void traversalOfLinkList(Node x) {
        Node currentNode = x;
        while (currentNode != null) {
            System.out.println(currentNode.data + " list list transaversl started.");
            currentNode = currentNode.next;
        }
    }

    public static void removeTheDuplicatesFromLinkList(Node head) {
        HashSet<Integer> set = new HashSet<>();
        Node currentNode = head;
        Node pointer = null;
        while (currentNode != null) {
            if (set.contains(currentNode.data)) {
                pointer.next = currentNode.next;
            } else {
                set.add(currentNode.data);
                pointer = currentNode;
            }
            currentNode = currentNode.next;
        }

        while (head != null) {
            System.out.println(head.data + " after duplicates are removed.");
            head = head.next;
        }
    }

    public static void removeTheDuplicatesFromLinkList2(Node head) {

        Node currentNode = head;
        Node pointer = null;
        HashSet<Integer> set = new HashSet<>();

        while (currentNode != null) {
            if (set.contains(currentNode.data)) {
                pointer.next = currentNode.next;
            } else {
                set.add(currentNode.data);
                pointer = currentNode;
            }
            currentNode = currentNode.next;
        }

        while (head != null) {
            System.out.println(head.data + " Thsis is new link list.");
            head = head.next;
        }
    }

    public static void revrseTheLinkList(Node head) {
        Node nextNode = null;
        Node prevNode = null;
        Node currentNode = head;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (prevNode != null) {
            list.add(prevNode.data);
            prevNode = prevNode.next;
        }
        System.out.println(list);
    }

    public static void findMiddleAndPlaceItToStart(Node head) {
        if (head == null || head.next == null)
            System.out.println("null");

        Node slowPointer = head;
        Node fastPointer = head;
        Node middleNode = null;
        while (fastPointer != null && fastPointer.next != null) {
            middleNode = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = slowPointer.next.next;
        } // from this middle pointer we will get.

        if (middleNode != null) {
            middleNode.next = slowPointer.next; // what is happninghere
            slowPointer.next = head;
            head = slowPointer;
        }

        while (head != null) {
            System.out.println(head.data + " -> ");
            head = head.next;
        }
    }

    public static boolean checkListIsCircularOrNot(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("This list is circular.");
                return true;
            }
        }
        System.out.println("This list is not circular.");
        return false;
    }

    public static void insertAnElementInSortedCurcularLinkList(Node head, int number) {

        Node previousPointer = head;
        Node currentNode = head;
        Node nodeToAdd = new Node(number);

        while (currentNode != null && currentNode.next.data < number) {
            previousPointer = currentNode;
            currentNode = currentNode.next;
        }
        System.out.println(previousPointer.next.next.data+"-------------------");
        if (previousPointer.next.next.data!= nodeToAdd.data) {
            nodeToAdd.next = currentNode.next;
            currentNode.next = nodeToAdd;
        }

        currentNode = null;
        currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data + " circ linst.");
            currentNode = currentNode.next;
            if (currentNode == head) {
                break;
            }
        }

    }

}

class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
}
