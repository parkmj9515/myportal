package himedia.myportal.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 전역 예외처리 컨트롤러
@ControllerAdvice	// @Compornent의 하위 어노테이션
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException e, Model model) {
		// 1. 기록 로그에 남겨야함 (로깅)
		System.err.println("========================");
		System.err.println("ControllerAdvice에 의한 ErrorHanling");
		e.printStackTrace();
		
		// 2. 시스템 오류 안내화면
		model.addAttribute("name",e.getClass().getSimpleName());
		model.addAttribute("message", e.getMessage());
		
		return "errors/exception";
	}
}
