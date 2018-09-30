package com.example.home.android_labs.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


public class Hit {
    @SerializedName("largeImageURL")
    @Expose
    private String largeImageURL;
    @SerializedName("webformatHeight")
    @Expose
    private int webformatHeight;
    @SerializedName("webformatWidth")
    @Expose
    private int webformatWidth;
    @SerializedName("likes")
    @Expose
    private int likes;
    @SerializedName("imageWidth")
    @Expose
    private int imageWidth;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("views")
    @Expose
    private int views;
    @SerializedName("comments")
    @Expose
    private int comments;
    @SerializedName("pageURL")
    @Expose
    private String pageURL;
    @SerializedName("imageHeight")
    @Expose
    private int imageHeight;
    @SerializedName("webformatURL")
    @Expose
    private String webformatURL;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("previewHeight")
    @Expose
    private int previewHeight;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("downloads")
    @Expose
    private int downloads;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("favorites")
    @Expose
    private int favorites;
    @SerializedName("imageSize")
    @Expose
    private int imageSize;
    @SerializedName("previewWidth")
    @Expose
    private int previewWidth;
    @SerializedName("userImageURL")
    @Expose
    private String userImageURL;
    @SerializedName("previewURL")
    @Expose
    private String previewURL;

    /**
     * No args constructor for use in serialization
     *
     */
    public Hit() {
    }

    /**
     *
     * @param tags
     * @param webformatHeight
     * @param imageHeight
     * @param previewHeight
     * @param previewURL
     * @param imageSize
     * @param favorites
     * @param previewWidth
     * @param type
     * @param downloads
     * @param userImageURL
     * @param pageURL
     * @param largeImageURL
     * @param id
     * @param views
     * @param likes
     * @param userId
     * @param webformatWidth
     * @param webformatURL
     * @param user
     * @param imageWidth
     * @param comments
     */
    public Hit(String largeImageURL, int webformatHeight, int webformatWidth, int likes,
               int imageWidth, int id, int userId, int views, int comments, String pageURL,
               int imageHeight, String webformatURL, String type, int previewHeight, String tags,
               int downloads, String user, int favorites, int imageSize, int previewWidth,
               String userImageURL, String previewURL) {
        super();
        this.largeImageURL = largeImageURL;
        this.webformatHeight = webformatHeight;
        this.webformatWidth = webformatWidth;
        this.likes = likes;
        this.imageWidth = imageWidth;
        this.id = id;
        this.userId = userId;
        this.views = views;
        this.comments = comments;
        this.pageURL = pageURL;
        this.imageHeight = imageHeight;
        this.webformatURL = webformatURL;
        this.type = type;
        this.previewHeight = previewHeight;
        this.tags = tags;
        this.downloads = downloads;
        this.user = user;
        this.favorites = favorites;
        this.imageSize = imageSize;
        this.previewWidth = previewWidth;
        this.userImageURL = userImageURL;
        this.previewURL = previewURL;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public int getWebformatHeight() {
        return webformatHeight;
    }

    public void setWebformatHeight(int webformatHeight) {
        this.webformatHeight = webformatHeight;
    }

    public int getWebformatWidth() {
        return webformatWidth;
    }

    public void setWebformatWidth(int webformatWidth) {
        this.webformatWidth = webformatWidth;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(int previewHeight) {
        this.previewHeight = previewHeight;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getImageSize() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    public int getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(int previewWidth) {
        this.previewWidth = previewWidth;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    @Override
    public String toString() {
        return "Hit{" +
                "\n likes=" + likes +
                "\n views=" + views +
                "\n comments=" + comments +
                "\n type='" + type + '\'' +
                "\n tags='" + tags + '\'' +
                "\n user='" + user + '\'' +
                "\n favorites=" + favorites +
                '}';
    }
}
