import java.util.*;

public class TreeTraversals {
    static class Node {       //Blueprint of the node
        int data;
        Node left;
        Node right;

        Node(int data) {      //Constructor call
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;    //Index of tree starts from -1. Then we update it at each step in the methods
        
        //Building tree from pre-order traversal
        public Node buildTree(int nodes[]) {
            index++;     //Start to build the tree from index 0.
            if (nodes[index] == -1) {     //Null node found
                return null;       //No child to be formed
            }

            //Create a new node
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);     //Creating left subtree
            newNode.right = buildTree(nodes);     //Creating right subtree

            return newNode;
        }

        //Printing tree with pre-order traversal
        public void preorder (Node root) {
            if (root == null) {       //No child exists i.e. we are on the leaf node of the tree (Base case)
                return;
            }

            System.out.print(root.data + " ");     //To print root of tree
            preorder(root.left);     //To print the left subtree of root
            preorder(root.right);     //To print right subtree of root
        }

        //In order traversal of the tree
        public void inorder(Node root) {
            if (root == null) {
                return;
            }

            //Left -> root -> right
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        //Post-order traversal
        public void postorder(Node root) {
            if (root == null) {
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        //Level order traversal
        public void levelorder(Node root) {
            if (root == null) {       //Tree is empty
                return;
            }

            Queue<Node> q = new LinkedList<>();     //To store the nodes
            
            //Adding root and null at the first iteration
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();

                if (curr == null) {
                    System.out.println();
                    if (q.isEmpty()) {     //All elements have been printed
                        break;
                    }
                    else {    //To print for other levels
                        q.add(null);
                    }
                }

                else {
                    System.out.print(curr.data + " ");

                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if(curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        } 
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.print("Pre-order traversal: ");
        tree.preorder(root);

        System.out.println();

        System.out.print("Inorder traversal: ");
        tree.inorder(root);

        System.out.println();

        System.out.print("Post-order traversal: ");
        tree.postorder(root);

        System.out.println();

        System.out.println("Level-order traversal: ");
        tree.levelorder(root);        
    }
}
