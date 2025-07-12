package dataStructure.month_25_05;

import java.util.PriorityQueue;

public class day_05_29_MedianFinder {
    class MedianFinder {
		private PriorityQueue<Integer> maxHeap;

		private PriorityQueue<Integer> minHeap;

		public MedianFinder() {
			maxHeap = new PriorityQueue<>((a, b) -> b - a);
			minHeap = new PriorityQueue<>((a, b) -> a - b);
		}

        public void addNum(int num) {
			if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
			balance();
		}
        
        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (double)(maxHeap.peek() + minHeap.peek() ) / 2;
            } else {
                return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
            }

            
        }

        public void balance(){
            if (Math.abs(maxHeap.size() - minHeap.size()) == 2) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else {
                    maxHeap.add(minHeap.poll());
                }
            }
        }
    }
}
