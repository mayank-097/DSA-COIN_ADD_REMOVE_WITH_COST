package org.example;

import java.util.Arrays;

/*
Given N piles of coins and the number of coins in each pile,
your job is to make all piles have same number of coins.
You can add or remove one single coin from a pile at a time.
Removing or adding a coin affects only a single pile.
Also adding a coin to a pile costs c1 and removing a coin from a pile costs c2.
What is the minimum cost to make the coins in all the piles equal
assuming you have infinite number of coins which you can use to add on any pile ?
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] arr = {1,5,6,10};
        int c1 = 3 , c2 = 1;
        //c1 - remove , c2 - add
        Arrays.sort(arr);
        int res = 0;
        for(int i=0;i<arr.length;i++)
        {
            res+=arr[i];
        }
        res =(int) Math.round((double)res/arr.length);
        int index = 0;
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(Math.abs(arr[i]-res)<diff){
                index = i;
                diff = Math.abs(arr[i]-res);
            }
        }
        System.out.println(res);

        while(true){
            int noremove = 0;
            int noadd = 0;
            int countr = 0;
            int counta = 0;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]<res){
                    noadd+=res-arr[i];
                    counta++;
                }
                else if(arr[i]>res){
                    noremove+=arr[i]-res;
                    countr++;
                }
            }
            //c2-3.   c1-1
            System.out.println("countr"+countr+" counta"+counta+" res"+res);
            if((c2+countr)>(c1+counta) && index <(arr.length-1) && index>0){
                index--;
                res = arr[index];

            }
            else if((c2+countr)<(c1+counta) && index <(arr.length-1) && index>0){
                System.out.println("true");
                index++;
                res = arr[index];

            }
            else{
                System.out.println(noadd*c2+noremove*c1);
                break;
            }
        }


    }
}

