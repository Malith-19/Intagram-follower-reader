import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the profile link: ");
        String profileLink = sc.nextLine();


        URI uri = new URI(profileLink + "followers");
        java.awt.Desktop.getDesktop().browse(uri);
        System.out.println("Followers web page opened in browser.Please copy list much as you need.\nAfter that paste here and enter #.");

        ArrayList<String> followers =  getInputData();

        URI uri1 = new URI(profileLink + "following");
        java.awt.Desktop.getDesktop().browse(uri1);
        System.out.println("Following web page opened in browser.Please copy list much as you need.\nAfter that paste here and enter #.");

        ArrayList<String> following = getInputData();

        decryptData(followers,following);


    }



    private static ArrayList<String> getInputData(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while(true){
            String line = scanner.nextLine();
            if(line.equals("#")) {
                break;
            }
            lines.add(line);
        }

        return lines;
    }

    private static void decryptData(ArrayList<String> followers,ArrayList<String> following){
        System.out.println("Followers:\n ");

        for(int i = 0;i <followers.size();i++){
            String line = followers.get(i);
            if(line.contains("profile picture")){
                String name = line.replace("'s profile picture","");
                System.out.println(name);
            }

        }

        System.out.println("\n\nFollowing:\n ");

        for(int i = 0;i <followers.size();i++){
            String line = followers.get(i);
            if(line.contains("profile picture")){
                String name = line.replace("'s profile picture","");
                System.out.println(name);
            }

        }



    }
}

