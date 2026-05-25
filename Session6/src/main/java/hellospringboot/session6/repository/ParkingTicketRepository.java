package hellospringboot.session6.repository;

import hellospringboot.session6.dto.TicketSummaryResponse;
import hellospringboot.session6.entity.ParkingTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ParkingTicketRepository
        extends JpaRepository<ParkingTicket, Long> {

    @Query("""
        SELECT new hellospringboot.session6.dto.TicketSummaryResponse(
            p.id,
            v.licensePlate,
            z.name,
            p.checkInTime,
            p.checkOutTime
        )
        FROM ParkingTicket p
        JOIN p.vehicle v
        JOIN p.zone z
        WHERE p.checkInTime >= :startOfDay
          AND p.checkInTime < :endOfDay
    """)
    List<TicketSummaryResponse> findTodayTicketSummary(
            LocalDateTime startOfDay,
            LocalDateTime endOfDay
    );
}