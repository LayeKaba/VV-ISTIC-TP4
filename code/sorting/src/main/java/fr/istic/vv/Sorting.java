package fr.istic.vv;
import java.util.Arrays;
import java.util.Comparator;

public class Sorting {

	public static <T>  T[] bubblesort(T[] array, Comparator<T> comparator) {

		int taille = array.length;  
		T tmp ;  
		for(int i=0; i < taille; i++) 
		{
			for(int j=1; j < (taille-i); j++)
			{  
				if(comparator.compare(array[j-1] , array[j]) > 0)
				{
					//echanges des elements
					tmp = array[j-1];  
					array[j-1] = array[j];  
					array[j] = tmp;  
				}

			}
		}
		return array; 
	}

	public static <T> T[] quicksort(T[] array, Comparator<T> comparator)  {
		int longueur=array.length;
		triRapide(array,0,longueur-1, comparator);

		return array;
	}

	public static <T> T[] mergesort(T[] array, Comparator<T> comparator) {

		/*
		 * int longueur=array.length; if (longueur>0) { triFusion(array,0,longueur-1,
		 * comparator); }
		 */
		if (array.length == 0) return array;

		mergeSort(array, array.length, comparator);

		return array; 
	}

	static  <T> void echangerElements(T[] t, int m, int n) {
		T temp = t[m];

		t[m] = t[n];
		t[n] = temp;
	}

	private static <T> int partition(T tableau[],int deb, int fin, Comparator<T> comparator)
	{
		int compt=deb;
		T pivot=tableau[deb];

		for(int i=deb+1;i<=fin;i++)
		{
			if (comparator.compare( tableau[i], pivot) < 0)//Comp
			{
				compt++;
				echangerElements(tableau,compt,i);
			}
		}
		echangerElements(tableau,deb,compt);
		return(compt);
	}

	private static <T> void triRapide(T tableau[],int deb,int fin, Comparator<T> comparator)
	{
		if(deb<fin)
		{
			int positionPivot=partition(tableau, deb, fin, comparator);
			triRapide(tableau, deb,positionPivot-1, comparator);
			triRapide(tableau, positionPivot+1, fin, comparator);
		}
	}



	public static <T> void merge(T[] left_arr, T[] right_arr, T[] arr, int left_size, int right_size, Comparator<T> comparator){

		int i=0,l=0,r = 0;
		//The while loops check the conditions for merging
		while(l<left_size && r<right_size){

			if(comparator.compare( left_arr[l], right_arr[r])<0){
				arr[i++] = left_arr[l++];
			}
			else{
				arr[i++] = right_arr[r++];
			}
		}
		while(l<left_size){
			arr[i++] = left_arr[l++];
		}
		while(r<right_size){
			arr[i++] = right_arr[r++];
		}
	}

	public static <T> void mergeSort(T [] arr, int len , Comparator<T> comparator){


		if (len < 2){return;}

		int mid = len / 2;
		T left_arr[]  = Arrays.copyOfRange(arr,  0, mid );

		T right_arr[]  = Arrays.copyOfRange(arr, mid , arr.length ); //new int[len-mid]

		//Dividing array into two and copying into two separate arrays
		int k = 0;
		for(int i = 0;i<len;++i){
			if(i<mid){
				left_arr[i] = arr[i];
			}
			else{
				right_arr[k] = arr[i];
				k = k+1;
			}
		}
		// Recursively calling the function to divide the subarrays further
		mergeSort(left_arr,mid, comparator);
		mergeSort(right_arr,len-mid, comparator);
		// Calling the merge method on each subdivision
		merge(left_arr,right_arr,arr,mid,len-mid, comparator);
	}




}
