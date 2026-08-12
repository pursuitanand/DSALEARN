package com.anand.ds.stack;

/**
 * Implement a Stack using an Array, where the size of the array, n is given.
 * The Stack must support the following operations:
 *
 * (i) push(x): Insert an element x at the top of the stack.
 * (ii) pop(): Remove the element from the top of the stack.
 * (iii) peek(): Return the top element if not empty, else -1.
 * (iv) isEmpty(): Return true if the stack is empty else return false.
 * (v) isFull(): Return true if the stack is full else return false.
 *
 * There will be a sequence of queries queries[][]. The queries are represented in numeric form:
 *
 *
 * 1 x : Call push(x)
 * 2 : Call pop()
 * 3 : Call peek()
 * 4  : Call isEmpty()
 * 5 : Call isFull()
 * You just have to implement the functions push, pop, peek, isEmpty, and isFull. The driver code will handle the output.
 *
 * Note: All the queries are valid.
 *
 * Examples:
 *
 * Input: n = 3, q = 6, queries[][] = [[1, 5], [1, 3], [3], [2], [4], [5]]
 * Output: [3, false, false]
 * Explanation: Queries on stack are as follows:
 * push(5) : Insert 5 at the top of the stack.
 * push(3) : Insert 3 at the top of the stack.
 * peek() : Return the top element i.e. 3.
 * pop() : Remove the top element i.e. 3.
 * isEmpty() : return false as the stack is not empty.
 * isFull() : return false as the stack is not full. Capacity = 3.
 * Input: n = 1, q = 5, queries[][] =  [[2], [3], [4], [1, 9], [5]]
 * Output: [-1, -1, true, true]
 * Explanation: Queries on stack are as follows:
 * pop(): Since stack is empty, nothing is popped.
 * peek(): Return the top element. Since the stack is empty, return -1.
 * isEmpty(): Return true as the stack is empty.
 * push(9): Insert 9 at the top of the stack. The stack will be [9].
 * isFull(): Return true as the stack is full. Capacity = 1.
 */
public class customStack {

    private int[] stack = null;
    private final int maxSize;
    private int top;


    public customStack(int n){
        //Define Data Structure
        this.maxSize = n;
        this.stack = new int[n];
        this.top=-1;
    }

    public boolean isEmpty(){
        // check if stack is empty
        return (this.top == -1);
    }

    public void push(int x){
        // Implement to push the element on top of stack
        // Ensure no ArrayIndexOutOfBoundsException occurs, if the stack is full, do not push the element.
        if(this.isFull()) return;
        this.stack[++this.top]=x;
    }

    public void pop() {
        //Remove the element from the top
        if(this.top == -1) return ;
        this.top--;
    }

    public int peep(){
        //Return the top element , don't remove it.
        if(this.top == -1) return this.top;
        return this.stack[this.top];
    }

    public boolean isFull(){
        //Return true if the stack is full else return false.
        return (this.top == (this.maxSize-1));
    }

    public static void main(String[] args){
        // Test the customStack implementation
//        customStack stack = new customStack(3);
//        System.out.println(stack.isEmpty()); // true
//        stack.push(5);
//        stack.push(3);
//        System.out.println(stack.peep()); // 3
//        stack.pop(); // 3
//        System.out.println(stack.isEmpty()); // false
//        System.out.println(stack.isFull()); // false
//        stack.push(7);
//        stack.push(9);
//        System.out.println(stack.isFull()); // true

        // Frame test case as below input and output
        //Input: n = 1, q = 5, queries[][] =  [[2], [3], [4], [1, 9], [5]]
        //* Output: [-1, -1, true, true]

        customStack stack2 = new customStack(1);
        stack2.pop(); // nothing to pop
        System.out.println(stack2.peep()); // -1
        System.out.println(stack2.isEmpty()); // true
        stack2.push(9);
        System.out.println(stack2.isFull()); // true

        // Print array representation of stack2
//        System.out.print("Stack2 elements: ");
//        for(int i=0; i<stack2.maxSize; i++) {
//            System.out.print(stack2.stack[i] + " ");
//        }
    }
}
