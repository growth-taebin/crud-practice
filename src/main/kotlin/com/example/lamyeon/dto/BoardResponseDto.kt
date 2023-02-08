package com.example.lamyeon.dto


data class BoardResponseDto(
        var id: Long?,
        var writer: String,
        var password: String,
        var title: String,
        var content: String
)