package com.ddddl.v2ex.data.http;


import com.ddddl.v2ex.data.bean.*;
import io.reactivex.Single;

import java.util.List;

/**
 * Created by liang.liu on 2018/3/15.
 */
public class V2exApiHelper implements IV2exApi {

    private final IV2exApi v2exApi;

    public V2exApiHelper() {
        v2exApi = DataSourceFactory.getInstance();
    }

    @Override
    public Single<SiteInfoBean> getSiteInfo() {
        return v2exApi.getSiteInfo();
    }

    @Override
    public Single<SiteStatsBean> getSiteStats() {
        return v2exApi.getSiteStats();
    }

    @Override
    public Single<TableBean> getTableInfoById(String id) {
        return v2exApi.getTableInfoById(id);
    }

    @Override
    public Single<TableBean> getTableInfoByName(String name) {
        return v2exApi.getTableInfoByName(name);
    }

    @Override
    public Single<List<TableBean>> getAllTableInfo() {
        return v2exApi.getAllTableInfo();
    }

    @Override
    public Single<MemberInfoBean> getMemberInfoById(String id) {
        return v2exApi.getMemberInfoById(id);
    }

    @Override
    public Single<MemberInfoBean> getMemberInfoByUserName(String username) {
        return v2exApi.getMemberInfoByUserName(username);
    }

    @Override
    public Single<List<TopicBean>> getLatestTopics() {
        return v2exApi.getLatestTopics();
    }

    @Override
    public Single<List<TopicBean>> getHotTopics() {
        return v2exApi.getHotTopics();
    }

    @Override
    public Single<List<TopicBean>> getTopicsById(String id) {
        return v2exApi.getTopicsById(id);
    }

    @Override
    public Single<List<TopicBean>> getTopicsByUsername(String username) {
        return v2exApi.getTopicsByUsername(username);
    }

    @Override
    public Single<List<TopicBean>> getTopicsByNodeName(String node_name) {
        return v2exApi.getTopicsByNodeName(node_name);
    }

    @Override
    public Single<List<TopicBean>> getTopicsByNodeId(String node_id) {
        return v2exApi.getTopicsByNodeId(node_id);
    }

    @Override
    public Single<List<RepliesBean>> getReplies(String topic_id) {
        return v2exApi.getReplies(topic_id);
    }

    @Override
    public Single<String> getTopicsByNode(String tab) {
        return v2exApi.getTopicsByNode(tab);
    }

    @Override
    public Single<String> loadMoreTopicsByNode(String tab, String p) {
        return null;
    }

    @Override
    public Single<String> getNodes() {
        return v2exApi.getNodes();
    }
}
