package be.unamur.vgnx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
@ComponentScan("be.unamur.vgnx")
public class VgnxApplication {

	public static void main(String[] args) { SpringApplication.run(VgnxApplication.class, args); }

	@Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.any())
      .build();
  }

  private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
              .title("VGNX API")
              .description("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum " +
                            "has been the industry's standard dummy text ever since the 1500s, when an unknown printer ...")
              .license("Apache License Version 2.0")
              .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
              .version("1.0")
              .build();
  }
}
