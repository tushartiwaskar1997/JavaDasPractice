package org.example.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
        System.out.println(previousPointer.next.next.data + "-------------------");
        if (previousPointer.next.next.data != nodeToAdd.data) {
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

    public static void deleteTheLastNodeFromTheLinkList(Node head, int n) {
        Node j = head;
        while (j.next.next != null) {
            j = j.next;
        }
        j.next = null;
        Node i = head;
        while (i != null) {
            System.out.println(i.data + " ----");
            i = i.next;
        }
    }

    public static void deleteThekTHNodeFromTheLinkList(Node head, int k, int totalNumber) {
        if (head == null || k <= 0 || k > totalNumber) {
            System.out.println("Invalid input");
            return;
        }
        if (k == totalNumber) {
            head = head.next;
            while (head != null) {
                System.out.println(head.data + " K remove ----");
                head = head.next;
            }
            return;
        }
        int nodeToRemove = totalNumber - k - 1;
        Node j = head;
        while (nodeToRemove > 0) {
            j = j.next;
            nodeToRemove--;
        }
        j.next = j.next.next;
        Node i = head;
        while (i != null) {
            System.out.println(i.data + " K remove ----");
            i = i.next;
        }
    }

    public static void deleteTheNodeWhenYouDontKnowHead(Node nodetoDelete, Node head) {
        // use head for iteration.
        if (nodetoDelete.next == null) {
            System.out.println("invalid Node.");
            return;
        }

        while (nodetoDelete.next.next != null) {
            nodetoDelete.data = nodetoDelete.next.data;
            nodetoDelete = nodetoDelete.next;
        }
        nodetoDelete.data = nodetoDelete.next.data;
        nodetoDelete.next = null;

        while (head != null) {
            System.out.println(head.data + " --- head data");
            head = head.next;
        }
    }

    public static void reorderTheListWithRelationToAnInputMaintainTheOrder(int number, Node head) {
        // head and tail concept . we add new element one by one . at last we combine
        // all the list
        Node lessHead = new Node(0); // theis are dummy node . 0 is adjuster by node_head.next.
        Node equalHead = new Node(0);
        Node greaterHead = new Node(0);

        Node lessListTail = lessHead;
        Node equalTail = equalHead;
        Node greaterTail = greaterHead;

        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.data < number) {
                lessListTail.next = currentNode;
                lessListTail = lessListTail.next;
            }

            else if (currentNode.data == number) {
                equalTail.next = currentNode;
                equalTail = equalTail.next;
            }

            else if (currentNode.data > number) {
                greaterTail.next = currentNode;
                greaterTail = greaterTail.next;
            }
            currentNode = currentNode.next;
        }
        greaterTail.next = null;

        // adding node logic
        equalTail.next = greaterHead.next;
        if (equalHead.next == null) {
            lessListTail.next = greaterHead.next;
        } else {

            lessListTail.next = equalHead.next;
        }

        while (lessHead.next != null) {
            System.out.println(lessHead.next.data + " --- mmm head data");
            lessHead = lessHead.next;
        }
    }

    public static void merge2SortedLinkedList(Node head1, Node head2) {

        Node pointer1 = head1;
        Node pointer2 = head2;
        Node finalList = new Node(0);
        Node head = finalList;

        while (pointer1 != null || pointer2 != null) {

            if (pointer1 != null && pointer2 != null) {
                if (pointer1.data < pointer2.data) {
                    finalList.next = pointer1;
                    pointer1 = pointer1.next;
                } else {
                    finalList.next = pointer2;
                    pointer2 = pointer2.next;
                }
            } else if (pointer1 == null) {
                finalList.next = pointer2;
                pointer2 = pointer2.next;
            } else if (pointer2 == null) {
                finalList.next = pointer1;
                pointer1 = pointer1.next;
            }
            finalList = finalList.next;
        }
        // finalList.next = null;

        while (head != null) {
            System.out.println(head.data + " ----dfsdfs");
            head = head.next;
        }
    }

    public static void copyRandonNode(Node headNode) {
        if (headNode == null) {
            System.out.println("Invalid ");
            return;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node p = headNode;
        while (p != null) {
            map.put(p, new Node(p.data, null, null));
            p = p.next;
        }
        Node q = headNode;
        while (q != null) {
            map.get(q).next = map.get(q.next);
            map.get(q).prev = map.get(q.prev);
            q = q.next;
        }
        while (headNode != null) {
            System.out.println(headNode.data + " --copy ");
            headNode = headNode.next;
        }
    }

    static int carryForAdding = 0;

    public static void addTwoNumberRepresentedInLinkList(Node number1, Node number2) {
        System.out.println(helperMethodToFindLengthOfList(number1) + "  length of node1.");
        System.out.println(helperMethodToFindLengthOfList(number2) + "  lenght of node2.");
        int node1Lenght = helperMethodToFindLengthOfList(number1);
        int node2Lenght = helperMethodToFindLengthOfList(number2);
        if (node1Lenght < node2Lenght) {
            number1 = addingZerosAtStarting(number1, node2Lenght - node1Lenght);
        } else if (node2Lenght < node1Lenght) {
            number2 = addingZerosAtStarting(number2, node1Lenght - node2Lenght);
        }
        Node result = sumHelper(number1, number2);
        if (carryForAdding > 0) {
            Node carrayNode = new Node(carryForAdding);
            carrayNode.next = result;
            result = carrayNode;
        }
        while (result != null) {
            System.out.println(result.data + " sum result");
            result = result.next;
        }
    }

    public static Node addingZerosAtStarting(Node head, int difference) {
        for (int i = 0; i < difference; i++) {
            Node newHead = new Node(0);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    public static Node sumHelper(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        Node sumNode = sumHelper(node1.next, node2.next);
        int sum = node1.data + node2.data + carryForAdding;
        carryForAdding = sum / 10;
        Node newNode = new Node(sum % 10);
        newNode.next = sumNode;
        return newNode;
    }

    public static int helperMethodToFindLengthOfList(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void findTheCommonPointBetweenTwoList(Node node1, Node node2) {

        int lenghtofA = helperMethodToFindLengthOfList(node1);
        int lenghtofB = helperMethodToFindLengthOfList(node2);
        Node p1 = node1;
        Node p2 = node2;
        if (lenghtofA > lenghtofB) {
            for (int i = 0; i < lenghtofA - lenghtofB; i++) {
                p1 = p1.next;
            }
        } else if (lenghtofA < lenghtofB) {
            for (int i = 0; i < lenghtofB - lenghtofA; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                System.out.println(p1.data + " this is intersection point");
                return;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
    }

    public static void checkIfListIsCircularOrNot(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("given list is circular.");
                return;
            }
        }
    }

    public static void removeTheCycleFromTheList(Node head) {
        Node newList = null;
        HashSet<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                newList.next = null;
                return;
            } else {
                set.add(head);
                newList = head;
                head = head.next;
            }
        }
    }

    ///// -------------------------------------//////
    public static Node findTheMidOfList(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data + "  - Mid Node of list.");
        return slow;
    }

    public static Node mergeOfTwoList(Node list1, Node list2) {

        Node mergeList = new Node(0);
        Node tail = mergeList;
        while (list1 != null && list2 != null) {

            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return mergeList.next;
    }

    public static Node finalMergeOfSortedList(Node heaNode) {

        if (heaNode == null || heaNode.next == null) {
            return heaNode;
        }
        Node mid = findTheMidOfList(heaNode);
        Node rightHandList = mid.next;
        mid.next = null;
        Node left = finalMergeOfSortedList(heaNode);
        Node right = finalMergeOfSortedList(rightHandList);
        return mergeOfTwoList(left, right);
    }

    public static void printzSortedList(Node head) {
        head = finalMergeOfSortedList(head);
        while (head != null) {
            System.out.println(head.data + "   - sorted head data.");
            head = head.next;
        }
    }
    ///// -------------------------------------//////

}
