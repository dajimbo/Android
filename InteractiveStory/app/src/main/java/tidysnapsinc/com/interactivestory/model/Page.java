package tidysnapsinc.com.interactivestory.model;

/**
 * Created by drj29_000 on 5/8/2015.
 */
public class Page {
    private int _imageId;
    private String _text;
    private Choice _choice1;
    private Choice _choice2;
    private boolean _lastPage = false;

    public Page(int imageId, String text, Choice choice1, Choice choice2)
    {
        _imageId = imageId;
        _text = text;
        _choice1 = choice1;
        _choice2 = choice2;
    }

    public Page(int imageId, String text)
    {
        _imageId = imageId;
        _text = text;
        _lastPage = true;
    }

    public boolean getLastPage()
    {
        return _lastPage;
    }

    public void setLastPage(boolean lastPage)
    {
        _lastPage = lastPage;
    }
    public int getImageId() {
        return _imageId;
    }

    public void setImageId(int imageId) {
        _imageId = imageId;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        _text = text;
    }

    public Choice getChoice1() {
        return _choice1;
    }

    public void setChoice1(Choice choice1) {
        _choice1 = choice1;
    }

    public Choice getChoice2() {
        return _choice2;
    }

    public void setChoice2(Choice choice2) {
        _choice2 = choice2;
    }

}
