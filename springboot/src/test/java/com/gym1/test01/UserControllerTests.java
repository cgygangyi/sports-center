package com.gym1.test01;

import com.gym1.service.ItemService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTests {

    @Autowired
    private ItemService itemService;

    @Test
    public void addItemTest01() {
        boolean res = itemService.addItem("apple", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("apple");
        Assert.assertTrue(res);
    }
    @Test
    public void addItemTest02() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        boolean res2 = itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        Assert.assertFalse(res2);
    }
    @Test
    public void deleteItemByNameTest01() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("pig");
        boolean res2 = itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        Assert.assertTrue(res2);
    }
    @Test
    public void deleteItemByNameTest02() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.addItem("apple", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("pig");
        boolean res2 = itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("apple");
        Assert.assertTrue(res2);
    }
    @Test
    public void deleteItemByNameTest03() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.addItem("apple", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("apple");
        boolean res2 = itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("pig");
        Assert.assertFalse(res2);
    }
    @Test
    public void queryAllItemTest01() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.addItem("apple", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("apple");
        boolean res2 = itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("pig");
        Assert.assertFalse(res2);
    }


    
}
