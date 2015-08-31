package tidysnapsinc.com.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import tidysnapsinc.com.interactivestory.R;
import tidysnapsinc.com.interactivestory.model.Page;
import tidysnapsinc.com.interactivestory.model.Story;


public class StoryActivity extends ActionBarActivity {
    public static final String TAG = "Story Activity";
    private Story myStory = new Story();
    private ImageView _img;
    private TextView _text;
    private Button _choice1;
    private Button _choice2;
    private String _name;
    private Page _page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        _name = intent.getStringExtra(getString(R.string.key_name));

        if(_name == null)
        {
            _name = "Friend";
        }
        Log.d(TAG,_name);
        _img = (ImageView)findViewById(R.id.pageImage);
        _text = (TextView)findViewById(R.id.pageText);
        _choice1 = (Button)findViewById(R.id.choice1Btn);
        _choice2 = (Button)findViewById(R.id.choice2Btn);
        loadPage(0);

    }

    private void loadPage(int index)
    {
         _page = myStory.getPage(index);
        Drawable draw = getResources().getDrawable(_page.getImageId());
        _img.setImageDrawable(draw);
        String addNameToText = _page.getText();
        addNameToText = String.format(addNameToText,_name);
        _text.setText(addNameToText);

        if(_page.getLastPage() == true)
        {
            _choice1.setVisibility(View.INVISIBLE);
            _choice2.setText("Play Again?");
            _choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else {
            _choice1.setText(_page.getChoice1().getText());
            _choice2.setText(_page.getChoice2().getText());
            _choice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(_page.getChoice1().getNextPage());
                }
            });

            _choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(_page.getChoice2().getNextPage());
                }
            });
        }
    }

}
