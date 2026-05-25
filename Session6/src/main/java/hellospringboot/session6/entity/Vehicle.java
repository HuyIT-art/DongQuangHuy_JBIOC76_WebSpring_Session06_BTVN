package hellospringboot.session6.entity;

import hellospringboot.session6.enums.VehicleType;
import jakarta.persistence.*;

        import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate")
    private String licensePlate;

    private String color;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @OneToMany(mappedBy = "vehicle")
    private List<ParkingTicket> parkingTickets =
            new ArrayList<>();

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getType() {
        return type;
    }

    public List<ParkingTicket> getParkingTickets() {
        return parkingTickets;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}