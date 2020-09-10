package com.jiadong.web.admin;

import com.jiadong.bean.Tag;
import com.jiadong.bean.Type;
import com.jiadong.service.ITagService;
import com.jiadong.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    private ITagService tagService;

    @GetMapping("/tags")
    public String tag(@PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC)
                                   Pageable pageable, Model model) {
        model.addAttribute("page", tagService.listTag(pageable));
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model) {
        model.addAttribute("tag", tagService.getTag((long)0));
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/tags-input";
    }

//    @PostMapping("/tags")
//    public String post(@Validated Tag tag, RedirectAttributes attributes) {
//
//        Tag tag1 = tagService.getTagByName(tag.getName());
//        if (tag1 != null) {
//            attributes.addFlashAttribute("message", "新增失败, 有重复存在");
//            return "redirect:/admin/tags";
//        }
//
//        Tag t = tagService.saveTag(tag);
//        if ( t == null) {
//            // 没保存成功
//            attributes.addFlashAttribute("message", "新增失败：原因未知");
//        } else {
//            // 保存成功
//            attributes.addFlashAttribute("message", "新增成功");
//        }
//        return "redirect:/admin/tags";
//    }

    @PostMapping("/tags/{id}")
    public String editPost(@Validated Tag tag, @PathVariable Long id, RedirectAttributes attributes) {

        Tag tag1 = tagService.getTagByName(tag.getName());

        if (tag1 != null) {
            attributes.addFlashAttribute("message", "更新失败, 有重复存在");
            return "redirect:/admin/tags";
        }

        System.out.println(tag);

        Tag t = tagService.saveTag(tag);
        if ( t == null) {
            // 没保存成功
            attributes.addFlashAttribute("message", "更改失败：原因未知");
        } else {
            // 保存成功
            attributes.addFlashAttribute("message", "更改成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/tags";
    }





}
