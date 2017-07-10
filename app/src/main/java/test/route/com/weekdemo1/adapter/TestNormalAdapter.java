package test.route.com.weekdemo1.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import test.route.com.weekdemo1.R;

/**
 * Created by my301s on 2017/6/15.
 */
  public class   TestNormalAdapter extends StaticPagerAdapter {
    private int[] imgs = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c
    };
    @Override
    public View getView(ViewGroup container, int position) {


        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }
    @Override
    public int getCount() {
        return imgs.length;
    }
}
