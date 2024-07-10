package dataStructures.Tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BanaryTreeTest {
    private BinaryTree<Integer> binaryTree;

    @BeforeEach
    void setUp(){
            binaryTree = new BinaryTree<>();
        }

    @Test
    void testInsertIntoEmptyElement(){
        Assertions.assertTrue(binaryTree.insert(10));
    }

    @Test
    void testInsertLeft(){
        binaryTree.insert(10);
        Assertions.assertTrue(binaryTree.insert(5));
    }

    @Test
    void testInsertRight(){
        binaryTree.insert(10);
        Assertions.assertTrue(binaryTree.insert(15));
    }

    @Test
    void testInsertDublicate(){
        binaryTree.insert(10);
        Assertions.assertFalse(binaryTree.insert(10));
    }

    @Test
    void testContains(){
        Integer[] elements = new Integer[]{10,11,12,13,14,15,16,17,19,18};
        binaryTree = BinaryTree.of(elements);
        for (Integer element : elements){
            Assertions.assertTrue(binaryTree.contains(element));
        }
        Integer element = ThreadLocalRandom.current().nextInt(20,100);
        Assertions.assertFalse(binaryTree.contains(element));
    }

    @Test
    void testDept(){
        Integer[] elements = new Integer[]{10,5,15,3,7,12,20};
        binaryTree = BinaryTree.of(elements);
        Assertions.assertEquals(3,binaryTree.depth());
    }

    @Test
    void testTimeArray(){
        List<Integer> list = new ArrayList<>();
        int limit = 100_000_000;
        long startProgram = System.nanoTime();
        for (int i = 0; i < limit; i++) {
            int val = ThreadLocalRandom.current().nextInt(limit);
            list.add(val);
        }
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            int val = ThreadLocalRandom.current().nextInt(limit);
            System.out.printf("contains(%d) - %s | %f c \n",val,list.contains(val),(System.nanoTime()-start) * (Math.pow(10,-9)));
        }
        System.out.printf("Program was running %f", (System.nanoTime() - startProgram)* (Math.pow(10,-9)));
    }
    @Test
    void testTimeTree(){
        BinaryTree<Long> binaryTree = new BinaryTree<>();
        long limit = 1_000_000_000;
        long startProgram = System.nanoTime();
        for (int i = 0; i < limit; i++) {
            long val = ThreadLocalRandom.current().nextLong(limit);
            binaryTree.insert(val);
        }
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long val = ThreadLocalRandom.current().nextLong(limit);
            System.out.printf("contains(%d) - %s | %f c \n",val,binaryTree.contains(val),(System.nanoTime()-start) * (Math.pow(10,-9)));
        }
        System.out.printf("Program was running %f", (System.nanoTime() - startProgram)* (Math.pow(10,-9)));
    }

    @Test
    void testFindingElement(){
        int limit = 100;
        for(int i = 0; i < limit; i++){
            binaryTree.insert(ThreadLocalRandom.current().nextInt(limit));
        }
        binaryTree.insert(55);
        Assertions.assertEquals(65,binaryTree.findElement(65).value);
    }


    @Test
    void showTree(){
        int limit = 10;
        for(int i = 0; i < limit; i++){
            binaryTree.insert(ThreadLocalRandom.current().nextInt(limit));
        }

        binaryTree.printTree();
    }

    @Test
    void testCountingElement(){
        int limit = 15;
        for(int i = 0; i < limit; i++){
            binaryTree.insert(ThreadLocalRandom.current().nextInt());
        }
        Assertions.assertEquals(limit,binaryTree.getCountElements());
    }
}
