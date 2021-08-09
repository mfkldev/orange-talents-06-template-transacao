package br.com.zupacademy.marciosouza.transacao.config.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrosReponse> handle(MethodArgumentNotValidException exception){

        List<ErrosReponse> listErrosReponse = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach( e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            listErrosReponse.add(new ErrosReponse(e.getField(), mensagem));
        });

        return listErrosReponse;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(TransacationNotFoundException.class)
    public ErrosReponse handle2(TransacationNotFoundException exception){

        return new ErrosReponse("idCard", exception.getMessage());
    }
}