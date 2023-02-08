package com.example.lamyeon.dto

import com.example.lamyeon.entity.Board

data class ResponseDto(
        var id: Long?,
        var writer: String,
        var password: String,
        var title: String,
        var content: String
)