package com.youai.river.base.mongo;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by Qingjiang Li on 2017/8/29.
 */
public class BatchUpdateOptions {

    private Query query;
    private Update update;
    private boolean upsert = false;
    private boolean multi = false;

    public Query getQuery() {
        return this.query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Update getUpdate() {
        return this.update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public boolean isUpsert() {
        return this.upsert;
    }

    public void setUpsert(boolean upsert) {
        this.upsert = upsert;
    }

    public boolean isMulti() {
        return this.multi;
    }

    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    public BatchUpdateOptions(Query query, Update update, boolean upsert, boolean multi) {
        this.query = query;
        this.update = update;
        this.upsert = upsert;
        this.multi = multi;
    }

}
