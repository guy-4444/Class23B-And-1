package com.guy.class23b_and_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class Activity_Game extends AppCompatActivity {

    ArrayList<Question> questions = new ArrayList<>();


    private AppCompatImageView[] game_IMG_hearts;

    private AppCompatImageView game_IMG_heart1;
    private AppCompatImageView game_IMG_heart2;
    private AppCompatImageView game_IMG_heart3;
    private AppCompatImageView game_IMG_animal;
    private MaterialTextView game_LBL_score;
    private MaterialTextView game_LBL_name;
    private MaterialButton game_BTN_no;
    private MaterialButton game_BTN_yes;

    private int index = 0;
    private int lives = 3;
    private int score = 0;

    private final static int SCORE_PER_ANSWER = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        findViews();
        initViews();

        questions.add(new Question().setName("bear").setImage(R.drawable.img_bear).setKosher(false));
        questions.add(new Question().setName("bison").setImage(R.drawable.img_bison).setKosher(true));
        questions.add(new Question().setName("camel").setImage(R.drawable.img_camel).setKosher(false));
        questions.add(new Question().setName("cheetah").setImage(R.drawable.img_cheetah).setKosher(false));
        questions.add(new Question().setName("chicken").setImage(R.drawable.img_chicken).setKosher(true));
        questions.add(new Question().setName("cow").setImage(R.drawable.img_cow).setKosher(true));
        questions.add(new Question().setName("crab").setImage(R.drawable.img_crab).setKosher(false));
        questions.add(new Question().setName("crocodile").setImage(R.drawable.img_crocodile).setKosher(false));
        questions.add(new Question().setName("deer").setImage(R.drawable.img_deer).setKosher(true));
        questions.add(new Question().setName("dog").setImage(R.drawable.img_dog).setKosher(false));
        questions.add(new Question().setName("duck").setImage(R.drawable.img_duck).setKosher(true));
        questions.add(new Question().setName("giraffe").setImage(R.drawable.img_giraffe).setKosher(true));
        questions.add(new Question().setName("goat").setImage(R.drawable.img_goat).setKosher(true));
        questions.add(new Question().setName("horse").setImage(R.drawable.img_horse).setKosher(false));
        questions.add(new Question().setName("prawn").setImage(R.drawable.img_prawn).setKosher(false));
        questions.add(new Question().setName("puffer").setImage(R.drawable.img_puffer).setKosher(false));
        questions.add(new Question().setName("rabbit").setImage(R.drawable.img_rabbit).setKosher(false));
        questions.add(new Question().setName("rat").setImage(R.drawable.img_rat).setKosher(false));
        questions.add(new Question().setName("shark").setImage(R.drawable.img_shark).setKosher(false));
        questions.add(new Question().setName("sheep").setImage(R.drawable.img_sheep).setKosher(true));
        questions.add(new Question().setName("snail").setImage(R.drawable.img_snail).setKosher(false));
        questions.add(new Question().setName("snake").setImage(R.drawable.img_snake).setKosher(false));
        questions.add(new Question().setName("tang").setImage(R.drawable.img_tang).setKosher(true));
        questions.add(new Question().setName("turkey").setImage(R.drawable.img_turkey).setKosher(true));
        questions.add(new Question().setName("turtle").setImage(R.drawable.img_turtle).setKosher(false));
        questions.add(new Question().setName("yak").setImage(R.drawable.img_yak).setKosher(true));
        questions.add(new Question().setName("zebra").setImage(R.drawable.img_zebra).setKosher(false));


        updateUI();
    }



    private void clicked(boolean answer) {
        Question question = questions.get(index);
        if (answer == question.isKosher()) {
            addScore();
        } else {
            reduceLive();
        }
        next();
    }

    private void addScore() {
        score += SCORE_PER_ANSWER;
    }

    private void reduceLive() {
        lives--;
    }

    private void next() {
        index++;
        if (hasNext()  &&  lives > 0) {
            updateUI();
        } else {
            gameOver();
        }
    }

    private boolean hasNext() {
        return index < questions.size();
    }

    private void gameOver() {
        Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show();
    }

    private void updateUI() {
        game_LBL_score.setText("" + score);
        refreshLivesUI();

        Question question = questions.get(index);
        game_LBL_name.setText(question.getName());
        game_IMG_animal.setImageResource(question.getImage());

    }

    private void refreshLivesUI() {
        for (int i = 0; i < lives; i++) {
            game_IMG_hearts[i].setVisibility(View.VISIBLE);
        }

        for (int i = lives; i < game_IMG_hearts.length; i++) {
            game_IMG_hearts[i].setVisibility(View.INVISIBLE);
        }
    }

    private void initViews() {
        game_BTN_no.setOnClickListener(v -> clicked(false));
        game_BTN_yes.setOnClickListener(v -> clicked(true));
    }

    private void findViews() {
        game_IMG_heart1 = findViewById(R.id.game_IMG_heart1);
        game_IMG_heart2 = findViewById(R.id.game_IMG_heart2);
        game_IMG_heart3 = findViewById(R.id.game_IMG_heart3);
        game_IMG_animal = findViewById(R.id.game_IMG_animal);
        game_LBL_score = findViewById(R.id.game_LBL_score);
        game_LBL_name = findViewById(R.id.game_LBL_name);
        game_BTN_no = findViewById(R.id.game_BTN_no);
        game_BTN_yes = findViewById(R.id.game_BTN_yes);

        game_IMG_hearts = new AppCompatImageView[]{
                game_IMG_heart1,
                game_IMG_heart2,
                game_IMG_heart3,
        };
    }
}
