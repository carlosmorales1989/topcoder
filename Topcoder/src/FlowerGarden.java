import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * 2004 TCCC Online Round 1 500 pt problem
 * @author Asistente
 *
 */

public class FlowerGarden {

	public int[] getOrdering(int[] height, int[] bloom, int[] wilt){
		Flower[] flowers = new Flower[height.length];
		for (int i = 0; i < flowers.length; i++) {
			flowers[i] = new Flower();
			flowers[i].height = height[i];
			flowers[i].bloom = bloom[i];
			flowers[i].wilt = wilt[i];
		}		
		
		Arrays.sort(flowers);	
		
		ArrayList<Flower> result = new ArrayList();
		result.add(flowers[flowers.length-1]);
		for (int i = height.length-2; i >=0; i--) {
			int bloomi = flowers[i].bloom;
			int wilti = flowers[i].wilt;
			int heighti = flowers[i].height;
			boolean added = false;
			for (int j = 0; j < result.size() && !added; j++) {
				Flower f = result.get(j);
				int bloomj = f.bloom;
				int wiltj = f.wilt;
				int heightj = f.height;
				System.out.println("Comparo: "+bloomi+","+wilti+" con "+bloomj+","+wiltj);
				if((bloomi <= bloomj && wilti >= bloomj) || (bloomi >= bloomj && bloomi <= wiltj)){
					System.out.println("Cruzan");
						result.add(j,flowers[i]);
						added=true;
				}	
			}
			if(!added)
				result.add(flowers[i]);			
		}
		
		int[] resultArray = new int[height.length];
		for (int i = 0; i < result.size(); i++) {
			resultArray[i] = result.get(i).height;
		}
		return resultArray;
	}
	
	
	class Flower implements Comparable<Flower>{
		
		int height;
		
		int bloom;
		
		int wilt;

		@Override
		public int compareTo(Flower o) {
			if(o.height> height)
				return -1;
			else if(o.height < height)
				return 1;
			else
				return 0;
		}
		
	}
	
}
