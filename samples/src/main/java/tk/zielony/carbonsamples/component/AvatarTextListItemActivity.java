package tk.zielony.carbonsamples.component;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import carbon.component.AvatarTextRow;
import carbon.component.DefaultAvatarTextItem;
import carbon.component.DividerItem;
import carbon.component.DividerRow;
import carbon.component.PaddingItem;
import carbon.component.PaddingRow;
import carbon.recycler.RowListAdapter;
import carbon.widget.RecyclerView;
import tk.zielony.carbonsamples.R;
import tk.zielony.carbonsamples.SampleAnnotation;
import tk.zielony.carbonsamples.ThemedActivity;
import tk.zielony.randomdata.RandomData;
import tk.zielony.randomdata.person.DrawableAvatarGenerator;
import tk.zielony.randomdata.person.StringNameGenerator;

@SampleAnnotation(layoutId = R.layout.activity_listcomponent, titleId = R.string.avatarTextListItemActivity_title)
public class AvatarTextListItemActivity extends ThemedActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolbar();

        List<Serializable> items = Arrays.asList(
                new PaddingItem(getResources().getDimensionPixelSize(R.dimen.carbon_paddingHalf)),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DividerItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DividerItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DividerItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new DefaultAvatarTextItem(),
                new PaddingItem(getResources().getDimensionPixelSize(R.dimen.carbon_paddingHalf)));

        RandomData randomData = new RandomData();
        randomData.addGenerator(Drawable.class, new DrawableAvatarGenerator(this));
        randomData.addGenerator(String.class, new StringNameGenerator().withMatcher(f -> f.getName().equals("text")));
        randomData.fill(items);

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        RowListAdapter<Serializable> adapter = new RowListAdapter<>(DefaultAvatarTextItem.class, AvatarTextRow::new);
        adapter.putFactory(PaddingItem.class, PaddingRow::new);
        adapter.putFactory(DividerItem.class, DividerRow::new);
        recycler.setAdapter(adapter);
        adapter.setItems(items);
    }
}
