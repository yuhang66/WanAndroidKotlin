package com.example.wanandroidkotlin.bean;

import java.util.List;

public class NomalSearchEntity {

    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","audit":1,"author":"的一幕","chapterId":362,"chapterName":"泛型","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9219,"link":"https://www.jianshu.com/p/dd34211f2565","niceDate":"2019-09-17","niceShareDate":"2019-09-17","origin":"","prefix":"","projectLink":"","publishTime":1568652914000,"shareDate":1568652914000,"shareUser":"","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"<em class='highlight'>java泛型<\/em>背后是什么","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"jjlanbupt","chapterId":313,"chapterName":"字节码","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2904,"link":"https://www.jianshu.com/p/5972220efc9a","niceDate":"2018-05-11","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1526031659000,"shareDate":null,"shareUser":"","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"<em class='highlight'>java泛型<\/em>你需要知道的一切","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":4557,"link":"http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650237296&idx=1&sn=943ab1fe4a26c55f1782f3a20a2e6b6c&chksm=8863981fbf141109f46676d0ab02cc9d5ca67176d8075f043f3a28ca7b4df7f2166d298c2eaf&scene=38#wechat_redirect","niceDate":"2016-10-10","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1476028800000,"shareDate":null,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"<em class='highlight'>Java泛型<\/em>超详细解读 : super和extend","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":1,"size":20,"total":4}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","audit":1,"author":"的一幕","chapterId":362,"chapterName":"泛型","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":9219,"link":"https://www.jianshu.com/p/dd34211f2565","niceDate":"2019-09-17","niceShareDate":"2019-09-17","origin":"","prefix":"","projectLink":"","publishTime":1568652914000,"shareDate":1568652914000,"shareUser":"","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"<em class='highlight'>java泛型<\/em>背后是什么","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"jjlanbupt","chapterId":313,"chapterName":"字节码","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2904,"link":"https://www.jianshu.com/p/5972220efc9a","niceDate":"2018-05-11","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1526031659000,"shareDate":null,"shareUser":"","superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"<em class='highlight'>java泛型<\/em>你需要知道的一切","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":4557,"link":"http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650237296&idx=1&sn=943ab1fe4a26c55f1782f3a20a2e6b6c&chksm=8863981fbf141109f46676d0ab02cc9d5ca67176d8075f043f3a28ca7b4df7f2166d298c2eaf&scene=38#wechat_redirect","niceDate":"2016-10-10","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1476028800000,"shareDate":null,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"<em class='highlight'>Java泛型<\/em>超详细解读 : super和extend","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 1
         * size : 20
         * total : 4
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * audit : 1
             * author : 的一幕
             * chapterId : 362
             * chapterName : 泛型
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : false
             * id : 9219
             * link : https://www.jianshu.com/p/dd34211f2565
             * niceDate : 2019-09-17
             * niceShareDate : 2019-09-17
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1568652914000
             * shareDate : 1568652914000
             * shareUser :
             * superChapterId : 245
             * superChapterName : Java深入
             * tags : []
             * title : <em class='highlight'>java泛型</em>背后是什么
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private int audit;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String niceShareDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private long shareDate;
            private String shareUser;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public int getAudit() {
                return audit;
            }

            public void setAudit(int audit) {
                this.audit = audit;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getNiceShareDate() {
                return niceShareDate;
            }

            public void setNiceShareDate(String niceShareDate) {
                this.niceShareDate = niceShareDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public long getShareDate() {
                return shareDate;
            }

            public void setShareDate(long shareDate) {
                this.shareDate = shareDate;
            }

            public String getShareUser() {
                return shareUser;
            }

            public void setShareUser(String shareUser) {
                this.shareUser = shareUser;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}
