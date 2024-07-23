package ru.lebedev.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
	private Long studentId;
	private String fio;
	private LocalDate bdDate;
	private Long classID;
}
