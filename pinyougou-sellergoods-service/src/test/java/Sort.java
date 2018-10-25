/**
 * @author YaphetS
 * @date 2018/10/25 9:08 AM
 */

public class Sort {

	public static void main(String[] args){
		int[] ini={3,2,1,7,4,5,4};
		//bubbleSort(ini);
		selectionSort(ini);
		for(int i=0;i<ini.length;i++){
			System.out.print(ini[i]+" ");
		}
	}


	//冒泡排序
	//从小到大
	public static void bubbleSort(int[] arr){
		int i,temp,len=arr.length;
		boolean changed;
		do{
			changed=false;
			len-=1;
			for(i=0;i<len;i++){
				if(arr[i]>arr[i+1]){
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					changed=true;
				}
			}

		}while(changed);
	}

	//选择排序
	//从小到大
	public static void selectionSort(int[] arr) {
		int i, j, min, temp, len = arr.length;

		for (i = 0; i < len - 1; i++) {
			min = i;
			for (j = i; j < len; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}

			temp = arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
	}
}