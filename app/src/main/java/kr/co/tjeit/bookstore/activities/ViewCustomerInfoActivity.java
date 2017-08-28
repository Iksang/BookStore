package kr.co.tjeit.bookstore.activities;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.tjeit.bookstore.R;
import kr.co.tjeit.bookstore.datas.Customer;

public class ViewCustomerInfoActivity extends AppCompatActivity {

    private Customer mCustomer;
    private TextView customerNameTxt;
    private TextView customerPhoneNumTxt;
    private TextView customerEmailTxt;
    private Button modifyCustomerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer_info);
        bindView();
        mCustomer = (Customer)getIntent().getSerializableExtra("customer");


        customerNameTxt.setText(mCustomer.name);
        customerPhoneNumTxt.setText(mCustomer.phoneNum);
        customerEmailTxt.setText(mCustomer.email);



        modifyCustomerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCustomerInfoActivity.this, EditCustomerInfoActivity.class);
                intent.putExtra("customer", mCustomer);
                startActivityForResult(intent, 1000);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if(resultCode == RESULT_OK){
                Customer tempCustomer = (Customer)data.getSerializableExtra("newCustomer");
                customerNameTxt.setText(tempCustomer.name);
                customerPhoneNumTxt.setText(tempCustomer.phoneNum);
                customerEmailTxt.setText(tempCustomer.email);

                int originalPosion = getIntent().getIntExtra("position",-1);

                Customer originalCustomer = CustomerListActivity.customers.get(originalPosion);
                originalCustomer.name = tempCustomer.name;
                originalCustomer.phoneNum = tempCustomer.phoneNum;
                originalCustomer.email = tempCustomer.email;

            }
        }
    }

    private void bindView() {
        customerNameTxt = (TextView)findViewById(R.id.customerNameTxt);
        customerPhoneNumTxt = (TextView)findViewById(R.id.customerPhoneNumTxt);
        customerEmailTxt = (TextView)findViewById(R.id.customerEmailTxt);
        modifyCustomerBtn = (Button) findViewById(R.id.modifyCustomerBtn);
    }
}
