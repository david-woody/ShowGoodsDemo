package com.adoregeek.showdemo.dummy;


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
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static ArrayList<GoodItem> makeDetails(int position) {
        ArrayList<GoodItem> goodItems = new ArrayList<>();
        for (int i = 0; i < position; i++) {
            GoodItem goodItem = new GoodItem();
            goodItem.setGood_num(position);
            goodItem.setGood_price(position + Math.random() + "");
            goodItem.setGood_name("物料货物" + position);
            goodItem.setId(position);
            goodItem.setGood_size(((int) (200 * Math.random())) + "");
            goodItems.add(goodItem);
        }
        return goodItems;
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final ArrayList<GoodItem> details;

        public DummyItem(String id, String content, ArrayList<GoodItem> details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    public static class GoodItem {
        /**
         * good_name : 测试商品
         * good_price : ¥200
         * good_num : 900
         * good_size : 12-31
         * good_img :
         */
        private int id;
        private String good_name;
        private String good_price;
        private int good_num;
        private String good_size;
        private String good_img = "https://happyreading.oss-cn-hangzhou.aliyuncs.com/avator/default_avator_1.png";

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGood_name() {
            return good_name;
        }

        public void setGood_name(String good_name) {
            this.good_name = good_name;
        }

        public String getGood_price() {
            return good_price;
        }

        public void setGood_price(String good_price) {
            this.good_price = good_price;
        }

        public int getGood_num() {
            return good_num;
        }

        public void setGood_num(int good_num) {
            this.good_num = good_num;
        }

        public String getGood_size() {
            return good_size;
        }

        public void setGood_size(String good_size) {
            this.good_size = good_size;
        }

        public String getGood_img() {
            return good_img;
        }

        public void setGood_img(String good_img) {
            this.good_img = good_img;
        }
    }
}
