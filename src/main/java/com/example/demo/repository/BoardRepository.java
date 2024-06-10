package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> { // T는 엔티티타입, ID는 pk, pk는 기초타입을 못씀

}
