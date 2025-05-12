public class Main {

    static class TreeNode {
        int value;
        TreeNode left, right, parent;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class BinarySearchTree {
        TreeNode root;

        public void insert(int value) {
            TreeNode newNode = new TreeNode(value);
            if (root == null) {
                root = newNode;
                return;
            }
            TreeNode current = root, parent = null;
            while (current != null) {
                parent = current;
                if (value < current.value)
                    current = current.left;
                else if (value > current.value)
                    current = current.right;
                else
                    return;
            }
            if (value < parent.value)
                parent.left = newNode;
            else
                parent.right = newNode;
            newNode.parent = parent;
        }

        public TreeNode find(int value) {
            TreeNode current = root;
            while (current != null) {
                if (value == current.value)
                    return current;
                else if (value < current.value)
                    current = current.left;
                else
                    current = current.right;
            }
            return null;
        }

        public void inOrder(TreeNode node) {
            if (node == null) return;
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }

        public void preOrder(TreeNode node) {
            if (node == null) return;
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }

        public void postOrder(TreeNode node) {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }

        public TreeNode findMin(TreeNode node) {
            if (node == null) return null;
            while (node.left != null)
                node = node.left;
            return node;
        }

        public TreeNode findMax(TreeNode node) {
            if (node == null) return null;
            while (node.right != null)
                node = node.right;
            return node;
        }

        public void delete(int value) {
            root = deleteRecursive(root, value);
        }

        private TreeNode deleteRecursive(TreeNode node, int value) {
            if (node == null) return null;
            if (value < node.value)
                node.left = deleteRecursive(node.left, value);
            else if (value > node.value)
                node.right = deleteRecursive(node.right, value);
            else {
                if (node.left == null && node.right == null)
                    return null;
                else if (node.left == null)
                    return node.right;
                else if (node.right == null)
                    return node.left;
                TreeNode minNode = findMin(node.right);
                node.value = minNode.value;
                node.right = deleteRecursive(node.right, minNode.value);
            }
            return node;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {50, 30, 100, 70, 60, 80, 40};
        for (int val : values)
            bst.insert(val);

        System.out.println("--PreOrder Traversal:------");
        bst.preOrder(bst.root);

        System.out.println("\n---PostOrder Traversal:------");
        bst.postOrder(bst.root);

        System.out.println("\nMinimum Node value: " + bst.findMin(bst.root).value);
        System.out.println("Maximum Node value: " + bst.findMax(bst.root).value);

        bst.delete(30);
        System.out.println("\n——InOrder Traversal:——");
        bst.inOrder(bst.root);

        TreeNode result = bst.find(40);
        if (result == null)
            System.out.println("\n40 is not found");
        else
            System.out.println("\n40 is found");
    }
}