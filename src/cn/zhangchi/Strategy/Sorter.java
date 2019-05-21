package cn.zhangchi.Strategy;

import java.util.Comparator;

public class Sorter<T> {

    // selection sort
    public void sort(T[] arr, Comparator<T> comparator){
        for(int i=0;i<arr.length;i++){
            int minPos = i;
            for(int j=i;j<arr.length;j++){
                minPos = comparator.compare(arr[minPos],arr[j]) == 1? j:minPos;
            }
            swap(arr,i,minPos);
        }
    }

    public void swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
