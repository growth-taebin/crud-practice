package com.example.lamyeon.controller

import com.example.lamyeon.dto.BoardFormDto
import com.example.lamyeon.service.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class BoardController constructor(private val boardService: BoardService){

    @PostMapping
    fun addPost(@RequestBody boardFormDto: BoardFormDto): ResponseEntity<Any> = boardService.write(boardFormDto)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: Long): ResponseEntity<Any> = boardService.getPost(id)
            .let { ResponseEntity.ok().body(it) }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Any> = boardService.deletePost(id)
            .let { ResponseEntity.ok().body(it) }

    @PatchMapping("/{id}")
    fun updatePost(
            @PathVariable id: Long,
            boardFormDto: BoardFormDto
    ): ResponseEntity<Any> = boardService.updatePost(id, boardFormDto)
            .let { ResponseEntity.ok().body(it) }

    @GetMapping("/list")
    fun listPost(): ResponseEntity<Any> = boardService.getPostList()
            .let { ResponseEntity.ok().body(it) }




}