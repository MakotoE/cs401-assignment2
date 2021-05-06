import edu.princeton.cs.algs4.Point2D;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ConvexHullBuilder implements Iterator<Point2D> {
	static Stack<Point2D> get_stack(ArrayList<Point2D> pointList) {
		// TODO empty list case
		var lowest = pointList.get(0);
		for (var point : pointList.subList(1, pointList.size())) {
			if (point.y() < lowest.y() || (point.y() == lowest.y() && point.x() < lowest.x())) {
				lowest = point;
			}
		}

		pointList.sort(lowest.polarOrder());

		for (int i = 0; i < pointList.size() - 1; i++) {
			if (
				lowest != pointList.get(i)
				&& lowest != pointList.get(i + 1)
				&& Point2D.ccw(lowest, pointList.get(i), pointList.get(i + 1)) == 0
			) {
				if (lowest.distanceTo(pointList.get(i)) > lowest.distanceTo(pointList.get(i + 1))) {
					pointList.remove(i + 1);
				} else {
					pointList.remove(i);
				}
				i--;
			}
		}

		var stack = new Stack<Point2D>();

		for (var point : pointList) {
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

	public ConvexHullBuilder(ArrayList<Point2D> pointList) {

	}

	public Iterable<Point2D> hull() {
		//noinspection unchecked
		return (Iterable<Point2D>) this;
	}

	public boolean hasNext() {
		return false;
	}

	public Point2D next() {
		return null;
	}
}
