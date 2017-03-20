package us.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Meeting {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="location")
    private String location;
    @Column(name="time")
    private String time;
    @Column(name="url")
    private String url;
    @OneToMany
    @JoinColumn(name="meeting_id")
    private List<Participant> participantList = new ArrayList<Participant>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    public void addParticipant(Participant participant){ this.participantList.add(participant); }

    public void removeParticipant(Participant participant) {
        if(participantList.contains(participant)) {
            participantList.remove(participant);
        }
    }

    public boolean isContainParticipant(Participant participant){
        return (participant.getMeeting_id() == this.id);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Meeting() {
    }

    public Meeting(String name, String location, String time) {
        this.name = name;
        this.location = location;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
