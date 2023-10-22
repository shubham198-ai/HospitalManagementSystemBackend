package sample.hms.project.exception;

public class MedicineNotFoundException extends Exception {
	public MedicineNotFoundException() {
		super("Medicine Not found");
}
}