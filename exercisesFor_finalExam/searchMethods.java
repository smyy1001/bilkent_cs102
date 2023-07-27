
public class searchMethods {

    //**Linear Search*/
    // visiting each element one by one until the method finds the wanted value
    private static int linearSearch(int[] arr, int find) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == find) {return i;}
        }
        return -1;
    }
    
    //**Binary Search*/ (recursive binary search)
    // works ONLY with sorted arrays!
    // checks the mid point and decides wether to check the right side or the left side
    private static int binarySearch(int[] arr, int find) {
        if(arr[arr.length/2] > find) {
            int[] right = new int[arr.length/2];
            for(int i = 0; i < arr.length/2; i++) {
                right[i] = arr[i];
            }
            return binarySearch(right, find);
        }
        else if( arr[arr.length/2] < find ) {
            int[] left = new int[arr.length - arr.length/2];
            for(int i = arr.length/2; i < arr.length; i++) {
                left[ i- arr.length/2] = arr[i];
            }
            return binarySearch(left, find);
        }
        return arr.length/2;
    }

}
