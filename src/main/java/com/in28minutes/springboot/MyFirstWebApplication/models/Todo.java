package com.in28minutes.springboot.MyFirstWebApplication.models;



import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Todo {

        public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
            this.id = id;
            this.username = username;
            this.description = description;
            this.targetDate = targetDate;
            this.done = done;
        }

        public Todo(String username, String description, LocalDate targetDate, boolean done, User user) {
            this.username = username;
            this.description = description;
            this.targetDate = targetDate;
            this.done = done;
            this.user = user;
        }

        public Todo(int id, String description, LocalDate targetDate, boolean done, User user) {
            this.id = id;
            this.description = description;
            this.targetDate = targetDate;
            this.done = done;
            this.user = user;
        }

    @Id
        @GeneratedValue
        private int id;
        @Column
        private String username;
        @Size(min=10, message = "Enter at least 10 characters")
        @Column
        private String description;
        @Column
        private LocalDate targetDate;
        @Column
        private boolean done;

        @ManyToOne
        @JoinColumn(name="user_id")
        private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
