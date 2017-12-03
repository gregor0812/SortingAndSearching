package ClassroomAssingment;

/**
 * Created by Gregor on 03/12/2017.
 */
public class Merge
{

	
	
	private Merge(){}
	
	public static void merge(Comparable[] array, Comparable[] tempArray, int laag, int midden, int hoog){
		
		int i = laag, j = midden+1;
		
		for (int k = laag; k <= hoog; k++)
		{
			tempArray[k] = array[k];
		}
		
		for (int k = laag; k<= hoog; k++)
			if (i > midden){
			array[k] = tempArray[j++];
			}
			else if (j > hoog){
				array[k] = tempArray[i++];
			}
			else if(less(tempArray[j],tempArray[i])){
				array[k] = tempArray[j++];
			}
			else {
				array[k] = tempArray[i++];
			}
		
	}
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length-1);
	}
	

	private static boolean isSorted(Comparable[] array, int laag, int hoog) {
		for (int i = laag + 1; i <= hoog; i++){
			
		
			if (less(array[i], array[i-1])) {
			return false;
			}
		}
		return true;
	}
	
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void sort(Comparable[] array, Comparable[] tempArray, int laag, int hoog) {
		if(!isSorted(array,laag,hoog))
		{
			if (hoog <= laag){
				return;
			}
			int mid = laag + (hoog - laag) / 2;
			sort(array, tempArray, laag, mid);
			sort(array, tempArray, mid + 1, hoog);
			merge(array, tempArray, laag, mid, hoog);
		}
	}
	
	
}
