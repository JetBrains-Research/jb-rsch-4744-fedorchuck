package org.jetbrains.assignment.model;

public class RecordedCoordinates {
	private int x;
	private int y;

	public RecordedCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		RecordedCoordinates that = (RecordedCoordinates) o;

		if (x != that.x) return false;
		return y == that.y;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}

	@Override
	public String toString() {
		return "RecordedCoordinates{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
