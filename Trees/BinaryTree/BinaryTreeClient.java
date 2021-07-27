package Trees.BinaryTree;

public class BinaryTreeClient {
    public static void main(String[] args) {

        //10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
        BinaryTree bt = new BinaryTree();
        bt.display();

        System.out.println(bt.size());

        System.out.println(bt.max());

        System.out.println(bt.find(80));

        System.out.println(bt.height());

        System.out.println(bt.diameter());

        System.out.println(bt.isBalanced());

        bt.preOrder();

        System.out.println();
        System.out.println("--------------");

        bt.preOrderI();

        System.out.println();

        System.out.println(bt.maxSubTreeSum());
    }
}
