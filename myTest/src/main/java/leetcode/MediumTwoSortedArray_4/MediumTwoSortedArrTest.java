package leetcode.MediumTwoSortedArray_4;

public class MediumTwoSortedArrTest {
    public static void main(String[] args) {
        int[] s1 = {1,2,4,5};
        int[] s2 = {1,2,3,4};
        double s = new MediumTwoSortedArr().findMedianSortedArrays(s1,s2);
        System.out.println(s);
    }
}
