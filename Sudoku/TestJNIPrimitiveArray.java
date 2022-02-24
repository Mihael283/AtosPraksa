public class TestJNIPrimitiveArray {
    static {
        System.loadLibrary("native"); // myjni.dll (Windows) or libmyjni.so (Unixes)
    }
  
    // Declare a native method sumAndAverage() that receives an int[] and
    //  return a double[2] array with [0] as sum and [1] as average
    private native int[] sumAndAverage(int[] numbers);
  
    // Test Driver
    public static void main(String args[]) {
       int[] numbers = {
        3, 0, 6, 5, 0, 8, 4, 0, 0, 
        5, 2, 0, 0, 0, 0, 0, 0, 0, 
        0, 8, 7, 0, 0, 0, 0, 3, 1, 
        0, 0, 3, 0, 1, 0, 0, 8, 0, 
        9, 0, 0, 8, 6, 3, 0, 0, 5, 
        0, 5, 0, 0, 9, 0, 6, 0, 0, 
        1, 3, 0, 0, 0, 0, 2, 5, 0, 
        0, 0, 0, 0, 0, 0, 0, 7, 4, 
        0, 0, 5, 2, 0, 6, 3, 0, 0
        };
        int[] results = new TestJNIPrimitiveArray().sumAndAverage(numbers);
        int[][] result_2d = new int[9][9];
        int index = 0;

        //Mogao sam odmah printat iz jedno dimenzionalnog i nakon svakog devetog znaka staviti /n ali to sam pre kasno shvatio :)
        for(int i = 0; i<9;i++){
            for(int j = 0; j<9; j++){
               result_2d[i][j] = results[index];
               index++;
            }
        }
        
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
                System.out.format("%d ",result_2d[i][j]);
            System.out.format("\n");
        }

    }
 }