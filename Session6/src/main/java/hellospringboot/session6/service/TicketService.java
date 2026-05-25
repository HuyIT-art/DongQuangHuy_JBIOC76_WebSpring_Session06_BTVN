package hellospringboot.session6.service;

import hellospringboot.session6.dto.ApiResponse;
import hellospringboot.session6.dto.TicketSummaryResponse;

import java.util.List;

public interface TicketService {

    ApiResponse<List<TicketSummaryResponse>>
    getTodayTicketSummary();
}