
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergeIntervals {

  public int[][] mergeInterval(int intervals[][]) {
    
    if(intervals.length <= 1) {
      return intervals;
    }

    Arrays.sort(intervals, Comparator.comparingInt(i -> i[0])); // sorting based on starting of the interval

    List<int[]> result = new ArrayList<>();

    int[] newInterval = intervals[0];
    result.add(newInterval);

    for(int[] interval : intervals) {
      if(interval[0] <= newInterval[1]) {
        newInterval[1] = Math.max(newInterval[1], interval[1]);
      } else {
        newInterval = interval;
        result.add(newInterval);
      }
    }

    return result.toArray(new int[result.size()][]);

  }

  void main() {
    int intervals[][] = {
        { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
    };
    int result[][] = mergeInterval(intervals);

    for (int interval[] : result) {
      System.out.println("[" + interval[0] + ", " + interval[1] + "]");
    }
  }
}