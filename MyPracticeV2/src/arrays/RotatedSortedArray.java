package arrays;

public class RotatedSortedArray
{
    // https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/?ref=rp

    //TODO with duplicate elements

    // NOTE: Smallest element is pivot.
    public static int findElement(int arr[], int key)
    {
        int pivot = findPivot(arr);
        System.out.println("Pivot at : " + pivot);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, arr.length - 1, key);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, arr.length - 1, key);
    }

    private static int findPivot(int arr[])
    {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (low < high && high < arr.length)
        {
            mid = (low + high) / 2;

            if (arr[mid] > arr[mid + 1]) // mid -> 5,1
                return mid + 1;

            if (arr[mid] < arr[mid - 1]) // 5,1 <- mid
                return mid;

            if(arr[mid] > arr[high]) //4,5,6,1,2
                low = mid;
            else  // 5,6,1,2,3,4
                high = mid;
        }

        return -1;
    }

    /* Standard Binary Search function */
    static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    public static void main(String[] args)
    {
        // Let us search 3 in below array
        int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int key = 3;

        System.out.println("Index of the element is : "
                           + findElement(arr1, key));
    }
}
