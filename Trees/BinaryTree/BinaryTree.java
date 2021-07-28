package Trees.BinaryTree;

import java.util.*;

public class BinaryTree {

    Scanner scn;

    private class Node{
        int data;
        Node leftChild;
        Node rightChild;
    }

    private Node root;

    public BinaryTree(){
        scn = new Scanner(System.in);
        root = construct(null,false);
    }

    private Node construct(Node parent,boolean isLeftChild){

        if(parent == null){
            System.out.print("Enter the data for root data - ");
        }else{
            if(isLeftChild)
                System.out.print("Enter the data for left child - ");
            else
                System.out.print("Enter the data for right child - ");
        }

        int data = scn.nextInt();
        Node node = new Node();
        node.data = data;

        System.out.print(data+" has left child?");
        boolean hlc = scn.nextBoolean();

        if(hlc){
            node.leftChild = construct(node,true);
        }

        System.out.print(data+" has right child?");
        boolean hrc = scn.nextBoolean();

        if(hrc){
            node.rightChild = construct(node,false);
        }

        return node;
    }

    public void display(){
        System.out.println("-------------");
        display(root);
        System.out.println("-------------");
    }

    private void display(Node root){

        if(root == null)
            return;

        String str = "";

        if(root.leftChild!=null){
            str+=root.leftChild.data;
        }else{
            str+=".";
        }

        str+=" -> "+ root.data+" <- ";

        if(root.rightChild!=null){
            str+=root.rightChild.data;
        }else{
            str+=".";
        }

        System.out.println(str);
        display(root.leftChild);
        display(root.rightChild);
    }

    public int size(){
        return size(root);
    }

    private int size(Node root){

        if(root == null)
            return 0;

        int leftSize = size(root.leftChild);
        int rightSize = size(root.rightChild);

        return leftSize+rightSize+1;

    }

    public int max(){
        return max(root);
    }

    private int max(Node root){

        if(root == null)
            return 0;

        int l_max = max(root.leftChild);
        int r_max = max(root.rightChild);

        return Math.max(l_max,Math.max(root.data,r_max));
    }

    public boolean find(int val){
        return find(root,val);
    }

    private boolean find(Node root,int val){

        if(root == null)
            return false;

        if(root.data == val)
            return true;

        boolean lc = find(root.leftChild,val);
        boolean rc = find(root.rightChild,val);

        return lc || rc;
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){

        if(root == null){
            return -1;
        }

        int lh = height(root.leftChild);
        int rh = height(root.rightChild);

        return Math.max(lh,rh)+1;
    }

    public int diameter(){
        return diameter(root);
    }

    private int diameter(Node root){

        if(root == null)
            return 0;

        int ld = diameter(root.leftChild);
        int rd = diameter(root.rightChild);

        int cd = height(root.leftChild)+height(root.rightChild)+2;

        int ans = Math.max(cd, Math.max(ld, rd));

        return ans;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node root){

        if(root == null)
            return true;

        boolean isLeftBalanced =  isBalanced(root.leftChild);
        boolean isRightBalanced = isBalanced(root.rightChild);

        boolean isCurrentBalanced = Math.abs(height(root.leftChild) - height(root.rightChild)) <= 1;

        return isCurrentBalanced && isLeftBalanced && isRightBalanced;
    }

    public boolean isFlipEquivalent(BinaryTree other){
        return isFlipEquivalent(root,other.root);
    }

    private boolean isFlipEquivalent(Node root1,Node root2){

        if(root1 ==null && root2 == null)
            return true;

        if(root1 == null || root2 == null)
            return false;

        if (root1.data != root2.data) {
            return false;
        }

        boolean llFlipEquivalent = isFlipEquivalent(root1.leftChild,root2.leftChild);
        boolean rrFlipEquivalent = isFlipEquivalent(root1.rightChild,root2.rightChild);

        boolean lrFlipEquivalent = isFlipEquivalent(root1.leftChild,root2.rightChild);
        boolean rlFlipEquivalent = isFlipEquivalent(root1.rightChild,root2.leftChild);

        return (llFlipEquivalent && rrFlipEquivalent) || (lrFlipEquivalent && rlFlipEquivalent);
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node root){

        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);

    }

    private class Pair{
        Node node;
        boolean isNodeVisited;
        boolean isLeftVisited;
        boolean isRightVisited;
    }

    public void preOrderI(){
        preOrderI(root);
    }

    private void preOrderI(Node root){

        Stack<Pair> stack = new Stack<>();

        Pair node = new Pair();
        node.node = root;
        stack.push(node);

        while (!stack.isEmpty()){

            Pair p = stack.peek();

            if(!p.isNodeVisited){
                System.out.print(p.node.data+" ");
                p.isNodeVisited = true;
            }else if(!p.isLeftVisited){

                Pair newPair = new Pair();
                newPair.node = p.node.leftChild;

                if(newPair.node!=null)
                    stack.add(newPair);

                p.isLeftVisited = true;
            }else if(!p.isRightVisited){
                Pair newPair = new Pair();
                newPair.node = p.node.rightChild;

                if(newPair.node != null)
                    stack.push(newPair);

                p.isRightVisited = true;
            }else{
                stack.pop();
            }

        }

    }

    public int maxSubTreeSum(){
        return maxSubTreeSum(root).max;
    }

    //we cannot use simple variables in the function to calculate the running maximum because these variables can change
    //with the function place in the stack callback
    //Therefore we will use a class to store that because that is created inside a heap and the changes done to that persists

    private class maxPair{
        int max;
    }

    private maxPair maxSubTreeSum(Node root){

        if(root == null)
            return new maxPair();

        maxPair lsum = maxSubTreeSum(root.leftChild);
        maxPair rsum = maxSubTreeSum(root.rightChild);

        maxPair currSum = new maxPair();
        int currMax = root.data+lsum.max+rsum.max;

        currSum.max = Math.max(currMax,Math.max(lsum.max,rsum.max));

        return currSum;
    }

    public boolean isSymmetric(){
        return mirror(root,root);
    }

    private boolean mirror(Node node1,Node node2){

        if(node1!=null && node2==null){
            return true;
        }else if(node1 == null || node2 == null){
            return false;
        }else if(node1.data != node2.data){
            return false;
        }

        boolean isLeftChildMirror = mirror(node1.leftChild,node2.rightChild);
        if(!isLeftChildMirror)
            return false;
        boolean isRightChildMirror = mirror(node1.rightChild,node2.leftChild);
        if(!isRightChildMirror)
            return false;

        return true;
    }

    public ArrayList<Integer> getCousins(int val){
        return getCousins(root,val);
    }

    private ArrayList<Integer> getCousins(Node root,int val){

        if(root == null || root.data == val)
            return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = false;

        while(!queue.isEmpty() && !flag){
            int n = queue.size();
            while(n-->0){
                Node curr = queue.poll();
                if((curr.leftChild!=null && curr.leftChild.data == val) && (curr.rightChild!=null && curr.rightChild.data == val))
                    flag = true;
                else{
                    if(curr.leftChild!=null && curr.leftChild.data != val)
                        queue.add(curr.leftChild);
                    if(curr.rightChild!=null && curr.rightChild.data != val)
                        queue.add(curr.rightChild);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        if(flag){
            while(!queue.isEmpty()){
                list.add(queue.poll().data);
            }
        }

        return list;
    }

}
