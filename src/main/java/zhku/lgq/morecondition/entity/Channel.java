package zhku.lgq.morecondition.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "channel")
public class Channel {

    public Channel(){}

    public Channel(int channelId, String channelName){
        this.channelId = channelId;
        this.channelName = channelName;
    }

    @Id
    private int channelId;

    private String channelName;

}
