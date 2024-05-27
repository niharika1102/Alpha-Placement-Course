import java.util.*;

public class TopViewOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Class to store data in queue for level order traversal
    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView (Node root) {
        //Level order Traversal
        Queue<Info> q = new LinkedList<>();

        //Map to store unique horizontal distances
        HashMap<Integer, Node> map = new HashMap<>();

        //Min and max to store min and max horizontal distances
        int min = 0;
        int max = 0;

        //Storing elements in the queue
        q.add(new Info(root, 0));   //HD of root is always 0
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                //Case 1: The tree has been traversed fully
                if (q.isEmpty()) {
                    break;
                }
                //Case 2: The level as been completely traversed
                else {
                    q.add(null);
                }
            }

            //If curr != null
            //If curr hd is not in map, we store it in the map. It means that the hd is unique. So, the node will be a part of the top view
            else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
    
                //If left child of root is not null, we store it in the queue
                if (curr.node.left != null) {
                    //First, we add the left child to the queue
                    q.add(new Info(curr.node.left, curr.hd - 1));
    
                    //Updating the value of min
                    min = Math.min(min, curr.hd - 1);
                }
    
                //Run the similar proces for right child also
                if (curr.node.right != null) {
                    //First, we add the right child to the queue
                    q.add(new Info(curr.node.right, curr.hd + 1));
    
                    //Updating the value of max
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        //Printing top view of tree
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        //         1
        //       /   \
        //      2     3
        //    /  \   /  \
        //   4    5  6   7

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root);
    }
}