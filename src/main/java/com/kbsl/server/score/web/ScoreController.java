package com.kbsl.server.score.web;

import com.kbsl.server.score.service.ScoreService;
import com.kbsl.server.song.dto.request.SongSaveRequestDto;
import com.kbsl.server.song.dto.response.SongResponseDto;
import com.kbsl.server.user.dto.response.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "Score", description = "점수 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping(value = "/{userSeq}")
    @Tag(name = "Song")
    @Operation(summary = "[App] 노래 생성 API",
            description =
                    "리그 시퀀스를 Path Variable 로 전달받아 해당 리그의 노래를 추가한다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "과정 생성 성공"),
            @ApiResponse(responseCode = "403", description = "권한 없음"),
            @ApiResponse(responseCode = "404", description = "리그 미조회")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponseDto> updatePlayerScore(
            @PathVariable("userSeq") Long userSeq
    ) throws Exception {
        return ResponseEntity.ok(scoreService.updatePlayerScore(userSeq));
    }
}
