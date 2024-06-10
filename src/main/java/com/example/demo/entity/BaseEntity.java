package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass // 해당 클래스는 엔티티로 처리안함. 부모클래스로 사용됨
// 데이터가 등록되거나 수정되는지 변화를 감지하는 리스너
@EntityListeners(value = { AuditingEntityListener.class })
@Getter
public abstract class BaseEntity {
	
	@CreatedDate //데이터가 생성되면 현재시간을 저장
	LocalDateTime regDate;
	
	@LastModifiedDate //데이터가 수정되면 컬럼에 현재시간을 저장
	LocalDateTime modDate;
}
