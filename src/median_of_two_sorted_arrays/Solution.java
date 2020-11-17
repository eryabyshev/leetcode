package median_of_two_sorted_arrays;

public class Solution {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length == 0) {
            return getMedian(nums2);
        } else if (nums2.length == 0) {
            return getMedian(nums1);
        }
        return getMedian(mergeArray(nums1, nums2));
    }

    private static int[] mergeArray(int[] nums1, int[] nums2) {
        int[] commonArray = new int[nums1.length + nums2.length];
        for(int c = 0, f = 0, s = 0; c < commonArray.length; c++) {

            if(f > nums1.length - 1) {
                commonArray[c] = nums2[s++];
            }

            else if(s > nums2.length - 1) {
                commonArray[c] = nums1[f++];
            }

            else if (nums1[f] > nums2[s]) {
                commonArray[c] = nums2[s++];
            }
            else {
                commonArray[c] = nums1[f++];
            }
        }
        return commonArray;
    }

    private static double getMedian(int[] ar) {
        if(ar.length % 2 == 0) {
            return (double)(ar[(ar.length / 2) - 1] + ar[ar.length/2]) / 2;
        }
        return ar[ar.length/2];
    }


    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[] {2, 3, 4}));
    }

}
