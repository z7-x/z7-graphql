package com.thuni.his.demo.service;

import com.thuni.his.demo.bean.Authority;
import com.thuni.his.demo.bean.Users;
import com.thuni.his.demo.dao.AuthorityDao;
import com.thuni.his.demo.dao.UsersDao;
import org.jfantasy.framework.dao.Pager;
import org.jfantasy.framework.dao.jpa.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional(rollbackFor = Exception.class)
public class UsersService {

    @Autowired
    private  UsersDao usersDao;
    @Autowired
    private AuthorityDao authorityDao;

    /**
     * 保存用户
     *
     * @param user 用户对象
     */
    public Users save(Users user) {
        return this.usersDao.save(user);
    }

    public Users update(Long id, boolean merge, Users user) {
        user.setId(id);
        return this.usersDao.update(user, merge);
    }

    public Pager<Users> findPager(Pager<Users> pager, List<PropertyFilter> filters) {
        return this.usersDao.findPager(pager, filters);
    }

    public void delete(Long... ids) {
        this.usersDao.deleteInBatch(Arrays.stream(ids).map(id -> Users.builder().id(id).build()).collect(Collectors.toList()));
    }

    public Optional<Users> get(Long id) {
        return this.usersDao.findById(id);
    }

    /**
     * 多对多保存: 用户权限
     */
    public Users saveUserAuthority(Users user){
        Users save = usersDao.save(user);
        List<Authority> authorities = authorityDao.saveAll(user.getAuthorityList());
        save.setAuthorityList(authorities);
        return save;
    }
}