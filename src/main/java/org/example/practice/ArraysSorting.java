package org.example.practice;

import java.util.stream.Stream;

public class ArraysSorting {


    public static void arrayBubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int k = 0; k < a.length; k++) {
            System.out.println(a[k]);
        }
    }

    public static void selectionSort(int[] a) {
        //compare the element one by one and replace it.
        //in selction sort we frist get the min value of index
        //in second loop we conpare that index value with second loop value.
        //if value found to less then we replace the element using index direct.
        //time O(n^2)
        for (int i = 0; i < a.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minValueIndex]) {
                    minValueIndex = j;
                }
            }
            if (minValueIndex != i) {
                int temp = a[i];
                a[i] = a[minValueIndex];
                a[minValueIndex] = temp;
            }
        }
        for (int k = 0; k < a.length; k++) {
            System.out.println(a[k]);
        }
    }

    // 28 may    06 06 2024     // document  module controllof schedule 6  20
    public static void insertionSort(int[] a) {
        //two parts we have to make sorted and unsorted
        //take first element and compare it the second element if it is bigger then move that element in sorted area.

        for (int i = 1; i < a.length; i++) {
            int key = a[i];   // it is assume  that 1st element is sorted.
            int j = 0;

            for (j = i - 1; j >= 0; j--) {  // j will run behind i
                if (a[j]> key) {
                    a[j + 1] = a[j];  // if i=1  j= 0  then a[j+1(0+1)]  a[1] >key    then a[1] = key
                } else {
                    break;
                }
            }
            a[j + 1] = key;
        }
        for (int number : a) {
            System.out.println(number);
        }
    }


    public static void insertionSort1(int[] a){

        for(int  i = 1 ; i <a.length ;i++){
            int key = a[i];
            int j = i-1;

            while( j>=0 && a[j]> key  ){
                a[j+1] = a[j] ;
                j--;
            }
            a[j+1] = key;
        }

        for (int number : a) {
            System.out.println(number);
        }
    }

    public static void findTheMaximnumAndMin(int[] a){

        // int maxValue=  Integer.MIN_VALUE;
        // int minValue=  Integer.MAX_VALUE;


        // for(int  i=0 ;i<a.length ; i++){
        //     maxValue =Math.max(maxValue,a[i]);
        //     minValue=Math.min(minValue,a[i]);
        // }

        // System.out.println(maxValue +"maxValue");
        // System.out.println(minValue +"min value ");
        int min ,max,i;
        if(a.length %2==0){
            if(a[0]>a[1]){
                max=a[0];
                min=a[1];
            }else{
                max =a[1];
                min=a[0];
            }i=2;
        }else{
            max = min =a[0];i=1;
        }

        while(i<a.length-1){
            if(a[i]>a[i+1]){
                if(max<a[i])max =a[i];
                if(min>a[i+1]) min = a[i+1];
            }else{
                 if(max<a[i+1])max =a[i+1];
                if(min>a[i]) min = a[i];
            }
            i =i+2;
        }
        
        System.out.println(max + " max value");
        System.out.println(min + "min value");
    }


    public static void reverseAnArraysInPlace(int a[]){
        int  temp=0,i=0;
        while(i < a.length/2){
            temp =  a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=temp;
            i=i+1;       
    }
        for(int j : a){
        System.out.println(j);
        }
}

public static void rotateTheArrayInPlaceAtKthPosition(int a[],int k){
    helperMethodToRotaterArray(a,0,a.length-1);
    helperMethodToRotaterArray(a,0,k-1);
    helperMethodToRotaterArray(a, k, a.length-1);
    for(int j : a){
        System.out.println(j +" <--inplace");
    }
}

public static void helperMethodToRotaterArray(int a[],int start, int end){
    int temp =0;
    while(start<end){
        temp =  a[start];
        a[start] = a[end];
        a[end]=temp;
        start++;
        end--;
    } 
}


}
