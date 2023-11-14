import java.io.FileWriter;
import java.io.IOException;

public class ExecutionTimeMeasurement {
    public static final int MAX_SIZE = 10000000;
    public static final int MAX_VALUE = 10000000;
    public static final int Number_of_implementations = 10;
    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter("execution_times.csv")) {
            writer.write("Run,Time (nanoseconds)\n");
            for (int i = 0; i < Number_of_implementations; i++) {

                int randomSize;
                randomSize = (int)(Math.random()* MAX_SIZE)+1;
                MyArray ma = new MyArray(randomSize);

                long startTime = System.nanoTime();

                for (int j = 0; j < randomSize; j++) {
                    int randomValue = (int)(Math.random() * MAX_VALUE);
                    ma.insert( randomValue ); // 0~MAX_VALUE 까지 임의
                }

                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                writer.write(i + "," + randomSize + "," + executionTime + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
