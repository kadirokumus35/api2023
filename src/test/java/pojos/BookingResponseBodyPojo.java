package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class BookingResponseBodyPojo {
    // 1) Tum keyler icin private variable lar olusturuyoruz
    private Integer bookingid;
    private BookingPojo booking;

    //2) Tum parametrelerle ve parametresiz constructurlarımızı olusturuyoruz


    public BookingResponseBodyPojo() {
    }

    public BookingResponseBodyPojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    //3) Getter ve Setters lerimizi olustuuryoruz

    public Integer getBookingid() {
        return bookingid;
    }

    //4) create toString methodumuzu olusturuyoruz


    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }
}
