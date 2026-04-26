package LeetCode.TopInterviewQuestions;

public class Q11 {
    /*
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).


    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.
    */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; (i + j) < height.length; j++) {
                if (height[j] < height[i + j]) {
                    if (height[j] * i > maxArea) maxArea = height[j] * i;
                } else {
                    if (height[i + j] * i > maxArea) maxArea = height[i + j] * i;
                }
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        for (int k = leftIndex; k < height.length - 1; k++) {
            if (k != leftIndex && height[k] <= height[leftIndex]) {
                continue;
            } else {
                leftIndex = k;
            }
            for (int i = height.length - 1; i > leftIndex; i--) {
                if (height[i] >= height[leftIndex] && (height[leftIndex] * (i - leftIndex)) > maxArea) {
                    maxArea = height[leftIndex] * (i - leftIndex);
                    break;
                }
            }
        }
        for (int k = rightIndex; k > 0; k--) {
            if (k != rightIndex && height[k] <= height[rightIndex]) {
                continue;
            } else {
                rightIndex = k;
            }
            for (int i = 0; i < rightIndex; i++) {
                if (height[i] >= height[rightIndex] && (height[rightIndex] * (rightIndex - i)) > maxArea) {
                    maxArea = height[rightIndex] * (rightIndex - i);
                    break;
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Q11 q11 = new Q11();
        int[] inputArray = new int[]{2,1};
        System.out.println(q11.maxArea1(inputArray));
        System.out.println(q11.maxArea2(inputArray));
    }
}
