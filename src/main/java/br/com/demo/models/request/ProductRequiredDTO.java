package br.com.demo.models.request;

public class ProductRequiredDTO {

    private Long id;

    public ProductRequiredDTO(){}

    public ProductRequiredDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
