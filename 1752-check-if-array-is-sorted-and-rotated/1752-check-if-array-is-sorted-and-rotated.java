class Solution {

    public void rotateArray(int[] arr){
        int [] copy=new int[arr.length];

        for(int i=0;i<arr.length-1;i++){
           copy[i+1]=arr[i];
        }
       copy[0]=arr[arr.length-1];

       for(int i=0;i<arr.length;i++){
        arr[i]=copy[i];
       }
    }
    public boolean check(int[] nums) {
        int rotationCount = 0;
        if(nums.length==1){
            return true;
        }

        while (rotationCount < nums.length) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    rotationCount++;
                    rotateArray(nums);
                    break;
                } else if (i == nums.length - 1)
                    return true;

            }
        }

        return false;

    }
}