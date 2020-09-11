package com.jiadong.dao;

import com.jiadong.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlogRepository extends JpaRepository <Blog, Long>, JpaSpecificationExecutor<Blog> {


}
