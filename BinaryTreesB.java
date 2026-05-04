import java.util.*;
import java.util.LinkedList;

public class BinaryTreesB {

    static class node {
        int data;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static node buildTree(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            node newNode = new node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

            
        public static void preOrder(node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(node root) {
            if (root == null) {
                return;
            }

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(node root) {
            if (root == null) {
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(node root) {
            if (root == null)
                return;

            Queue<node> q = new java.util.LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public static int height(node root) {
            if (root == null)
                return 0;

            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh, rh) + 1;
        }

        static int diameter = 0;

        public int diameter(node root) {
            if (root == null) {
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);

            diameter = Math.max(diameter, (lh + rh));

            return 1 + Math.max(lh, rh);
        }

        public static int countNodes(node root) {
            if (root == null)
                return 0;

            int lh = countNodes(root.left);
            int rh = countNodes(root.right);

            return lh + rh + 1;
        }

        public static int nodeSum(node root) {
            if (root == null)
                return 0;

            int leftSum = nodeSum(root.left);
            int rightSum = nodeSum(root.right);

            return leftSum + rightSum + root.data;
        }

        public static boolean isSubtree(node root, node subRoot) {
            if (root == null) {
                return false;
            }

            if (root.data == subRoot.data) {
                if (isIdentical(root, subRoot)) {
                    return true;
                }
            }

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public static boolean isIdentical(node root1, node root2) {
            if (root1 == null && root2 == null) {
                return true;
            }

            if (root1 == null || root2 == null || root1.data != root2.data) {
                return false;
            }

            return (isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
        }

        static class Info {
            int hd;
            node node;

            public Info(node node, int hd) {
                this.hd = hd;
                this.node = node;
            }
        }

        public static void topView(node root) {
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer, node> map = new HashMap<>();

            int min = 0, max = 0;
            q.add(new Info(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Info curr = q.remove();

                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }

                    if (curr.node.left != null) {
                        q.add(new Info(curr.node.left, curr.hd-1));
                        min = Math.min(min, curr.hd-1);
                    }

                    if (curr.node.right != null) {
                        q.add(new Info(curr.node.right, curr.hd+1));
                        max = Math.max(max, curr.hd+1);
                    }
                }
            }

            for (int i=min; i<=max; i++) {
                System.out.print(map.get(i).data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // node root = BinaryTree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        // tree.levelOrder(root);

        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        // System.out.println("Diameter : " + tree.diameter(root));

        // System.out.println(BinaryTree.isSubtree(root, subRoot));
        BinaryTree.topView(root);
    }
}