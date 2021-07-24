package Trees.GenericTree;

import java.util.*;

public class GenericTree {

    private class Node{
        int data;
        ArrayList<Node> children;

        private Node(int data){
            this.data = data;
            children = new ArrayList<>();
        }

    }

    private Node root;
    private int size;

    public GenericTree(){
        Scanner scn = new Scanner(System.in);
        this.root = takeInput(scn,null,0);
    }

    private Node takeInput(Scanner scn,Node parent,int ithChild){

        if(parent==null){
            System.out.println("Enter the data for root Node - ");
        }else{
            System.out.println("Enter the data for "+ithChild+"th Child of "+parent.data);
        }

        int nodeData = scn.nextInt();
        Node nn = new Node(nodeData);
        this.size++;

        System.out.println("Enter the number of children for "+nodeData);
        int n = scn.nextInt();

        for(int i=0;i<n;i++){
            Node child = takeInput(scn,nn,i+1);
            nn.children.add(child);
        }

        return nn;
    }

    public void display(){
        display(root);
    }

    private void display(Node root){

        String ans = root.data+" => ";
        for(int i=0;i<root.children.size();i++){
            ans+=root.children.get(i).data+", ";
        }
        ans+=", END";

        System.out.println(ans);

        for(int i=0;i<root.children.size();i++)
            display(root.children.get(i));

    }

    public int getSize(){
        return this.size;
    }

    public int calculateSize(){
        return calculateSize(root);
    }

    private int calculateSize(Node root){

        int totalSize = 0;

        for(Node child: root.children){
            int childSize = calculateSize(child);

            totalSize += childSize;
        }

        return totalSize + 1;   //added one for root element
    }

    public int getMax(){
        return getMax(root);
    }

    private int getMax(Node root){
        int totalMax = root.data;

        for(Node child: root.children){
            int childMax = getMax(child);
            if(totalMax < childMax)
                totalMax = childMax;
        }
        return totalMax;
    }

    public boolean find(int val){
        return find(root,val);
    }

    private boolean find(Node root,int val){

        if(root.data == val)
            return true;

        for(Node child: root.children){
            boolean found = find(child,val);
            if(found)
                return true;
        }
        return false;
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        int totalHeight = -1;
        for(Node child: root.children){

            int childHeight = height(child);
            if(totalHeight < childHeight)
                totalHeight = childHeight;

        }
        return totalHeight+1;
    }

    public void mirror(){
        mirror(root);
    }

    private void mirror(Node root){

        for(Node child: root.children){
            mirror(child);
        }

        int left=0;
        int right = root.children.size()-1;
        while(left<right){

            Node leftChild = root.children.get(left);
            Node rightChild = root.children.get(right);

            root.children.set(right,leftChild);
            root.children.set(left,rightChild);

            left++;
            right--;
        }

    }

    public void printLevel(int level){
        printLevel(root,0,level);
    }

    private void printLevel(Node root,int count,int level){

        if(count == level){
            System.out.println(root.data);
            return;
        }

        for(Node child: root.children)
            printLevel(child,count+1,level);

    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node root){

        System.out.print(root.data+"  ");

        for(Node child: root.children)
            preOrder(child);

    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node root){
        for(Node child: root.children){
            postOrder(child);
        }
        System.out.print(root.data+" ");
    }

    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(Node root){

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            Node node = queue.poll();

            System.out.print(node.data+" ");

            for(Node child: node.children)
                queue.add(child);

        }
        System.out.print(".");
    }

    public void levelOrderLineWise(){
        levelOrderLineWise(root);
    }

    private void levelOrderLineWise(Node root){

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        Queue<Node> childQueue = new ArrayDeque<>();

        while (!queue.isEmpty()){

            Node parent = queue.remove();

            System.out.print(parent.data+" ");

            for(Node child: parent.children)
                childQueue.add(child);

            if(queue.isEmpty()){
                queue = childQueue;
                childQueue = new ArrayDeque<>();
                System.out.println();   // to show that one level is completed
            }

        }

    }

    public void levelOrderLineWise2(){
        levelOrderLineWise2(root);
    }

    private void levelOrderLineWise2(Node root){

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){

            Node parent = queue.removeFirst();

            if(parent == null){
                System.out.println();

                if(queue.isEmpty()){
                    break;
                }

                queue.add(null);
                continue;
            }else{
                for(Node child: parent.children)
                    queue.add(child);
            }

            System.out.print(parent.data+" ");

        }

    }

    public void levelOrderZigZag(){
        levelOrderZigZag(root);
    }

    private void levelOrderZigZag(Node root){

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        Stack<Node> childStack = new Stack<>();
        int ct = 0;
        while (!stack.isEmpty()){

            Node parent = stack.pop();

            System.out.print(parent.data+" ");

            if(ct%2==1){
                //add children in reverse order to print in reverse
                for(int i=parent.children.size()-1;i>=0;i--)
                    childStack.add(parent.children.get(i));
            }else{
                //add children from front
                for(Node child: parent.children)
                    childStack.add(child);
            }

            if(stack.isEmpty()){
                ct++;
                stack = childStack;
                childStack = new Stack<>();
                System.out.println();
            }

        }

    }

    public void removeLeaves(){
        removeLeaves(root);
    }

    private void removeLeaves(Node root){

        for(int i = root.children.size()-1;i>=0;i--){
            Node child = root.children.get(i);
            if(child.children.size()==0)
                root.children.remove(i);
        }

        for(Node child: root.children)
            removeLeaves(child);

    }

    public void linearizeTree(){
        linearizeTree(root);
    }

    private void linearizeTree(Node root){

        for(Node child: root.children){
            linearizeTree(child);
        }

        while(root.children.size() > 1){
            Node lastNode = root.children.remove(root.children.size()-1);
            Node secondLastNode = root.children.get(root.children.size()-1);
            Node secondLastNodeTail = getTail(secondLastNode);
            secondLastNodeTail.children.add(lastNode);
        }

    }

    private Node getTail(Node root){

        while(root.children.size() == 1){
            root = root.children.get(0);
        }

        return root;
    }

    public void linearize2(){
        linearize2(root);
    }

    private Node linearize2(Node root){

        if(root.children.size() == 0){
            return root;
        }

        Node lastNodeTail = linearize2(root.children.get(root.children.size()-1));
        while(root.children.size() > 1){
            Node lastNode = root.children.remove(root.children.size()-1);
            Node secondLastNode = root.children.get(root.children.size()-1);
            Node secondLastNodeTail = linearize2(secondLastNode);
            secondLastNodeTail.children.add(lastNode);
        }

        return lastNodeTail;
    }

}
