package cup.SingleWeek.cup270.q3;

import java.util.*;

/**
 * @author 1iin
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, TreeNode> nodes = new HashMap<>();
    String res = "";

    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root);
        TreeNode startNode = nodes.get(startValue);
        TreeNode destNode = nodes.get(destValue);
        Set<Integer> path = new HashSet<>();
        path.add(startNode.val);
        int temp = startNode.val;
        while (temp != root.val) {
            temp = parent.get(temp);
            path.add(temp);
        }
        temp = destNode.val;
        while (!path.contains(temp)) {
            temp = parent.get(temp);
        }
        StringBuilder sb = new StringBuilder();
        while (startValue != temp) {
            startValue = parent.get(startValue);
            sb.append('U');
        }
        startNode = nodes.get(startValue);
        search(startNode, destNode, sb);
        return res;
    }

    public void search(TreeNode node, TreeNode destNode, StringBuilder track) {
        if (node == destNode) {
            res = track.toString();
            return;
        }
        if (node == null) {
            return;
        }
        Queue<A> queue = new LinkedList<>();
        A n = new A(node, new StringBuilder(track));
        queue.add(n);
        while (!queue.isEmpty()) {
            n = queue.poll();
            track = n.track;
            node = n.treeNode;
            if (node == destNode) {
                res = n.track.toString();
                return;
            }
            if (node.left != null) {
                StringBuilder sb = new StringBuilder(track);
                sb.append('L');
                queue.add(new A(node.left, sb));
            }
            if (node.right != null) {
                StringBuilder sb = new StringBuilder(track);
                sb.append('R');
                queue.add(new A(node.right, sb));
            }
        }


    }

    public void dfs(TreeNode root) {
        if (root == null || !"".equals(res)) {
            return;
        }
        nodes.put(root.val, root);
        if (root.left != null) {
            parent.put(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root.val);
            dfs(root.right);
        }
    }
}

class A {
    TreeNode treeNode;
    StringBuilder track;

    public A(TreeNode treeNode, StringBuilder track) {
        this.treeNode = treeNode;
        this.track = track;
    }
}
