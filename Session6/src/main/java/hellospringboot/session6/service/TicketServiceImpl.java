package hellospringboot.session6.service;

import hellospringboot.session6.dto.ApiResponse;
import hellospringboot.session6.dto.TicketSummaryResponse;
import hellospringboot.session6.repository.ParkingTicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl
        implements TicketService {

    private final ParkingTicketRepository
            parkingTicketRepository;

    public TicketServiceImpl(
            ParkingTicketRepository parkingTicketRepository
    ) {
        this.parkingTicketRepository =
                parkingTicketRepository;
    }

    @Override
    public ApiResponse<List<TicketSummaryResponse>>
    getTodayTicketSummary() {

        LocalDate today = LocalDate.now();

        LocalDateTime startOfDay =
                today.atStartOfDay();

        LocalDateTime endOfDay =
                today.plusDays(1).atStartOfDay();

        List<TicketSummaryResponse> tickets =
                parkingTicketRepository
                        .findTodayTicketSummary(
                                startOfDay,
                                endOfDay
                        );

        return new ApiResponse<>(
                "Success",
                tickets
        );
    }
}