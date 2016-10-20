package gym.com.br.mylocalgym.Parameters;

/**
 * Created by Matheus on 19/10/2016.
 */

public class MarkerParameter {

    private String title;

    private String snippet;

    public MarkerParameter(String title, String snippet){

        this.title = title;
        this.snippet = snippet;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}
