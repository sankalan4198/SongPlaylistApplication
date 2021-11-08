public class Song {
    String title;
    double duration;

    public Song(String title, double duration)
    {
        this.title=title;
        this.duration=duration;
    }
    //Empty constructor
    public Song(){

    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }
    //This return the property of the objects
    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
