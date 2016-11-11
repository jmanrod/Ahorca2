package com.jorge.ahorca2;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jorge.core.Ahorca2Words;
import com.jorge.game.BasicAhorca2WordsGame;
import com.jorge.core.providers.FakeWordsProvider;
import com.jorge.core.providers.WordsProvider;

public class Ahorca2Main extends AppCompatActivity {

    public static final String WHITESPACE = " ";

    private TextView tvWord1;
    private TextView tvWord2;
    private EditText etLetter;

    private WordsProvider wordsProvider;
    private BasicAhorca2WordsGame game;
    private ImageButton btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorca2_main);

        tvWord1 = (TextView) findViewById(R.id.word1);
        tvWord2 = (TextView) findViewById(R.id.word2);
        etLetter = (EditText) findViewById(R.id.letter);
        btnRestart = (ImageButton) findViewById(R.id.restart);

        wordsProvider = new FakeWordsProvider();

        etLetter.addTextChangedListener(createWatcher());
        btnRestart.setOnClickListener(createClickListenerToRestart());

        startGame();
    }

    @Override
    protected void onResume() {
        super.onStart();
        etLetter.requestFocus();
    }

    @NonNull
    private View.OnClickListener createClickListenerToRestart() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        };
    }

    private void restartGame() {
        etLetter.getBackground().setColorFilter(
                Color.GRAY,
                PorterDuff.Mode.SRC_ATOP
        );

        etLetter.setVisibility(View.VISIBLE);
        startGame();
    }

    private void startGame() {
        Ahorca2Words words = wordsProvider.getWords();
        game = new BasicAhorca2WordsGame(words);
        tvWord1.setText(includeWhitespaces(game.getWord1UnderScored()));
        tvWord2.setText(includeWhitespaces(game.getWord2UnderScored()));
    }

    private TextWatcher createWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && s.length() > 0) {
                    checkLetter(s.toString());
                }
            }
        };
    }

    private void checkLetter(String s) {
        if(game.isLetterAlreadyPressed(s)){
            etLetter.getBackground().setColorFilter(
                    Color.RED,
                    PorterDuff.Mode.SRC_ATOP
            );

            Toast.makeText(this.getApplicationContext(),"Come on! You can do it better!", Toast.LENGTH_SHORT).show();
        } else if(game.replace(s)){
            tvWord1.setText(includeWhitespaces(game.getWord1UnderScored()));
            tvWord2.setText(includeWhitespaces(game.getWord2UnderScored()));

            etLetter.getBackground().setColorFilter(
                    Color.GREEN,
                    PorterDuff.Mode.SRC_ATOP
            );

            Toast.makeText(this.getApplicationContext(),"Well done!", Toast.LENGTH_SHORT).show();

            if(game.isFinished()){
                etLetter.setVisibility(View.INVISIBLE);
                etLetter.clearFocus();
                Toast.makeText(this.getApplicationContext(),"CONGRATULATIONS!! Game finished!!", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this.getApplicationContext(),":(  Try again!", Toast.LENGTH_SHORT).show();

            etLetter.getBackground().setColorFilter(
                    Color.RED,
                    PorterDuff.Mode.SRC_ATOP
            );
        }
        //Clean the EditText whithout launching an event
        etLetter.getText().clear();
    }

    private String includeWhitespaces(String word) {
        StringBuilder stringWithSpaces = new StringBuilder(word);
        for (int i = 0; i < word.length()*2; i++){
            if(i%2 != 0)
                stringWithSpaces.insert(i, WHITESPACE);
        }
        return stringWithSpaces.toString();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ahorca2_main, menu);
        return true;
    }
}
