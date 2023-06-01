package com.example.skyprohomeworkalgorithmpart3;



import com.example.skyprohomeworkalgorithmpart3.exception.ElementNotFoundException;
import com.example.skyprohomeworkalgorithmpart3.exception.NoSuchIndexException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerArrayList implements IntegerList {

    private Integer[] integerArrayList;

    public IntegerArrayList(int size) {
        integerArrayList = new Integer[size];
    }

    public Integer[] getIntegerArrayList() {
        return integerArrayList;
    }


    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NullPointerException("String is null");
        }
        if (isArrayFull()) {
            increasedStringArrayList();
        }
        for (int i = 0; i < integerArrayList.length; i++) {
            if (integerArrayList[i] == null) {
                integerArrayList[i] = item;
                break;
            }
        }
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index >= integerArrayList.length || index >= size()) {
            throw new NoSuchIndexException("Index is more then array's length");
        }
        if (item == null) {
            throw new NullPointerException("Integer is null");
        }
        if (isArrayFull()) {
            increasedStringArrayList();
        }
        moveElementsToTheRight(index);
        integerArrayList[index] = item;
        return item;
    }


    @Override
    public Integer set(int index, Integer item) {
        if (index >= integerArrayList.length || index >= size()) {
            throw new NoSuchIndexException("Index is more then array's length or array's size");
        }
        if (item == null) {
            throw new NullPointerException("Integer is null");
        }
        integerArrayList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int index = 0;
        if (contains(item)) {
            for (int i = 0; i < size(); i++) {
                if (integerArrayList[i] == item) {
                    index = i;
                    integerArrayList[i] = null;
                }
            }
            moveElementsToTheLeft(index);
        } else {
            throw new ElementNotFoundException();
        }
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index >= size()) {
            throw new NoSuchIndexException("Index is more then array's size");
        }
        Integer result = integerArrayList[index];
        integerArrayList[index] = null;
        moveElementsToTheLeft(index);
        return result;
    }

    @Override
    public boolean contains(Integer item) {
        sort(integerArrayList, integerArrayList[0], integerArrayList[integerArrayList.length - 1]);
        return binarySearch(integerArrayList, item);
    }

    @Override
    public int indexOf(Integer item) {
        int result = -1;
        for (int i = 0; i < size(); i++) {
            if (integerArrayList[i] == item) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int result = -1;
        for (int i = (size() - 1); i > 0; i--) {
            if (integerArrayList[i] == item) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer get(int index) {
        if (index >= size()) {
            throw new NoSuchIndexException("Index is more then array's size");
        }
        return integerArrayList[index];
    }

    @Override
    public boolean equals(IntegerArrayList otherList) {

        if (this.getIntegerArrayList() == otherList.getIntegerArrayList())
            return true;
        if (this.getIntegerArrayList() == null || otherList.getIntegerArrayList() == null)
            return false;

        int length = this.getIntegerArrayList().length;
        if (otherList.getIntegerArrayList().length != length)
            return false;

        for (int i = 0; i < length; i++) {
            if (!Objects.equals(this.getIntegerArrayList()[i], otherList.getIntegerArrayList()[i]))
                return false;
        }
        return true;
    }

    @Override
    public int size() {
        return (int) Arrays.stream(integerArrayList).filter(e -> e != null).count();
    }

    @Override
    public boolean isEmpty() {
        boolean result = false;
        if (size() == 0) {
            result = true;
        }
        return result;
    }

    @Override
    public void clear() {
        integerArrayList = Arrays.stream(integerArrayList).map(e -> e = null).toArray(Integer[]::new);
    }

    @Override
    public Integer[] toArray() {
        Integer[] newArray = integerArrayList.clone();
        return newArray;
    }

    @Override
    public void sort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            sort(arr, begin, partitionIndex - 1);
            sort(arr, partitionIndex + 1, end);
        }
    }




    public void increasedStringArrayList() {
        int length = integerArrayList.length;
        double increase = 1.5;
        double newLength = increase * length;
        Integer[] newArray = new Integer[(int)newLength];
        System.arraycopy(integerArrayList, 0, newArray, 0, integerArrayList.length);
        integerArrayList = newArray;
    }

    public void moveElementsToTheRight(int index) {
        for (int i = integerArrayList.length - 1; i > index; i--) {
            integerArrayList[i] = integerArrayList[i - 1];
        }
    }


    public void moveElementsToTheLeft(int index) {
        for (int i = index; i < size(); i++) {
            integerArrayList[i] = integerArrayList[i + 1];
            integerArrayList[i + 1] = null;
        }
    }

    private boolean binarySearch(Integer[] arr, Integer element) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (element == arr[mid]) {
                return true;
            }
            if (element < arr[mid]) {
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }
        return false;
    }

    private boolean isArrayFull() {
        long countNull = Arrays.stream(integerArrayList).filter(e -> e == null).count();
        if (countNull > 0) {
            return false;
        }
        return true;
    }


    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }



}
