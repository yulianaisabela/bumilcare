package com.bela.pregnancycare.onBoarding;


import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bela.pregnancycare.R;

import de.hdodenhof.circleimageview.CircleImageView;

/*
* This class is responsible to show flascards at beginning of application
* */
public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {

        this.context = context;
    }

    // three images of flashcards
    public int[] image_slide ={
            R.drawable.weighttrack,
            R.drawable.report,
            R.drawable.fooddiary
    };

    // three headings of flashcards
    public String[] heading_slide ={
            "Track Weight",
            "Generate Report",
            "Food Diary"
    };

    // description Array
    public String[] description_slide ={
            "You can track your weight and maintain weight log during different stages of pregnancy and compare your weight gain with recommended maximum and minimum weight gain with help of a graph.",
            "You can generate PDF report containing your weight information before pregnancy, weight log during maternity and weight gain graph during all the weeks of pregnancy.",
            "This application lets you maintain a log of food items and quantity that you ate and count calories and other nutrients intake during pregnancy."
    };




    @Override
    public int getCount() {

        return heading_slide.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    // to show flashcards
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);
        container.addView(view);
        CircleImageView slide_imageView = view.findViewById(R.id.imageView1);

        TextView slideHeading = view.findViewById(R.id.tvHeading);
        TextView  slideDescription = view.findViewById(R.id.tvDescription);

        slide_imageView.setImageResource(image_slide[position]);
        slideHeading.setText(heading_slide[position]);
        slideDescription.setAllCaps(false);
        slideDescription.setText(description_slide[position]);
        slideDescription.setTextColor(Color.parseColor("#000000"));
        slideHeading.setTextColor(Color.parseColor("#000000"));

        return view;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }


}
