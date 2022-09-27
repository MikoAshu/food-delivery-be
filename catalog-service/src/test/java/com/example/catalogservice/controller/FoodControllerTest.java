// package com.example.catalogservice.controller;

// import static org.mockito.Mockito.when;

// import com.example.catalogservice.service.FoodService;

// import java.util.ArrayList;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// @ContextConfiguration(classes = {FoodController.class})
// @ExtendWith(SpringExtension.class)
// class FoodControllerTest {
//     @Autowired
//     private FoodController foodController;

//     @MockBean
//     private FoodService foodService;

//     /**
//      * Method under test: {@link FoodController#getfoods()}
//      */
//     @Test
//     void testGetfoods() throws Exception {
//         when(foodService.getFoods()).thenReturn(new ArrayList<>());
//         MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getfoods");
//         MockMvcBuilders.standaloneSetup(foodController)
//                 .build()
//                 .perform(requestBuilder)
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
//                 .andExpect(MockMvcResultMatchers.content().string("<List/>"));
//     }

//     /**
//      * Method under test: {@link FoodController#getfoods()}
//      */
//     @Test
//     void testGetfoods2() throws Exception {
//         when(foodService.getFoods()).thenReturn(new ArrayList<>());
//         MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/getfoods");
//         getResult.characterEncoding("Encoding");
//         MockMvcBuilders.standaloneSetup(foodController)
//                 .build()
//                 .perform(getResult)
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
//                 .andExpect(MockMvcResultMatchers.content().string("<List/>"));
//     }
// }

