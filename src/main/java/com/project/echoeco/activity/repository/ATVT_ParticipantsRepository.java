package com.project.echoeco.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.echoeco.activity.entity.Activity_Member;

@Repository
public interface ATVT_ParticipantsRepository extends JpaRepository<Activity_Member,Integer> {

}
