package br.jus.tream.restlib.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ApiResponse<T> {
	 private boolean success;
	 private String message;
	 private T data;
	 private List<String> errors;
	 private int errorCode;
	 private long timestamp;
	 private String path;

}
