package vn.vnpt.vanquan223.internetjson.newsmodel;

public class ListNewsModel {
    String date;
    ListNewTitleModel title;
    ListNewExcerptModel excerpt;
    ListNewsImageModel better_featured_image;
    ListNewsContentModel content;

    public ListNewsModel(String date, ListNewTitleModel title, ListNewExcerptModel excerpt, ListNewsImageModel better_featured_image, ListNewsContentModel content) {
        this.date = date;
        this.title = title;
        this.excerpt = excerpt;
        this.better_featured_image = better_featured_image;
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ListNewTitleModel getTitle() {
        return title;
    }

    public void setTitle(ListNewTitleModel title) {
        this.title = title;
    }

    public ListNewExcerptModel getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(ListNewExcerptModel excerpt) {
        this.excerpt = excerpt;
    }

    public ListNewsImageModel getBetter_featured_image() {
        return better_featured_image;
    }

    public void setBetter_featured_image(ListNewsImageModel better_featured_image) {
        this.better_featured_image = better_featured_image;
    }

    public ListNewsContentModel getContent() {
        return content;
    }

    public void setContent(ListNewsContentModel content) {
        this.content = content;
    }
}
