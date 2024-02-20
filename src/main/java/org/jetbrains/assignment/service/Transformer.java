package org.jetbrains.assignment.service;

import java.util.List;

public interface Transformer<T, F> {
	List<T> transform(List<F> from);
}
