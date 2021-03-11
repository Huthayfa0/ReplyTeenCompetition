package Competition2021;


import java.io.*;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class B{

    static File fileInput = null;
    static File fileOutput = null;
    static Scanner input = null;
    static FileWriter output = null;

    static String[] all = null;
    static int T = 0;
    static int N = 0;
    static int K = 0;
    static int[] array;
    static int num = 1;

    public static void main (String[] args) throws IOException{


        read("src/Competition2021/BInput/A.in");

    }


    public static void read(String source)throws IOException {

        fileInput = new File(source);


        try {
            input = new Scanner(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        T = Integer.parseInt(input.nextLine());



        while(T-->0){

            all = input.nextLine().split(" ");
            N = Integer.parseInt(all[0]);
            K = Integer.parseInt(all[1]);

            all =  input.nextLine().split(" ");
            array = new int[N];
            for (int i = 0 ; i < N ; i++)
                array[i] = Integer.parseInt(all[i]);

            print("src/Competition2021/Boutput/A.txt");
        }



        input.close();




    }

    public static void print(String source) throws IOException{
        fileOutput = new File(source);
        try {
            output = new FileWriter(fileOutput,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HashMap<Integer, Integer> change = new HashMap<>(N);

        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++){
            arr1[i] = i;
            change.put(i, i);
        }


/*
1
5 2
array = 0 4 3 1 2


arr1 = 0 1 2 3 4

0 3 4 2 1

0 2 1 4 3

 */



        for (int j = 0; j < K; j++){




            for (int i= 0; i < N ; i++)
                change.replace(array[i], arr1[i]);



            for (int i= 0; i < N ; i++)
                arr1[i] = change.get(i);

        }








        output.write("Case #" + num+": ");
        num++;
        for (int i= 0; i < N ; i++)
            output.write(change.get(i) + " ");

        output.write("\n");


        output.close();


    }




}

