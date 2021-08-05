package Trees.BST;

import java.util.ArrayList;
import java.util.Stack;

public class BST {
    private class Node {
        int val;
        Node left;
        Node right;

        private Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    public BST(int[] in){
        this.root = construct(in,0,in.length-1);
    }

    private Node construct(int[] in,int lo,int hi){

        if(lo>hi)
            return null;

        int mid = (lo+hi)/2;
        Node nn = new Node(in[mid]);
        nn.left = construct(in,lo,mid-1);
        nn.right = construct(in,mid+1,hi);

        return nn;
    }

    public void display(){
        System.out.println("-----------------");
        display(root);
        System.out.println("-----------------");
    }

    private void display(Node root){

        if(root==null){
            return;
        }

        String str = "";
        if(root.left!=null){
            str+=root.left.val;
        }else{
            str+=".";
        }
        str+=" -> "+root.val+" <- ";
        if(root.right!=null){
            str+=root.right.val;
        }else{
            str+=".";
        }

        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public boolean validBSTFromPreOrder(int[] preOrder){

        Stack<Integer> stack = new Stack<>();
        int firstMax = Integer.MIN_VALUE;

        for(int i=0;i<preOrder.length;i++){
            if(preOrder[i] < firstMax)
                return false;
            while (stack.isEmpty() && stack.peek() < preOrder[i])
                firstMax = stack.pop();
            stack.push(preOrder[i]);
        }
        return true;
    }

    public boolean twoSumBinaryTree(int target){
        return twoSumBinaryTreeUsingInOrder(root,target);
    }

    ArrayList<Integer> ans = new ArrayList<>();
    private boolean twoSumBinaryTreeUsingInOrder(Node root,int target){
        getInOrder(root);
        return findTwoNumberSum(ans,target);
    }

    private void getInOrder(Node root){
        if(root==null)
            return;
        getInOrder(root.left);
        ans.add(root.val);
        getInOrder(root.right);
    }

    private boolean findTwoNumberSum(ArrayList<Integer> ans,int target){

        int lo = 0;
        int hi = ans.size()-1;

        int sum = 0;
        while(lo<hi){
            sum = ans.get(lo)+ans.get(hi);
            if(sum==target){
                return true;
            }else if(sum>target){
                hi--;
            }else{
                lo++;
            }
        }
        return false;
    }

    public boolean twoSumBinaryTreeUsingStacks(int target){

        Node curr1 = this.root;
        Node curr2 = this.root;

        int lo = nextSmaller(curr1).val;
        int hi = nextGreater(curr2).val;

        int sum = 0;
        while(lo<hi){
            sum=(lo+hi);
            if(sum==target)
                return true;
            else if(sum>target)
                lo = nextSmaller(curr1).val;
            else hi = nextGreater(curr2).val;
        }
        return false;
    }

    private Node nextSmaller(Node curr1){
        Stack<Node> stack = new Stack<>();
        while (curr1!=null){
            stack.push(curr1);
            curr1 = curr1.left;
        }
        curr1 = stack.pop();
        Node temp = curr1;
        curr1 = curr1.right;
        return temp;
    }

    private Node nextGreater(Node root){
        Stack<Node> stack = new Stack<>();
        while (root!=null){
            stack.push(root);
            root = root.right;
        }
        root = stack.pop();
        Node temp = root;
        root = root.left;
        return temp;
    }

}
