package T1_17;


public class T17 {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int [] nums2 = {6,8,10,12,13};
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        System.out.println("Average: " + total/(float)nums.length);
        System.out.println("Average: " + Average(nums2));
    }
    
    public static float Average(int[] nums){
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        return total/(float)nums.length;
    }
    
}
