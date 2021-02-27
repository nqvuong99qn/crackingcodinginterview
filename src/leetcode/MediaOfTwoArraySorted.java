package leetcode;


public class MediaOfTwoArraySorted {
	
	int solution(int[] arr1, int[] arr2) {
		
		// merge two array
		int len1 = arr1.length;
		int len2 = arr2.length;
		
		int[] temp = new int[len1 + len2];
		
		int a1 = 0;
		int a2 = 0;
		int i = 0;
		while(a1 < len1 && a2 < len2) {
			if(arr1[a1] < arr2[a2]) {
				temp[i++] = arr1[a1++];
			}
			else {
				temp[i++] = arr2[a2++];
			}
		}
		while(a1 < len1) {
			temp[i++] = arr1[a1++];
		}
		while(a2 < len2) {
			temp[i++] = arr2[a2++];
		}
		
		if((len1 + len2) % 2 == 1) {
			return temp[(len1 + len2) / 2];
		}
		else return (temp[(len1 + len2)/2] + temp[(len1 + len2)/2 - 1]) / 2;
		
		
	}
	
	public double solution2(int[] nums1, int[] nums2) {
		
		// merge two list;
		int[] newArr = new int[nums1.length + nums2.length];
		
		int i = 0;
		int j = 0;
		int id = 0;
		while( i < nums1.length && j < nums2.length) {
			newArr[id++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
		}
		while( i < nums1.length) {
			newArr[id++] = nums1[i++];
		}
		while( j < nums2.length) {
			newArr[id++] = nums2[j++];
		}
		
		if((nums1.length + nums2.length) % 2 != 0)
			return newArr[(nums1.length + nums2.length) /2];
	
		return (newArr[(nums1.length + nums2.length) /2] +
				newArr[(nums1.length + nums2.length) /2 - 1]) / 2;
	}
	
	public static void main(String args) {
		
		System.out.println("Sayhi!!!");

		MediaOfTwoArraySorted test = new MediaOfTwoArraySorted();
		
		int[] a1 = {1, 2, 3, 4};
		int[] a2 = { 5, 6, 7};
		
		
		System.out.println("Expected result: " + test.solution(a1, a2));
		
		
	}

}
