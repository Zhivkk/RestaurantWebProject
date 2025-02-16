package app.message;

import app.user.model.User;
import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Message { //// изпращане на съобщение от потребителя до системата и отговор

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private User user; // името на клиента (логнатия в системата)

    @Column (nullable = false)
    private String subject;

    @Column (nullable = false)
    private String messageText;

    @Enumerated(EnumType.STRING)
    private MessageStaus messageStatus; //written, read, replied, deleted

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;
}
