package org.jetbrains.assignment.sercvice;

import org.assertj.core.api.Assertions;
import org.jetbrains.assignment.model.MovementOperation;
import org.jetbrains.assignment.model.RecordedCoordinates;
import org.jetbrains.assignment.service.RecordedCoordinatesToMovementOperationTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.jetbrains.assignment.model.Direction.EAST;
import static org.jetbrains.assignment.model.Direction.NORTH;
import static org.jetbrains.assignment.model.Direction.SOUTH;
import static org.jetbrains.assignment.model.Direction.WEST;

class RecordedCoordinatesToMovementOperationTransformerTest {
	private RecordedCoordinatesToMovementOperationTransformer service;

	@BeforeEach
	void setUp() {
		service = new RecordedCoordinatesToMovementOperationTransformer();
	}

	@Test
	void shouldCorrectTransform() {
		//GIVEN
		List<RecordedCoordinates> coordinates = List.of(
				new RecordedCoordinates(0, 0),
				new RecordedCoordinates(1, 0),
				new RecordedCoordinates(1, 3),
				new RecordedCoordinates(0, 3),
				new RecordedCoordinates(0, 0)
		);

		//WHEN
		List<MovementOperation> actual = service.transform(coordinates);

		//THEN
		List<MovementOperation> expected = List.of(
				new MovementOperation(EAST, 1),
				new MovementOperation(NORTH, 3),
				new MovementOperation(WEST, 1),
				new MovementOperation(SOUTH, 3)
		);

		Assertions.assertThat(actual).isEqualTo(expected);
	}
}