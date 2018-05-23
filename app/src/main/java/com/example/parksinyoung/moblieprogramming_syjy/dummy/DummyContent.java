package com.example.parksinyoung.moblieprogramming_syjy.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List <DummyItem> ITEMS = new ArrayList <DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map <String, DummyItem> ITEM_MAP = new HashMap <String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem( DummyItem item ) {
        ITEMS.add(item);
        ITEM_MAP.put(item.title, item);
    }

    private static DummyItem createDummyItem( int position  ) {
        return new DummyItem(String.valueOf(position),"제목입력받기", makeDetails(position), "2018. 05. 24 AM12:22", "신주연");
    }

    private static String makeDetails( int position ) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        builder.append("\n내용 입력받기");
        builder.append("\n게시판의 내용을 입력받을 수 있습니다.");

        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String title;
        public final String body;
        public final String time;
        public final String name;

        public DummyItem( String id,String title, String body, String time, String name ) {
            this.id =id;
            this.title = title;
            this.body = body;
            this.time = time;
            this.name = name;
        }

        @Override
        public String toString() {
            return body+"\n"+time+name;
        }
    }
}