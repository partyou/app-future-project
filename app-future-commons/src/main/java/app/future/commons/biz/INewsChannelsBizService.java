package app.future.commons.biz;

import app.future.commons.bean.NewsChannels;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.List;

@Service
public interface INewsChannelsBizService {
    /**
     * 根据用户查询频道列表
     * @param userId
     * @return
     * @throws Exception
     */
    List<NewsChannels> queryNewsChannelsByUser(Long userId)throws Exception;
}
