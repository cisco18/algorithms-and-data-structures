package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ExpressionTree {
    HuffmanNode root;

    public char[] changeToChars(String string) {

        return string.toCharArray();
    }


    public void constructTree(ArrayList<HuffmanNode> arrayList) {
        PriorityQueue<HuffmanNode> queue
                = new PriorityQueue<HuffmanNode>(arrayList.size(), new HuffmanComparator());
        arrayList.sort(new HuffmanComparator());
        for (HuffmanNode huffmanNode: arrayList){
            if (huffmanNode.frequency>0){
                queue.add(huffmanNode);
            }
        }
        int i = 1;
        while (queue.size() > 1) {

            HuffmanNode huffmanNodeA = queue.poll();

            if (queue.peek()==null){

            }
            HuffmanNode huffmanNodeB = queue.poll();

            HuffmanNode huffmanNodeC = new HuffmanNode('#');
            assert huffmanNodeB != null;
            huffmanNodeC.setFrequency(huffmanNodeA.frequency + huffmanNodeB.frequency);

            if (huffmanNodeA.frequency > huffmanNodeB.frequency) {
                if (huffmanNodeB.frequency > 0)
                    huffmanNodeC.left = huffmanNodeB;
                huffmanNodeC.right = huffmanNodeA;

            }
            if (huffmanNodeA.frequency < huffmanNodeB.frequency) {
                huffmanNodeC.right = huffmanNodeB;
                if (huffmanNodeA.frequency > 0)
                    huffmanNodeC.left = huffmanNodeA;

            }
            if (huffmanNodeA.frequency == huffmanNodeB.frequency) {
                if (huffmanNodeA.frequency > 0) {
                    huffmanNodeC.right = huffmanNodeA;
                    huffmanNodeC.left = huffmanNodeB;
                }
            }
            queue.add(huffmanNodeC);
        }
        root = queue.poll();

    }

    int getLeafCount() {
        return getLeafCount(root);
    }

    int getLeafCount(HuffmanNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }

    int findHeight() {
        return findHeight(root);
    }

    public char integerToCharacter(int integer) {
        String string1 = String.valueOf(integer);
        return string1.charAt(0);

    }

    int findHeight(HuffmanNode node) {
        if (node == null) {
            return -1;
        }

        int leftH = findHeight(node.left);
        int rightH = findHeight(node.right);

        if (leftH > rightH) {
            return leftH + 1;
        } else {
            return rightH + 1;
        }
    }

    int getNodeCount() {
        return getNodeCount(root);
    }

    int getNodeCount(HuffmanNode node) {
        if (node == null) {
            return 0;
        } else return getNodeCount(node.left) + getNodeCount(node.right) + 1;
    }

    public void codeIntoBinary(String string, HuffmanNode root, String nameOfFile) {
            File file = new File(nameOfFile);
            StringBuilder stringBuilder = new StringBuilder();
        char[] chars = string.toCharArray();
        for (char character : chars) {
            codeRecursive(character, root, stringBuilder);
        }
        try(FileWriter writer = new FileWriter(nameOfFile)){
        writer.write(stringBuilder.toString());
        writer.write("\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    private void codeRecursive(char c, HuffmanNode root, StringBuilder stringBuilder) {

        if (c == root.character) {
            System.out.print(root.binaryCode);
            stringBuilder.append(root.binaryCode);

        } else {
            if (root.left != null)
                codeRecursive(c, root.left, stringBuilder);
            if (root.right != null)
                codeRecursive(c, root.right, stringBuilder);
        }
    }

    public ArrayList<HuffmanNode> transferTreeIntoArrayList(HuffmanNode root) {
        ArrayList<HuffmanNode> arrayList = new ArrayList<>();
        addRecursive(root, arrayList);
        return arrayList;
    }

    private void addRecursive(HuffmanNode root, ArrayList<HuffmanNode> arrayList) {
        arrayList.add(root);
        if (root.left != null) {
            addRecursive(root.left, arrayList);
        }
        if (root.right != null) {
            addRecursive(root.right, arrayList);
        }
    }

    public void decodeBinary(String string, ArrayList<HuffmanNode> arrayList) {
        char[] chars = string.toCharArray();
        StringBuilder s = new StringBuilder();
        int i = 0;
        boolean done = false;
        System.out.println();
        while (!done){

            for (HuffmanNode node:arrayList){
                if (s.toString().equals("")){
                    if (i<chars.length) {
                        s.append(chars[i]);
                        i++;
                    }
                }
                if (s.toString().equals(node.binaryCode)){
                    if (node.character!='#')
                    System.out.print(node.character);
                    s.delete(0,s.length());
                }
            }
            if (i<chars.length){
                s.append(chars[i]);
            }
            i++;
            if (i>chars.length){
                done=true;
            }


        }

    }
}