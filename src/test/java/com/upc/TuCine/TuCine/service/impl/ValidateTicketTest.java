package com.upc.TuCine.TuCine.service.impl;

import com.upc.TuCine.TuCine.dto.TicketDto;
import com.upc.TuCine.TuCine.model.Showtime;
import com.upc.TuCine.TuCine.model.Ticket;
import com.upc.TuCine.TuCine.shared.exception.ValidationException;
import com.upc.TuCine.TuCine.user.domain.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


public class ValidateTicketTest {

    @Test
    public void testValidTicket() {
    	int maxCapacity = 6;
    	int ticketSeats = 5;
        
        Showtime showtime = new Showtime();
        showtime.setCapacity(maxCapacity);

        try {
            Ticket validTicket = new Ticket();
            validTicket.setNumberSeats(ticketSeats);
            validTicket.validateShowtime(showtime);
            validTicket.setShowtime(showtime);

            assertEquals(validTicket.getShowtime(), showtime);
        } catch (ValidationException e) {
            fail(e.getMessage());
        }
    }

/*     @Test()
    public void testNullUserTicket() {
        TicketDto nullUserTicket = new TicketDto();
        nullUserTicket.setShowtime(new Showtime());
        nullUserTicket.setNumberSeats(5);
        nullUserTicket.setTotalPrice(100.0F);
        try {
            TicketServiceImpl.validateTicket(nullUserTicket);
            fail("Se esperaba una excepción para un ticket sin usuario");
        } catch (ValidationException e) {
            // La excepción esperada se lanzó, lo que es correcto
        }
    }

    @Test
    public void testNullShowtimeTicket() {
        TicketDto nullShowtimeTicket = new TicketDto();
        nullShowtimeTicket.setUser(new User());
        nullShowtimeTicket.setNumberSeats(5);
        nullShowtimeTicket.setTotalPrice(100.0F);
        try {
            TicketServiceImpl.validateTicket(nullShowtimeTicket);
            fail("Se esperaba una excepción para un ticket sin showtime");
        } catch (ValidationException e) {
            // La excepción esperada se lanzó, lo que es correcto
        }
    }

    @Test
    public void testZeroSeatsTicket() {
        TicketDto zeroSeatsTicket = new TicketDto();
        zeroSeatsTicket.setUser(new User());
        zeroSeatsTicket.setShowtime(new Showtime());
        zeroSeatsTicket.setNumberSeats(0);
        zeroSeatsTicket.setTotalPrice(100.0F);
        try {
            TicketServiceImpl.validateTicket(zeroSeatsTicket);
            fail("Se esperaba una excepción para un ticket con número de asientos cero");
        } catch (ValidationException e) {
            // La excepción esperada se lanzó, lo que es correcto
        }
    }

    @Test
    public void testNullSeatsTicket() {
        TicketDto nullSeatsTicket = new TicketDto();
        nullSeatsTicket.setUser(new User());
        nullSeatsTicket.setShowtime(new Showtime());
        nullSeatsTicket.setNumberSeats(null);
        nullSeatsTicket.setTotalPrice(100.0F);
        try {
            TicketServiceImpl.validateTicket(nullSeatsTicket);
            fail("Se esperaba una excepción para un ticket con número de asientos nulo");
        } catch (ValidationException e) {
            // La excepción esperada se lanzó, lo que es correcto
        }
    }

    @Test
    public void testNegativePriceTicket() {
        TicketDto negativePriceTicket = new TicketDto();
        negativePriceTicket.setUser(new User());
        negativePriceTicket.setShowtime(new Showtime());
        negativePriceTicket.setNumberSeats(5);
        negativePriceTicket.setTotalPrice(-100.0F);
        try {
            TicketServiceImpl.validateTicket(negativePriceTicket);
            fail("Se esperaba una excepción para un ticket con precio total negativo");
        } catch (ValidationException e) {
            // La excepción esperada se lanzó, lo que es correcto
        }
    }

    @Test
    public void testZeroPriceTicket() {
        TicketDto zeroPriceTicket = new TicketDto();
        zeroPriceTicket.setUser(new User());
        zeroPriceTicket.setShowtime(new Showtime());
        zeroPriceTicket.setNumberSeats(5);
        zeroPriceTicket.setTotalPrice(0.0F);
        try {
            TicketServiceImpl.validateTicket(zeroPriceTicket);
            fail("Se esperaba una excepción para un ticket con precio total cero");
        } catch (ValidationException e) {
            // La excepción esperada se lanzó, lo que es correcto
        }
    }

    @Test
    public void testNullPriceTicket() {
        TicketDto nullPriceTicket = new TicketDto();
        nullPriceTicket.setUser(new User());
        nullPriceTicket.setShowtime(new Showtime());
        nullPriceTicket.setNumberSeats(5);
        nullPriceTicket.setTotalPrice(null);
        try {
            TicketServiceImpl.validateTicket(nullPriceTicket);
            fail("Se esperaba una excepción para un ticket con precio total nulo");
        } catch (ValidationException e) {
            // La excepción esperada se lanzó, lo que es correcto
        }
    }
 */
}