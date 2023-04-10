package org.example;

interface Player {
    String name();
}
record BaseballPlayer(String name, String position) implements  Player{}
record FootballPlayer(String name, String position) implements  Player{}
record VolleyballPlayer(String name, String position) implements Player{}
public class Main {
    public static void main(String[] args) {

        var philly = new Affiliation("city", "Philadephia, PA", "US");

        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoredResult(phillies1, 3, astros1, 5);
        System.out.println("-".repeat(80));

        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        scoredResult(phillies2, 3, astros2, 5);

        Team<BaseballPlayer, Affiliation> phillies = new Team<>("Philadelphia Phillies", philly);
        Team<BaseballPlayer, Affiliation> astros = new Team<>("Houston Astros", philly) ;
        scoredResult(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
        phillies.addTeamMember(guthrie);
        phillies.listTeamMembers();
        System.out.println("-".repeat(80));


        SportsTeam afc1 = new SportsTeam("Adelaide Crows");
        Team<FootballPlayer, Affiliation> afc = new Team<>("Adelaide Crows", "City of Adelaide, South Australia in AU");
        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
        afc.addTeamMember(tex);
        var rory = new FootballPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();
        System.out.println("-".repeat(80));

        Team<VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm", philly);
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
        adelaide.listTeamMembers();
        System.out.println("-".repeat(80));

        var canberra = new Team<VolleyballPlayer, Affiliation>("Canberra Heat", philly);
        canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        scoredResult(canberra, 0, adelaide, 1);
        System.out.println("-".repeat(80));

//        Team<Integer> melbourneVB = new Team<>("Melbourne Vipers");
    }

    public static void scoredResult(BaseballTeam team1, int t1_score,
                                    BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
    public static void scoredResult(SportsTeam team1, int t1_score,
                                    SportsTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoredResult(Team team1, int t1_score,
                                    Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score,t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

}