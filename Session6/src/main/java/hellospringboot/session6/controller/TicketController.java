package hellospringboot.session6.controller;

import hellospringboot.session6.dto.ApiResponse;
import hellospringboot.session6.dto.TicketSummaryResponse;
import hellospringboot.session6.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(
            TicketService ticketService
    ) {
        this.ticketService = ticketService;
    }

    @GetMapping("/summary")
    public ResponseEntity<
            ApiResponse<List<TicketSummaryResponse>>
            > getSummary() {

        return ResponseEntity.ok(
                ticketService.getTodayTicketSummary()
        );
    }
}