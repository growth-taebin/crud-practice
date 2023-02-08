package com.example.lamyeon.repository

import com.example.lamyeon.dto.ResponseDto
import com.example.lamyeon.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository: JpaRepository<ResponseDto, Long> {
}