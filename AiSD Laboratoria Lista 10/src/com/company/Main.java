package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	Operations operations = new Operations();
	HuffmanNode[] nodes = operations.createAlphabetArray();
	String fileName = operations.scan();


    List<Character> list = operations.readAndSaveFrequency(fileName);
    String fileContent = operations.getFileString(fileName);
    nodes = operations.assignFrequences(list, nodes);
    ArrayList<HuffmanNode> arrayList = operations.sortNodes(nodes);


    System.out.println(arrayList);
    ExpressionTree expressionTree = new ExpressionTree();
    expressionTree.constructTree(arrayList);
    System.out.println(expressionTree.root);
    operations.printCode(expressionTree.root, "");
    System.out.println(expressionTree.root.binaryCode);
    expressionTree.codeIntoBinary(fileContent, expressionTree.root, "fileCodedBinary");
    String binaryCodeToDecipher = operations.printACommand();
    System.out.println();
    expressionTree.decodeBinary(binaryCodeToDecipher, expressionTree.transferTreeIntoArrayList(expressionTree.root));

    }
}
