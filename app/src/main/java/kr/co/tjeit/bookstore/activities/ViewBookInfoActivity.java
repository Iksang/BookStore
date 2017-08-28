package kr.co.tjeit.bookstore.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import kr.co.tjeit.bookstore.R;
import kr.co.tjeit.bookstore.datas.Book;

public class ViewBookInfoActivity extends AppCompatActivity {


    private Book mBook;
    private android.widget.TextView bookTitleNameTxt;
    private android.widget.TextView authorNameTxt;
    private android.widget.TextView publisherNameTxt;
    private android.widget.TextView costTxt;
    private android.widget.Button modifyBookBtn;
    private android.widget.ImageView bookImgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book_info);
        bindView();
        mBook = (Book)getIntent().getSerializableExtra("book");

    }

    private void setValues(){
        bookTitleNameTxt.setText(mBook.getTitle());
        authorNameTxt.setText(mBook.getAuthorName());
        publisherNameTxt.setText(mBook.getPublisherName());
        costTxt.setText(mBook.getCost()+" 원");
        bookImgView.setImageResource(mBook.getBookImgId());
    }

    private void bindView() {

        this.modifyBookBtn = (Button) findViewById(R.id.modifyBookBtn);
        this.costTxt = (TextView) findViewById(R.id.costTxt);
        this.publisherNameTxt = (TextView) findViewById(R.id.publisherNameTxt);
        this.authorNameTxt = (TextView) findViewById(R.id.authorNameTxt);
        this.bookTitleNameTxt = (TextView) findViewById(R.id.bookTitleNameTxt);
        this.bookImgView = (ImageView) findViewById(R.id.bookImgView);


    }
}
