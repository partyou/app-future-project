package app.future.server.dao;

import app.future.commons.base.BaseMapper;
import app.future.commons.bean.Brand;
import app.future.commons.bean.UserChannelRelation;

import java.util.List;

public interface UserChannelRelationMapper extends BaseMapper<UserChannelRelation> {
    List<UserChannelRelation> find(Brand bean);
}