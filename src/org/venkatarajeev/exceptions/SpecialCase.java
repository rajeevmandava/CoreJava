package org.venkatarajeev.exceptions;

import java.io.IOException;
import java.sql.SQLException;

public class SpecialCase {

	public void callingMethod() throws CustomException, SQLException, IOException {
		try {
			calledMethod();
		} catch (Exception e) {
			throw e;
		}
	}

	public void calledMethod() throws IOException, SQLException, CustomException {

	}

}

class CustomException extends Exception {
	CustomException() {

	}
}
