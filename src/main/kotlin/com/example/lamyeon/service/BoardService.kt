package com.example.lamyeon.service

import com.example.lamyeon.dto.BoardFormDto
import com.example.lamyeon.dto.ResponseDto
import com.example.lamyeon.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(val boardRepository: BoardRepository) {

    fun write(boardFormDto: BoardFormDto): Long? {
        return boardRepository.save(
                ResponseDto(id = -1, boardFormDto.writer, boardFormDto.password, boardFormDto.title, boardFormDto.content)
        ).id
    }

    fun findPostById(id: Long): ResponseDto =
            boardRepository.findById(id).get()
                    .let { return it }

    fun deletePostById(id: Long) {
        boardRepository.deleteById(id)
    }

    fun updatePostById(id: Long, boardFormDto: BoardFormDto): ResponseDto =
            boardRepository.findById(id).get()
                    .let { updatePostById(id, boardFormDto) }
                    .let { return it  }

    fun findAllPost(): List<ResponseDto> =
            boardRepository.findAll()
}