package com.atella.book.conarts.collection;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by yuan on 2016/12/29.
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int COMPUTE_THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start,int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if ((end - start) <= COMPUTE_THRESHOLD) {
            for (int i=start;i<=end;i++)
                sum += i;
        } else {
            int mid = (end + start)/2;
            CountTask task1 = new CountTask(start, mid);
            CountTask task2 = new CountTask(mid+1, end);
            task1.fork();
            task2.fork();
            int r1 = task1.join();
            int r2 = task2.join();
            sum = r1 + r2;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountTask task = new CountTask(1,4);
        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> result = pool.submit(task);
        try {
            System.out.println("Result: " + result.get());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
