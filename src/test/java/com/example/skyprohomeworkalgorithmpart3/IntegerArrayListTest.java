package com.example.skyprohomeworkalgorithmpart3;


import com.example.skyprohomeworkalgorithmpart3.exception.NoSuchIndexException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerArrayListTest {

    private final IntegerArrayList integerArrayList = new IntegerArrayList(3);

    @BeforeEach
    public void beforeEach() {
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
    }

    @AfterEach
    public void afterEach() {
        integerArrayList.clear();
    }

    @Test
    public void addTest() {
        Assertions.assertThat(integerArrayList.add(4)).isEqualTo(4);
    }

    @Test
    public void addArgumentNullTest() {
        Assertions.assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> integerArrayList.add(null));
    }

    @Test
    public void addStringArrayListIsFullTest() {
        Integer[] newArray = {1, 4, 2, 3, null, null};
        integerArrayList.add(1, 4);
        Assertions.assertThat(integerArrayList.getIntegerArrayList()).isEqualTo(newArray);
    }

    @Test
    public void addIndexTest() {
        Assertions.assertThat(integerArrayList.add(1,4)).isEqualTo(4);
    }

    @Test
    public void addIndexArgumentStringNullTest() {
        Assertions.assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> integerArrayList.add(2,null));
    }

    @Test
    public void addIndexMoreThenSizeOrLengthTest() {
        Assertions.assertThatExceptionOfType(NoSuchIndexException.class).isThrownBy(() -> integerArrayList.add(5,4));
    }

    @Test
    public void addIndexIntegerArrayListIsFullTest() {
        Integer[] newArray = {1, 4, 2, 3, null, null};
        integerArrayList.add(1, 4);
        Assertions.assertThat(integerArrayList.getIntegerArrayList()).isEqualTo(newArray);
    }

    @Test
    public void setTest() {
        Assertions.assertThat(integerArrayList.set(1, 4)).isEqualTo(4);
    }

    @Test
    public void setArgumentStringNullTest() {
        Assertions.assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> integerArrayList.set(1,null));
    }

    @Test
    public void setMoreThenSizeOrLengthTest() {
        Assertions.assertThatExceptionOfType(NoSuchIndexException.class).isThrownBy(() -> integerArrayList.add(5,4));
    }

    @Test
    public void removeTest() {
        Assertions.assertThat(integerArrayList.remove(2)).isEqualTo(3);
    }


    @Test
    public void removeIndexTest() {
        Assertions.assertThat(integerArrayList.remove(2)).isEqualTo(3);
    }

    @Test
    public void removeIndexMoreThenSizeOrLengthTest() {
        Assertions.assertThatExceptionOfType(NoSuchIndexException.class).isThrownBy(() -> integerArrayList.remove(5));
    }

    @Test
    public void containsTest() {
        Assertions.assertThat(integerArrayList.contains(2)).isTrue();
    }

    @Test
    public void containsNoTest() {
        Assertions.assertThat(integerArrayList.contains(4)).isFalse();
    }

    @Test
    public void indexOfTest() {
        Assertions.assertThat(integerArrayList.indexOf(3)).isEqualTo(2);
    }

    @Test
    public void lastIndexOfTest() {
        integerArrayList.add(1);
        Assertions.assertThat(integerArrayList.lastIndexOf(1)).isEqualTo(3);
    }

    @Test
    public void getTest() {
        Assertions.assertThat(integerArrayList.get(0)).isEqualTo(1);
    }

    @Test
    public void getNoSuchIndexTest() {
        Assertions.assertThatExceptionOfType(NoSuchIndexException.class).isThrownBy(() -> integerArrayList.get(7));
    }

    @Test
    public void equalsTest() {
        IntegerArrayList newArray = new IntegerArrayList(3);
        newArray.add(1);
        newArray.add(2);
        newArray.add(3);

        Assertions.assertThat(integerArrayList.equals(newArray)).isTrue();
    }

    @Test
    public void sizeTest() {
        Assertions.assertThat(integerArrayList.size()).isEqualTo(3);
    }

    @Test
    public void isEmptyTest() {
        integerArrayList.clear();
        Assertions.assertThat(integerArrayList.isEmpty()).isTrue();
    }

    @Test
    public void isNoEmptyTest() {
        Assertions.assertThat(integerArrayList.isEmpty()).isFalse();
    }

    @Test
    public void clearTest() {
        Assertions.assertThat(integerArrayList.isEmpty()).isFalse();
        integerArrayList.clear();
        Assertions.assertThat(integerArrayList.isEmpty()).isTrue();
    }

    @Test
    public void toArrayTest() {
        Assertions.assertThat(integerArrayList.toArray()).isEqualTo(integerArrayList.getIntegerArrayList());
    }

    @Test
    public void isArrayFullTest() {
        Assertions.assertThat(integerArrayList.isArrayFull()).isTrue();
    }

    @Test
    public void isArrayNoFullTest() {
        integerArrayList.add(4);
        Assertions.assertThat(integerArrayList.isArrayFull()).isFalse();
    }

    @Test
    public void increasedStringArrayList() {
        Assertions.assertThat(integerArrayList.getIntegerArrayList().length).isEqualTo(3);
        integerArrayList.increasedStringArrayList();
        Assertions.assertThat(integerArrayList.getIntegerArrayList().length).isEqualTo(6);
    }

    @Test
    public void moveElementsToTheRightTest() {
        Assertions.assertThat(integerArrayList.get(1)).isEqualTo(2);
        integerArrayList.moveElementsToTheRight(0);
        Assertions.assertThat(integerArrayList.get(2)).isEqualTo(2);
    }

    @Test
    public void moveElementsToTheLeftTest() {
        Assertions.assertThat(integerArrayList.get(2)).isEqualTo(3);
        integerArrayList.moveElementsToTheLeft(1);
        Assertions.assertThat(integerArrayList.get(1)).isEqualTo(3);
    }

    @Test
    public void sortTest() {
        integerArrayList.add(0, 99);
        integerArrayList.add(1, 14);
        integerArrayList.add(2, 8);

        Assertions.assertThat(integerArrayList.toArray()).isEqualTo(new Integer[]{99, 14, 8, 1, 2, 3});
        integerArrayList.sort(integerArrayList.getIntegerArrayList());
        Assertions.assertThat(integerArrayList.toArray()).isEqualTo(new Integer[]{1, 2, 3, 8, 14, 99});
    }




















}
