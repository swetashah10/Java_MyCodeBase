public class TestTopNValues {

    public static void main(String a[]) {

	System.out.println("Hello world!");

	final MyTopNValues mine = new MyTopNValues(5);
	Thread t1 = new Thread() {

	    @Override
	    public void run() {
		mine.top();
		mine.consume(12);
		mine.display();
	    }
	};
	Thread t2 = new Thread() {

	    @Override
	    public void run() {
		mine.top();
		mine.consume(1);
		mine.display();
	    }
	};
	t1.start();
	t2.start();
    }

}
