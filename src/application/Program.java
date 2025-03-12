package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
		System.out.print("Room number: ");
		int rNumber = sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkin = LocalDate.parse(sc.next(), fmt);
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkout = LocalDate.parse(sc.next(), fmt);
		
		if(checkout.isBefore(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {			
			Reservation reservation = new Reservation(rNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation.toString());
			System.out.println();
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.next(), fmt);
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.next(), fmt);
			
			LocalDate dateNow = LocalDate.now();
			if(checkin.isBefore(dateNow) || checkout.isBefore(dateNow)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (checkout.isBefore(dateNow)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {				
				reservation.updateDates(checkin, checkout);
				System.out.println("Reservation: " + reservation.toString());
			}
			
			
		}
		sc.close();
		
	}

}
