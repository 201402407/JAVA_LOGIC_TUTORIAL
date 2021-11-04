package sort;

public class Sorting {
	
	/* 퀵소트 */
	public static void quickSort(int[] arr, int curLeft, int curRight) {
		int left = curLeft;
		int right = curRight;
		int pivot = arr[(left + right) / 2];	// 피봇 생성(중간 값)
		
		// left와 right가 반대가 되는 시점 전까지 진행
		do {
			// left로 pivot보다 큰 값을 찾을 때 까지 탐색
			while(arr[left] < pivot) {
				left++;
			}
			
			// right로 pivot보다 작은 값을 찾을 때 까지 탐색
			while(arr[right] > pivot) {
				right--;
			}
			
			// 두 값 위치 변경
			if(left <= right) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				left++;
				right--;
			}
		} while(left <= right);
		
		if(left < curRight) {
			quickSort(arr, left, curRight);
		}
		if(right > curLeft) {
			quickSort(arr, curLeft, right);	
		}
	}
	
	public static void bubbleSort(int[] arr) {
		// 가장 끝에서부터 step 단위 별 값 고정
		// 하나의 step당 끝에서부터 하나의 원소를 정렬완료했다고 가정
		for(int i = arr.length - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void insertionSort(int[] arr) {
		int size = arr.length;
		int temp = 0;
		int j = 0;
		
		for(int i = 1; i < size; i++) {
			temp = arr[i];
			for(j = i - 1; j >= 0 && temp < arr[j]; j--) {	// 비교하는 인덱스 값이 더 작았을 때도 for문 종료
				arr[j + 1] = arr[j];
			}
			
			arr[j + 1] = temp;	// 해당 위치에 원소 삽입
		}
	}
	
	public static void selectionSort(int[] arr) {
		int size = arr.length;
		int min;
		
		for(int i = 0; i < size - 1; i++) {	// i 인덱스에 적합한 원소 넣기(정렬)
			min = i;	// 무조건 해당 인덱스보다 원소의 값이 같거나 클 수 밖에 없다.
			for(int j = i + 1; j < size; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			
			// 가장 낮은 값(또는 높은 값) 을 i번째 인덱스에 넣기(정렬됨)
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
}
