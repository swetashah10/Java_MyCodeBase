
public class Test {
		public static void main(String args[]){
		int sum = 0, p = 1;
		for (int count = 1; count <= 50; count++)
		{
		sum += p;
		p *= 2;
		System.out.println(sum);
		}
		System.out.println(sum);
		}
		
}
