package org.jetbrains.assignment.sercvice;

import org.assertj.core.api.Assertions;
import org.jetbrains.assignment.model.RecordedCoordinates;
import org.jetbrains.assignment.model.MovementOperation;
import org.jetbrains.assignment.service.MovementOperationToRecordedCoordinatesTransformer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.jetbrains.assignment.model.Direction.EAST;
import static org.jetbrains.assignment.model.Direction.NORTH;
import static org.jetbrains.assignment.model.Direction.SOUTH;
import static org.jetbrains.assignment.model.Direction.WEST;

class MovementOperationToRecordedCoordinatesTransformerTest {

	private MovementOperationToRecordedCoordinatesTransformer service;

	@BeforeEach
	void setUp() {
		service = new MovementOperationToRecordedCoordinatesTransformer();
	}

	@Test
	void shouldCorrectDetermineLocation() {
		//GIVEN
		List<MovementOperation> submittedCoordinates = List.of(
				new MovementOperation(EAST, 1),
				new MovementOperation(NORTH, 3),
				new MovementOperation(EAST, 3),
				new MovementOperation(SOUTH, 5),
				new MovementOperation(WEST, 2)
		);

		//WHEN
		List<RecordedCoordinates> actual = service.transform(submittedCoordinates);

		//THEN
		List<RecordedCoordinates> expected = List.of(
		new RecordedCoordinates(0, 0),
		new RecordedCoordinates(1, 0),
		new RecordedCoordinates(1, 3),
		new RecordedCoordinates(4, 3),
		new RecordedCoordinates(4, -2),
		new RecordedCoordinates(2, -2)
		);

		Assertions.assertThat(actual).isEqualTo(expected);
	}
}