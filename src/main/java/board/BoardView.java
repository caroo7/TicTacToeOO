package board;

public class BoardView {

    public String prepareReadableOutput(String result) {
        result = result.replaceAll("[\\[\\]]", "");
        result = result.replaceAll("\n, ", "\n");
        result = result.replaceAll(",", "");
        return result;
    }

}
