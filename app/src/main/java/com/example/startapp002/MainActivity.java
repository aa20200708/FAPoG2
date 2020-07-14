package com.example.startapp002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //создаем два поля
    private EditText EditText_f1;
    private Button Button_f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //устанавливаем связь между идентификатором элемента и переменной
        Button_f1 = findViewById(R.id.Button_a1);
        EditText_f1 = findViewById(R.id.EditText_a1);

        //"вешаем" OnclickListener на кнопку
        Button_f1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //сохраняем в переменную, написанное в поле ввода
                String text_of_letter = EditText_f1.getText().toString();

                //передаем контекст в качестве аргумента (?)
                Context context = MainActivity.this;

                //получаем класс Acivity, которое желаем запустить ("место назначения")
                Class destinationActivity = MainActivity2.class;

                //создаем Intent (намерение)
                Intent MainActivity2 = new Intent(context, destinationActivity);

                //для передачи данных применяем метод putExtra(), где Intent.EXTRA_TEXT - ключ (можно,
                // но не нужно, использовать любой), text_of_letter - связанное с ним значение
                MainActivity2.putExtra(Intent.EXTRA_TEXT, text_of_letter);

                //вызываем метод startActivity для явного перехода или startActivityForResult для неявного
                startActivity(MainActivity2);
            }
        });

    }
}