package org.jetbrains.assignment.model;

public class MovementOperation {
	private final Direction direction;
	private final int steps;

	public MovementOperation(Direction direction, int steps) {
		this.direction = direction;
		this.steps = steps;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getSteps() {
		return steps;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MovementOperation that = (MovementOperation) o;

		if (steps != that.steps) return false;
		return direction == that.direction;
	}

	@Override
	public int hashCode() {
		int result = direction != null ? direction.hashCode() : 0;
		result = 31 * result + steps;
		return result;
	}

	@Override
	public String toString() {
		return "SubmittedCoordinates{" +
				"direction=" + direction +
				", steps=" + steps +
				'}';
	}
}
