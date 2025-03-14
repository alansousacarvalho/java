package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.exception.DomainException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;

	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		if (checkout.isBefore(checkin)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public long duration() {
		Duration diff = Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay());
		Integer t2 = (int) diff.toDays();
		return t2;
	}

	public void updateDates(LocalDate checkin, LocalDate checkout) {
		LocalDate dateNow = LocalDate.now();
		if (checkin.isBefore(dateNow) || checkout.isBefore(dateNow)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}

		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", checkin: " + fmt.format(checkin) + ", checkout: " + fmt.format(checkout) + ", "
				+ duration() + " nights";
	}
}
