package newspaper;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NewsPaper {

    private String name;
    private Set<Article> articles = new TreeSet<>();

    public NewsPaper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public List<Article> findArticlesByAuthor(String author) {
        return articles.stream().filter(article -> author.equals(article.getAuthor())).toList();
    }

    public List<Article> findArticleByParagraphPart(String part) {
        return articles.stream().filter(article -> article.getParagraphs().stream().anyMatch(paragraph -> paragraph.contains(part))).toList();
    }


}
