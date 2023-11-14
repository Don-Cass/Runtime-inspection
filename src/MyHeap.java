public class MyHeap {
    int arr[];
    int size; //실제 데이 개수, 초깃값은 자동으로 0
    public MyHeap(int maxSize) { //생성자
        arr = new int[maxSize+1];
    }
    public void insertHeap(int item) {
        int pos = ++size; // 전체 자료 개수도 증가시키고, 초기 자료 저장할 위치를 설정
        // 내가 들어갈 위치 찾기...부보의 값과 비교해서 교환 여부 결정
        while( pos!=1 && item > arr[pos/2] ) { // 부모가 나보다 작은 경우 root까지 가면서 반복
            arr[pos] = arr[pos/2]; // 부모를 끌어내린다.
            pos = pos/2; // 한 레벨 위로 가서 반복하자.
        }
        // pos ==1이되어서 root까지 왔거나, 부모가 나보다 더 큰 경우
        arr[pos] = item; // 찾은 위치에 item을 넣기
    }
    public int getMaxHeap() {
        if( size==0 ) return -1; // 자료가 하나도 없는 경우 -1을 리턴. Exception처리가 바람직
        int max = arr[1];
        // 루트를 삭제하고, 자식 중에서 후보자를 위로 올리는 작업
        // 맨 끝의 자료의 값과 비교하면서 root에서부터 내려오며서 왼쪽, 오른쪽 자식중에 큰 자식을 위로 올려서 확정
        int parent = 1; // root의 index
        int child = 2; // 2는 왼쪽 자식, 3은 오른쪽 자식
        int last = arr[size]; // 맨 끝의 자료 값
        size--; // 자료 개수 1감소. 이 작업을 언제하느냐에 따라 아래의 size값 비교 방법이 달라짐
        while(child <= size) { // 맨 아래(마지막) 노드까지 위로 교환해야 할 수 있으니
            // last보다 큰 자식이 있으면 그 자녀를 골라서 parent자리에 놓자
            // 왼쪽 자식 vs 오른쪽 자식 중에 큰 자식을 선택해야함.
            if( child<size && arr[child] < arr[child+1] ) child = child+1; //child==size인경우 더이상 오른쪽 자식이 없으니 고려하지 않음
            if( last >= arr[child] ) break; //last값이 child값보다 같거나 크면 parent 자리에 last값을 넣어야 하므로 loop를 빠져나감
            arr[parent] = arr[child]; // 큰 자식을 부모 위치에 옮김
            parent = child; // 이제 child를 새로운 부모로 삼고 반복해야함.
            child = child*2; // child도 한 세대 아래로
        }
        arr[parent] = last; // last값이 들어갈 자리가 확정됨. parent 자리에 들어감
        return max; //처음에 보관했던 root의 값을 리턴하는 것임
    }

    public void print() {
        for (int i = 1; i <= size(); i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int size() {
        return size;
    }

    public int peekHeap() {
        if(size <= 0) return -1;
        return arr[1];
    }
}
