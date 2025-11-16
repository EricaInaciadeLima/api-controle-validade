package com.api.controlevalidade.controller;

        import com.api.controlevalidade.model.ProdutoModel;
        import com.api.controlevalidade.service.ProdutoService;
        import jakarta.validation.Valid;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.FieldError;
        import org.springframework.web.bind.MethodArgumentNotValidException;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.HashMap;
        import java.util.Map;

        @RestController
        @RequestMapping("/produto")
        public class ProdutoController {

            @Autowired
            private ProdutoService produtoService;

            @PostMapping
            public ResponseEntity<ProdutoModel> criar(@Valid @RequestBody ProdutoModel produto) {
                ProdutoModel criado = produtoService.salvarProduto(produto);
                return ResponseEntity.status(HttpStatus.CREATED).body(criado);
            }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
        }