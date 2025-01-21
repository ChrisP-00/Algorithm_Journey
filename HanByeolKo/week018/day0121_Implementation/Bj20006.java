package week018.day0121_Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Bj20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            Player player = new Player(nickname, level);

            boolean added = false;

            for (Room room : rooms){
                if(room.canJoin(player)){
                    room.addPlayer(player);
                    added = true;
                    break;
                }
            }

            if(!added){
                Room newRoom = new Room(m, level);
                newRoom.addPlayer(player);
                rooms.add(newRoom);
            }
        }

        for(Room room : rooms){
            if(room.isFull()){
                System.out.println("Started!");
            } else{
                System.out.println("Waiting!");
            }
            room.sortPlayers();
            for(Player player : room.players){
                System.out.println(player.level + " " + player.nickname);
            }
        }
    }

    static class Player{
        String nickname;
        int level;

        public Player(String nickname, int level){
            this.nickname = nickname;
            this.level = level;
        }
    }

    static class Room{
        int limit;
        int maxLevel;
        int minLevel;
        List<Player> players;

        public Room(int limit, int level){
            this.limit = limit;
            this.maxLevel = level + 10;
            this.minLevel = level - 10;
            this.players = new ArrayList<>();
        }

        public boolean canJoin(Player player){
            return players.size() < limit && player.level >= minLevel && player.level <= maxLevel;
        }

        public void addPlayer(Player player){
            players.add(player);
        }

        public void sortPlayers(){
            players.sort(Comparator.comparing(p->p.nickname));
        }

        public boolean isFull(){
            return players.size() == limit;
        }
    }
}
