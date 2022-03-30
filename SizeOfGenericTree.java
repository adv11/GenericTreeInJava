package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of size function. The function is expected to count the number of nodes in the tree and return it.
3. Input and Output is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1

Sample Output
6
*/
public class SizeOfGenericTree{
    // constructor
    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    // method for calculating size of the generic tree
    static int size(Node node){
        int totalNodes = 0;
        for(Node child : node.children){
            int currentNode = size(child);
            totalNodes += currentNode;
        }
        return totalNodes+1;    // adding root node
    }
    public static void main(String[] args) {
        int[] elements = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Stack<Node> stack = new Stack<>();
        Node root = null;
        for(int i : elements){
            // it means node has no children
            if(i == -1){
                stack.pop();
            }else{
                // creating new node
                Node newNode = new Node();
                newNode.data = i;
                if(stack.size() > 0){
                    // making new node children of the previous node
                    stack.peek().children.add(newNode);
                }else{
                    root = newNode; // if the stack is empty then the first node is the root node of the tree
                }
                stack.push(newNode);
            }
        }
        System.out.println("Size of the given generic tree is : " + size(root));
    }
}
