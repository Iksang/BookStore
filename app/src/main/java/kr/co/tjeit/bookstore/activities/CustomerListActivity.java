package kr.co.tjeit.bookstore.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.tjeit.bookstore.R;
import kr.co.tjeit.bookstore.datas.Customer;

public class CustomerListActivity extends AppCompatActivity {
    private ListView customerListView;
    private ImageButton addCustomerImgBtn;
    // static => 프로그램 실행시에 단 한번 생성되는 변수 / 메쏘드
    // 아무리 다시 new를 만난다고 해도 기존에 만들어진걸 활용
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayAdapter<Customer> customerAdapter;

    // 1. 리스트뷰 멤버변수 => findViewById
    // 2. 리스트뷰에 뿌려줄 데이터 ArrayList 생성 : 멤버변수
    // 3. ArrayList에 데이터 채워넣기. <= 서버에서 받아온 데이터
    // 4. ArrayAdapter => 멤버 변수. onCreate 초기화
    // 5. 리스트뷰 => setAdapter => ArrayAdapter 변수
    // ===> 여기까지가, 데이터를 리스트뷰에 출력하는 방법
    // 6. 리스트뷰를 눌렀을때 이벤트 처리
    // => listView.setOnItemClickLinstner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        bindView();
        customers.clear();
        customers.add(new Customer("고동윤","010-6784-4123","asdfjh@adsf.asdf"));
        customers.add(new Customer("권성민", "010-3214-1145","fjwer@qwej.cne"));
        customers.add(new Customer("김현철", "012-3242-0151", "erkljqwe@nf.eor"));
        customers.add(new Customer("박석영", "012-3242-0151", "dalfkj@nfke.ro"));


        customerAdapter = new ArrayAdapter<Customer>(CustomerListActivity.this,
                android.R.layout.simple_list_item_1, customers);

        customerListView.setAdapter(customerAdapter);

        customerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CustomerListActivity.this, ViewCustomerInfoActivity.class);
                intent.putExtra("customer", customers.get(position));
                intent.putExtra("position",position);

                startActivity(intent);

            }
        });

        customerListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(CustomerListActivity.this);
                myBuilder.setTitle("삭제 확인");
                myBuilder.setMessage("정말 삭제하시겠습니까?");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

//                        Toast.makeText(CustomerListActivity.this, "삭제 준비중입니다.", Toast.LENGTH_SHORT).show();
                        customers.remove(position);
                        customerAdapter.notifyDataSetChanged();
                    }
                });
                myBuilder.setNegativeButton("취소",null);
                myBuilder.setNeutralButton("나중에 하기", null);
                myBuilder.setIcon(R.mipmap.ic_launcher_round);
                myBuilder.show();
                return true;
            }
        });

        
        
        addCustomerImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO - 고객 추가 화면으로 이동시켜야 함.
//                Toast.makeText(CustomerListActivity.this, "아직 준비중인 기능입니다", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CustomerListActivity.this, EditCustomerInfoActivity.class);
                startActivityForResult(intent, 1000);
            }
        });

        

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CustomerListActivity","onResume");
        customerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000){
            Log.d("IS", "사용자 객체가 돌아옴");

            if(resultCode == RESULT_OK) {
                Customer tempCustomer = (Customer)data.getSerializableExtra("newCustomer");
                Log.d("새고객이름", tempCustomer.name);

                customers.add(tempCustomer);

                customerAdapter.notifyDataSetChanged();

            }
        }

    }

    private void bindView() {

        customerListView = (ListView)findViewById(R.id.customerListView);
        addCustomerImgBtn = (ImageButton)findViewById(R.id.addCustomerImgBtn);
    }
}
