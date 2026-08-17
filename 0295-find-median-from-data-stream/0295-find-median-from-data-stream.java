import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        if(maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {
        int totalSize = maxHeap.size() + minHeap.size(); 
        if(totalSize % 2 != 0)
            return maxHeap.peek().doubleValue();
        else{
            double median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            return median;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */