package service;

import model.Search;

public class SearchCreator {

    public static Search withTextSearch(String text){
        return new Search(text);
    }

    public static Search emptySearch(){
        return new Search("");
    }
}
