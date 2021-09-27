package com.company;

import java.util.Comparator;

public class HuffmanComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {
if (x.frequency== y.frequency){
    if (y.left == null&& x.left !=null||y.right == null&& x.right !=null){
        return 1;
    }
}
        return x.frequency-y.frequency;

}
}
