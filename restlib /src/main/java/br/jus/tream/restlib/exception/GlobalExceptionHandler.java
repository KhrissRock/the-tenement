package br.jus.tream.restlib.exception;

import java.util.Arrays;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.jus.tream.restlib.response.ApiResponse;
import br.jus.tream.restlib.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ApiResponse<Object> objectNotFound(Exception ex, HttpServletRequest request) {
        return ResponseUtil.error(Arrays.asList(ex.getMessage()), "Objeto não encontrado!", 404,
                request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleGeneralException(Exception ex, HttpServletRequest request) {
        return ResponseUtil.error(Arrays.asList(ex.getMessage()), "Um erro inesperado ocorreu", 1001,
                request.getRequestURI());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<Object> handleResourceNotFoundException(ResourceNotFoundException ex,
            HttpServletRequest request) {
        return ResponseUtil.error(Arrays.asList(ex.getMessage()), "Recurso não encontrado", 404,
                request.getRequestURI());
    }

    @ExceptionHandler(ResponseNotFoundException.class)
    public ApiResponse<Object> handleResponseNotFoundException(ResponseNotFoundException ex,
            HttpServletRequest request) {
        return ResponseUtil.error(Arrays.asList(ex.getMessage()), "Dados não encontrados", 204,
                request.getRequestURI());
    }

    @ExceptionHandler(LivroIndisponivelException.class)
    public ApiResponse<Object> handleLivroIndisponivelException(LivroIndisponivelException ex,
            HttpServletRequest request) {
        return ResponseUtil.error(
                Arrays.asList(ex.getMessage()),
                "Livro indisponível para empréstimo",
                409,
                request.getRequestURI());
    }
}