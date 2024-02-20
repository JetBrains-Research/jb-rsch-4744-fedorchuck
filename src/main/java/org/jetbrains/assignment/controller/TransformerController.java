package org.jetbrains.assignment.controller;

import jakarta.annotation.Resource;
import org.jetbrains.assignment.model.MovementOperation;
import org.jetbrains.assignment.model.RecordedCoordinates;
import org.jetbrains.assignment.service.Transformer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransformerController {

	@Resource
	private Transformer<RecordedCoordinates, MovementOperation> movementOperationToRecordedCoordinatesTransformer;
	@Resource
	private Transformer<MovementOperation, RecordedCoordinates> recordedCoordinatesToMovementOperationTransformer;

	@PostMapping(path = "/locations")
	public List<RecordedCoordinates> locations(@RequestBody List<MovementOperation> directionOrder) {
		return movementOperationToRecordedCoordinatesTransformer.transform(directionOrder);
	}

	@PostMapping(path = "/moves")
	public List<MovementOperation> moves(@RequestBody List<RecordedCoordinates> coordinates) {
		return recordedCoordinatesToMovementOperationTransformer.transform(coordinates);
	}

}
