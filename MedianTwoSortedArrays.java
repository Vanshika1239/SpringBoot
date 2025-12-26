package array;

public class MedianTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int total = m + n;
		int[] merged = new int[total];

		int i = 0, j = 0, k = 0;

		// Merge both arrays
		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				merged[k++] = nums1[i++];
			} else {
				merged[k++] = nums2[j++];
			}
		}

		// Copy remaining elements
		while (i < m)
			merged[k++] = nums1[i++];
		while (j < n)
			merged[k++] = nums2[j++];

		// Find median
		if (total % 2 == 1) {
			return merged[total / 2];
		} else {
			return (merged[total / 2 - 1] + merged[total / 2]) / 2.0;
		}
	}
	public static void main(String[] args) {
		MedianTwoSortedArrays sol = new MedianTwoSortedArrays();
		System.out.println(sol.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 })); // 2.0
		System.out.println(sol.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 })); // 2.5
	}

}
