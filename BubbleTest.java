package fishtank;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BubbleTest {
	ArrayList<Bubble> myBubbleList;

	@Before 
	public void setUp() {
		FishTank myTank = new FishTank();
		myBubbleList = new ArrayList<Bubble>();
		myBubbleList.add(new Bubble(myTank, 5, 7));
	}
	
	@After
	public void tearDown() {
		myBubbleList.clear();
	}
	
	@Test
	public void test() {
		myBubbleList.get(0).floatStraightUp();
		assertTrue(myBubbleList.get(0).getCoordinateTwo() == 6);
		myBubbleList.get(0).floatRightUp();
		assertTrue(myBubbleList.get(0).getCoordinateOne() == 6);
		myBubbleList.get(0).floatLeftUp();
		assertTrue(myBubbleList.get(0).getCoordinateOne() == 5);
	}

}
