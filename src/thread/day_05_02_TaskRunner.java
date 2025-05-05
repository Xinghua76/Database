package thread;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class day_05_02_TaskRunner {
    
    public static void runTasksInBatches(List<Runnable> tasks, List<List<Integer>> batches) throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        List<Future<Void>> futures = new ArrayList<>();
        Set<Integer> executedTaskIndices = new HashSet<>();

        for (int batchIndex  = 0; batchIndex  < batches.size(); batchIndex++){
            
            List<Integer> currentBatch = batches.get(batchIndex);

            for (int taskIndex : currentBatch){
                 Future<Void> future = (Future<Void>) executor.submit(tasks.get(taskIndex));
                 futures.add(future);
                 executedTaskIndices.add(taskIndex);
            }

            for (Future<Void> f : futures){
                f.get();
            }
            futures.clear();

            System.out.println("第"+ batchIndex+ "批任务执行完成");
        }

        for (int i = 0; i < tasks.size(); i++){
            if (!executedTaskIndices.contains(i)) {
                executor.submit(tasks.get(i));
            }
        }


        executor.shutdown();

        while (!executor.isTerminated()) {
        }
        
    }


    public static void main(String[] args) {
        List<Runnable> tsaks = creatTasks();

        List<Integer> batch1 = Arrays.asList(1,3,5,7);
        List<Integer> batch2 = Arrays.asList(11,13,15,17);
        List<List<Integer>> batchs = new ArrayList<>();

        batchs.add(batch1);
        batchs.add(batch2);

        try {
            runTasksInBatches(tsaks, batchs);
            System.out.println("所有任务完成");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Runnable> creatTasks(){
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            final int taskId = i;
            tasks.add(() ->  System.out.println("执行任务" + taskId));
        }

        return tasks;
    }

    
}
