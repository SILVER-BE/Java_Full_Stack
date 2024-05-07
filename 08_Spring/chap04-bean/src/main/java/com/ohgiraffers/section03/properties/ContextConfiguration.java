package com.ohgiraffers.section03.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("section03/properties/product-info.properties")
public class ContextConfiguration {

    // 해당하는 값을 꺼내와서 이 필드에 주입
    // 정의되지 않았을 경우 대체값 주입 가능

    /* 치환자(placeholer)문법을 이용하여 properties에 저장된 key를 입력하면 value에 해당하는 값을 꺼내온다.
    *   : 을 사용하면 값을 읽어오지 못하는 경우 사용할 대체 값을 작성할 수 있다.
    *   공백을 사용하면 값을 읽어오지 못한다. ${}
    *  */
    @Value("${bread.carpbread.name:슈크림붕어빵}")
    private String carpBreadName;

    @Value("${bread.carpbread.price}")
    private int carpBreadPrice;

    @Value("${beverage.milk.name}")
    private String milkName;

    @Value("${beverage.milk.price}")
    private int milkPrice;

    @Value("${beverage.milk.capacity}")
    private int milkCapacity;

    //

    @Bean
    public Product carpBread() {
        return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    public Product water(@Value("${beverage.water.name}")String waterName,
                         @Value("${beverage.water.price}")int waterPrice,
                         @Value("${beverage.water.capacity}")int waterCapacity) {
        return new Beverage(waterName, waterPrice, waterCapacity);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }

}
