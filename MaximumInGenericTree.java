package GenericTree;
/*
1. You are given a partially written GenericTree class. 2. You are required to complete the body of max function. The function is expected to find the node with maximum value and return it. 3. Input and Output is managed for you.


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
60
*/
import java.util.ArrayList;
import java.util.Stack;

public class MaximumInGenericTree {
    // constructor
    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    // method for finding max element
    static int maxElement(Node node){
        int max = Integer.MIN_VALUE;
        for(Node child : node.children){
            int curMax = maxElement(child);
            max = Math.max(curMax, max);
        }
        max = Math.max(max, node.data);
        return max;
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
        System.out.println("Maximum element is : " + maxElement(root));
    }
}
