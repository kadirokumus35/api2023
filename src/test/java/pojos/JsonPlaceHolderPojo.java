package pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//Farkli key-value ikililerinin uyusmazlıgını
// @JsonIgnoreProperties(ignoreUnknown = true)
// anotationını Pojo classımızın basona yazarak cözebiliriz
public class JsonPlaceHolderPojo {
    /*
    1) Tum keyler icin private variable lar olusturuyoruz
    2) Tum parametrelerle ve parametresiz constructurlarımızı olusturuyoruz
    3) Getter ve Setters lerimizi olustuuryoruz
    4) create toString methodumuzu olusturuyoruz
     */

    // 1) Tum keyler icin private variable lar olusturuyoruz
    private Integer userId; // int de yazabiliriz daha hizli olur  hatta. ama metodlar gelmez
    private String title;
    private Boolean completed;

    //2) Tum parametrelerle ve parametresiz constructurlarımızı olusturuyoruz


    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {

    }

    //3) Getter ve Setters lerimizi olusturyoruz

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //4) create toString methodumuzu olusturuyoruz

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

}
