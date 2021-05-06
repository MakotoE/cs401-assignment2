import edu.princeton.cs.algs4.Point2D;

import java.util.ArrayList;
import java.util.Stack;

public class ConvexHullBuilder {
	static Stack<Point2D> get_stack(ArrayList<Point2D> points) {
		if (points.size() == 0) {
			return new Stack<>();
		}

		// Find lowest point
		var lowest = points.get(0);
		for (var point : points.subList(1, points.size())) {
			if (point.y() < lowest.y() || (point.y() == lowest.y() && point.x() < lowest.x())) {
				lowest = point;
			}
		}

		// Sort by polar angle with lowest point
		points.sort(lowest.polarOrder());

		// Remove points with same polar angle
		for (int i = 0; i < points.size() - 1; i++) {
			if (
				lowest != points.get(i)
				&& lowest != points.get(i + 1)
				&& Point2D.ccw(lowest, points.get(i), points.get(i + 1)) == 0
			) {
				if (lowest.distanceTo(points.get(i)) > lowest.distanceTo(points.get(i + 1))) {
					points.remove(i + 1);
				} else {
					points.remove(i);
				}
				i--;
			}
		}

		var stack = new Stack<Point2D>();

		// Find path with only left turns
		for (var point : points) {
			while (
				stack.size() > 1
				&& Point2D.ccw(stack.get(stack.size() - 2), stack.peek(), point) <= 0
			) {
				stack.pop();
			}
			stack.push(point);
		}
		return stack;
	}

	public ConvexHullBuilder(ArrayList<Point2D> points) {
		this.stack = get_stack(points);
	}

	public Iterable<Point2D> hull() {
		return this.stack;
	}

	private final Stack<Point2D> stack;
}
