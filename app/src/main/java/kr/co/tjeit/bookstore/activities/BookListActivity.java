package kr.co.tjeit.bookstore.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.tjeit.bookstore.R;
import kr.co.tjeit.bookstore.datas.Book;

public class BookListActivity extends AppCompatActivity {

    private android.widget.TextView activityTitleTxt;
    private android.widget.ImageButton addImageBtn;
    private android.widget.ListView bookListView;
    public static ArrayList<Book> books = new ArrayList<Book>();
    ArrayAdapter<Book> booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        bindViews();
        addBooksToArray();
        booksAdapter = new ArrayAdapter<Book>(BookListActivity.this, android.R.layout.simple_list_item_1, books);
        bookListView.setAdapter(booksAdapter);

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(BookListActivity.this, ViewCustomerInfoActivity.class);
                myIntent.putExtra("book",books.get(position));
                startActivity(myIntent);
            }
        });
        bookListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder myBuiler = new AlertDialog.Builder(BookListActivity.this);
                myBuiler.setTitle("도서 삭제 확인");
                Book tempBook = books.get(position);
                String messageStr ="정말 ["+tempBook.getTitle()+"] 책을 삭제 하시겠어요?";

                myBuiler.setMessage(messageStr);
                myBuiler.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BookListActivity.this, "책이 삭제 되엇습니다.", Toast.LENGTH_SHORT).show();

                        books.remove(position);
                        booksAdapter.notifyDataSetChanged();

                    }
                });
                myBuiler.setNegativeButton("취소",null);
                myBuiler.show();


                return true;
                // 짧은 클릭과 긴 클릭을 구별하게 하려면
                // return false => return true로 변환
            }
        });

    }

    private void addBooksToArray() {
        books.clear();
        books.add(new Book("의학의 법칙들", "싯다르타 무케르지", "문학동네", 1500, R.drawable.book1));
        books.add(new Book("여자의 독서", "김진애", "다산북스", 2000, R.drawable.book2));
        books.add(new Book("기억 독서법", "기성준", "북싱크", 1500, R.drawable.book3));
        books.add(new Book("인간의 위대한 여정", "배철현", "21세기북스", 1000, R.drawable.book4));

    }

    private void bindViews() {

        this.bookListView = (ListView) findViewById(R.id.bookListView);
        this.addImageBtn = (ImageButton) findViewById(R.id.addImageBtn);
        this.activityTitleTxt = (TextView) findViewById(R.id.activityTitleTxt);
    }
}
