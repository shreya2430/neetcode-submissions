class Solution {
    public int maxArea(int[] height) {
        int i=0, j = height.length-1;
        int maxArea = 0;
        while(j > i){
            int width = j-i;
            if(height[i] > height[j]){
                maxArea = Math.max(maxArea, height[j] * width);
                j--;
            }else{
                maxArea = Math.max(maxArea, height[i] * width);
                i++; 
            }
        }
        return maxArea;
    }
}
