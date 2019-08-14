import static com.TreenodeUtil.*;
import java.util.LinkedList;
import java.util.Queue;


public class lc297_SerializeandDeserializeBinaryTree {
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "[]";

            String output = "";
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    output += "null,";
                    continue;
                }

                output += String.valueOf(node.val) + ",";
                queue.add(node.left);
                queue.add(node.right);
            }
            String[] parts = output.substring(0, output.length() - 1).split(",");
            LinkedList<String> ls1 = new LinkedList<>();
            boolean firstHit = true;
            for (int i = parts.length - 1; i >= 0; i--) {
                if (firstHit && parts[i].equals("null")) {
                    continue;
                } else {
                    firstHit = false;
                    ls1.add(parts[i]);
                }
            }
            LinkedList<String> ls2 = new LinkedList<>();
            for (int i = ls1.size() - 1; i >= 0; i--) {
                ls2.add(ls1.get(i));
            }
            return "[" + String.join(",",ls2) + "]";

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String input = data.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) return null;

            String[] parts = input.split(",");
            String item = parts[0];
            TreeNode root = new TreeNode(Integer.parseInt(item));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (index == parts.length) {
                    break;
                }

                item = parts[index++];
                item = item.trim();
                if (!item.equals("null")) {
                    int leftNumber = Integer.parseInt(item);
                    node.left = new TreeNode(leftNumber);
                    queue.add(node.left);
                }

                if (index == parts.length) {
                    break;
                }

                item = parts[index++];
                item = item.trim();
                if (!item.equals("null")) {
                    int rightNumber = Integer.parseInt(item);
                    node.right = new TreeNode(rightNumber);
                    queue.add(node.right);
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        String tree = "[1,2,3,null,null,4,5]";
        Codec codec = new Codec();
        TreeNode root = codec.deserialize(tree);
        String encode = codec.serialize(root);
        System.out.println(encode);
        prettyPrintTree(root);
    }
}
