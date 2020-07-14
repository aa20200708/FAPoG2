package com.example.startapp002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    //создаем поле
    private Button Button_f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //получаем введенный на MainActivity текст, воспользовавшись методом get(), в который передается ключ объекта
        //(для истории - 10,5 часов на 2 строчки)
        Bundle arguments = getIntent().getExtras();
        final String text_of_letter = arguments.get(Intent.EXTRA_TEXT).toString();

        //устанавливаем связь между идентификатором элемента и переменной
        Button_f2 = findViewById(R.id.Button_a2);

        //"вешаем" OnclickListener на кнопку
        Button_f2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //читерим, воспользовавшись https://developer.android.com/guide/components/intents-common#Email
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("string");
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"freeit.andr0id@gmail.com", "aa20200708@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Android task1");

                //добавляем строку, передающую текст, введенный на первой Activity
                intent.putExtra(Intent.EXTRA_TEXT, text_of_letter);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}