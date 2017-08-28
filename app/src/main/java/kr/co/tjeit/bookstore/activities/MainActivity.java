package kr.co.tjeit.bookstore.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import kr.co.tjeit.bookstore.R;

public class MainActivity extends AppCompatActivity {

    private Button customerAdminBtn;
    private Button bookAdminBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFiled();

        bindView();

        customerAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myItent = new Intent(MainActivity.this, CustomerListActivity.class);
                startActivity(myItent);
            }
        });
        bookAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookListActivity.class);
                startActivity(intent);
            }
        });

    }

    private void viewFiled() {
        this.bookAdminBtn = (Button) findViewById(R.id.bookAdminBtn);
        this.customerAdminBtn = (Button) findViewById(R.id.customerAdminBtn);
    }

    private void bindView() {
        customerAdminBtn = (Button)findViewById(R.id.customerAdminBtn);
    }
}
