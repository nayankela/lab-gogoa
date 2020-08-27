package services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;

// Type your code
public class FareCalculator extends Booking {

	public double book(Hotel hotel) {
		Double tariff;
		int noOfPersons = hotel.getNoOfPersons();
		int rates = hotel.getRates();
		long days = ChronoUnit.DAYS.between(hotel.getFromdate(), hotel.getTodate());
		double rate = super.booking(noOfPersons, rates);
		int month = hotel.getFromdate().getMonthValue();

		System.out.println(month);
		System.out.println(rate);
		System.out.println(days);
		if ((month >= 1 && month < 4) || (month > 6 && month < 11)) {
			System.out.println("Inside if loop");
			tariff = (rate - (rate * (25 / 100.0))) * days;
			System.out.println(tariff);
		} else {
			System.out.println("Entering else part");
			tariff = (rate + (rate * (50 / 100.0))) * days;
			System.out.println(tariff);
		}
		return tariff;
	}

	public double book(Flight flight) {
		double totalFare = 0;
		if (flight.getTriptype().equals("one-way")) {
			System.out.println("One Way Trip");
			int noOfPersons = flight.getNoOfPersons();
			int rates = flight.getRates();
			totalFare = super.booking(noOfPersons, rates);

		} else {
			// round-trip
			if (flight.getFrom().isBefore(flight.getTo())) {
				System.out.println("Round Trip");
				int noOfPersons = flight.getNoOfPersons();
				int rates = flight.getRates();
				totalFare = super.booking(noOfPersons, rates);
				System.out.println(totalFare);
				totalFare = totalFare * 2;
				System.out.println(totalFare);
			}
		}

		return totalFare;
	}

	public double book(Train train) {
		int noOfPerson = train.getNoOfPersons();
		int rates = train.getRates();
		double totalRate = super.booking(noOfPerson, rates);
		return totalRate;

	}

	public double book(Bus bus) {
		int noOfPerson = bus.getNoOfPersons();
		int rates = bus.getRates();
		double totalRate = super.booking(noOfPerson, rates);
		return totalRate;
	}

}