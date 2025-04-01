package com.sandrorjr.myBlog.dto;

import com.sandrorjr.myBlog.model.PostModel;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.time.LocalDateTime;

public record responseProject(
        UUID id,
        String logoSrc,
        String title,
        String Description,
        UUID post,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao
) {
}



