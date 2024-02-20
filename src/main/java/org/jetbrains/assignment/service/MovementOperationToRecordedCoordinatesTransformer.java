package org.jetbrains.assignment.service;

import org.jetbrains.assignment.model.RecordedCoordinates;
import org.jetbrains.assignment.model.MovementOperation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovementOperationToRecordedCoordinatesTransformer implements Transformer<RecordedCoordinates, MovementOperation> {

	@Override
	public List<RecordedCoordinates> transform(List<MovementOperation> movementOperations) {
		List<RecordedCoordinates> result = new ArrayList<>();
		int x = 0;
		int y = 0;
		result.add(new RecordedCoordinates(x, y));
		for (MovementOperation movementOperation : movementOperations) {
			switch (movementOperation.getDirection()) {
				case EAST:
					x = x + movementOperation.getSteps();
					break;
				case WEST:
					x = x - movementOperation.getSteps();
					break;
				case NORTH:
					y = y + movementOperation.getSteps();
					break;
				case SOUTH:
					y = y - movementOperation.getSteps();
					break;
			}
			result.add(new RecordedCoordinates(x, y));
		}
		return result;
	}
}
