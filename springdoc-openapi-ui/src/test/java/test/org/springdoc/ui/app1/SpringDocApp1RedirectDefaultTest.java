package test.org.springdoc.ui.app1;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import test.org.springdoc.ui.AbstractSpringDocTest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SpringDocApp1RedirectDefaultTest extends AbstractSpringDocTest {

    @Test
    public void shouldRedirectWithDefaultQueryParams() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/swagger-ui.html"))
                .andExpect(status().isFound()).andReturn();

        String locationHeader = mvcResult.getResponse().getHeader("Location");
        assertEquals("/swagger-ui/index.html?url=/v3/api-docs&validatorUrl=", locationHeader);
    }

}