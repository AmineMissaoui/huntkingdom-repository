/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntkingdom.entities;

/**
 *
 * @author AmineMissaoui
 */
public class Publication {
    private int id;
    private String title, content, description;

    public Publication() {
    }

    public Publication(String title, String content, String description) {
        this.title = title;
        this.content = content;
        this.description = description;
    }

    public Publication(int id, String title, String content, String description) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Publication{" + "id=" + id + ", title=" + title + ", content=" + content + ", description=" + description + '}';
    }
    
    
}
