package com.aako.traffic.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import com.aako.traffic.R;
import com.aako.traffic.ui.adapter.GlobalMenuAdapter;

/**
 * Created by aako on 2015/6/16.
 */
public class GlobalMenuView extends ListView implements View.OnClickListener {

    private OnHeaderClickListener onHeaderClickListener;
    private GlobalMenuAdapter globalMenuAdapter;
    private ImageView ivAvatar;
    private int avatarSize;
    private String avatarUrl;

    public GlobalMenuView(Context context) {
        super(context);
        init();
    }

    private void init(){
        setChoiceMode(CHOICE_MODE_SINGLE);
        setDivider(getResources().getDrawable(android.R.color.transparent));
        setDividerHeight(0);
        setBackgroundColor(Color.WHITE);

        setupHeader();
        setupAdapter();
    }

    private void setupAdapter() {
        globalMenuAdapter = new GlobalMenuAdapter(getContext());
        setAdapter(globalMenuAdapter);
    }

    private void setupHeader() {
        this.avatarSize = getResources().getDimensionPixelSize(R.dimen.global_menu_avatar_size);

        setHeaderDividersEnabled(true);
        View vHeader = LayoutInflater.from(getContext()).inflate(R.layout.view_global_menu_header, null);
        ivAvatar = (ImageView) vHeader.findViewById(R.id.ivUserProfilePhoto);
//        Picasso.with(getContext())
//                .load(profilePhoto)
//                .placeholder(R.drawable.img_circle_placeholder)
//                .resize(avatarSize, avatarSize)
//                .centerCrop()
//                .transform(new CircleTransformation())
//                .into(ivUserProfilePhoto);
        addHeaderView(vHeader);
        vHeader.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (onHeaderClickListener != null) {
            onHeaderClickListener.onGlobalMenuHeaderClick(view);
        }
    }

    public interface OnHeaderClickListener {
        public void onGlobalMenuHeaderClick(View v);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.onHeaderClickListener = onHeaderClickListener;
    }
}
