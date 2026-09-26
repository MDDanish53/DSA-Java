class Task implements Comparable<Task> {
  int frequency;
  int executionTime;

  public Task(int frequency, int executionTime) {
    this.frequency = frequency;
    this.executionTime = executionTime;
  }

  public int compareTo(Task other) {
    return other.frequency - this.frequency;
  }
}

public class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {

    // Frequency Map
    HashMap<Character, Integer> frequencyMap = new HashMap<>();
    for (char ch : tasks) {
      frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
    }

    // insertion in maxHeap - Priority Queue
    PriorityQueue<Task> priorQueue = new PriorityQueue<>();
    // insert tasks in priorityQueue
    for (char ch : frequencyMap.keySet()) {
      int frequency = frequencyMap.get(ch);
      priorQueue.offer(new Task(frequency, 0));
    }

    // Queue
    Queue<Task> queue = new LinkedList<>();
    int time = 0;
    while (!queue.isEmpty() || !priorQueue.isEmpty()) {
      time++;
      // check if there is a task in priorQueue and process it
      if (!priorQueue.isEmpty()) {
        Task task = priorQueue.poll();
        task.frequency--;
        if (task.frequency > 0) {
          // update the execution time
          task.executionTime = time + n;
          queue.offer(task);
        }
      }
      // shift the active process to the priorQueue
      if (!queue.isEmpty() && queue.peek().executionTime == time) {
        priorQueue.offer(queue.poll());
      }
    }
    return time;
  }
}