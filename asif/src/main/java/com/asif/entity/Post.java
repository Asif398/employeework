package com.asif.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Entity
@Table(name = "post")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", length = 500)
  private String description;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,orphanRemoval = true)
  private Set<Comment> comments;

}