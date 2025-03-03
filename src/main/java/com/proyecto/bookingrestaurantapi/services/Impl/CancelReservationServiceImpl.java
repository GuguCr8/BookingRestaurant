package com.proyecto.bookingrestaurantapi.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.bookingrestaurantapi.exceptions.BookingException;
import com.proyecto.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.proyecto.bookingrestaurantapi.exceptions.NotFountException;
import com.proyecto.bookingrestaurantapi.repositories.ReservationRepository;
import com.proyecto.bookingrestaurantapi.services.CancelReservationService;

@Service
public class CancelReservationServiceImpl  implements CancelReservationService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);
	
	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public String deleteReservation(String locator) throws BookingException {
		 reservationRepository.findByLocator(locator)
				.orElseThrow(() -> new NotFountException("LOCATOR_NOT_FUND","LOCATOR_NOT_FOUND"));
		 try {
			reservationRepository.deleteByLocator(locator);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR",e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return "LOCATOR_DELETED";
	}

}
