package com.youai.river.base.mongo;

import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.youai.river.util.BaseUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Qingjiang Li on 2017/8/29.
 */
@Repository("mongoClientTemplate")
public abstract class AbstractMongoBaseDao<T> {

    @Resource
    protected MongoTemplate mongoTemplate;
    protected String collectionName;
    protected final Class<T> tClass = (Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public AbstractMongoBaseDao() {
        Document document = (Document)this.tClass.getAnnotation(Document.class);
        if(document != null) {
            this.collectionName = document.collection();
        } else {
            this.collectionName = this.tClass.getSimpleName();
        }

    }



    public T add(T t) {
        this.mongoTemplate.insert(t);
        return t;
    }

    public void addBatch(List<T> tList) {
        this.mongoTemplate.insert(tList, this.tClass);
    }

    public T removeById(Object id) {
        Criteria criteria = Criteria.where("id").is(id);
        return this.mongoTemplate.findAndRemove(Query.query(criteria), this.tClass);
    }

    public void save(T t) {
        this.mongoTemplate.save(t);
    }

    public long getTotalCount() {
        Criteria criteria = Criteria.where("");
        return this.countByQuery(Query.query(criteria));
    }

    public List<T> getAllList(int limit, int offset) {
        Criteria criteria = Criteria.where("");
        return this.findByQuery(Query.query(criteria), limit, offset);
    }

    public T findById(Object id) {
        return this.mongoTemplate.findById(id, this.tClass);
    }

    public long countByQuery(Query query) {
        return this.mongoTemplate.count(query, this.tClass);
    }

    public T findOneByQuery(Query query) {
        return this.mongoTemplate.findOne(query, this.tClass);
    }

    public List<T> findByQuery(Query query, int limit, int offset) {
        return this.mongoTemplate.find(query.limit(limit).skip(offset), this.tClass);
    }

    public T findAndRemove(Query query) {
        return this.mongoTemplate.findAndRemove(query, this.tClass);
    }

    public List<T> findAllAndRemove(Query query) {
        return this.mongoTemplate.findAllAndRemove(query, this.tClass);
    }

    public T findAndUpdate(Query query, Update update) {
        return this.mongoTemplate.findAndModify(query, update, this.tClass);
    }

    public void updateAll(Query query, Update update) {
        this.mongoTemplate.updateMulti(query, update, this.tClass);
    }

    public boolean save(List<T> tList) {
        if(CollectionUtils.isEmpty(tList)) {
            return true;
        } else {
            ArrayList bulkUpdates = Lists.newArrayList();
            Iterator var3 = tList.iterator();

            while(var3.hasNext()) {
                Object t = var3.next();
                BasicDBObject dbDoc = new BasicDBObject();
                this.mongoTemplate.getConverter().write(t, dbDoc);
                BatchUpdateOptions batchUpdateOptions = new BatchUpdateOptions(Query.query(Criteria.where("_id").is(BaseUtils.getProperty(t, "id"))), Update.fromDBObject(dbDoc, new String[0]), true, false);
                bulkUpdates.add(batchUpdateOptions);
            }

            return this.doUpdate(bulkUpdates);
        }
    }

    public boolean doUpdate(List<BatchUpdateOptions> updates) {
        if(CollectionUtils.isEmpty(updates)) {
            return true;
        } else {
            BasicDBObject command = new BasicDBObject();
            command.put("update", this.collectionName);
            ArrayList updateList = new ArrayList();
            Iterator commandResult = updates.iterator();

            while(commandResult.hasNext()) {
                BatchUpdateOptions option = (BatchUpdateOptions)commandResult.next();
                BasicDBObject update = new BasicDBObject();
                update.put("q", option.getQuery().getQueryObject());
                update.put("u", option.getUpdate().getUpdateObject());
                update.put("upsert", Boolean.valueOf(option.isUpsert()));
                update.put("multi", Boolean.valueOf(option.isMulti()));
                updateList.add(update);
            }

            command.put("updates", updateList);
            command.put("ordered", Boolean.valueOf(false));
            CommandResult commandResult1 = this.mongoTemplate.getCollection(this.collectionName).getDB().command(command);
            return updates.size() == Integer.parseInt(commandResult1.get("n").toString());
        }
    }

    protected Long getNextId() {
        Query query = new Query(Criteria.where("collName").is(this.collectionName));
        Update update = new Update();
        update.inc("seqId", Integer.valueOf(1));
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.upsert(true);
        options.returnNew(true);
        SequenceId seqId = (SequenceId)this.mongoTemplate.findAndModify(query, update, options, SequenceId.class);
        return seqId.getSeqId();
    }

}
