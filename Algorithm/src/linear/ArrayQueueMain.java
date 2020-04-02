package linear;

public class ArrayQueueMain {
	  public static void main(String args[]) {
	        int queueSize = 3;
	        ArrayQueue arrQueue = new ArrayQueue(queueSize);
	        
	        arrQueue.enQueue('A');
	        arrQueue.printQueue();
	        
	        arrQueue.enQueue('B');
	        arrQueue.printQueue();
	        
	        arrQueue.enQueue('C');
	        arrQueue.printQueue();
	        
	        arrQueue.deQuque();
	        arrQueue.printQueue();
	        
	        arrQueue.deQuque();
	        arrQueue.printQueue();
	        
	        arrQueue.deQuque();
	      
	        arrQueue.clear();
	        arrQueue.printQueue();
	        
	        arrQueue.enQueue('A');
	        arrQueue.printQueue();
	        
	        arrQueue.enQueue('B');
	        arrQueue.printQueue();
	        
	        arrQueue.enQueue('C');
	        arrQueue.printQueue();
	        
	        arrQueue.deQuque();
	        arrQueue.printQueue();
	        //선형 큐의 문제점 - 2개의 데이터만 저장된 상태 인데도 데이터가 저장이 안됨  
	        arrQueue.enQueue('D');
	        arrQueue.printQueue();
	   
	    }
}
