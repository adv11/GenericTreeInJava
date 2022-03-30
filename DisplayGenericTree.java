package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class DisplayGenericTree {
    // d - display , s - self
    // d(10) -> 10 will print itself, and it's family
    // d(20), d(30), d(40) -> will print themselves, and their family
    // d(10) = s(10) + d(20) + d(30) + d(40)
    static void display(Node node){
        // printing itself and it's family
        StringBuilder str = new StringBuilder(node.data + " -> ");
        for(Node child : node.children){
            str.append(child.data).append(", ");
        }
        str.append(".");
        System.out.println(str);

        // recursive call from family of upper node(ancestor)
        for(Node child : node.children){
            display(child);
        }
    }
    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
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
        display(root);
    }
}
