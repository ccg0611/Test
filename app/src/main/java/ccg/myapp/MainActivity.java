package ccg.myapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {


    private ViewPager mPager;
    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private ImageButton btn4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
        // 타이틀바 제거
        getSupportActionBar().hide();


    }


    // 초기화
    private void initLayout(){

        btn1 = (ImageButton) findViewById(R.id.imageButton);
        btn2 = (ImageButton) findViewById(R.id.imageButton2);
        btn3 = (ImageButton) findViewById(R.id.imageButton3);
        btn4 = (ImageButton) findViewById(R.id.imageButton4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        // 뷰페이저
        mPager = (ViewPager) findViewById(R.id.viewPager);
        mPager.setAdapter(new ViewPagerAdapter(this));
    }

    private class ViewPagerAdapter extends PagerAdapter{

        private LayoutInflater mLayoutInflater;


        public ViewPagerAdapter(Context context) {
            super();
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public Object instantiateItem(View pager, int index) {

            View view = null;

            if(index == 0){
                view = mLayoutInflater.inflate(R.layout.first_layout, null);
            }
            else if(index == 1){
                view = mLayoutInflater.inflate(R.layout.second_layout, null);
            }
            else if(index == 2){
                view = mLayoutInflater.inflate(R.layout.third_layout, null);
            }
            else{
                view = mLayoutInflater.inflate(R.layout.fourth_layout, null);
            }
            ((ViewPager)pager).addView(view,0);

            return view;
        }

        @Override
        public void destroyItem(View pager, int position, Object view) {
            ((ViewPager) pager).removeView((View) view);
        }

        @Override
        public boolean isViewFromObject(View pager, Object obj) {

            return pager == obj;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.imageButton :
                setCurrentItem(0);
                break;
            case R.id.imageButton2 :
                setCurrentItem(1);
                break;
            case R.id.imageButton3 :
                setCurrentItem(2);
                break;
            case R.id.imageButton4 :
                setCurrentItem(3);
                break;

        }

    }

    private void setCurrentItem(int index){
        if(index == 0){
            mPager.setCurrentItem(0);
        }else if(index == 1){
            mPager.setCurrentItem(1);
        }else if(index == 2){
            mPager.setCurrentItem(2);
        }else{
            mPager.setCurrentItem(3);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
