public class one1 {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i]=i+1;
        }
        System.out.println(Crug(array, m));
    }
    public static String Crug(int[] array, int m){
        int i = 0;
        String s = "";
        do{
            s += Integer.toString(array[i]);
            i+=(m-1);
            i = i<array.length ? i : i - (array.length);
        }while (array[0] != array[i]);
        return s;
    }
}
