class Solution {
    public int solution(int[][] sizes) {
        int max=0, min=0;

        for(int[] line : sizes){
            int paramMax = Math.max(line[0],line[1]);
            int paramMin = Math.min(line[0],line[1]);

            max = Math.max(paramMax, max);
            min = Math.max(paramMin, min);
        }

        return max*min;
    }
}