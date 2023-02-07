package com.example.lamyeon.service

import com.example.lamyeon.entity.Board
import com.example.lamyeon.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BoardService @Autowired constructor(
        val boardRepository: BoardRepository,
) {

    fun write(boardFormDto: BoardFormDto): Long? {
        return boardRepository.save(Board(boardFormDto.writer, boardFormDto.password, boardFormDto.title, boardFormDto.content)).id
    }

    fun getPost(id: Long): Board? {
        return boardRepository.findById(id).get()
    }

    fun deletePost(id: Long) {
        boardRepository.deleteById(id)
    }

    fun updatePost(id: Long, boardFormDto: BoardFormDto): Board {
        val post = boardRepository.findById(id)
        post.updatePost(boardFormDto)
        return post
    }

    fun getPostList(): List<Board> {
        return boardRepository.findAll()
    }
}