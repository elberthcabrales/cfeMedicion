package com.example.hp.hellowwordl;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private String[] mDataset;


    private enum SwipedState {
        SHOWING_PRIMARY_CONTENT,
        SHOWING_SECONDARY_CONTENT
    }

    private List<SwipedState> mItemSwipedStates;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public  class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        // each data item is just a string in this case
        Button btnUno;
        Button btnDos;
        public View mView;

        public ViewHolder(View v) {
            super(v);
            btnUno = (Button) v.findViewById(R.id.btn1);
            btnDos = (Button) v.findViewById(R.id.btn2);
            btnUno.setOnClickListener(this);
            btnDos.setOnClickListener(this);
            mView = v;
        }

        @Override
        public void onClick(View v) {

            if (v.getId() == btnUno.getId()) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"zindyfrias@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT   , "body of email "+ mDataset[getPosition()]);
                try {
                    v.getContext().startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(v.getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
               // Toast.makeText(btnUno.getContext(),"Prbando click "+ mDataset[getPosition()], Toast.LENGTH_SHORT).show();
            } else  {
                Toast.makeText(btnUno.getContext(),"xxxxxxxxxxxxxxxxxxxx", Toast.LENGTH_SHORT).show();
            }

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecyclerViewAdapter(String[] dataSet) {
        mDataset = dataSet;
        mItemSwipedStates = new ArrayList<>();
        for (int i = 0; i < dataSet.length; i++) {
            mItemSwipedStates.add(i, SwipedState.SHOWING_PRIMARY_CONTENT);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // Create a new view which is basically just a ViewPager in this case
        ViewPager v = (ViewPager) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewPagerAdapter adapter = new ViewPagerAdapter();

        ((ViewPager) v.findViewById(R.id.viewPager)).setAdapter(adapter);

        //Perhaps the first most crucial part. The ViewPager loses its width information when it is put
        //inside a RecyclerView. It needs to be explicitly resized, in this case to the width of the
        //screen. The height must be provided as a fixed value.
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        v.getLayoutParams().width = displayMetrics.widthPixels;
        v.requestLayout();

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ((TextView) holder.mView.findViewById(R.id.txt)).setText(mDataset[position]);

        Log.i("MyAdapter", "PagePosition " + position + " set to " + mItemSwipedStates.get(position).ordinal());
        ((ViewPager) holder.mView).setCurrentItem(mItemSwipedStates.get(position).ordinal());

        ((ViewPager) holder.mView).setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int previousPagePosition = 0;

            @Override
            public void onPageScrolled(int pagePosition, float positionOffset, int positionOffsetPixels) {
                if (pagePosition == previousPagePosition)
                    return;

                switch (pagePosition) {
                    case 0:
                        mItemSwipedStates.set(position, SwipedState.SHOWING_PRIMARY_CONTENT);
                        break;
                    case 1:
                        mItemSwipedStates.set(position, SwipedState.SHOWING_SECONDARY_CONTENT);
                        break;

                }
                previousPagePosition = pagePosition;

                Log.i("MyAdapter", "PagePosition " + position + " set to " + mItemSwipedStates.get(position).ordinal());
            }

            @Override
            public void onPageSelected(int pagePosition) {
                //This method keep incorrectly firing as the RecyclerView scrolls.
                //Use the one above instead
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }


}