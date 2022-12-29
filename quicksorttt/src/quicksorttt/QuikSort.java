/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quicksorttt;

import java.util.Random;


public class QuikSort {


    public static int pivot(int[] array, int yüzde) {
        return (int) Math.floor(array.length * yüzde / 100.0);
    }


    public static int quicksort(int[] dizi, int pivotIndex,int yüzdelik) {
        int gecici = 0;
        if (dizi.length <= 1) {
            return gecici;
        }
       
        int pivot = dizi[pivotIndex];
        int i = 0;
        int j = dizi.length - 1;
        while (i < j) {
            while (dizi[i] < pivot) {
                i++;
            }
            while (dizi[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = dizi[i];
                dizi[i] = dizi[j];
                dizi[j] = temp;
                gecici++;
            }
        }
        int[] left = new int[i];
        int[] right = new int[dizi.length - i - 1];
        System.arraycopy(dizi, i + 1, right, 0, dizi.length - i - 1);
        int yeniYüzde=100-yüzdelik;
        int yeniSolYüzde=100-yeniYüzde;
        gecici += quicksort(left, pivot(left, yüzdelik),yüzdelik);
        gecici += quicksort(right, pivot(right, yüzdelik),yüzdelik);
        return gecici;
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        Random random = new Random();
        int rand;
        int[] kontrol = new int[100];
        rand = random.nextInt();

        for (int i = 0; i < 100; i++) {
            do {
                rand = random.nextInt(100) + 1;
            } while (kontrol[rand - 1] == 1);

            kontrol[rand - 1] = 1;
            array[i] = rand;
            System.out.print(array[i] + ",");

        }


        int işlemSayısı = Integer.MAX_VALUE;
        int EnİyiPivot = 0;
        for (int i = 0; i < 100; i += 10) {
            int pivotIndex = pivot(array, i);
           
            int gecici = quicksort(array, pivotIndex,i);
            if (gecici < işlemSayısı) {
                işlemSayısı = gecici;
                EnİyiPivot = pivotIndex;
            }
        }

        System.out.println();
        System.out.println(" en iyi adım=%" + EnİyiPivot + " islem=" + işlemSayısı);
        System.out.println();

       
    }
}