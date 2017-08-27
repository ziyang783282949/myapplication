package com.zhongying.zy.sharetrash.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */

public class RankGson {

    private List<RanklistBean> rankGson;

    public static RankGson objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, RankGson.class);
    }



    public List<RanklistBean> getNewslist() {
        return rankGson;
    }

    public void setNewslist(List<RanklistBean> rankGson) {
        this.rankGson = rankGson;
    }

    public static class RanklistBean {
        private String id;
        private String icon;
        private String name;
        private String point;

        public static RanklistBean objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, RanklistBean.class);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }
    }
}
