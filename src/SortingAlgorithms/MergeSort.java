/* 
 * Author => Mohit
 * 
 * Date => 19/1/18 
 */




package SortingAlgorithms;
import java.util.Scanner;
import java.util.Arrays;

public class MergeSort {
	public void mergeSort(int[] arr) {
		int l = arr.length; 
		if(l==1)
			return;
		else {
			int mid = arr.length/2;
			int[] leftSublist = new int[mid];
			int[] rightSublist = new int[arr.length - mid];
			for(int k=0;k<mid;k++) {
				leftSublist[k] = arr[k];
			}
			for(int i=mid;i<arr.length;i++) {
				rightSublist[i-mid] = arr[i];
			}
			System.out.println("before left, leftsublist: " + Arrays.toString(leftSublist));
			mergeSort(leftSublist);
			System.out.println("before rigth, rightsublist: " +  Arrays.toString(rightSublist));
			mergeSort(rightSublist);
			System.out.println("before merge");
			merge(leftSublist,rightSublist,arr);
		}
	}
	
	public void merge(int[] leftSublist,int[] rightSublist,int[] arr) {
		
		int lengthOfLeftSublist = leftSublist.length;
		int lengthOfRightSublist = rightSublist.length;
		int i=0,j=0,k=0;
		System.out.println("In merge => LeftSublist: " + Arrays.toString(leftSublist) + " RightSublist: " + Arrays.toString(rightSublist));
		while(i<lengthOfLeftSublist && j<lengthOfRightSublist) {
			if(leftSublist[i]<rightSublist[j]) {
				arr[k] = leftSublist[i];
				i++;
			}else {
				arr[k] = rightSublist[j];
				j++;
			}
			k++;
		}
		while(i<lengthOfLeftSublist) {
			arr[k] = leftSublist[i];
			i++;
			k++;
		}
		while(j<lengthOfRightSublist) {
			arr[k] = rightSublist[j];
			j++;
			k++;
		}
		System.out.println("After merge:" + Arrays.toString(arr));
	}
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the elements to be sorted: ");
		String s = scan.nextLine();
		String[] s1 = s.split(" ");
		int[] arr = new int[s1.length];
		for(int i=0;i<s1.length;i++) {
			arr[i] = Integer.parseInt(s1[i]);
		}
		m.mergeSort(arr);
		System.out.println("\nSorted list: " + Arrays.toString(arr));
		System.out.println("End of program");
	}

}
