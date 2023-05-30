package cn.stack;
import java.util.LinkedList;
import java.util.Queue;
class MyStack {
	private Queue<Integer> q;
    /** Initialize your data structure here. */
    public MyStack() {
    	q = new LinkedList<>();	
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	// 创建另外一个队列q2
    	Queue<Integer> q2 = new LinkedList<>();
    	q2.add(x);
    	while(!q.isEmpty())
    		q2.add(q.remove());
    	q = q2 ;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
//    	// 创建另外一个队列q2
//    	Queue<Integer> q2 = new LinkedList<>();
//    	// 除了最后一个将q中所有元素放入q2
//    	while(q.size()>1)
//    		q2.add(q.remove());
//    	int ret = q.remove();
//    	q = q2;	
    	return q.remove();
    }
    
    /** Get the top element. */
    public int top() {
    	return q.peek();
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */