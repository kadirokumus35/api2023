package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestResponseBodyPojo {
    // 1) Tum keyler icin private variable lar olusturuyoruz
    private Object meta;
    private GoRestDataPojo data;

    //2) Tum parametrelerle ve parametresiz constructurlarımızı olusturuyoruz


    public GoRestResponseBodyPojo() {
    }

    public GoRestResponseBodyPojo(String meta, GoRestDataPojo data) {
        this.meta = meta;
        this.data = data;
    }

    //3) Getter ve Setters lerimizi olustuuryoruz


    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo getData() {
        return data;
    }

    public void setData(GoRestDataPojo data) {
        this.data = data;
    }

    //4) create toString methodumuzu olusturuyoruz

    @Override
    public String toString() {
        return "GoRestResponseBodyPojo{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
