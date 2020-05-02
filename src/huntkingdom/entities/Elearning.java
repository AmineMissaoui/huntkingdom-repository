package huntkingdom.entities;

/**
 *
 * @author Akkari
 */
public class Elearning {
    int id ;
    String name ;
    String description;
    String path ;
    
    public Elearning() {
    }
    
     public Elearning( String name, String description, String path) {
        this.name = name;
        this.description = description;
        this.path = path;
    }

    public Elearning(int id , String name, String description, String path) {
        this.name = name;
        this.description = description;
        this.path = path;
        this.id =id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Elearning{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
