package com.aditya.sometask.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aditya.sometask.ToneListData;

import java.util.ArrayList;
import java.util.List;

public class ToneListViewModel extends ViewModel {
    public List<ToneListData> toneListData = new ArrayList<>();

    public void populateList() {
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/680/100/100.jpg?hmac=HsAnZxUQtBXLIJm3EuokEqkuHw0Hnoye-cRxkIZhn3I"));
        toneListData.add(new ToneListData("Ed Sheeran - Sing", "3.5", "4:05", false, "https://i.picsum.photos/id/1068/100/100.jpg?hmac=6m6-BcFu4gAENtUoLcngpzddkWZdqEtEXB_W4ZDwj54"));
        toneListData.add(new ToneListData("BFMV - Raising hell", "3.5", "4:05", false, "https://i.picsum.photos/id/424/100/100.jpg?hmac=yXnHn7NrhLnhmban-hFnAFh_qkV9aVjMCEeWN596iOg"));
        toneListData.add(new ToneListData("Coldplay - Hymn", "3.5", "4:05", false, "https://i.picsum.photos/id/3/100/100.jpg?hmac=IutPclhkeCYSVYwQILaYtu1gJ3p3GSUC_V8u3497wAs"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/680/100/100.jpg?hmac=HsAnZxUQtBXLIJm3EuokEqkuHw0Hnoye-cRxkIZhn3I"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/1068/100/100.jpg?hmac=6m6-BcFu4gAENtUoLcngpzddkWZdqEtEXB_W4ZDwj54"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/424/100/100.jpg?hmac=yXnHn7NrhLnhmban-hFnAFh_qkV9aVjMCEeWN596iOg"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/3/100/100.jpg?hmac=IutPclhkeCYSVYwQILaYtu1gJ3p3GSUC_V8u3497wAs"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/926/100/100.jpg?hmac=4UTYxHAscAjkIIUE-G6GM2UuIidPe0yEy0IzpVH6D-w"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/680/100/100.jpg?hmac=HsAnZxUQtBXLIJm3EuokEqkuHw0Hnoye-cRxkIZhn3I"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/1068/100/100.jpg?hmac=6m6-BcFu4gAENtUoLcngpzddkWZdqEtEXB_W4ZDwj54"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/424/100/100.jpg?hmac=yXnHn7NrhLnhmban-hFnAFh_qkV9aVjMCEeWN596iOg"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/3/100/100.jpg?hmac=IutPclhkeCYSVYwQILaYtu1gJ3p3GSUC_V8u3497wAs"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/926/100/100.jpg?hmac=4UTYxHAscAjkIIUE-G6GM2UuIidPe0yEy0IzpVH6D-w"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/680/100/100.jpg?hmac=HsAnZxUQtBXLIJm3EuokEqkuHw0Hnoye-cRxkIZhn3I"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/1068/100/100.jpg?hmac=6m6-BcFu4gAENtUoLcngpzddkWZdqEtEXB_W4ZDwj54"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/424/100/100.jpg?hmac=yXnHn7NrhLnhmban-hFnAFh_qkV9aVjMCEeWN596iOg"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/3/100/100.jpg?hmac=IutPclhkeCYSVYwQILaYtu1gJ3p3GSUC_V8u3497wAs"));
        toneListData.add(new ToneListData("Alan Walker - Faded", "3.5", "4:05", false, "https://i.picsum.photos/id/926/100/100.jpg?hmac=4UTYxHAscAjkIIUE-G6GM2UuIidPe0yEy0IzpVH6D-w"));
    }

}
