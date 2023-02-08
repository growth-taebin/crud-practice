package com.example.lamyeon.service

import com.example.lamyeon.dto.BoardFormDto
import com.example.lamyeon.response.BoardResponseDto
import com.example.lamyeon.entity.Board
import com.example.lamyeon.repository.BoardRepository
import com.example.lamyeon.response.BoardListResponseDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardService(val boardRepository: BoardRepository) {

    fun write(boardFormDto: BoardFormDto): Long? {
        return boardRepository.save(
                Board(id = -1, boardFormDto.writer, boardFormDto.password, boardFormDto.title, boardFormDto.content)
        ).id
    }

    fun findPostById(id: Long): BoardResponseDto =
            boardRepository.findById(id).get()
                    .let { return BoardResponseDto(it.id, it.writer, it.title, it.password, it.content ) }

    fun deletePostById(id: Long) {
        boardRepository.deleteById(id)
    }

    @Transactional(rollbackFor = [Exception::class])
    fun updatePostById(id: Long, boardFormDto: BoardFormDto) {
        val post = boardRepository.findBoardById(id) ?: throw RuntimeException()
        post.updatePost(boardFormDto)
    }


    fun findAllPost(): BoardListResponseDto =
            boardRepository.findAll()
                    .let { return BoardListResponseDto(it) }
}