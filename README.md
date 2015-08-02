# TitleView
![TitleView](http://7xir7h.com1.z0.glb.clouddn.com/titleview.png)

### xml

```
  xmlns:app="http://schemas.android.com/apk/res-auto"
```

```
 <com.logoocc.titleview.views.TitleView
        app:tv_center_text="主页"
        app:tv_right_text="注册"
        app:tv_center_textSize="20sp"
        app:tv_right_textSize="18sp"
        android:id="@+id/main_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

```

### java

```
        tv = (TitleView) findViewById(R.id.main_title);

        tv.setOnLeftClickListener(clickLis);
        tv.setOnRightClickListener(clickLis);

```

```
private View.OnClickListener clickLis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.title_left:
                    Toast.makeText(getApplicationContext(), "click left", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.title_right:
                    Toast.makeText(getApplicationContext(), "click right", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

```
