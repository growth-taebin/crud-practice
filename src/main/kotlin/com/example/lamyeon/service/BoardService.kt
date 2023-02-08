package com.example.lamyeon.service

import com.example.lamyeon.dto.BoardFormDto
import com.example.lamyeon.dto.ResponseDto
import com.example.lamyeon.entity.Board
import com.example.lamyeon.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BoardService(
        val boardRepository: BoardRepository,
) {

    fun write(
            boardFormDto: BoardFormDto
    ): Long? {
        return boardRepository.save(
                ResponseDto(id = -1, boardFormDto.writer, boardFormDto.password, boardFormDto.title, boardFormDto.content)
        ).id
    }

    fun getPost(
            id: Long
    ): ResponseDto =
            boardRepository.findById(id).get()
                    .let { return it }

    fun deletePost(
            id: Long
    ) {
        boardRepository.deleteById(id)
    }

    fun updatePost(
            id: Long,
            boardFormDto: BoardFormDto
    ): ResponseDto =
            boardRepository.findById(id).get()
                    .let { updatePost(id, boardFormDto) }
                    .let { return it  }

    fun getPostList(): List<ResponseDto> {
        return boardRepository.findAll()
    }
}