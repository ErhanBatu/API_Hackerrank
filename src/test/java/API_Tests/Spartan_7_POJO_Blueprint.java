package API_Tests;

public class Spartan_7_POJO_Blueprint {

    private int page;
    private int per_page;

    public Spartan_7_POJO_Blueprint() {
    }

    @Override
    public String toString() {
        return "Spartan_7_POJO_Blueprint{" +
                "page=" + page +
                ", per_page=" + per_page +
                '}';
    }

    public Spartan_7_POJO_Blueprint(int page, int per_page) {
        this.page = page;
        this.per_page = per_page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }
}
