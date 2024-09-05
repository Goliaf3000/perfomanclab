package task3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestReportGenerator {

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode testResultsNode = objectMapper.readTree(new File(args[0]));
            JsonNode testStructureNode = objectMapper.readTree(new File(args[1]));

            Map<Integer, String> testResultsMap = new HashMap<>();
            for (JsonNode resultNode : testResultsNode.get("values")) {
                int testId = resultNode.get("id").asInt();
                String resultValue = resultNode.get("value").asText();
                testResultsMap.put(testId, resultValue);
            }

            populateTestValues(testStructureNode.get("tests"), testResultsMap);

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(args[2]), testStructureNode);

            System.out.println("Отчет успешно сгенерирован!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void populateTestValues(JsonNode testsNode, Map<Integer, String> testResultsMap) {
        for (JsonNode testNode : testsNode) {
            int testId = testNode.get("id").asInt();
            if (testResultsMap.containsKey(testId)) {
                ((ObjectNode) testNode).put("value", testResultsMap.get(testId));
            }

            if (testNode.has("values")) {
                populateTestValues(testNode.get("values"), testResultsMap);
            }
        }
    }
}
