/**
 * TCCC 2003 Semifinals 3 300pt problem
 * @author Asistente
 *
 */
public class ZigZag {


	int longestZigZag(int[] sequence){
		Element[] result = new Element[sequence.length];
		result[0] = new Element();
		result[0].positive=0;
		result[0].length=1;
		for (int i = 1; i < sequence.length; i++) { 
			
			int positive;
			if(sequence[i]>sequence[i-1]){
				positive = 1;
			}else if(sequence[i]<sequence[i-1]){
				positive = -1;
			}else{
				result[i] = result[i-1];
				continue;
			}
			Element e = new Element();
			e.positive = positive;
			e.length=1;
			for (int j = 0; j < i; j++) {
				int l = result[j].length;
				if(positive*result[j].positive<=0){
					l++;
				}
				if(l>e.length){
					e.length=l;
					e.positive=positive;
				}								
			}			
			result[i]=e;
		}
				
		return result[sequence.length-1].length;
	}
	
	class Element{
		int positive;
		
		int length;
	}
	
	public static void main(String[] args) {
		int[] seq = new int[]{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		System.out.println(new ZigZag().longestZigZag(seq));
	}
}
