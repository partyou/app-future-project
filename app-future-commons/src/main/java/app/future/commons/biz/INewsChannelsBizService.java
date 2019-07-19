package app.future.commons.biz;

import app.future.commons.bean.NewsChannels;

import java.util.List;

public interface INewsChannelsBizService {
    /**
     * 根据用户查询频道列表
     * @param userId
     * @return
     * @throws Exception
     */
    List<NewsChannels> queryNewsChannelsByUser(Long userId)throws Exception;
}
