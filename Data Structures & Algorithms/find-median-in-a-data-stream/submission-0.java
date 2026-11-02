class MedianFinder {
    PriorityQueue<Integer> firstHalf;
    PriorityQueue<Integer> secondHalf;
    public MedianFinder() {
        firstHalf = new PriorityQueue<>(Collections.reverseOrder());
        secondHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(!firstHalf.isEmpty() && firstHalf.peek() > num){
            firstHalf.offer(num);
        }else{
            secondHalf.offer(num);
        }

        if(firstHalf.size() > secondHalf.size() + 1){
            secondHalf.offer(firstHalf.poll());
        }
        if(secondHalf.size() > firstHalf.size()){
            firstHalf.offer(secondHalf.poll());
        }
    }
    
    public double findMedian() {
        if(firstHalf.size() > secondHalf.size()){
            return firstHalf.peek();
        }
        return ((double)firstHalf.peek() + (double)secondHalf.peek()) / 2.0;
    }
}
