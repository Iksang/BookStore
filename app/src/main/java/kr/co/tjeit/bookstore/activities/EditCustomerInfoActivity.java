package kr.co.tjeit.bookstore.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.tjeit.bookstore.R;
import kr.co.tjeit.bookstore.datas.Customer;

public class EditCustomerInfoActivity extends AppCompatActivity {

    private EditText nameEdt;
    private EditText phoneEdt;
    private EditText emailEdt;
    private Button saveBtn;
    private Customer mCustomer;
    private TextView activityTitleTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer_info);
        bindView();

        mCustomer = (Customer)getIntent().getSerializableExtra("customer");

        if(mCustomer != null) {

            activityTitleTxt.setText("회원 정보 수정");
            nameEdt.setText(mCustomer.name);
            phoneEdt.setText(mCustomer.phoneNum);
            emailEdt.setText(mCustomer.email);
        }


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerName = nameEdt.getText().toString();
                String customerPhone = phoneEdt.getText().toString();
                String customerEmail = emailEdt.getText().toString();

                Customer myCustomer = new Customer(customerName, customerPhone, customerEmail);

                Toast.makeText(EditCustomerInfoActivity.this, "저장이 완료되었습니다", Toast.LENGTH_SHORT).show();

                // 이전 화면으로 데이터 전송
                Intent intent = new Intent();
                intent.putExtra("newCustomer",myCustomer);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void bindView() {
        nameEdt = (EditText)findViewById(R.id.nameEdt);
        phoneEdt = (EditText)findViewById(R.id.phoneEdt);
        emailEdt = (EditText)findViewById(R.id.emailEdt);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        activityTitleTxt = (TextView)findViewById(R.id.activityTitleTxt);


    }
}
