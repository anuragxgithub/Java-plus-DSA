package StacksAndQueues.Custom;
//HERER WE WILL IMPLEMENT THE DYNAMIC SIMPLE QUEUE SINCE WE ALREADY CREATED THE STATIC SIMPLE 
//QUEUE WE WILL EXTEND THAT CLASS AS EVERYTHING WILL BE SAME INSTEAD OF add() method 
//we will provide its own implementation by method overriding.   
public class SimpleQueue2 extends SimpleQueue1 {

    public SimpleQueue2() {
        super();
    }

    public SimpleQueue2(int size) {
        super(size);
    }

    @Override
    public boolean add(int value) throws QueueException {
        if(this.isFull()) {
            //create a new array with bigger size and copy items
            int[] temp = new int[data.length*2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        //Now size is managed now you can add the element
        super.add(value);
        return true;
    }


    public static void main(String[] args) throws QueueException {
        SimpleQueue2 q = new SimpleQueue2(5);
        System.out.println(q.add(1));
        System.out.println(q.add(2));
        System.out.println(q.add(3));
        System.out.println(q.add(4));
        System.out.println(q.add(5));
        System.out.println(q.add(6));
        
        //Dynamic queue is created :)

        q.display();
        System.out.println(q.remove());
        q.display();
    }
}
