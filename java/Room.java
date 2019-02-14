


import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Room")
@Table(name = "Room")


public class Room{
    private long id;
    private int numberOfGuests;
    private double price;
    private int breakfastIncluded;
    private int petesAllowed;
    private Date dateAvailableFrom;


    private Hotel hotel;


    public Room() {
    }

    public Room(int numberOfGuests, double price, int breakfastIncluded, int petesAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petesAllowed = petesAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public Room(long id, int numberOfGuests, double price, int breakfastIncluded, int petesAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petesAllowed = petesAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    @Id
    @SequenceGenerator(name = "PR_SEQ", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PR_SEQ")
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NUMBEROFGUESTS")
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "BREAKFASTINCLUDED")
    public int getBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(int breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }


    @Column(name = "PETSALLOWED")
    public int getPetesAllowed() {
        return petesAllowed;
    }

    public void setPetesAllowed(int petesAllowed) {
        this.petesAllowed = petesAllowed;
    }

    @Temporal(TemporalType.DATE)
    @Column(name= "DATEAVAILABLEFROM")
    public Date getDateAvailableFrom(){
        return dateAvailableFrom;
    }
    public void setDateAvailableFrom(Date dateAvailableFrom){
        this.dateAvailableFrom = dateAvailableFrom;
    }


@OneToOne(cascade = CascadeType.ALL, optional = false, fetch= FetchType.LAZY)
@JoinColumn(name = "HOTEL_ID", unique=true, nullable=false, updatable=true)
@LazyToOne(value = LazyToOneOption.NO_PROXY)
    public Hotel getHotel() {
        return hotel;
    }
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", numberOfGuests=" + numberOfGuests +
                ", price=" + price +
                ", breakfastIncluded=" + breakfastIncluded +
                ", petesAllowed=" + petesAllowed +
                ", hotel=" + hotel +
                '}';
    }
}
