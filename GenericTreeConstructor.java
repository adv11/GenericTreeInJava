package GenericTree;
import java.util.Stack;

public class GenericTreeConstructor {
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
    }
}
