package se.dmitrykhalizov.webbshoplabb.repository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import se.dmitrykhalizov.webbshoplabb.entity.Order;
import se.dmitrykhalizov.webbshoplabb.entity.User;
import se.dmitrykhalizov.webbshoplabb.service.CustomerbasketService;
import se.dmitrykhalizov.webbshoplabb.service.EmailSenderService;
import se.dmitrykhalizov.webbshoplabb.service.OrderService;
import se.dmitrykhalizov.webbshoplabb.service.UserService;
import se.dmitrykhalizov.webbshoplabb.ui.OrderController;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class OrderRepoTest {

    @Mock
    private OrderService orderService;

    @Mock
    private UserService userService;

    @Mock
    private CustomerbasketService customerbasketService;

    @Mock
    private EmailSenderService emailSenderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    void createOrderServiceTest() {
        User user = new User();
        when(orderService.createOrder(any(User.class), anyList())).thenReturn(new Order());
        Order order = orderService.createOrder(user, new ArrayList<>());
        assertNotNull(order);
        verify(orderService, times(1)).createOrder(any(User.class), anyList());
    }

    @Test
    void changeStatusServiceTest(){
        Order order = new Order();
        doAnswer(invocation -> {
            Integer arg0 = invocation.getArgument(0);
            Boolean arg1 = invocation.getArgument(1);
            order.setStatus(arg1);
            return null;
        }).when(orderService).changeStatus(anyInt(), anyBoolean());
        orderService.changeStatus(1, true);
        assertTrue(order.getStatus());
        verify(orderService, times(1)).changeStatus(anyInt(), anyBoolean());
    }

    @Test
    void createOrderControllerTest() {
        User user = new User();
        when(userService.getUser(1)).thenReturn(user);
        String viewName = orderController.createOrder(1, mock(Model.class));
        assertEquals("orderconfirmation", viewName);
        verify(orderService, times(1)).createOrder(eq(user), anyList());
    }

    @Test
    void listOrderControllerTest() {
        String viewName = orderController.listOrders(mock(Model.class));
        assertEquals("orders", viewName);
        verify(orderService, times(1)).findAll();
    }
}