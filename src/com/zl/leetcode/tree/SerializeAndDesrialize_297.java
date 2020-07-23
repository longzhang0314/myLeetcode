package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Create by zhanglong on 2020/7/22
 */
public class SerializeAndDesrialize_297 {

    private static final String N = "N";
    private static final String SPLIT = ",";

    /**
     * 方法1：前序
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize1(root, sb);
        return sb.toString();
    }
    private void serialize1(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(N).append(SPLIT);
            return;
        }
        sb.append(root.val).append(SPLIT);
        serialize1(root.left, sb);
        serialize1(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        String[] ss = data.split(SPLIT);
        Deque<String> deque = new LinkedList<>();
        for (String s : ss) {
            deque.addLast(s);
        }
        return deserialize(deque);
    }
    private TreeNode deserialize(Deque<String> deque) {
        if (deque.isEmpty()) return null;
        String s = deque.removeFirst();
        if (N.equals(s)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(deque);
        root.right = deserialize(deque);
        return root;
    }

    /**
     * 方法2：层级
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append(N).append(SPLIT);
                continue;
            }
            sb.append(cur.val).append(SPLIT);
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] ss = data.split(SPLIT);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        queue.offer(root);

        for (int i = 1; i < ss.length; i++) {
            TreeNode cur = queue.poll();
            String leftS = ss[i++];
            if (N.equals(leftS)) {
                cur.left = null;
            } else {
                cur.left = new TreeNode(Integer.parseInt(leftS));
                queue.offer(cur.left );
            }

            String rightS = ss[i++];
            if (N.equals(rightS)) {
                cur.right = null;
            } else {
                cur.right = new TreeNode(Integer.parseInt(rightS));
                queue.offer(cur.right);
            }
        }
        return root;
    }

}
