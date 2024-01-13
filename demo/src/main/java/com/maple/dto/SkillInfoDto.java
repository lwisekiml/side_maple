package com.maple.dto;

import lombok.Data;

@Data
public class SkillInfoDto {
    String skill_name;
    String skill_description;
    long skill_level;
    String skill_effect;
    String skill_icon;
}
