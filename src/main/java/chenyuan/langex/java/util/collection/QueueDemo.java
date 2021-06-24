package chenyuan.langex.java.util.collection;

import org.junit.Test;

import java.util.*;

/**
 * Created by chenyuan on 2017/12/18.
 */
public class QueueDemo {

    private void printQueue(Queue queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    @Test
    public void testQueue() {
        Random rand = new Random(47);
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<10; i++) {
            queue.offer(rand.nextInt(i + 10));
        }

        printQueue(queue);
    }

    @Test
    public void testPriorityQueue() {
        Random rand = new Random(47);
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>(10, Collections.reverseOrder());

        for (int i=0; i<10; i++) {
            priorityQueue.offer(rand.nextInt(i + 100));
        }

        printQueue(priorityQueue);
    }

}
