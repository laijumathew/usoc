/*
ID: laijuma1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {
    public static void main(String args[]) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

        //Get total number of friends
        int nFriends = Integer.parseInt(f.readLine());

        if(nFriends <=0) {
            output.close();
            System.exit(0);
        }

        String[] friends = new String[nFriends];
        int[] gives = new int[nFriends];
        int[] recieves = new int[nFriends];

        for(int i =0 ; i < nFriends; i++) {
            gives[i] = 0;
            recieves[i] = 0;
        }

        //Get name of friends
        for(int i = 0; i < nFriends; i++) {
            friends[i] = f.readLine();
        }

        //Get amount and division details of each friend

        String owner;
        while((owner = f.readLine()) != null) {
            //Get money owner
            String line2 = f.readLine();

            int ownerIndex = searchForFriend(friends, owner);

            //Check if this a line with two tokens
            //i.e line with amount and number of people to divide with
            StringTokenizer st = new StringTokenizer(line2);

            //Get total amount and number of people to share
            //Total amount
            int total = Integer.parseInt(st.nextToken());
            int shareCount = Integer.parseInt(st.nextToken());


           //Get person for whom this should be credited
           if(shareCount > 0) {
            int shareForEach = total/shareCount;
            gives[ownerIndex] += (shareForEach * shareCount);
            for(int fr = 0; fr < shareCount; fr++) {
                String friend = f.readLine();
                int frIndex = searchForFriend(friends, friend);
                recieves[frIndex] += shareForEach;
            }
           }
        }

        for(int i = 0; i < nFriends; i++) {
            output.println(friends[i] +" "+ (recieves[i] - gives[i]));
        }
        output.close();
        System.exit(0);
    }

    private static int searchForFriend(String[] array, String name) {
        for(int i=0; i < array.length; i++) {
            if(array[i].equals(name)) {
                return i;
            }
        }

        return -1;
    }
}