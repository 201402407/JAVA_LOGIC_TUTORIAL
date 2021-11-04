package sort;

import java.util.function.Supplier;

import common.Utils;

public class Sample {
	static final int SIZE = 20000;
	public static void main(String args[]) {
		bubbleSort();
		insertionSort();
		quickSort();
	}

	public static void bubbleSort() {
		System.out.println("[QUESTION] Bubble Sort(버블정렬)");
		System.out.println("[ANSWER] 1) 인접한 두 개의 원소를 비교");
		System.out.println("[ANSWER] 2) 인덱스를 하나씩 증가시키면서, 끝까지 인접한 두 개의 원소를 비교");
		System.out.println("[ANSWER] 3) 1~2 과정을 1개의 step으로 했을 때, 매 step마다 끝에서부터 한 개의 원소가 정렬됨");
		System.out.println("[ANSWER] 4) 모든 원소를 정렬완료할 때 까지 step 반복");
		System.out.println("[ANSWER] 시간복잡도 : Best => O(n^2) / Average => O(n^2) / Worst => O(n^2)");
		System.out.print("Bubble Sort Test :: ");
		Utils.elapsedCheck(bubbleSortSupplier);
	}
	
	public static void insertionSort() {
		System.out.println("[QUESTION] Insertion Sort(삽입정렬)");
		System.out.println("[ANSWER] 1) 2번째 인덱스부터 순회 시작. 해당 값을 정렬된 인덱스에 삽입하기 위한 정렬");
		System.out.println("[ANSWER] 2) 1)의 인덱스부터 최대 첫 번째 인덱스까지 순회하면서 1)의 인덱스값과 2)에서 순회한 인덱스값 크기 비교");
		System.out.println("[ANSWER] 3) 1)의 인덱스 값보다 2)의 인덱스 값이 더 크면 2)의 인덱스 원소를 한 칸 뒤로 옮긴다.");
		System.out.println("[ANSWER] 4) 1)의 인덱스 값이 더 클때까지 2~3 과정 반복.");
		System.out.println("[ANSWER] 시간복잡도 : Best => O(n) / Average => O(n^2) / Worst => O(n^2)");
		System.out.print("Insertion Sort Test :: ");
		Utils.elapsedCheck(insertionSortSupplier);
	}
	
	public static void quickSort() {
		System.out.println("[QUESTION] Quick Sort(퀵정렬)");
		System.out.println("[ANSWER] 1) List에서 하나의 기준으로 원소를 선택(pivot)");
		System.out.println("[ANSWER] 2) pivot 기준 앞(왼쪽)에는 pivot보다 작은 값이, 뒤(오른쪽)에는 pivot보다 큰 값이 오도록 두 개의 리스트로 분할");
		System.out.println("[ANSWER] 3) 분할된 두 개의 리스트 각각 재귀호출로 퀵소트 진행");
		System.out.println("[ANSWER] 시간복잡도 : Best => O(nlogn) / Average => O(nlogn) / Worst => O(n^2)");
		System.out.print("Quick Sort Test :: ");
		Utils.elapsedCheck(quickSortSupplier);
	}
	
	// 버블정렬
	static Supplier<Boolean> bubbleSortSupplier = () -> {
		int[] arr = initIntArr(SIZE);
		Sorting.bubbleSort(arr);
		return true;
	};
	
	// 삽입정렬
	static Supplier<Boolean> insertionSortSupplier = () -> {
		int[] arr = initIntArr(SIZE);
		Sorting.insertionSort(arr);
		return true;
	};
	
	// 퀵정렬
	static Supplier<Boolean> quickSortSupplier = () -> {
		int[] arr = initIntArr(SIZE);
		Sorting.quickSort(arr, 0, SIZE - 1);
		return true;
	};
	
	public static int[] initIntArr(int size) {
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			int num = (int) (Math.random() * size);
			arr[i] = num;
		}
		
		return arr;
	}
}
