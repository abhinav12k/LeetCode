package Trees.BST;

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
}
