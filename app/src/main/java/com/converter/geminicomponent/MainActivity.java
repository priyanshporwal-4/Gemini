package com.converter.geminicomponent;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText promptInput;
    private Button generateButton;
    private TextView generatedText;
    private ProgressBar progressBar;

    // REPLACE THIS WITH YOUR ACTUAL API KEY
    private static final String API_KEY = "YOUR_API_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generatedText = findViewById(R.id.generated_text);
        promptInput = findViewById(R.id.prompt_input);
        generateButton = findViewById(R.id.generate_button);
        progressBar = findViewById(R.id.pogressBar);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeminiPro model = new GeminiPro();

                String prompt = promptInput.getText().toString();
                if (prompt.isEmpty()) {

                }
                progressBar.setVisibility(View.VISIBLE);

                generatedText.setText("");
                promptInput.setText("");

                model.getResponse(prompt, new ResponseCallback() {
                    @Override
                    public void onResponse(String response) {
                        generatedText.setText(response);
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        });

    }
}




