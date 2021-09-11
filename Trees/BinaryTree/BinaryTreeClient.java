package Trees.BinaryTree;

public class BinaryTreeClient {
    public static void main(String[] args) {

        //10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
        //1 true 2 false false true 3 true 4 false true 5 false false false
        //3 true 5 true 6 false false true 2 true 0 false false true 4 false false true 1 true 10 false false true 8 false false
        BinaryTree bt = new BinaryTree();
        bt.display();

//        System.out.println(bt.size());
//
//        System.out.println(bt.max());
//
//        System.out.println(bt.find(80));
//
//        System.out.println(bt.height());
//
//        System.out.println(bt.diameter());
//
//        System.out.println(bt.isBalanced());
//
//        bt.preOrder();
//
//        System.out.println();
//        System.out.println("--------------");
//
//        bt.preOrderI();
//
//        System.out.println();
//
//        System.out.println(bt.maxSubTreeSum());
//
//        System.out.println(bt.getCousins(40));
//        System.out.println();
//        bt.inOrder();
//        System.out.println();
//        bt.preOrder();
//        System.out.println();
//        bt.postOrder();

//        System.out.println(bt.lca(3,8));

//        bt.replaceEachNodeWithSumOfInorderPredecessorAndSuccessor();
//        bt.display();

        bt.diagonalTraversal();
    }
}
