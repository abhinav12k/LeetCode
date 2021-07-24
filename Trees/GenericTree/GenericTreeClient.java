package Trees.GenericTree;

public class GenericTreeClient {

    public static void main(String[] args) {
        //60 3 41 2 17 0 16 0 15 1 21 0 24 2 33 0 84 0
        //10 3 20 2 50 0 60 0 30 3 70 0 80 2 110 0 120 0 90 0 40 1 100 0
        GenericTree gt = new GenericTree();
        gt.display();

        System.out.println(gt.getSize());
        System.out.println(gt.calculateSize());
        System.out.println(gt.getMax());

        System.out.println(gt.find(21));
        System.out.println(gt.find(22));

        System.out.println(gt.height());
//        gt.mirror();
//        gt.display();

//        gt.printLevel(0);

//        gt.preOrder();

        System.out.println();
//        gt.levelOrder();
        gt.levelOrderLineWise();

        System.out.println();
        gt.levelOrderLineWise2();
//        gt.levelOrderZigZag();
    }

}
