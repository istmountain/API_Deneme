package pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HerokuappResponse_pojo {

    private Integer bookingiD;
    private HeroukappBooking_pojo booking;

    public HerokuappResponse_pojo() {
    }

    public HerokuappResponse_pojo(Integer bookingiD, HeroukappBooking_pojo booking) {
        this.bookingiD = bookingiD;
        this.booking = booking;
    }

    public HerokuappResponse_pojo(HeroukappBooking_pojo booking) {
        this.booking = booking;
    }

    public Integer getBookingiD() {
        return bookingiD;
    }

    public void setBookingiD(Integer bookingiD) {
        this.bookingiD = bookingiD;
    }

    public HeroukappBooking_pojo getBooking() {
        return booking;
    }

    public void setBooking(HeroukappBooking_pojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("pojos.HerokuappResponse_pojo{");
        sb.append("bookingiD=").append(bookingiD);
        sb.append(", booking=").append(booking);
        sb.append('}');
        return sb.toString();
    }
}
