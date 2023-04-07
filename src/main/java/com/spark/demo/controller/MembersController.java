package com.spark.demo.controller;

import com.spark.demo.domain.Members;
import com.spark.demo.service.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MembersController {

    private final MembersService membersService;

    @GetMapping
    public Page<Members> getMembers() {
        return membersService.getMembers();
    }

    @GetMapping("/{id}")
    public Members getMember(@PathVariable Long id) {
        return membersService.getMember(id);
    }

    @PostMapping
    public Members saveMember(@RequestBody Members members) {
        return membersService.saveMember(members);
    }

    @PutMapping
    public Members updateMember(@RequestBody Members members) {
        return membersService.updateMember(members);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        membersService.deleteMember(id);
    }
}
