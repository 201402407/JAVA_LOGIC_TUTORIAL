package sorting;

import java.util.function.Supplier;

import common.Utils;

public class Sample {
	static final int SIZE = 50000;
	public static void main(String args[]) {
		bubbleSort();
		selectionSort();
		insertionSort();
		mergeSort();
		quickSort();
		radixSort();
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
		System.out.println("------------------------------------------------------------------------------");
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
		System.out.println("------------------------------------------------------------------------------");
	}
	
	public static void selectionSort() {
		System.out.println("[QUESTION] Selection Sort(선택정렬)");
		System.out.println("[ANSWER] 1) 전체 배열을 순회하면서 최소값(또는 최대값)을 찾는다.");
		System.out.println("[ANSWER] 2) 1)의 값을 맨 앞자리와 교체한다.");
		System.out.println("[ANSWER] 3) 교체한 값을 제외한 다음 값부터 1~2를 반복한다.");
		System.out.println("[ANSWER] 데이터의 양이 적을 때 유용함. 대신, 데이터의 양이 어느정도 많아지면 사용하기 힘들다.");
		System.out.println("[ANSWER] 시간복잡도 : Best => O(n^2) / Average => O(n^2) / Worst => O(n^2)");
		System.out.print("Selection Sort Test :: ");
		Utils.elapsedCheck(selectionSortSupplier);
		System.out.println("------------------------------------------------------------------------------");
	}
	
	public static void mergeSort() {
		System.out.println("[QUESTION] Merge Sort(합병정렬)");
		System.out.println("[ANSWER] devide and conquer 알고리즘(분할정복) 활용하여 배열을 나누고 합치면서 정렬을 진행한다.");
		System.out.println("[ANSWER] 1) 배열을 반으로 분할한다.(2-way)");
		System.out.println("[ANSWER] 2) 더이상 분할할 배열이 없을 때까지(길이가 1인 배열) 1)의 과정을 진행한다.");
		System.out.println("[ANSWER] 3) 분할된 배열들을 합친다.");
		System.out.println("[ANSWER] 시간복잡도 : Best => O(nlogn) / Average => O(nlogn) / Worst => O(nlogn)");
		System.out.print("Merge Sort Test :: ");
		Utils.elapsedCheck(mergeSortSupplier);
		System.out.println("------------------------------------------------------------------------------");
	}
	
	public static void quickSort() {
		System.out.println("[QUESTION] Quick Sort(퀵정렬)");
		System.out.println("[ANSWER] 1) List에서 하나의 기준으로 원소를 선택(pivot)");
		System.out.println("[ANSWER] 2) pivot 기준 앞(왼쪽)에는 pivot보다 작은 값이, 뒤(오른쪽)에는 pivot보다 큰 값이 오도록 두 개의 리스트로 분할");
		System.out.println("[ANSWER] 3) 분할된 두 개의 리스트 각각 재귀호출로 퀵소트 진행");
		System.out.println("[ANSWER] 시간복잡도 : Best => O(nlogn) / Average => O(nlogn) / Worst => O(n^2)");
		System.out.print("Quick Sort Test :: ");
		Utils.elapsedCheck(quickSortSupplier);
		System.out.println("------------------------------------------------------------------------------");
	}
	
	public static void radixSort() {
		System.out.println("[QUESTION] Radix Sort(기수정렬)");
		System.out.println("[ANSWER] 낮은 자리수부터 비교해서 0~9 10개의 큐(여기서는 배열)에 자리수 숫자에 맞게 분배하고 빼며 정렬하는 방식");
		System.out.println("[ANSWER] 메모리 낭비 심함");
		System.out.println("[ANSWER] 1) 각 최소 자리수부터 시작해서 자리수에 맞는 숫자에 맞게 큐에 넣는다.");
		System.out.println("[ANSWER] 2) 낮은 수의 큐(0~9 중 0)부터 차례로 값을 꺼낸다.");
		System.out.println("[ANSWER] 3) 십 단위의 자리수 순서대로 최대 숫자의 자리수까지 1~2 과정 반복");
		System.out.println("[ANSWER] 시간복잡도 : Best => O(n) / Average => O(d(n + k)) / Worst => O(d(n + k))");
		System.out.println("[!] 시간복잡도 계산 참고");
		System.out.println("-> d를 최대 자릿수의 길이라고 했을 때 각 자릿수마다 반복하기 때문에 일단 d번 반복하며, ");
		System.out.println("-> 한 번 반복할 때 그 안에서 각 자릿수를 대체하는 큐에 배열의 요소들을 집어넣기 때문에 n개의 요소에 대해 n번 반복한다고 할 수 있고, ");
		System.out.println("-> 이 n번 반복이 끝나면 큐에 있는 걸 다시 꺼내서 배열을 업데이트 시키기 때문에 이번엔 자릿수가 될 수 있는 것이 0부터 9이므로 여기선 10번 반복한다. ");
		System.out.println("-> 그러나 정수에 대한 정렬이 아니고 문자나, 문자열의 정렬일 경우 확정되어있는 것이 아니기 때문에 그렇게 반복될 횟수를 k라고 정한다.");
		System.out.print("Radix Sort Test :: ");
		Utils.elapsedCheck(radixSortSupplier);
		System.out.println("------------------------------------------------------------------------------");
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
	
	// 선택정렬
	static Supplier<Boolean> selectionSortSupplier = () -> {
		int[] arr = initIntArr(SIZE);
		Sorting.selectionSort(arr);
		return true;
	};
	
	// 합병정렬
	static Supplier<Boolean> mergeSortSupplier = () -> {
		int[] arr = initIntArr(SIZE);
		Sorting.mergeSort(arr, new int[arr.length], 0, arr.length - 1);
		return true;
	};
	
	// 합병정렬
	static Supplier<Boolean> radixSortSupplier = () -> {
		int[] arr = initIntArr(SIZE);
		Sorting.radixSort(arr, arr.length);
		return true;
	};
	
	// 임의의 숫자 배열 생성
	public static int[] initIntArr(int size) {
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			int num = (int) (Math.random() * size);
			arr[i] = num;
		}
		
		return arr;
	}
}
