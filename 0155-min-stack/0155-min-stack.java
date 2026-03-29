// key point: pop 했을때 어떻게 min 값을 시간복잡도 1로 얻을지
// LinkedList 처럼 이전 값을 알고 있게 하는건 어떨지?
// 특정 class 는 이전 class 를 얻는다? 그럼 특정 값이 들어왔을대 어떻게 몇번째 인지 알 수 있을까?
// 새로운 값이 들어왔을때 이전의 최솟값을 저장한다.
class MinStack {
    Deque<Element> deque;
    int minNum;

    public MinStack() {
        deque = new ArrayDeque<>();
        minNum = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        // System.out.println("val: " + val + ", previosMin: " + minNum + ", min: " + Math.min(minNum, val));
        deque.addLast(new Element(val, minNum));
        // System.out.println(deque);
        minNum = Math.min(minNum, val);
        // System.out.println(minNum);
    }
    
    public void pop() {
        minNum = deque.peekLast().previousMin;
        deque.removeLast();
    }
    
    public int top() {
        return deque.peekLast().num;
    }
    
    public int getMin() {
        return minNum;
    }
}

class Element {
    public int num;
    public int previousMin;

    public Element(int num, int previousMin) {
        this.num = num;
        this.previousMin = previousMin;
    }

    @Override
    public String toString() {
        return "[num: " + num +", previousMin: " + previousMin + "]";
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */