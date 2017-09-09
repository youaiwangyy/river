package com.youai.river.base.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Qingjiang Li on 2017/8/29.
 */
@Document(collection = "mongo_sequence_id")
public class SequenceId implements Serializable{

    private Long seqId;
    private String collName;

    public SequenceId() {
    }

    public Long getSeqId() {
        return this.seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    public String getCollName() {
        return this.collName;
    }

    public void setCollName(String collName) {
        this.collName = collName;
    }

}
