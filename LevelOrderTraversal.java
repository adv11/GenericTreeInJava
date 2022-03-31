package GenericTree;
/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorder function. The function is expected to visit every node in "levelorder fashion". Please check the question video for more details.
3. Input is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
All nodes from left to right (level by level) all separated by a space and ending in a "."

Example
Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 20 30 40 50 60 70 80 90 100 110 120
*/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {
    // constructor
    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    static void levelOrderTraversal(Node node){
        // using queue data structure
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (queue.size() > 0){
            // remove
            node = queue.remove();
            // print
            System.out.print(node.data + " ");
            // add children of removed node
            queue.addAll(node.children);
        }
    }
    public static void main(String[] args) {
        int[] elements = {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};

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
        levelOrderTraversal(root);
    }
}
