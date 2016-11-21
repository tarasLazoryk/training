package ua.training.model.entity.carriages;

import java.util.Comparator;

public class PassangerCarriagesComparator<E extends PassangerCarriage> implements Comparator<E> {

	public int compare(PassangerCarriage passCarriage1, PassangerCarriage passCarriage2) {
		return passCarriage1.getComfortType().compareTo(passCarriage2.getComfortType());
	}
}
