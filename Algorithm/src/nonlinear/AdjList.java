package nonlinear;

class GraphNode {
	int vertex;
	GraphNode link;
}

class StackNode{
	int data;
	StackNode link;
}

class QNode{
	int data;
	QNode link;
}

class LinkedQueue{
	QNode front;
	QNode rear;
		
	public LinkedQueue(){
		front = null;
		rear = null;		
	}
	
	public boolean isEmpty(){
		return (front == null);
	}
	
	public void enQueue(int item){
		QNode newNode = new QNode();
		newNode.data = item;
		newNode.link = null;
		if(isEmpty()){
			front = newNode;
			rear = newNode;
		}
		else {
			rear.link = newNode;
			rear = newNode;			
		}		
	}
	
	public int deQueue(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Queue is empty!!");
			return 0;
		}
		else{ 
			int item = front.data;
			front = front.link;
			if(front == null)
				rear = null;
			return item;
		}				
	}
}


class LinkedStack{
	StackNode top;
		
	public boolean isEmpty(){
		return (top == null);
	}
	
	public void push(int item){
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;		
	}
	
	public int pop(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		}
		else{ 
			int item = top.data;
			top = top.link;
			return item;	
		}				
	}
}

class AdjList {
	private GraphNode head[];;
	private int size;
	private boolean isDirect;

	public AdjList(int size, boolean isDirect) {
		head = new GraphNode[size];
		for (int i = 0; i < size; i++) {
			head[i] = new GraphNode();
		}
		this.isDirect = isDirect;
		this.size = size;
	}

	public void insertEdge(int v1, int v2) {
		if (v1 >= size || v2 >= size) {
			System.out.println("그래프에 없는 정점입니다!!");
		} else {
			if (head[v1].link == null) {
				GraphNode next = new GraphNode();
				next.vertex = v2;
				head[v1].link = next;
			} else {
				GraphNode next = new GraphNode();
				next.vertex = v2;
				GraphNode temp = head[v1].link;
				GraphNode prev = head[v1];
				boolean flag = false;
				while (true) {
					if (v2 == temp.vertex) {
						System.out.println("이미 존재하는 간선입니다.");
						return;
					} else if (v2 > temp.vertex) {
						if (temp.link == null) {
							break;
						}
						prev = temp;
						temp = temp.link;
					} else {
						flag = true;
						break;
					}
				}
				if (flag == false) {
					next.link = temp.link;
					temp.link = next;
				} else {
					prev.link = next;
					next.link = temp;
				}
			}
			if (isDirect == false) {
				int imsi = v1;
				v1 = v2;
				v2 = imsi;
				if (head[v1].link == null) {
					GraphNode next = new GraphNode();
					next.vertex = v2;
					head[v1].link = next;
				} else {
					GraphNode next = new GraphNode();
					next.vertex = v2;
					GraphNode temp = head[v1].link;
					GraphNode prev = head[v1];
					boolean flag = false;
					while (true) {
						if (v2 == temp.vertex) {
							System.out.println("이미 존재하는 간선입니다.");
							return;
						} else if (v2 > temp.vertex) {
							if (temp.link == null) {
								break;
							}
							prev = temp;
							temp = temp.link;
						} else {
							flag = true;
							break;
						}
					}
					if (flag == false) {
						next.link = temp.link;
						temp.link = next;
					} else {
						prev.link = next;
						next.link = temp;
					}
				}
			}

		}
	}

	public void removeEdge(int v1, int v2) {
		if (v1 >= size || v2 >= size) {
			System.out.println("그래프에 없는 정점입니다!!");
		} else {
			if (head[v1].link == null) {
				System.out.println("간선이 없어서 삭제할 수 없습니다!!");
			} else {
				GraphNode temp = head[v1].link;
				GraphNode prev = head[v1];
				while (true) {
					if (v2 == temp.vertex) {
						prev.link = temp.link;
						temp = null;
						break;
					} else {
						if (temp.link == null) {
							System.out.println("존재하지 않는 간선입니다.");
							break;
						}
						prev = temp;
						temp = temp.link;
					}
				}

				if(isDirect == false) {
					int imsi = v1;
					v1 = v2;
					v2 = imsi;

					if (head[v1].link == null) {
						System.out.println("간선이 없어서 삭제할 수 없습니다!!");
					} else {
						temp = head[v1].link;
						prev = head[v1];
						while (true) {
							if (v2 == temp.vertex) {
								prev.link = temp.link;
								temp = null;
								return;
							} else {
								if (temp.link == null) {
									System.out.println("존재하지 않는 간선입니다.");
									return;
								}
								prev = temp;
								temp = temp.link;
							}
						}
					}
				}
			}

		}
	}

	public void printAdjList() {
		for (int i = 0; i < size; i++) {
			if (head[i].link == null) {
				break;
			} else {
				GraphNode temp = head[i].link;
				while (true) {
					System.out.print("(" + i + "," + temp.vertex + ")");
					if (temp.link == null) {
						break;
					} else {
						System.out.print(",");
						temp = temp.link;
					}
				}
				System.out.println();
			}
		}
	}

	public void DFS(int v){
		GraphNode w = new GraphNode();
		LinkedStack S = new LinkedStack();;
		boolean visited[] = new boolean[size];
		S.push(v);
		visited[v] = true;
		System.out.print(v + " ");
		while(S.top != null){
			w = head[v];
			while(w != null){
				if(visited[w.vertex]==false){
					S.push(w.vertex);
					visited[w.vertex]=true;
					System.out.print(w.vertex +" ");
					v = w.vertex;
					w = head[v];
				}
				else w = w.link;
			}
			v = S.pop();
		}
		System.out.println();
	}

	public void BFS(int v){
		GraphNode w = new GraphNode();
		LinkedQueue Q = new LinkedQueue();
		boolean visited[] = new boolean[10];
		visited[v] = true;
		System.out.print(v + "  ");
		Q.enQueue(v);
		while(! Q.isEmpty()){
			v = Q.deQueue();
			for(w=head[v]; w != null; w=w.link){
				if(visited[w.vertex] == false){
					visited[w.vertex] = true;
					System.out.print(w.vertex + "  ");
					Q.enQueue(w.vertex);
				}
			}			
		}
		System.out.println();
	}
}
