package com.ohgiraffers.rpg.controller;

import com.ohgiraffers.rpg.dto.Item;
import com.ohgiraffers.rpg.dto.PersonDTO;
import com.ohgiraffers.rpg.dto.User;

public class Manager {

    private User user = new User();
    private PersonDTO[] npcList = new PersonDTO[] {
            new PersonDTO("아이린", -20),
            new PersonDTO("카리나", 0),
            new PersonDTO("장원영", 15)
    };

    public Manager() {}

    public void setUserName(String name) {
        this.user.setName(name);
    }

    public void alba(int type) {
        user.alba(type);
    }












}
