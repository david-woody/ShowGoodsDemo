package com.adoregeek.showdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adoregeek.showdemo.dummy.DummyContent;
import com.adoregeek.showdemo.util.ImageLoadUtil;

import java.util.List;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            recyclerView = rootView.findViewById(R.id.item_detail);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
            recyclerView.setAdapter(new GridViewAdapter(getActivity(), mItem.details, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DummyContent.GoodItem goodItem= (DummyContent.GoodItem) v.getTag();
                }
            }));
//            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.details);
        }

        return rootView;
    }


    public static class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {

        private final Context mParentActivity;
        private final List<DummyContent.GoodItem> mValues;

        GridViewAdapter(Context parent, List<DummyContent.GoodItem> items, View.OnClickListener onClickListener) {
            mValues = items;
            mParentActivity = parent;
            this.onClickListener=onClickListener;
        }

        private View.OnClickListener onClickListener;

        @Override
        public GridViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_detail_content, parent, false);
            return new GridViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final GridViewAdapter.ViewHolder holder, int position) {

            final DummyContent.GoodItem goodItem = mValues.get(position);
            ImageLoadUtil.load(holder.itemView.getContext(), goodItem.getGood_img(), holder.ivGoodImg);
            holder.tvName.setText(goodItem.getGood_name() + "");
            holder.tvNum.setText(goodItem.getGood_num() + "");
            holder.tvSize.setText(goodItem.getGood_size() + "");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.setTag(goodItem);
                    if(onClickListener!=null)
                        onClickListener.onClick(v);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final ImageView ivGoodImg;
            final TextView tvName;
            final TextView tvNum;
            final TextView tvSize;

            ViewHolder(View view) {
                super(view);
                ivGoodImg = (ImageView) view.findViewById(R.id.iv_good_img);
                tvName = (TextView) view.findViewById(R.id.tv_name);
                tvNum = (TextView) view.findViewById(R.id.tv_num);
                tvSize = (TextView) view.findViewById(R.id.tv_size);
            }
        }
    }
}
