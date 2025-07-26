package com.example.memo.controller;

import com.example.memo.dto.MemoRequestDto;
import com.example.memo.dto.MemoResponseDto;
import com.example.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/memos")
public class MemoController {

    //맵 자료구조 생성
    private  final Map<Long, Memo> memoList = new HashMap<>();

    //메모 생성 기능
    @PostMapping
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto dto) {

        // 메모리스트가 비어있다면 초기값을 1로 설정 / 식별자가 1씩 증가하도록 만듦
        Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;

        // 요청받은 데이터로 Memo 객체 생성
        Memo memo = new Memo(memoId, dto.getTitle(), dto.getContents());

        //Inmemory DB에 Memo 저장
        memoList.put(memoId, memo);

        return new MemoResponseDto(memo);
    }

    //메모 목록 조회
    @GetMapping
    public List<MemoResponseDto> findAllMemos() {

        //List 초기화
        List<MemoResponseDto> responseList = new ArrayList<>();

        //HashMap<Memo> -> List<MemoResponseDto> 방법 (1)
        for (Memo memo : memoList.values()) {
            MemoResponseDto responseDto = new  MemoResponseDto(memo);
            responseList.add(responseDto);
        }
        //Map to List 방법 (2)
        // responseList = memoList.values().stream().map(MemoResponseDto::new).collect(Collectors.toList());
        return responseList;
    }

    //메모 조회 기능
    @GetMapping("/{id}")
    public MemoResponseDto findMemoById(@PathVariable Long id) {
        Memo memo = memoList.get(id);
        return new MemoResponseDto(memo);
    }

    //메모 수정 기능
    public MemoResponseDto updateMemoById(
            @PathVariable Long id,
            @RequestBody MemoRequestDto dto
    ) {
        Memo memo = memoList.get(id);
        memo.update(dto);

        return new MemoResponseDto(memo);
    }

    //메모 삭제 기능
    @DeleteMapping("/{id}")
    public void deleteMemoById(
            @PathVariable Long id
    ) {
        memoList.remove(id);

    }
}
