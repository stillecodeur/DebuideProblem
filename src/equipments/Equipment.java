package equipments;

public abstract class Equipment {
    private String title;

    public Equipment(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
