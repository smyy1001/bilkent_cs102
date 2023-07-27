

class sortMethods {
    //**Selection Sort*/
    // choosing the min or max and moving it to the beginning (easiest sorting method)
    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < arr.length; j++) { 
                if (arr[j] < arr[min_idx]) {min_idx = j;}
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    //**Merge Sort*/
    // consider the first item to be a sorted sublist (of one item) insert the second 
    // item into the sorted sublist, 
    // shifting the first item as needed to make room to 
    // insert the new addition
    private static void mergeSort(int[] arr) {
        int lenght = arr.length;
        if(lenght < 2) {return;}
        int midindex = lenght/2;
        int[] right = new int[midindex];
        int[] left = new int[lenght - midindex];
        for(int i = 0; i < right.length; i++) {
            right[i] = arr[i];
        }
        for(int i = right.length; i < arr.length; i++) {
            left[i-right.length] = arr[i];
        }
        mergeSort(right);
        mergeSort(left);
        merge(arr, right, left);
    }
    private static void merge(int[] result, int[] right, int[] left) {
        int rightLenght = right.length;
        int leftLenght = left.length;
        int a=0,b=0,c=0;
        while(a<rightLenght && b<leftLenght) {
            if(right[a]<=left[b]) {
                result[c] = right[a];
                a++;
            }
            else { result[c] = left[b]; b++; }
            c++;
        }
        while( a < rightLenght ) {
            result[c] = right[a];
            a++;
            c++;
        }
        while( b < leftLenght ) {
            result[c] = left[b];
            b++;
            c++;
        }
    }

    //**Quick Sort*/
    // Select a pivot (partitioning element)
    // Rearrange the list so that all the elements in the 
    // positions before the pivot are smaller than or equal to the 
    // pivot and those after the pivot are larger than the pivot 
    // Exchange the pivot with the last element in the first (i.e., ≤) sub list
    // the pivot is now in its final position
    // Sort the two sub lists recursively
    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if(lowIndex >= highIndex) {return;}
        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        while( leftPointer < rightPointer ) {
            while( arr[leftPointer] <= pivot && rightPointer > leftPointer ) {
                leftPointer++;
            }
            while( arr[rightPointer] >= pivot && rightPointer > leftPointer ) {
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, highIndex);
        quickSort(arr, lowIndex, leftPointer-1);
        quickSort(arr, leftPointer+1, highIndex);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    //**Bubble Sort*/
    // checking and sorting by small groups of two
    private static void bubbleSort(int[] arr) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    //**Insertion Sort*/
    // accepting the first as a start and going through the array and inserting all others either to the 
    // right ot left of the first number
    private static void insertionSort(int[] arr) {
        for(int i = 1; i<arr.length; i++) {
            int current = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > current) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }
}