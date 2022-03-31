package GenericTree;
/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorderLineWise function. The function is expected to visit every node in "levelorder fashion" and print them from left to right (level by level). All nodes on same level should be separated by a space. Different levels should be on separate lines. Please check the question video for more details.
3. Input is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
All nodes from left to right (level by level) all separated by a space.
All levels on separate lines starting from top to bottom.

Example
Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10
20 30 40
50 60 70 80 90 100
110 120
*/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderLinewise{
    // constructor
    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    // Level order linewise
    static void levelOrderLinewise(Node node){
        // Queue for storing parent nodes
        Queue<Node> parentQueue = new ArrayDeque<>();
        parentQueue.add(node);

        // Queue for storing children of deleting node
        Queue<Node> childQueue = new ArrayDeque<>();

        while (parentQueue.size() > 0){
            node = parentQueue.remove();
            System.out.print(node.data + " ");

            // node add children of removed node
            childQueue.addAll(node.children);

            // if parentQueue.size() == 0 then add children to parent queue
            if(parentQueue.size() == 0){
                parentQueue = childQueue;   // storing child to parent queue
                childQueue = new ArrayDeque<>();    // remove all children from childQueue

                System.out.println();
            }
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
        levelOrderLinewise(root);
    }
}
