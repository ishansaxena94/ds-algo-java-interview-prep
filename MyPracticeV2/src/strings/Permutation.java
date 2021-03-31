package strings;

public class Permutation {
	
	static void swap(char arr[], int i, int j) {
		
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	static void permute(char arr[], int l, int r) {
		
		if(l == r) {
			System.out.println(arr);
		}
		else {
			for(int i = l; i<=r; i++) {
				swap(arr, l, i);
				permute(arr, l+1, r);
				swap(arr, l, i);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char arr[] = new char[] {'A', 'B', 'C'};
		
		permute(arr, 0, arr.length - 1);
		
	}

}
