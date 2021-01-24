package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Person {
    private @Id @GeneratedValue Long id;
    private String name;
    private int score;

    public Person() {}

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.equals(obj)) return true;
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return Objects.equals(this.id, person.id) &&
                Objects.equals(this.name, person.name) &&
                Objects.equals(this.score, person.score);
    }

    @Override
    public String toString() {
        return String.format(
                "Person { id = %d, name = |%s|, score = %d",
                this.id, this.name, this.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.score);
    }
}
