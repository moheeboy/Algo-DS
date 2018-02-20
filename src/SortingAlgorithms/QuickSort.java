/* 
 * Author => Mohit
 * 
 * Date => 20/1/18 
 */

package SortingAlgorithms;
import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {
	
	public int partition(int[] arr,int start, int end) {
		int pivotIndex = 0;
		int pivot = arr[end];
		for(int i=start;i<end;i++) {
			if (arr[i]<=pivot) {
					int temp = arr[pivotIndex];
					arr[pivotIndex] = arr[i];
					arr[i] = temp;
					pivotIndex++;
			}
		}
		int temp = arr[pivotIndex];
		arr[pivotIndex] = arr[end];
		arr[end] = temp;
		return pivotIndex;
	}
	
	public void quickSort(int[] arr,int start,int end) {
		if(start<end) {
			int pivotIndex = partition(arr,start,end);
			quickSort(arr,start,pivotIndex-1);
			quickSort(arr,pivotIndex+1,end);
		}else {
			return;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the array (separated by space): ");
		String s = scan.nextLine();
		String[] s1;
		QuickSort q = new QuickSort();
		s1 = s.split(" ");
		int[] arr = new int[s1.length];
		for(int i=0;i<s1.length;i++) {
			arr[i] = Integer.parseInt(s1[i]);
		}
		q.quickSort(arr,0,arr.length-1);
		System.out.println("Sorted Array: " + Arrays.toString(arr));
			
	}

}
