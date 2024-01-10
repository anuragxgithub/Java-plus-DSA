package StacksAndQueues.Custom;
//HERE WE WILL IMPLEMET DYNAMIC CIRCULAR QUEUE.
//SINCE WE ALREADY CREATED A STATIC CIRCULAR QUEUE WE WILL EXTENDS THAT CLASS HERE BCZ
//ALMOST EVERTHING IS SAME ONLY WE HAVE TO UPDATE IT WHEN THE QUEUE GETS FULL
//AND WE KNOW THAT IN ORDER TO MODIFY/Provide own implementaion of already defined method in
// parent class WE USE METHOD OVERRIDING
//only we need to override add() method everything else will be same. 
public class CircularQueue2 extends CircularQueue1 {

    public CircularQueue2() {
        super();  //super alone if not specified calls the constructor we know
    }

    public CircularQueue2(int size) {
        super(size);
    }

    @Override
    public boolean add(int value) {
        if(this.isFull()) {
            //create a new array with bigger size and copy items
            int[] temp = new int[data.length*2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front+i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
            
        }
        //Now size is managed now you can add the element
        super.add(value);
        return true;
    }


    public static void main(String[] args) throws QueueException {
        CircularQueue2 c = new CircularQueue2();
        System.out.println(c.add(1));
        System.out.println(c.add(2));
        System.out.println(c.add(3));
        System.out.println(c.add(4));
        System.out.println(c.add(5));
        System.out.println(c.add(6));
        System.out.println(c.add(7));
        System.out.println(c.add(8));
        System.out.println(c.add(9));
        System.out.println(c.add(10));
        System.out.println(c.add(11));
        //See now we can add as many items in the circular queue as we want
        
        c.display();

        System.out.println(c.remove());
        System.out.println(c.add(12));

        c.display();
    }
}
