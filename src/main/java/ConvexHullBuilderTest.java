import edu.princeton.cs.algs4.Point2D;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Enclosed.class)
public class ConvexHullBuilderTest {

	@RunWith(Parameterized.class)
	public static class get_stack {
		@Parameterized.Parameters
		public static Collection<Object> data() {
			return Arrays.asList(new Object[][]{
				{
					new Point2D[]{},
					new Point2D[]{},
				},
				{
					new Point2D[]{
						new Point2D(0, 0),
					},
					new Point2D[]{
						new Point2D(0, 0),
					},
				},
				{
					new Point2D[]{
						new Point2D(0, 0),
						new Point2D(1, 0),
					},
					new Point2D[]{
						new Point2D(0, 0),
						new Point2D(1, 0),
					},
				},
				{
					new Point2D[]{
						new Point2D(0, 0),
						new Point2D(1, 1),
						new Point2D(1, 0),
					},
					new Point2D[]{
						new Point2D(0, 0),
						new Point2D(1, 0),
						new Point2D(1, 1),
					},
				},
				{
					new Point2D[]{
						new Point2D(-2, 1),
						new Point2D(-1, -1),
						new Point2D(1, 1),
						new Point2D(2, 0),
						new Point2D(0, 0),
					},
					new Point2D[]{
						new Point2D(-2, 1),
						new Point2D(-1, -1),
						new Point2D(2, 0),
						new Point2D(1, 1),
					},
				}
			});
		}

		@Parameterized.Parameter
		public Point2D[] points;

		@Parameterized.Parameter(1)
		public Point2D[] expected;

		@Test
		public void test() {
			var result = ConvexHullBuilder.get_stack(new ArrayList<>(Arrays.asList(points)));
			assertArrayEquals(result.toArray(), expected);
		}
	}
}
