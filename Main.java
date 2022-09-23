import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Tree tree=new Tree();
        Scanner scan = new Scanner(System.in);
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<10;i++){
            tree.addLeaf(scan.nextInt());
        }


        tree.outTree(tree.isMax());


    }
}
