package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSubsequence
{
    // https://www.geeksforgeeks.org/longest-consecutive-subsequence/

    // TimeComplexity: O(n^2). for loop contains while loop.
    // SpaceComplexity: O(n). To store every element in hashmap O(n) space is needed
    public static int findLongestConsecutiveSubsequence(int arr[])
    {
        if (null == arr)
        {
            return 0;
        }

        int maxLength = 0;
        Set<Integer> hash = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        for (int i = 0; i < arr.length; i++)
        {
            // if current element is the starting
            // element of a sequence
            if (!hash.contains(arr[i] - 1)) // starting point of subsequence
            {
                // Then check for next elements
                // in the sequence
                int j = arr[i];

                while (hash.contains(j))
                {
                    j++;
                }

                if (maxLength < j - arr[i])
                {
                    maxLength = j - arr[i];
                }

            }
        }

        return maxLength;
    }

    // The idea is to first sort the array and find the longest subarray with consecutive elements.
    // TimeComplexity: O(n*log(n)). Time to sort the array is O(nlogn).
    // SpaceComplexity: O(n). To store every element in new array O(n) space is needed
    public static int findLongestConsecutiveSubsequenceV2(int arr[])
    {
        if (null == arr)
        {
            return 0;
        }

        int maxLength = 0;
        int curLength = 1;

        Set<Integer> hash = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        List<Integer> list = new ArrayList<>(hash);
        Collections.sort(list);

        int arr2[] = list.stream().mapToInt(i -> i).toArray();

        for (int i = 0; i < arr2.length - 1; i++)
        {
            if (arr2[i] + 1 == arr2[i + 1])
            {
                curLength++;
            }
            else
            {
                if (maxLength < curLength)
                {
                    maxLength = curLength;
                }

                curLength = 1;
            }
        }

        return maxLength;
    }

    public static void main(String[] args)
    {
        int arr[] = {1, 9, 3, 10, 4, 20, 2};

        System.out.println(
                "Length of the Longest consecutive subsequence is "
                + findLongestConsecutiveSubsequence(arr));
        System.out.println(
                "Length of the Longest consecutive subsequence is "
                + findLongestConsecutiveSubsequenceV2(arr));
    }
}
