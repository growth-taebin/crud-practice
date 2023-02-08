package com.example.lamyeon.service

import com.example.lamyeon.dto.BoardFormDto
import com.example.lamyeon.dto.BoardResponseDto
import com.example.lamyeon.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(val boardRepository: BoardRepository) {

    fun write(boardFormDto: BoardFormDto): Long? {
        return boardRepository.save(
                BoardResponseDto(id = -1, boardFormDto.writer, boardFormDto.password, boardFormDto.title, boardFormDto.content)
        ).id
    }

    fun findPostById(id: Long): BoardResponseDto =
            boardRepository.findById(id).get()
                    .let { return it }

    fun deletePostById(id: Long) {
        boardRepository.deleteById(id)
    }

    fun updatePostById(id: Long, boardFormDto: BoardFormDto) {
        val post = boardRepository.findBoardById(id) ?: throw RuntimeException()
        post.updatePost(boardFormDto)
    }


    fun findAllPost(): List<BoardResponseDto> =
            boardRepository.findAll()
}