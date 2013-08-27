import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * 
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
		
		ArrayList<Integer> result = new ArrayList();
		result.add(0);
		for (int i = 1; i < height.length; i++) {			
			int bloomi = flowers[i].bloom;
			int wilti = flowers[i].wilt;
			int heighti = flowers[i].height;
			boolean added = false;
			for (int j = 0; j < result.size() && !added; j++) {
				int k = result.get(j);
				int bloomj = bloom[k];
				int wiltj = wilt[k];
				int heightj = height[j];
				System.out.println("Comparo: "+bloomi+","+wilti+" con "+bloomj+","+wiltj);
				if((bloomi < bloomj && wilti > bloomj) || (bloomi > bloomj && bloomi < wiltj)){
					System.out.println("Cruzan");
					// Se cruzan
					if(heightj < heighti){
						System.out.println("Agrego de todas formas");
						result.add(j,i);
						added=true;
					}
				}else{
					System.out.println("No cruzan");
					result.add(j,i);
					added=true;
				}				
			}
			if(!added)
				result.add(i);			
		}
		
		int[] resultArray = new int[height.length];
		for (int i = 0; i < result.size(); i++) {
			resultArray[i] = height[result.get(i)];
		}
		return resultArray;
	}
	
	public static void main(String[] args) {
		FlowerGarden fg = new FlowerGarden();
		System.out.println(Arrays.toString(fg.getOrdering(new int[]{5,4,3,2,1}, 
				new int[]{1,5,10,15,20}, 
				new int[]{4,9,14,19,24})));
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
