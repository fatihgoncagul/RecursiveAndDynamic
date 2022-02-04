/**
 * @author fatih goncagül
 */


public class SmallestNumberOfItems {


    public static void main(String[] args) {
        int n = 14152;
        long startR = System.nanoTime();
        int recursiveResult = recursiveSol(n);
        long durationR = System.nanoTime() - startR;
        long startD = System.nanoTime();
        int dynamicResult = dynamicProg(n);
        long durationD = System.nanoTime() - startD;

        System.out.println("recursive result: " + recursiveResult + ", recursive running time: " + durationR);
        System.out.println("dynamic result: " + dynamicResult + ", dynamic running time: " + durationD );

    }
    public  static  int recursiveSol(int n){

        if (n<1){
            return 0;
        }else if (n>=5  && n!=8 && n!=12  ){
            return 1 + recursiveSol(n - 5);
        }else if (n>=4 ){
            return 1 + recursiveSol(n-4);
        }else {
            return 1+ recursiveSol(n-1);
        }

    }
    public  static int dynamicProg( int n){

        int[] array = new int[n+1];
        array[0] = 0;

        for (int i = 0;i<=n ;i++){

            if (i<4){
                array[i] = i;
            }else if (i<5){
                array[i] = Math.min(array[i - 4], array[i - 1]) +1;
            }
            else {
                    array[i] = Math.min(array[i-5],Math.min(array[i - 4], array[i - 1]) ) +1;
                }
            }

    return array[n];

    }


}
