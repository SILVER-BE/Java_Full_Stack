package com.ohgiraffers.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @PostMapping("/single-file")    //html에 작성된 변수명과 데이터값의 이름 일치시키면 넘어옴, RequestParam은 생략도 가능
    public String singleFileUpload(@RequestParam String singleFileDescription,
                                   @RequestParam MultipartFile singleFile,
                                    Model model) { //화면에 출력해주기 위해 model 추가

        System.out.println("singleFileDescription : " + singleFileDescription);
        System.out.println("singleFile : " + singleFile);

        /* 서버로 전달된 File을 서버에서 설정하는 경로에 저장한다. */
        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles"; //root의 하위 경로 설정
        File dir = new File(filePath);

        /* 설정된 절대경로 출력 */
        System.out.println(dir.getAbsolutePath());

        /* 경로가 존재하지 않는다면 생성하라는 명령 */
        if(!dir.exists()) dir.mkdirs();

        /* 파일명 변경 처리(업로드한 파일명이 중복될 시 사용) */
        String originFileName = singleFile.getOriginalFilename(); //원래 파일 이름
        String ext = originFileName.substring(originFileName.lastIndexOf(".")); //.을 기준으로 잘라내서 저장
        String savedName = UUID.randomUUID() + ext; //유니크&랜덤한 아이디를 만들어주는 기능

        /* 파일 저장 */
        try {
            //입출력 과정은 exception 처리해줘야 함
            singleFile.transferTo(new File(filePath + "/" + savedName));
            model.addAttribute("message", "파일 업로드에 성공했습니다.");
        } catch (IOException e) {
            model.addAttribute("message", "파일 업로드를 실패했습니다.");
        }

        return "result";
    }

    @PostMapping("/multi-file")
    public String multiFileUpload(@RequestParam String multiFileDescription,
                                  @RequestParam List<MultipartFile> multiFile,
                                  Model model){

        System.out.println("multiFileDescription = " + multiFileDescription);
        System.out.println("multiFile = " + multiFile);

        /* 서버로 전달 된 file을 서버에서 설정하는 경로에 저장한다. */
        String root = "src/main/resources/static";
        String filePath = root + "/uploadFiles";
        File dir = new File(filePath);
        System.out.println(dir.getAbsolutePath());

        if(!dir.exists()) dir.mkdirs();

        List<FileDTO> files = new ArrayList<>();

        try {
            /* 파일명 변경 처리 후 저장 : 다중 파일 반복문 처리 */
            for(MultipartFile file : multiFile) {

                /* 파일명 변경처리 */
                String originFileName = file.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedName = UUID.randomUUID() + ext;

                /* 파일에 관한 정보 추출 후 보관 */
                files.add(new FileDTO(originFileName, savedName, filePath, multiFileDescription));

                /* 파일 저장 */

                file.transferTo(new File(filePath + "/" + savedName));

            }
            /* 서버의 정해진 경로로 파이 저장이 완료되면 LIst<FileDTO> 타입의 객체에 저장된 정보를 DB에 insert 한다. */
            model.addAttribute("message","파일 업로드 완료!");
        } catch (IOException e) {
            /* 파일 저장 중간에 실패 시 이전에 저장 된 파일 삭제 */
            for(FileDTO file : files) {
                new File(filePath + "/" + file.getSavedName()).delete();
            }
            model.addAttribute("message","파일 업로드 실패!");

        }
        return "result";
    }


}
