package GenericTree;
/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of traversals function. The function is expected to visit every node. While traversing the function must print following content in different situations.
   2.1. When the control reaches the node for the first time -> "Node Pre" node.data.
   2.2. Before the control leaves for a child node from a node -> "Edge Pre"
   node.data--child.data.
   2.3. After the control comes back to a node from a child -> "Edge Post" node.data-
   -child.data.
    2.4. When the control is about to leave node, after the children have been visited
    -> "Node Post" node.data.
3. Input is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
As suggested in Sample Output

Example
Sample Input

12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1

Sample Output
Node Pre 10
Edge Pre 10--20
Node Pre 20
Node Post 20
Edge Post 10--20
Edge Pre 10--30
Node Pre 30
Edge Pre 30--50
Node Pre 50
Node Post 50
Edge Post 30--50
Edge Pre 30--60
Node Pre 60
Node Post 60
Edge Post 30--60
Node Post 30
Edge Post 10--30
Edge Pre 10--40
Node Pre 40
Node Post 40
Edge Post 10--40
Node Post 10
*/
import java.util.ArrayList;
import java.util.Stack;

public class TraversalsInGenericTree {
    // constructor
    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    static void traversals(Node node){
        // preorder
        System.out.println("Node Pre " + node.data);
        for(Node child : node.children){
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }
        // postorder
        System.out.println("Node Post " + node.data);
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
        traversals(root);
    }
}
