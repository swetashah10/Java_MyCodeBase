// firstStr = g->e->e->k->s, secondStr = g->e->e->k->s, result = 0
// firstStr = p->e->e->k->s, secondStr = g->e->e->k->s, result = 1
// firstStr = g->e->e->k->s, secondStr = p->e->e->k->s, result = -1
class NodeString{
	char data;
	NodeString next;
	NodeString(char str){
		data = str;
		next = null;
	}
}
public class CompareStringsAsLists {

	public static void main(String[] args){
		
		CompareStringsAsLists compareStrings = new CompareStringsAsLists();
		NodeString firstStringNode = new NodeString('g');
		firstStringNode.next = new NodeString('e');
		firstStringNode.next.next = new NodeString('e');
		firstStringNode.next.next.next = new NodeString('k');
		firstStringNode.next.next.next.next = new NodeString('s');

		NodeString secondStringNode = new NodeString('g');
		secondStringNode.next = new NodeString('e');
		secondStringNode.next.next = new NodeString('e');
		secondStringNode.next.next.next = new NodeString('k');
		secondStringNode.next.next.next.next = new NodeString('s');
		secondStringNode.next.next.next.next.next = new NodeString('s');


		System.out.println("Strings to be compared are:");
		compareStrings.printStringList(firstStringNode);
		compareStrings.printStringList(secondStringNode);

		int result = compareStrings.compareStrings(firstStringNode, secondStringNode);
		System.out.println("Result of comparison = "+result);
		
	}
	public void printStringList(NodeString str){
		NodeString temp = str;
		while(temp != null){
			System.out.print(temp.data+ " -> ");
			temp = temp.next;
		}
		System.out.println(" NULL ");
	}
	
	public int getLength(NodeString node){
		int length = 0;
		NodeString temp = node;
		while(temp != null){
			length++;
			temp = temp.next;
		}
		
		return length;
	}
	public int compareStrings(NodeString firstString, NodeString secondString){
		int result = 0;
		
		int firstStrLength = getLength(firstString);
		int secondStrLength = getLength(secondString);
		
		if(firstStrLength == secondStrLength){
			NodeString temp1 = firstString;
			NodeString temp2 = secondString;
			while(temp1 != null && temp2 != null){
				if(temp1.data == temp2.data){
					temp1 = temp1.next;
					temp2 = temp2.next;
				}else if(Character.getNumericValue(temp1.data) > Character.getNumericValue(temp2.data) ){
					return 1;
				}else if(Character.getNumericValue(temp1.data) < Character.getNumericValue(temp2.data) ){
					return -1;
				}
			}
			return 0;
			
		}else if(firstStrLength > secondStrLength){
			result = compare(secondString, firstString);
		}else if(firstStrLength < secondStrLength){
			result = compare(firstString, secondString);
		}
		return result;
	}
	
	public int compare(NodeString smallerString, NodeString largerString){
		NodeString temp1 = smallerString;
		NodeString temp2 = largerString;
		
		while(temp1 != null){
			if(temp1.data == temp2.data){
				temp1 = temp1.next;
				temp2 = temp2.next;
			}else if(Character.getNumericValue(temp1.data) > Character.getNumericValue(temp2.data) ){
				return 1;
			}else if(Character.getNumericValue(temp1.data) < Character.getNumericValue(temp2.data) ){
				return -1;
			}
		}
		return -1;
	}
}
