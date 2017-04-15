package org.chzz.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.chzz.R;

/**
 * Created by copy on 2017/4/14.
 */

public class CHZZLoadDataLayout extends FrameLayout {
    public final static int LOADING = 10;
    public final static int SUCCESS = 11;
    public final static int EMPTY = 12;
    public final static int ERROR = 13;
    public final static int NO_NETWORK = 14;

    public final static int FULL = 20;
    public final static int BUTTON = 21;
    private Context mContext;
    public static Builder builder = new Builder();
    private View contentView, loadingView, emptyView, errorView, noNetworkView;
    private TextView tvLoading, emptyTv, errorTv, noNetworkTv;

    public static Builder getBuilder() {
        return builder;
    }

    public CHZZLoadDataLayout setLoadingText(@NonNull String text) {
        if (tvLoading != null) {
            tvLoading.setText(text);
        }
        return this;
    }

    public CHZZLoadDataLayout( Context context) {
        super(context);
    }
    public CHZZLoadDataLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public CHZZLoadDataLayout(Context context, AttributeSet attrs,int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CHZZLoadDataLayout);
        builder.setLoadingText(TextUtils.isEmpty(typedArray.getString(R.styleable.CHZZLoadDataLayout_loadingText)) ? builder.loadingText : typedArray.getString(R.styleable.CHZZLoadDataLayout_loadingText));
        builder.setLoadingTextColor(typedArray.getResourceId(R.styleable.CHZZLoadDataLayout_loadingTextColor, builder.loadingTextColor));

        typedArray.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 1) {
            throw new IllegalStateException(getClass().getSimpleName() + " can host only one direct child");
        }
        build();
    }

    private void build() {
        if (getChildCount() > 0) {
            contentView = getChildAt(0);
            contentView.setVisibility(GONE);
        }
        loadingView = View.inflate(mContext, R.layout.widget_loading_view, null);
        tvLoading = (TextView) loadingView.findViewById(R.id.loading_text);

        setLoadingText(builder.loadingText);
        addView(loadingView);
    }

    public void setStatus(int status) {
        if (contentView != null) {
            contentView.setVisibility(GONE);
            loadingView.setVisibility(GONE);
        }
        switch (status) {
            case SUCCESS:
                if (null != contentView) {
                    contentView.setVisibility(VISIBLE);
                }
                break;
            case ERROR:

                break;
            case LOADING:
                loadingView.setVisibility(VISIBLE);
                break;
        }
    }

    public static class Builder {
        String loadingText = "加载中";
        int loadingTextColor = R.color.text_color_theme;

        public Builder setLoadingText(String loadingText) {
            this.loadingText = loadingText;
            return builder;
        }

        public Builder setLoadingTextColor(int loadingTextColor) {
            this.loadingTextColor = loadingTextColor;
            return builder;
        }
    }

}
