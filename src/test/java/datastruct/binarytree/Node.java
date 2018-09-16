package datastruct.binarytree;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@Getter@Setter
public class Node implements Serializable {
    private Node left;
    private Node right;
    private Node parent;
    private Integer value;
    private Integer level;

    private Node root ;

    public Node() {
    }

    public Node(Node parent, Integer value,Integer level) {
        this.parent = parent;
        this.value = value;
        this.level = level;
    }

    public String insert(Integer value){
        Node t = root;
        Node parent = null;
        int compare = 0;
        int level = 0;
        if (t == null){
            root = this;
            this.setValue(value);
            this.setLevel(0);
        }else {
            while (t != null){
                parent = t;
                level ++;
                compare = value.compareTo(t.getValue());
                if (compare < 0){
                    t = t.left;
                }else if(compare > 0){
                    t = t.right;
                }else {
                     t.setValue(value);
                     return null;
                }
            }
            Node e = new Node(parent, value,level);
            if (compare < 0){
                parent.setLeft(e);
            }else {
                parent.setRight(e);
            }

        }
        return null;
    }


    public static void main(String[] args) {
        Node node = new Node();
        int[] nums = {8, 3, 17, 1, 5, 2, 0, 4, 2, 8, 4, 10, 194, 7, 19, 37};
        for (int num : nums) {
            node.insert(new Integer(num));
        }
        List<List<Integer>> lists = node.printNode(node);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        System.out.println(JSON.toJSONString(node.get(3).getLeft().value));

    }

    /**
     * 二叉树的打印，层序遍历
     * @param qroot
     * @return
     */
    public List<List<Integer>> printNode(Node qroot){
        List<List<Integer>> result = new ArrayList<>();
        if(qroot == null){
            return result;
        }
        Queue<Node> queue  = new LinkedList<Node>();
        queue.add(qroot);
        Node tmp = null;
        int currentLevel = 0;
        List<Integer> tmpList = new ArrayList<>();
        result.add(tmpList);
        while (! queue.isEmpty()){
            tmp = queue.remove();
            if(currentLevel != tmp.getLevel()){
                currentLevel++;
                tmpList = new ArrayList<>();
                result.add(tmpList);
            }
            tmpList.add(tmp.getValue());
            if(tmp.getLeft() != null){
                queue.add(tmp.getLeft());
            }else {
                //result.add("null");
            }
            if(tmp.getRight() != null){
                queue.add(tmp.getRight());
            }else {
                //result.add("null");
            }
        }
        return result;
    }

    public Node get(Integer value){
        Node t = root;
        if(t == null){
            return null;
        }
        while (t != null){
            int cmp = value.compareTo(t.getValue());
            if(cmp < 0){
                t = t.getLeft();
            }else if(cmp > 0){
                t = t.getRight();
            }else {
                return t;
            }
        }
        return null;
    }
}
