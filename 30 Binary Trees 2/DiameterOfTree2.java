public class DiameterOfTree2 {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {      //This class is returned by the diamater method
        int dia;
        int height;

        public Info(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }

    public static Info diameter(Node root) {
        if (root  == null) {
            return new Info(0, 0);
        }

        Info leftDia = diameter(root.left);
        Info rightDia = diameter(root.right);

        int finalDia = Math.max(Math.max(leftDia.dia, rightDia.dia), leftDia.height + rightDia.height + 1);
        int finalHt = Math.max(leftDia.height, rightDia.height) + 1;

        return new Info(finalDia, finalHt);
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

        System.out.println(diameter(root).dia);
    }    
}