package Models.Wiki;

public class WikipediaSummaryResponse {
    public String title;
    public String description;
    public String extract;
    public String lang;
    public Content content_urls;
    public WikipediaThumbnail thumbnail;

    public boolean hasImage() {
        return thumbnail != null && thumbnail.source != null;
    }
}

