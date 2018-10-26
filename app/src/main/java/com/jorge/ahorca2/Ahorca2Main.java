package com.jorge.ahorca2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    private static final String GAME = "GAME";

    private TextView tvWord1;
    private TextView tvWord2;
    private EditText etLetter;
    private ImageButton btnRestart;

    private WordsProvider wordsProvider;
    private BasicAhorca2WordsGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorca2_main);

        tvWord1 = findViewById(R.id.word1);
        tvWord2 = findViewById(R.id.word2);
        etLetter = findViewById(R.id.letter);
        btnRestart = findViewById(R.id.restart);

        etLetter.addTextChangedListener(createWatcher());
        btnRestart.setOnClickListener(createClickListenerToRestart());

        wordsProvider = new FakeWordsProvider();

        if(savedInstanceState == null) {
            startNewGame();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
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
        startNewGame();
    }

    private void startNewGame() {
        Ahorca2Words words = wordsProvider.getWords();
        game = new BasicAhorca2WordsGame(words);
        updateTextViews();
        resetTextViews();
    }

    private void resetTextViews() {
        tvWord1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tvWord2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }

    private void updateTextViews() {
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
                    etLetter.setText("");
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
            updateTextViews();

            etLetter.getBackground().setColorFilter(
                    Color.GREEN,
                    PorterDuff.Mode.SRC_ATOP
            );

            Toast.makeText(this.getApplicationContext(),"Well done!", Toast.LENGTH_SHORT).show();

            if(game.isFinished()){
                finishGame();
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

    private void finishGame() {
        Toast.makeText(this.getApplicationContext(),"CONGRATULATIONS!! Game finished!!", Toast.LENGTH_LONG).show();
        etLetter.setVisibility(View.INVISIBLE);
        tvWord1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tvWord2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        hideKeyboard(etLetter);
    }

    private void hideKeyboard(EditText etLetter) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm != null) imm.hideSoftInputFromWindow(etLetter.getWindowToken(), 0);
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
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(GAME, game);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        game = (BasicAhorca2WordsGame) savedInstanceState.getSerializable(GAME);
        updateTextViews();
        if(game.isFinished())
            finishGame();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ahorca2_main, menu);
        return true;
    }
}
