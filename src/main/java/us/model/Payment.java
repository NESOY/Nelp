package us.model;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="meeting_id"),
            @JoinColumn(name="user_id")
    })
    private Participation participation;
    private String name;
    private String ssoId;

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    private int amount;

    public Payment() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Participation getParticipation() {
        return participation;
    }

    public void setParticipation(Participation participation) {
        this.participation = participation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public boolean isOwner(String ssoId) {
        return this.ssoId.equals(ssoId);
    }
}
