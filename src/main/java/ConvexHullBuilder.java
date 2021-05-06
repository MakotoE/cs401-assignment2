import edu.princeton.cs.algs4.Point2D;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

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

		// Remove lowest point and duplicates
		// Sort by polar angle with lowest point
		Point2D finalLowest = lowest;
		var sortedPoints = points
			.stream()
			.distinct()
			.filter(p -> p != finalLowest)
			.sorted(lowest.polarOrder())
			.collect(Collectors.toList());

		// Remove points with same polar angle
		for (int i = 0; i < sortedPoints.size() - 1; i++) {
			if (Point2D.ccw(lowest, sortedPoints.get(i), sortedPoints.get(i + 1)) == 0) {
				if (lowest.distanceTo(sortedPoints.get(i)) > lowest.distanceTo(sortedPoints.get(i + 1))) {
					sortedPoints.remove(i + 1);
				} else {
					sortedPoints.remove(i);
				}
				i--;
			}
		}

		var stack = new Stack<Point2D>();
		stack.push(lowest);

		// Find enclosing path with only left turns
		for (var point : sortedPoints) {
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
