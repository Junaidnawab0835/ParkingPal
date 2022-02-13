package com.example.parkingpal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideViewPagerAdapter extends PagerAdapter {
    Context ctx;

    public SlideViewPagerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.intro_screen,container,false);


        ImageView logo=view.findViewById(R.id.slider_img);

        ImageView ind1=view.findViewById(R.id.ind_1);
        ImageView ind2=view.findViewById(R.id.ind_2);


        TextView title=view.findViewById(R.id.slider_txt);
      //  TextView desc=view.findViewById(R.id.desc);

        TextView next=view.findViewById(R.id.next_btn);

        TextView skip_btn=view.findViewById(R.id.skip_btn);
        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ctx,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position+1);
            }
        });



        switch (position)
        {
            case 0:
                logo.setImageResource(R.drawable.ic_into1);
                ind1.setImageResource(R.drawable.seleted);
                ind2.setImageResource(R.drawable.unselected);

                title.setText("Best Prking Spots");
                next.setVisibility(View.VISIBLE);
                break;
            case 1:
                logo.setImageResource(R.drawable.ic_intro2);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.seleted);

                title.setText("Quick Navigation");
                next.setVisibility(View.GONE);
                break;






        }


        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
