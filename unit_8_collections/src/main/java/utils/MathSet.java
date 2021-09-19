package utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Arrays;


public class MathSet<Numbers extends Number & Comparable<Numbers>> {
    private final int SIZE = 10;
    private int capacity=0;
    private Numbers[] numbers;

    public MathSet() {
        numbers = (Numbers[]) new Number[SIZE];
    }

    public MathSet(int capacity) {
    this.capacity=capacity;
        numbers = (Numbers[]) new Number[capacity];
    }

    public MathSet(Number[] n) {
        this.numbers = (Numbers[]) new Number[n.length];
        for (Number number : n) {
            add(number);
        }
    }

    public MathSet(Number[]... numbers) {
        for (Number[]  n : numbers) {
            for (Number number : n) {
                this.add(number);
            }
        }
    }

    public MathSet(MathSet nums) {
        numbers = (Numbers[]) new Number[nums.capacity];
        for (int i = 0; i < nums.capacity; i++) {
            add((Numbers) numbers[i]);
        }
    }

    public MathSet(MathSet... nums) {
        for(MathSet n: nums){
            for(int i=0;i< n.capacity;i++){
                add(n.get(i));
            }
        }
    }

    public void add(Numbers n) {
        if (!containsDuplicate(n)) {
            if (numbers.length == capacity) {
                int newLength = numbers.length + (numbers.length + 1);
                Numbers[] newNumbers = (Numbers[])  new Number[newLength];
                int index = 0;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] != null) {
                        newNumbers[index] = numbers[i];
                        index++;
                    }
                }
                numbers = newNumbers;
                capacity = index;
            }
            numbers[capacity] = n;
            capacity++;
        }
    }

    public boolean containsDuplicate(Number n) {
        for (int i = 0; i < capacity; i++) {
            if (numbers[i] == n) return true;
        }
        return false;
    }

    public void add(Number... n) {
        for (int i = 0; i < n.length; i++) {
            add(n[i]);
        }
    }

    public void join(MathSet ms) {
        Numbers[] set = (Numbers[]) ms.toArray();
        this.add(set);
    }

    public void join(MathSet... ms) {
        for (MathSet m : ms) {
            this.join(m);
        }
    }

    public void intersection(MathSet ms) {
        for(int i=0;i<capacity;i++){
            Numbers[]copied= (Numbers[]) new Number[capacity];
            System.arraycopy(this.numbers, 0, copied, 0, capacity);
            clear();
            for (Numbers n : copied) {
                if (contains(ms.numbers, ms.capacity, n)) {
                    add(n);
                }
            }
        }
    }

    private boolean contains(Number[] numbers, int capacity, Numbers n) {
        for (int i = 0; i < capacity; i++) {
            if (numbers[i].equals(n)) return true;
        }
        return false;
    }

    public void intersection(MathSet... ms) {
        for (MathSet mathSet : ms) {
            intersection(mathSet);
        }
    }

    public void sortDesc() {
        sortDesc(0, capacity);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if ((lastIndex - firstIndex) > 0) {
            for (int i = firstIndex; i < lastIndex - 1; i++) {
                for (int j = i + 1; j < lastIndex; j++) {
                    if ((numbers[i].compareTo(numbers[j]) < 0)) {
                        Numbers temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                    }
                }
            }
        }
    }

    public void sortDesc(Number value) {
sortDesc(value.intValue(),capacity);
    }

    public void sortAsc() {
        sortAsc(0, capacity);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if ((lastIndex - firstIndex) > 0) {
            for (int i = firstIndex; i < lastIndex - 1; i++) {
                for (int j = i + 1; j < lastIndex; j++) {
                    if (numbers[i].compareTo(numbers[j]) > 0) {
                        Numbers temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                    }
                }
            }
        }
    }

    public void sortAsc(Number value) {
        sortAsc(value.intValue(), capacity);
    }

    public Numbers get(int index) {
        if (index < 0 || index > capacity)
            throw new IllegalArgumentException("Incorrect index");
        return numbers[index];
    }

    public Number getMax() {
        Numbers max=get(0);
        for(int i=1;i<capacity;i++){
            if(numbers[i].compareTo(max) > 0){
                max=numbers[i];
            }
        }
        return max;
    }

    public Number getMin() {
        Numbers min = numbers[0];
        for (int i = 1; i < capacity; i++) {
            if (numbers[i].compareTo(min) < 0) min = numbers[i];
        }
        return min;
    }

    public double getAverage() {
        BigDecimal sum=BigDecimal.valueOf(numbers[0].doubleValue());
        for (int i=1;i<capacity;i++){
            sum=sum.add(BigDecimal.valueOf(numbers[i].doubleValue()));
        }
        sum=sum.divide(BigDecimal.valueOf(capacity));
        return sum.doubleValue();
    }

    public Number getMedian() {
        return get(capacity/2);
    }

    public Number[] toArray() {
        return numbers;
    }

    public Number[] toArray(int firstIndex, int lastIndex) {
        if (!(firstIndex < 0 || firstIndex > capacity) &&
            !(lastIndex < 0 || lastIndex > capacity)  &&
            !(firstIndex > lastIndex)) {
            return (Number[]) Arrays.copyOfRange(numbers, firstIndex, lastIndex + 1);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public MathSet cut(int firstIndex, int lastIndex) {
        MathSet<Numbers> cut = new MathSet<>();
        for (int i = 0; i < capacity; i++) {
            if (i >= firstIndex && i <= lastIndex) cut.add(numbers[i]);
        }
        return cut;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            numbers[i] = null;
        }
        capacity = 0;
    }

    public int getCapacity(){ return capacity;}
   public void clear(Number[] nums) {
       for (Number number : nums) {
           for (int i = 0; i < capacity; i++) {
               if (number.equals(numbers[i])) {
                   for (int j = i; j < capacity; j++) {
                       numbers[j] = numbers[j + 1];
                       numbers[j + 1] = null;
                   }
                   capacity--;
               }
           }
       }
    }
}
