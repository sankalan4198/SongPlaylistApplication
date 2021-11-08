import java.util.*;

public class Main {
    private static ArrayList<Album> albums= new ArrayList<>();

    public static void main(String[] args){

        Album album=new Album("Album1","LINKIN PARK");

        album.addSong("NUMB",4.5);
        album.addSong("In the End",3.6);
        album.addSong("New Divide",5.2);
        albums.add(album);

        album=new Album("Album2", "AC/DC");

        album.addSong("Thunderstruck",3.8);
        album.addSong("Highway to Hell",4.7);
        album.addSong("TNT",4.2);

        albums.add(album);

        LinkedList<Song> playList_1=new LinkedList<>();

        albums.get(0).addToPlaylist("NUMB",playList_1);
        albums.get(1).addToPlaylist("TNT",playList_1);
        albums.get(0).addToPlaylist("In the End",playList_1);
        albums.get(0).addToPlaylist("New Divide",playList_1);

        play(playList_1);

    }

    private static void play(LinkedList<Song> playList)
    {
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size()==0)
        {
            System.out.println("This playlist has no song");
        }
        else
        {
            System.out.println("Now playing "+listIterator.next().toString());
            printMenu();
        }
        //While quit is true or not false
        while(!quit)
        {
            int action=sc.nextInt();

            switch(action){

                case 0:
                    System.out.println("Playlist complete!");
                    quit=true;
                    break;

                case 1:
                    if(!forward)
                    {
                        //checking if next song exists, only if yes then plays
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now playing "+listIterator.next().toString());
                    }
                    else
                    {
                        System.out.println("No Song available, reached to the end of list!");
                        forward= false;
                    }
                    break;

                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }
                    else{
                        System.out.println("We re at the first song");
                        forward=false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                                System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }
            }
        }
    }

    private static void printMenu()
    {
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available songs\n"+
                "6 - delete current song");
    }
    //Method to print the list
    private static void printList(LinkedList<Song> playList)
    {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-------------------------");

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        System.out.println("--------------------------");

    }
}
