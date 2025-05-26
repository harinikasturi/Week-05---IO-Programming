import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class IPLCensorAnalyzer {

    public static void main(String[] args) {
        try {
            // Process JSON file
            processJsonFile("ipl_data.json", "censored_ipl_data.json");

            // Process CSV file
            processCsvFile("ipl_data.csv", "censored_ipl_data.csv");

            System.out.println("Censorship completed successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void processJsonFile(String inputFile, String outputFile) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(inputFile)));
        JSONArray matches = new JSONArray(content);

        for (int i = 0; i < matches.length(); i++) {
            JSONObject match = matches.getJSONObject(i);

            // Apply censorship rules
            censorTeamName(match, "team1");
            censorTeamName(match, "team2");
            censorTeamName(match, "winner");

            // Redact player of the match
            if (match.has("player_of_match")) {
                match.put("player_of_match", "REDACTED");
            }

            // Censor team names in score object if it exists
            if (match.has("score")) {
                JSONObject score = match.getJSONObject("score");
                for (String team : score.keySet()) {
                    String censoredTeam = censorName(team);
                    if (!censoredTeam.equals(team)) {
                        int teamScore = score.getInt(team);
                        score.remove(team);
                        score.put(censoredTeam, teamScore);
                    }
                }
            }
        }

        // Write censored data to new file
        try (FileWriter file = new FileWriter(outputFile)) {
            file.write(matches.toString(2));
        }
    }

    private static void processCsvFile(String inputFile, String outputFile) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        if (lines.isEmpty()) return;

        List<String> censoredLines = new ArrayList<>();
        censoredLines.add(lines.get(0)); // Add header

        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");

            // Apply censorship rules
            if (values.length > 1) values[1] = censorName(values[1]); // team1
            if (values.length > 2) values[2] = censorName(values[2]); // team2
            if (values.length > 5) values[5] = censorName(values[5]); // winner
            if (values.length > 6) values[6] = "REDACTED"; // player_of_match

            censoredLines.add(String.join(",", values));
        }

        // Write censored data to new file
        Files.write(Paths.get(outputFile), censoredLines);
    }

    private static void censorTeamName(JSONObject match, String field) {
        if (match.has(field)) {
            String teamName = match.getString(field);
            match.put(field, censorName(teamName));
        }
    }

    private static String censorName(String name) {
        if (name == null || name.isEmpty()) return name;

        String[] parts = name.split(" ");
        if (parts.length > 1) {
            return parts[0] + " ****";
        }
        return name;
    }
}