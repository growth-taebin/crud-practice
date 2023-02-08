package com.example.lamyeon.entity

import com.example.lamyeon.dto.BoardFormDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Board(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var writer: String,
        var password: String,
        var title: String,
        var content: String
) {
    fun updatePost(boardFormDto: BoardFormDto) {
        writer = boardFormDto.writer
        title = boardFormDto.title
        password = boardFormDto.password
        content = boardFormDto.content
    }

}