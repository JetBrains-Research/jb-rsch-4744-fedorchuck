package org.jetbrains.assignment.service;

import org.jetbrains.assignment.model.Direction;
import org.jetbrains.assignment.model.MovementOperation;
import org.jetbrains.assignment.model.RecordedCoordinates;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordedCoordinatesToMovementOperationTransformer implements Transformer<MovementOperation, RecordedCoordinates> {

	@Override
	public List<MovementOperation> transform(List<RecordedCoordinates> coordinates) {
		List<MovementOperation> result = new ArrayList<>();
		int x = 0;
		int y = 0;
		for (RecordedCoordinates coordinate : coordinates) {
			int newX = coordinate.getX();
			int newY = coordinate.getY();
			int steps = 0;
			if ((x == newX) && (y == newY)) {
				continue;
			}
			if (x > newX) {
				steps = x - newX;
				x = x - steps;
				result.add(new MovementOperation(Direction.WEST, steps));
				continue;
			}
			if (x < newX) {
				steps = newX - x;
				x = x + steps;
				result.add(new MovementOperation(Direction.EAST, steps));
				continue;
			}
			if (y > newY) {
				steps = y - newY;
				y = y - steps;
				result.add(new MovementOperation(Direction.SOUTH, steps));
				continue;
			}
			if (y < newY) {
				steps = newY - y;
				y = y + steps;
				result.add(new MovementOperation(Direction.NORTH, steps));
				continue;
			}
		}

		return result;
	}
}
