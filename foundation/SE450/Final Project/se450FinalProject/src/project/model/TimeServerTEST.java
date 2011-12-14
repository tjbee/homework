package project.model;
import junit.framework.TestCase;
import junit.framework.Assert;

public class TimeServerTEST extends TestCase {
	TimeServerLinked q = new TimeServerLinked();
	
	public TimeServerTEST(String name){
		super(name);
	}
	
	public void testThatEmptySizeIsZero(){
		Assert.assertEquals(0, q.size());
	}
	
	public void testThatDequeueOnEmptyThrowsIndexOutOfBoundsException() {
		boolean exceptionOccured = false;
		
		try {
			@SuppressWarnings("unused")
			Agent o = q.dequeue();
		}catch (java.util.NoSuchElementException e){
			exceptionOccured = true;
		}
		
		Assert.assertTrue(exceptionOccured);
	}
	
	public void testThatEnqueueFollowedByDequeueReturnsSameReference() {
		class TestThatEnqueueFollowedByDequeueReturnsSameReference implements Agent {
			public void run(double time) {}
		}
		Agent x1 = new TestThatEnqueueFollowedByDequeueReturnsSameReference();
		q.enqueue(0, x1);
		Assert.assertSame(x1, q.dequeue());
		Assert.assertSame(0, q.size());
	}
	
	public void testThatElementsAreInsertedInOrder() {
		class TestThatElementsAreInsertedInOrder implements Agent{
			public void run(double time) {}
		}
		
		Agent a1 = new TestThatElementsAreInsertedInOrder();
		Agent a2 = new TestThatElementsAreInsertedInOrder();
		q.enqueue(0, a2);
		q.enqueue(1, a1);
		Assert.assertSame(a2, q.dequeue());
		Assert.assertSame(a1, q.dequeue());
		q.enqueue(1, a1);
		q.enqueue(0, a2);
		Assert.assertSame(a2, q.dequeue());
		Assert.assertSame(a1, q.dequeue());
		q.enqueue(0, a1);
		q.enqueue(0, a2);
		Assert.assertSame(a1, q.dequeue());
		Assert.assertSame(a2, q.dequeue());
		q.enqueue(0, a2);
		q.enqueue(0, a1);
		Assert.assertSame(a2, q.dequeue());
		Assert.assertSame(a1, q.dequeue());
	}
	
	public void testToString(){
		class TestToString implements Agent {
			public void run(double time) {}
			public String toString() { return "x";}
		}
		q.enqueue(0, new TestToString());
		q.enqueue(1, new TestToString());
		
		Assert.assertEquals("[(0.0,x);(1.0,x)]", q.toString());
	}
	
	public void testCurrentTime(){
		class TestCurrentTime implements Agent {
			public void run(double time) { }
		}
		double expected = 1230;
		q.enqueue(expected, new TestCurrentTime());
		
		Assert.assertEquals(0.0, q.currentTime());
		q.run(expected);
		
		Assert.assertEquals(expected, q.currentTime());
	}
	
	private double _scratch;
	public void testDoActionsAtOrBefore(){
		class TestDoActionsAtOrBefore implements Agent {
			private double _myScratch;
			TestDoActionsAtOrBefore(double myScratch){
				_myScratch = myScratch;
			}
			public void run(double time){
				_scratch = _myScratch;
			}
		}
		double time1 = 12;
		double time2 = 23;
		double value1 = 42;
		double value2 = 27;
		
		q.enqueue(time1, new TestDoActionsAtOrBefore(value1));
		
		_scratch = 0;
		q.run(time1 - 1);
		Assert.assertEquals(0.0, _scratch);
		
		_scratch = 0;
		q.run(1);
		Assert.assertEquals(value1, _scratch);
		
		q.enqueue(time2, new TestDoActionsAtOrBefore(value2));
		
		_scratch = 0;
		q.run(time2);
		Assert.assertEquals(value2, _scratch);
		
	}
}