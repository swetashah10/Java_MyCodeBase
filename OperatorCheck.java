import java.util.ArrayList;
import java.util.List;


public class OperatorCheck {

	public static void main(String args[]){
		
		int x = 5; 
		
		x++; 
		System.out.println(x);
		
		x = 5;
		++x;
		System.out.println(x);
		//int numbers[] = new int[]{0,1,2,4,5,7};
		int numbers[] = new int[]{-1};
		System.out.println(summaryRanges(numbers));
	}


	public static List<String> summaryRanges(int[] nums) {
	      
	      int parent=0;
	      ArrayList<String> sumRange = new ArrayList<String>();
	      
	       if(nums == null || nums.length==0)
	        return sumRange;
	 
	       if(nums.length==1){
	        sumRange.add(nums[0]+"");
	        return sumRange;
	       }
	       
	      for(int i=0; i<nums.length; i++){
	          
	    	  if(i+1 == nums.length ){
	              if(parent==i)
	                sumRange.add(""+nums[i]);
	                else if(parent < i && (nums[i-1]+1) == nums[i]){
	                  sumRange.add(""+nums[parent]+"->"+nums[i]);  
	                }
	              break;
	          }

	          if((nums[i]+1) != nums[i+1]){
	              
	              if(parent == i){
	                  sumRange.add(""+nums[i]);
	              } else if( parent < i){
	                  sumRange.add(""+nums[parent]+"->"+nums[i]);
	                  parent = i+1;
	              }else{
	                  System.out.println("Parent index cannot be greater than current index. Please check your code.");
	              }
	              
	          }
	      }
	      
	      return sumRange;
	}
}
