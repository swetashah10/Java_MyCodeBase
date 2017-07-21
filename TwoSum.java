/*Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 */



public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] result = new int[2];
        
        for(int i=0; i < numbers.length; i++){
           
            int nextNum = Math.abs(target - numbers[i]);
            
            int firstIndex = i+1;
            int secondIndex = binSearch(nextNum, numbers, firstIndex, numbers.length - 1);
            
            if(secondIndex != -1){
                result[0] = firstIndex;
                result[1] = secondIndex + 1;
                break;
            }
        }
        
        return result;
    }
    
    public int binSearch(int num, int[] numbers, int low, int high){
        
        int index = -1;
        
        int mid = -1;
        
        while(low <= high){
            
             mid = (low+high)/2;
            
            if(num == numbers[mid]){
                index = mid;
                break;
            }else if(num > numbers[mid]){
                
               low = mid + 1; 
            }else{
                
                high = mid - 1;
            }
        }
        return index;
    }
}
