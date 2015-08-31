package tidysnapsinc.com.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tidysnapsinc.com.interactivestory.R;


public class MainActivity extends ActionBarActivity {
    private EditText _nameField;
    private Button _startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _nameField = (EditText)findViewById(R.id.textInput);
        _startBtn = (Button)findViewById(R.id.startBtn);
        _startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = _nameField.getText().toString();
                startStory(name);
               // Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
            }
        });
    }

    private void startStory(String name)
    {
        Intent intent = new Intent(this,StoryActivity.class);
        intent.putExtra(getString(R.string.key_name),name);
        startActivity(intent);
    }


}
