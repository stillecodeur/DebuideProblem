package beds;

public abstract class Bed {

    private String title;

    public Bed(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
