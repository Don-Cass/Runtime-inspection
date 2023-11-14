public class MyArray {
    int[] arr;
    int pos; // 마지막 데이터 저장 장소
    public MyArray(int size) {
        arr = new int[size];
        pos = -1;
    }
    public void insert(int value) {
        arr[++pos] = value;
    }
    public int getMax() {
        // 최댓값을 리턴
        if( pos <0 ) {
            return -1;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if( arr[i] > max ) {
                max = arr[i];
            }
        }
        return max;
    }
    public void deleteMax(){
        if( pos <0 ) {
            return;
        }

        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if( arr[i] > arr[maxIndex] ) {
                maxIndex = i;
            }
        }
        arr[maxIndex] = arr[pos--];
    }
}
