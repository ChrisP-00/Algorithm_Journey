package week011_020.week016.day0107_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Bj25601 {
    static class TreeNode{
        String value;
        List<TreeNode> children;

        public TreeNode(String value){
            this.value = value;
            this.children = new ArrayList<>();
        }

        public void addChild(TreeNode child){
            children.add(child);
        }

        public boolean contains(String value){
            if(this.value.equals(value)) return true;
            for(TreeNode child : this.children){
                if(child.contains(value)){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, TreeNode> nodeMap = new HashMap<>();

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();

            nodeMap.putIfAbsent(parent, new TreeNode(parent));
            nodeMap.putIfAbsent(child, new TreeNode(child));

            TreeNode parentNode = nodeMap.get(parent);
            TreeNode childNode = nodeMap.get(child);
            parentNode.addChild(childNode);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        TreeNode root = findRoot(nodeMap);

        if(isDescendant(root,a,b) || isDescendant(root, b, a)){
            System.out.println(1);
            return;
        }

        System.out.println(0);
    }

    private static TreeNode findRoot(Map<String, TreeNode> nodeMap){
        Set<TreeNode> allNodes = new HashSet<>(nodeMap.values());
        for(TreeNode node : nodeMap.values()){
            node.children.forEach(allNodes::remove);
        }
        return allNodes.iterator().next();
    }

    private static boolean isDescendant(TreeNode root, String ancestor, String descendant){
        if(root == null) return false;
        if(root.value.equals(ancestor)){
            return root.contains(descendant);
        }
        for(TreeNode child : root.children){
            if(isDescendant(child, ancestor, descendant)){
                return true;
            }
        }
        return false;
    }
}
