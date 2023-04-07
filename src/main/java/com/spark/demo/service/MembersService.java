package com.spark.demo.service;

import com.spark.demo.domain.Members;
import com.spark.demo.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembersService {

    private final MembersRepository membersRepository;
    public Members getMember(Long id) {
        var threadName = Thread.currentThread().toString();
        System.out.println("threadName = " + threadName);
        return membersRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Page<Members> getMembers() {
        var threadName = Thread.currentThread().toString();
        System.out.println("threadName = " + threadName);
        return membersRepository.findAll(PageRequest.of(0, 10));
    }

    public Members saveMember(Members members) {
        var threadName = Thread.currentThread().toString();
        System.out.println("threadName = " + threadName);
        return membersRepository.save(members);
    }

    public void deleteMember(Long id) {
        var threadName = Thread.currentThread().toString();
        System.out.println("threadName = " + threadName);
        membersRepository.deleteById(id);
    }

    public Members updateMember(Members members) {
        var threadName = Thread.currentThread().toString();
        System.out.println("threadName = " + threadName);
        var findMember = membersRepository.findById(members.getId()).orElseThrow(RuntimeException::new);
        findMember.update(members);

        return members;
    }
}
