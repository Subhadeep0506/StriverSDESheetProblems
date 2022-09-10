package sdesheet.Day08;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        int currWeight = 0;
        double currValue = 0;

        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double rate1 = (double) item1.value / item1.weight;
                double rate2 = (double) item2.value / item2.weight;
                if (rate1 < rate2)
                    return 1;
                if (rate1 > rate2)
                    return -1;
                return 0;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (currWeight + arr[i].weight <= W) {
                currValue += arr[i].value;
                currWeight += arr[i].weight;
            }
            else {
                currWeight = W - currWeight;
                currValue += ((double) arr[i].value / arr[i].weight) * currWeight;
                break;
            }
        }
        return currValue;
    }
}