import edu.princeton.cs.algs4.Point2D;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvexHullBuilderTest {
	@Test
	public void test() {
		var points = new Point2D[]{
			new Point2D(-2, 1),
			new Point2D(-1, -1),
			new Point2D(1, 1),
			new Point2D(2, 0),
			new Point2D(0, 0),
		};
		for (var point : ConvexHullBuilder.get_stack(new ArrayList<>(Arrays.asList(points)))) {
			System.out.println(point);
		}
	}
}
