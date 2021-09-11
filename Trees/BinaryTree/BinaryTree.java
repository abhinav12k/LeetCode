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

    //BT using preorder and inorder
    public void construct(int[] preOrder,int[] inOrder){
        this.root = construct(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }

    private Node construct(int[] preOrder,int preLo,int preHi,int[] inOrder,int inLo,int inHi){

        if(preLo > preHi || inLo > inHi)
            return null;

        Node nn = new Node();
        nn.data = preOrder[preLo];

        int si = -1;
        int nel = 0;
        for(int i=preLo;i<=preHi;i++){
            if(preOrder[preLo]==inOrder[i]){
                si = i;
                break;
            }
            nel++;
        }

        nn.leftChild = construct(preOrder,preLo+1,preLo+nel,inOrder,inLo,si-1);
        nn.rightChild = construct(preOrder,preLo+nel+1,preHi,inOrder,si+1,inHi);

        return nn;
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

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.leftChild);
        System.out.print(root.data+" ");
        inOrder(root.rightChild);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node root){
        if(root==null)
            return;
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.data+" ");
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

    public int lca(int B, int C) {

        ArrayList<Integer> ntr1 = nodeToRoot(root,B);
        ArrayList<Integer> ntr2 = nodeToRoot(root,C);

        int lst1 = ntr1.size()-1;
        int lst2 = ntr2.size()-1;

        if(lst1<=0||lst2<=0)
            return -1;

        while(lst1>=0&&lst2>=0&&ntr1.get(lst1)==ntr2.get(lst2)){
            lst1--;
            lst2--;
        }
        lst1++;
        lst2++;
        System.out.println(ntr1);
        System.out.println(ntr2);
        return ntr1.get(lst1);
    }

    private ArrayList<Integer> nodeToRoot(Node root,int target){

        if(root==null){
            return new ArrayList<>();
        }

        if(root.data == target){
            ArrayList<Integer> br = new ArrayList<>();
            br.add(root.data);
            return br;
        }

        ArrayList<Integer> mr = new ArrayList<>();
        ArrayList<Integer> l_rr = nodeToRoot(root.leftChild,target);
        if(l_rr.size()!=0){
            mr = l_rr;
            mr.add(root.data);
            return mr;
        }
        ArrayList<Integer> r_rr = nodeToRoot(root.rightChild,target);
        if(r_rr.size()!=0){
            mr = r_rr;
            mr.add(root.data);
            return mr;
        }
        return mr;
    }

    private void storeInOrderTraversal(Node root,ArrayList<Integer> arr){
        if(root==null)
            return;

        storeInOrderTraversal(root.leftChild,arr);
        arr.add(root.data);
        storeInOrderTraversal(root.rightChild,arr);
    }

    private static class HeapMover{
        int idx=1;
    }

    public void replaceEachNodeWithSumOfInorderPredecessorAndSuccessor(){

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0); //for storing the predecessor of extreme left child

        storeInOrderTraversal(root,arr);

        arr.add(0); //for storing the successor of extreme right child

        HeapMover hm = new HeapMover();
        replaceNodesWithPredecessorAndSuccessor(root,arr,hm);
    }

    private void replaceNodesWithPredecessorAndSuccessor(Node root,ArrayList<Integer> arr,HeapMover hm){

        if(root==null)
            return;

        replaceNodesWithPredecessorAndSuccessor(root.leftChild,arr,hm);
        root.data = arr.get(hm.idx-1)+arr.get(hm.idx+1);
        hm.idx++;
        replaceNodesWithPredecessorAndSuccessor(root.rightChild,arr,hm);
    }

    public void diagonalTraversal(){

        Queue<Node> queue = new LinkedList<>();

        Node temp = root;
        while(temp!=null || !queue.isEmpty()){
            while(temp!=null){
                queue.offer(temp);
                temp = temp.rightChild;
            }
            temp = queue.poll();
            System.out.print(temp.data+" ");
            temp = temp.leftChild;
        }
    }

}
