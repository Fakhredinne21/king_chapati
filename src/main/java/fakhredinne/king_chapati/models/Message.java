package fakhredinne.king_chapati.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table( name = "message")
@Getter
@Setter
@ToString
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_message")
    private Long id_message;
    @ManyToOne
    private Conversation conversation;
    private String content;
    private Date date_msg;
    private String Sender;
    private String Receveir;

}
