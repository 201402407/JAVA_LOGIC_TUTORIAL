package sorting;

import java.util.Arrays;

public class Sorting {
	
	// 퀵정렬
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
	
	// 버블정렬
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
	
	// 삽입정렬
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
	
	// 선택정렬
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
	
	/* 합병정렬 */
	public static int[] mergeSort(int[] arr, int[] temp, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, temp, left, mid);
			mergeSort(arr, temp, mid + 1, right);
			
			merge(arr, temp, left, mid, right);
		}
		
		return arr;
	}
	public static void merge(int[] arr, int[] temp, int left, int mid, int right) {
		int pLeft = left;
		int pRight = mid + 1;
		int tempIndex = left;
		
		while(pLeft <= mid && pRight <= right) {
			// 더 작은 값을 합칠 때 앞에다 둔다(오름차순 정렬)
			if(arr[pLeft] < arr[pRight]) {
				temp[tempIndex++] = arr[pLeft++]; 
			}
			else {
				temp[tempIndex++] = arr[pRight++]; 
			}
		}
		
		while(pLeft <= mid) {
			temp[tempIndex++] = arr[pLeft++];
		}
		while(pRight <= right) {
			temp[tempIndex++] = arr[pRight++];
		}
		
		// 복사한 배열 옮기기
		for(int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
	}
	
	/* 기수정렬 */
	public static void radixSort(int[] arr, int n) {
		int max = getMax(arr);

		// 최대값의 자리수만큼 countsort
		// exp: 자리 수(1, 10, 100 ...)
		for (int exp = 1; max / exp > 0; exp *= 10) {
			countSort(arr, n, exp);
		}
	}
	// 작은 자리수부터 정렬
	// exp: 자리 수
	static void countSort(int[] arr, int n, int exp) {
		int[] output = new int[n];	// 정렬된 배열을 담기 위한 공간
		int[] count = new int[10];	// 0~9까지의 자리수에 따른 정렬을 위한 별도 배열
		Arrays.fill(count, 0);	// 초기 0으로 설정
		
	    //발생횟수를 count[] 저장
	    for (int i = 0; i < n ; i++) {
	        count[(arr[i] / exp) % 10]++;
	    }
	    
	    //count[i]에 output[]의 숫자의 실제 위치가 포함되도록 count[i]를 변경
	    for (int i = 1; i < 10; i++) {
	    	count[i] += count[i - 1];
	    }
	    
	    //출력 배열 저장
	    for (int i = n - 1 ; i >= 0; i--) {
	       output[count[(arr[i] / exp) % 10] - 1] = arr[i];
	       count[(arr[i] / exp) % 10]--;
	    }
	    
	    // output[]을 arr[]에 복사
	    // arr []에 현재 배열에 따라 정렬 된 숫자가 포함됨
	    for (int i = 0; i < n; i++) {
	        arr[i] = output[i];
	    }
	}
	// 배열의 최대값을 갖는 함수를 통해 배열의 최댓값 찾음
	static int getMax(int[] arr) {
		if(arr.length == 0) {
			return 0;
		}
		
		int max = arr[0];
		for(int num : arr) {
			max = Math.max(max, num);
		}
		
		return max;
	}
}
