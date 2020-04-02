package sorting;

import java.util.ArrayList;
import java.util.List;

class Linear_Queue {
    
    int rear = -1;
    int front = 0;
    int maxsize = 0;
    int[] Linear_Queue;
    
    public Linear_Queue(int maxsize){
        this.maxsize = maxsize;
        Linear_Queue = new int[maxsize];
    }
    
    public void EnQueue(int num)
    {
        if(rear != maxsize-1){
            Linear_Queue[++rear] = num;
        }else{
            System.out.println("데이터 다참");
        }
    }
    
    public int DeQueue()
    {
        if(rear!=front || (rear==0 && front==0)){
            int tmp =Linear_Queue[front];
            for(int i=1;i<=rear;i++)
            {
                Linear_Queue[i-1] = Linear_Queue[i];
            }
            rear--;
            return tmp;
        } else{
            return -1;
        }    
    }
}

public class RadixSort {
	public static void radix_sort(int[] data)
    {
        int maxsize = getMaxlength(data);
        List<Linear_Queue> bucket = new ArrayList<Linear_Queue>();
        int powed=1;
        int index = 0;
 
        for(int i=0;i<10;i++){
            bucket.add(new Linear_Queue(10));
        }
        
        for(int i=1;i<=maxsize;i++)        //자리수가 가장 큰 수만큼 전체 반복문을 반복합니다.
        {
            for(int j=0;j<data.length;j++)    
            {    
                bucket.get((data[j]/powed)%10).EnQueue(data[j]);    //각 자리수의 맞는 index의 bucket에 넣습니다.
            }
            for(int k=0;k<10;k++)        //버킷에서 데이터를 가지고옵니다.
            {
                int bucket_num = bucket.get(k).rear;
 
                for(int n=0;n<=bucket_num;n++)
                {
                    data[index] = bucket.get(k).DeQueue();
                    index++;
                }
            }
            index =0;
            powed *=10;
        }
    }
    public static int getMaxlength(int[] data)
    {
        int maxsize = 0;
        for(int i=0;i<data.length;i++)
        {
            int length = (int)Math.log10((double)data[i])+1;
            if(maxsize <length)
            {
                maxsize = length;
            }
        }
        return maxsize;            //가장 큰 자리수를 반환합니다.
    }
    
    public static void main(String [] args) {
    	int[] x = {69, 10, 30, 2, 16, 8, 31, 22};
    	for (int i = 0; i <x.length ; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
		
		radix_sort(x);
		System.out.println("정렬 후");
		for (int i = 0; i <x.length ; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
    }
}

