package app.future.commons.services;

import app.future.commons.base.PageData;
import app.future.commons.base.PageModel;
import app.future.commons.bean.UsersAccount;

import java.util.List;

/**
 * @Author: zhaoyong.
 * @Description: TODO()
 * @Date:Created in 2019/7/16 10:03.
 * @Modified By:
 */
public interface IUsersAccountService {
    int insert(UsersAccount bean) throws Exception;

    int update(UsersAccount bean) throws Exception;

    List<UsersAccount> find(UsersAccount bean) throws Exception;

    long findTotal(UsersAccount bean) throws Exception;

    PageData<UsersAccount> findByPage(UsersAccount bean, PageModel model)
            throws Exception;

    UsersAccount findById(Long id) throws Exception;

    UsersAccount findObject(UsersAccount bean) throws Exception;
}
