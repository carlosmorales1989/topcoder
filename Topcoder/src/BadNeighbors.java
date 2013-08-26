/**
 * 2004 TCCC Online Round 4 250 pt problem
 * @author Asistente
 *
 */
public class BadNeighbors {

	public int maxDonations(int[] donations){
		int[] don1 = new int[donations.length-1];
		int[] don2 = new int[donations.length-1];
		for (int i = 0; i < don2.length; i++) {
			don1[i] = donations[i];
			don2[i] = donations[i+1];
		}
		return Math.max(calculate(don1), calculate(don2));
		
		
	}
	
	private int calculate(int[] donations){
		int[] max = new int[donations.length];
		max[0] = donations[0];
		if(donations.length==1)
			return donations[0];
		max[1] = donations[1];
		for (int i = 2; i < donations.length; i++) {
			int m = donations[i];
			for (int j = 0; j < i-1; j++) {
				if(max[j]+donations[i]>m)
					m=max[j]+donations[i];
			}
			max[i]=m;
		}
		return max[donations.length-1];
	}
	
	public static void main(String[] args) {
		BadNeighbors bn = new BadNeighbors();
		System.out.println(bn.maxDonations(new int[]{ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 }));
	}
	
}
