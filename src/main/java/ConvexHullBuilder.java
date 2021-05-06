import edu.princeton.cs.algs4.Point2D;

import java.util.ArrayList;
import java.util.Iterator;

public class ConvexHullBuilder implements Iterator<Point2D> {
	public ConvexHullBuilder(ArrayList<Point2D> pointList) {

		// TODO empty list case
		var lowest = pointList.get(0);
		for (var point : pointList.subList(1, pointList.size())) {
			if (point.y() < lowest.y() || (point.y() == lowest.y() && point.x() < lowest.x())) {
				lowest = point;
			}
		}

		pointList.sort(lowest.polarOrder());
		this.pointList = pointList;
	}

	public Iterable<Point2D> hull() {
		//noinspection unchecked
		return (Iterable<Point2D>) this;
	}

	private final ArrayList<Point2D> pointList;

	public boolean hasNext() {
		return false;
	}

	public Point2D next() {
		return null;
	}
}
