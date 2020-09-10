package com.jiadong.service;

import com.jiadong.bean.Tag;
import com.jiadong.bean.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id, Tag tag);

    void deleteTag(Long id);
}
