package com.example.lamyeon.controller

import com.example.lamyeon.dto.BoardFormDto
import com.example.lamyeon.service.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("board")
class BoardController @Autowired constructor(val boardService: BoardService){

    @PostMapping
    fun addPost(boardFormDto: BoardFormDto): ResponseEntity<Any> {
        val save = boardService.write(boardFormDto)
        return ResponseEntity.ok().body(save)
    }

    @GetMapping("/{id}")
    fun getPost(@PathVariable id: Long): ResponseEntity<Any> {
        val post = boardService.getPost(id)
        return ResponseEntity.ok().body(post)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Any> {
        boardService.deletePost(id)
        return ResponseEntity.ok().body(true)
    }

    @PatchMapping("/{id}")
    fun updatePost(
            @PathVariable id: Long,
            boardFormDto: BoardFormDto
    ): ResponseEntity<Any> {
        val post = boardService.updatePost(id, boardFormDto)
        return ResponseEntity.ok().body(post)
    }

    @GetMapping("/list")
    fun listPost(): ResponseEntity<Any> {
        return ResponseEntity.ok().body(boardService.getPostList())
    }




}