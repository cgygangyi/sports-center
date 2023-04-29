package com.gym1.test01;

import com.gym1.entity.Item;
import com.gym1.service.ItemService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
class ItemServiceTests {

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
    public void getAllItemTest01() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        List<Item> items = itemService.getAllItem();
        Item res = items.get(items.size()-1);
        Item res2 = new Item("pig", 12.3, "aaa", "asdasdasda");
        itemService.deleteItem("pig");
        Assert.assertEquals(res.toString(), res.toString());
    }
    @Test
    public void getAllItemTest02() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.addItem("apple", "aaa", 12.3, "asdasdasda");
        List<Item> items = itemService.getAllItem();
        Item res = items.get(items.size()-1);
        Item res2 = new Item("pig", 12.3, "aaa", "asdasdasda");
        itemService.deleteItem("pig");
        itemService.deleteItem("apple");
        Assert.assertNotEquals(res.toString(), res2.toString());
    }
    @Test
    public void editItemTest01() {
        boolean res = itemService.addItem("apple", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("apple");
        Assert.assertTrue(res);
    }
    @Test
    public void editItemTest02() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        boolean res2 = itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        Assert.assertFalse(res2);
    }
    @Test
    public void editItemTest03() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("pig");
        boolean res2 = itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        Assert.assertTrue(res2);
    }
    @Test
    public void queryItemByNameTest01() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.addItem("apple", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("pig");
        boolean res2 = itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("apple");
        Assert.assertTrue(res2);
    }
    @Test
    public void queryItemByNameTest02() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.addItem("apple", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("apple");
        boolean res2 = itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        itemService.deleteItem("pig");
        Assert.assertFalse(res2);
    }
    @Test
    public void queryItemByNameTest03() {
        itemService.addItem("pig", "aaa", 12.3, "asdasdasda");
        List<Item> items = itemService.getAllItem();
        Item res = items.get(items.size()-1);
        Item res2 = new Item("pig", 12.3, "aaa", "asdasdasda");
        itemService.deleteItem("pig");
        Assert.assertEquals(res.toString(), res.toString());
    }
}
