package com.wolf.consumer1;

import com.wolf.consumer1.entity.Customer;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureStubRunner(ids = {"at.wolf.dependencies:8080"}, stubsMode =
        StubRunnerProperties.StubsMode.LOCAL)
class Consumer1ApplicationTests {

    @Test
    public void getCustomerInfo() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> customerResponseEntity = restTemplate.exchange(
                "http://localhost:8080/customers", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Customer>>(){});
        assertThat(customerResponseEntity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(customerResponseEntity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(customerResponseEntity.getBody()).isNotEmpty();
    }

}
