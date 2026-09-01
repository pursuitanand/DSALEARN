package com.anand.ds.heap;

/**
 * Given an initially empty Binary Min Heap and a list of queries. Process each query by performing the corresponding heap operation.
 *
 * The queries are of the following types:
 *
 * [1, x]: Insert the value x into the Binary Min Heap.
 * [2, x]: Delete the element present at index x in the current Binary Min Heap. If the index is invalid, ignore the query.
 * [3]: Remove and return the minimum element from the Binary Min Heap. If the heap is empty, return -1.
 * Implement the following methods:
 *
 * insertKey(x): Inserts x into the Binary Min Heap.
 * deleteKey(i): Deletes the element at index i from the Binary Min Heap.
 * extractMin(): Removes and returns the minimum element from the Binary Min Heap, or -1 if the heap is empty.
 * The driver code will invoke these methods according to the given queries.
 *
 * Examples :
 *
 * Input: queries[][] = [[1, 4], [1, 2], [3], [1, 6], [2, 0], [3], [3]]
 * Output: [2, 6, -1]
 * Explanation:
 * - Initially, the Min Heap is empty.
 * - Insert 4. The heap contains 4.
 * - Insert 2. The heap is rearranged to satisfy the Min Heap property, with 2 at the root.
 * - Extract the minimum element. The value 2 is removed and printed.
 * - Insert 6. The heap contains 4 and 6.
 * - Delete the element at index 0. The value 4 is removed, leaving only 6 in the heap.
 * - Extract the minimum element. The value 6 is removed and printed.
 * - Extract the minimum element again. Since the heap is empty, -1 is returned.
 * Input: queries[][] = [[1, 8], [1, 9], [2, 1], [3], [3]]
 * Output: [8, -1]
 * Explanation:
 * - Initially, the Min Heap is empty.
 * - Insert 8. The heap contains 8.
 * - Insert 9. The heap contains 8 and 9.
 * - Delete the element at index 1. The value 9 is removed, leaving only 8 in the heap.
 * - Extract the minimum element. The value 8 is removed and printed.
 * - Extract the minimum element again. Since the heap is empty, -1 is returned.
 */
class BinaryMinHeap {
    /**
     * More precisely:
     * insertKey() → bubble up
     * decreaseKey() → bubble up
     * extractMin() → heapify down
     * deleteKey() → usually decrease to -∞, then extract
     * 17. The four operations you should memorize
     * Operation	| What happens?	                | Direction
     * insertKey()	|  Add new element at bottom	    ⬆️ UP
     * decreaseKey()|  Make element smaller	            ⬆️ UP
     * extractMin()	| Remove root, replace with last	⬇️ DOWN
     * deleteKey()	| Make it -∞, then remove	        ⬆️ then remove
     */
    int[] harr;
    int capacity;
    int heap_size;

    BinaryMinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    int parent(int i) { return (i - 1) / 2; }

    int left(int i) { return (2 * i + 1); }

    int right(int i) { return (2 * i + 2); }

    /**
     * Put at bottom → bubble UP.
     * @param k
     */
    void insertKey(int k) {
        // code here
        if(heap_size == capacity){
            System.out.println("Overflow: Could not insertKey");
            return;
        }

        int i = heap_size;
        harr[i] = k;
        heap_size++;

        while(i!=0 && harr[parent(i)] > harr[i]){
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }

    }

    /**
     * Take root
     *    ↓
     * Move last element to root
     *    ↓
     * Decrease size
     *    ↓
     * Heapify DOWN
     *    ↓
     * Return old root
     * @return
     */
    int extractMin() {
        if(heap_size <= 0) return -1; //return Integer.MAX_VALUE;
        if(heap_size == 1 ){
            heap_size--;
            return harr[0];
        }

        int root =harr[0];
        //Move last element to root
        harr[0] = harr[heap_size-1];
        heap_size--;
        MinHeapify(0);
        return root;
    }

    /**
     * DECREASE → EXTRACT
     * @param i
     */
    void deleteKey(int i) {
        // code here
        if(i < 0 || i >= heap_size){
            System.out.println("Invalid index: Could not deleteKey");
            return;
        }
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    // Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val) {

        // storing new value at ith index.
        harr[i] = new_val;

        while (i != 0 && harr[parent(i)] > harr[i]) {

            // swapping values of ith index with its parent node
            // if value at parent node is greater.
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        // if left or right child is smaller than current element,
        // we store its position.
        if (l < heap_size && harr[l] < harr[smallest]) smallest = l;

        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;

        // if smallest is not equal to i, we swap the values at their position.
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;

            // calling function recursively for the smallest index.
            MinHeapify(smallest);
        }
    }

    public static void main(String[] args) {
        BinaryMinHeap minHeap = new BinaryMinHeap(10);
        minHeap.insertKey(3);
        minHeap.insertKey(2);
        minHeap.deleteKey(1);
        minHeap.insertKey(15);
        minHeap.insertKey(5);
        minHeap.insertKey(4);
        minHeap.insertKey(45);

        System.out.println(minHeap.extractMin()); // Should print 2
        System.out.println(minHeap.extractMin()); // Should print 3
        System.out.println(minHeap.extractMin()); // Should print 4
    }
}
