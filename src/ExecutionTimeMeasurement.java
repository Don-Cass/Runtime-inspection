import java.io.FileWriter;
import java.io.IOException;

public class ExecutionTimeMeasurement {
    public static final int MAX_SIZE = 10000000;
    public static final int MAX_VALUE = 10000000;
    public static final int Number_of_implementations = 10000;
    public static void main(String[] args) {

        try (
                FileWriter writer1 = new FileWriter("execution_times_array2.csv");
                FileWriter writer2 = new FileWriter("execution_times_heap2.csv")
        ) {
            writer1.write("Run,Size,Time_insert (nanoseconds)\n");//Time_getMax (nanoseconds),Time_deleteMax (nanoseconds) \n");
            writer2.write("Run,Size,Time_insert (nanoseconds)\n");//Time_getMax (nanoseconds),Time_deleteMax (nanoseconds) \n");
//            for (int i = 0; i <= Number_of_implementations; i++) {
//
//                int randomSize;
//                randomSize = (int)(Math.random()* MAX_SIZE)+1;
//                MyArray ma = new MyArray(randomSize);
//                MyHeap mh = new MyHeap(randomSize);
            for (int i = 0; i < Number_of_implementations; i++) {
                int randomSize = (int)(Math.random() * MAX_SIZE) + 1;
                int[] randomValues = new int[randomSize];

                // 난수 값을 미리 생성
                for (int j = 0; j < randomSize; j++) {
                    randomValues[j] = (int)(Math.random() * MAX_VALUE);
                }

                MyArray ma = new MyArray(randomSize);
                MyHeap mh = new MyHeap(randomSize);
                /////////////////////array 실험

                //////////배열 자료의 삽입 실험
                long startTime_insert = System.nanoTime();

                for (int j = 0; j < randomSize; j++) {
                    ma.insert(randomValues[j]); // 미리 생성된 난수 값 사용
                }

                long endTime_insert = System.nanoTime();



                //////////배열 최댓값 확인 실험
//                long startTime_getMax = System.nanoTime();
//
//                int max = ma.getMax();
//
//                long endTime_getMax = System.nanoTime();
//
//
//
//                //////////배열 최댓값 삭제 실험
//                long startTime_deleteMax = System.nanoTime();
//
//                ma.deleteMax();
//
//                long endTime_deleteMax = System.nanoTime();

                /////////////////////heap 실험

                //////////Heap 자료의 삽입 실험
                long startTime_insertHeap = System.nanoTime();

                for (int j = 0; j < randomSize; j++) {
                    mh.insertHeap(randomValues[j]); // 미리 생성된 난수 값 사용
                }

                long endTime_insertHeap = System.nanoTime();

                //////////Heap 최댓값 출력 실험

//                long startTime_peekHeap = System.nanoTime();
//
//                max = mh.peekHeap();
//
//                long endTime_peekHeap = System.nanoTime();
//
//                //////////Heap 최댓값 삭제 실험
//
//                long startTime_getMaxHeap = System.nanoTime();
//
//                max = mh.getMaxHeap();
//
//                long endTime_getMaxHeap = System.nanoTime();


                long executionTime_insert = endTime_insert - startTime_insert;
//                long executionTime_getMax = endTime_getMax - startTime_getMax;
//                long executionTime_deleteMax = endTime_deleteMax - startTime_deleteMax;
                long executionTime_insertHeap = endTime_insertHeap - startTime_insertHeap;
//                long executionTime_peekHeap = endTime_peekHeap - startTime_peekHeap;
//                long executionTime_getMaxHeap = endTime_getMaxHeap - startTime_getMaxHeap;

                writer1.write(i + "," + randomSize + "," + executionTime_insert + "\n"); // + "," + executionTime_getMax + "," + executionTime_deleteMax + "\n");
                writer2.write(i + "," + randomSize + "," + executionTime_insertHeap + "\n");// "," + executionTime_peekHeap + "," + executionTime_getMaxHeap + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
