package tidysnapsinc.com.interactivestory.model;

/**
 * Created by drj29_000 on 5/8/2015.
 */
public class Choice {
    private String _text;
    private int _nextPage;

    public Choice(String text, int nextPage)
    {
        _text = text;
        _nextPage = nextPage;
    }
    
    public String getText()
    {
        return  _text;
    }

    public int getNextPage()
    {
        return _nextPage;
    }
}
