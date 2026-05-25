package hellospringboot.session6.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zones")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer capacity;

    @Column(name = "occupied_spots")
    private Integer occupiedSpots;

    @OneToMany(mappedBy = "zone")
    private List<ParkingTicket> parkingTickets =
            new ArrayList<>();

    public Zone() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getOccupiedSpots() {
        return occupiedSpots;
    }

    public List<ParkingTicket> getParkingTickets() {
        return parkingTickets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setOccupiedSpots(Integer occupiedSpots) {
        this.occupiedSpots = occupiedSpots;
    }
}