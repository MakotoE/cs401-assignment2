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
						new Point2D(-1, -1),
						new Point2D(2, 0),
						new Point2D(1, 1),
						new Point2D(-2, 1),
					},
				},
				{
					new Point2D[]{
						new Point2D(2950.0, 7388.0),
						new Point2D(2913.0, 4900.0),
						new Point2D(6138.0, 5063.0),
						new Point2D(6675.0, 7538.0),
						new Point2D(4413.0, 6300.0),
					},
					new Point2D[]{
						new Point2D(2913.0, 4900.0),
						new Point2D(6138.0, 5063.0),
						new Point2D(6675.0, 7538.0),
						new Point2D(2950.0, 7388.0),
					},
				},
			});
		}

		@Parameterized.Parameter
		public Point2D[] points;

		@Parameterized.Parameter(1)
		public Point2D[] expected;

		@Test
		public void test() {
			var result = ConvexHullBuilder.get_stack(new ArrayList<>(Arrays.asList(points)));
			assertArrayEquals(expected, result.toArray());
		}
	}
}
