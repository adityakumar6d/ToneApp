package com.aditya.sometask;

public class ToneListData {
    private String toneTitle, toneSize, toneDuration, imageUrl;
    private Boolean isLiked;

    public ToneListData(String toneTitle, String toneSize, String toneDuration, Boolean isLiked, String imageUrl) {
        this.toneTitle = toneTitle;
        this.toneSize = toneSize;
        this.toneDuration = toneDuration;
        this.isLiked = isLiked;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getLiked() {
        return isLiked;
    }

    public void setLiked(Boolean liked) {
        isLiked = liked;
    }

    public String getToneTitle() {
        return toneTitle;
    }

    public void setToneTitle(String toneTitle) {
        this.toneTitle = toneTitle;
    }

    public String getToneSize() {
        return toneSize;
    }

    public void setToneSize(String toneSize) {
        this.toneSize = toneSize;
    }

    public String getToneDuration() {
        return toneDuration;
    }

    public void setToneDuration(String toneDuration) {
        this.toneDuration = toneDuration;
    }

    public Boolean getIsliked() {
        return isLiked;
    }

    public void setIsliked(Boolean isLiked) {
        this.isLiked = isLiked;
    }
}