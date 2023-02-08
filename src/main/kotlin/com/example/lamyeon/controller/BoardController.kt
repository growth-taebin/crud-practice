package com.example.lamyeon.controller

import com.example.lamyeon.dto.BoardFormDto
import com.example.lamyeon.response.BoardListResponseDto
import com.example.lamyeon.response.BoardResponseDto
import com.example.lamyeon.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class BoardController(
        private val boardService: BoardService
) {

    @PostMapping
    fun addPost(
            @RequestBody boardFormDto: BoardFormDto
    ): ResponseEntity<Any> =
            boardService.write(boardFormDto)
                    .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping("/{id}")
    fun findPostById(
            @PathVariable id: Long
    ): ResponseEntity<Any> =
            boardService.findPostById(id)
                    .let { ResponseEntity.ok().build() }

    @DeleteMapping("/{id}")
    fun deletePostById(
            @PathVariable id: Long
    ): ResponseEntity<Any> =
            boardService.deletePostById(id)
                    .let { ResponseEntity.ok().build() }

    @PatchMapping("/{id}")
    fun updatePostById(
            @PathVariable id: Long,
            @RequestBody boardFormDto: BoardFormDto
    ): ResponseEntity<Any> =
            boardService.updatePostById(id, boardFormDto)
                    .let { ResponseEntity.ok(it) }

    @GetMapping("/list")
    fun findAllPost(): ResponseEntity<BoardListResponseDto> =
            boardService.findAllPost()
                    .let { ResponseEntity.ok(it) }


}