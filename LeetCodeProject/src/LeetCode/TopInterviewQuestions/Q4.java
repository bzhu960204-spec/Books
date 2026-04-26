package LeetCode.TopInterviewQuestions;

public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int length = (nums1.length + nums2.length) / 2 + 1;
        int[] mergeArray = new int[(nums1.length + nums2.length) / 2 + 1];
        int index1 = 0;
        int index2 = 0;
        int mergeIndex = 0;
        while (mergeIndex < mergeArray.length) {

            if (index1 == nums1.length) {
                mergeArray[mergeIndex] = nums2[index2];
                mergeIndex++;
                index2++;
                continue;
            } else if (index2 == nums2.length) {
                mergeArray[mergeIndex] = nums1[index1];
                mergeIndex++;
                index1++;
                continue;
            }

            if (nums1[index1] > nums2[index2]) {
                mergeArray[mergeIndex] = nums2[index2];
                mergeIndex++;
                index2++;
            } else {
                mergeArray[mergeIndex] = nums1[index1];
                mergeIndex++;
                index1++;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 1) {
            return mergeArray[mergeArray.length - 1];
        } else {
            return (double)(mergeArray[mergeArray.length - 1] + mergeArray[mergeArray.length - 2]) / 2;
        }

    }

    public static void main(String[] args) {
        int[] array1 = new int[]{};
        int[] array2 = new int[]{1};
        Q4 q4 = new Q4();
        System.out.println(q4.findMedianSortedArrays(array1, array2));
    }
}
