package org.example;


import org.example.dao.CrudDao;
import org.example.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {
        Product p = new Milk();
        Product p2 = new Bread();
        Product m = new Milk();
        m.setDiscountCardPrice(new BigDecimal("88.88"));
        m.setPrice(new BigDecimal("99.88"));
        m.setExpirationDate(LocalDate.now().plusDays(10));
        p.setPrice(new BigDecimal("99.99"));
        p2.setExpirationDate(LocalDate.ofYearDay(2025,1));

        Buyer buyer = new Buyer();
        Buyer buyer2 = new Buyer();
        Buyer buyer3 = new Buyer();

        buyer.getProducts().add(m);
        buyer.getProducts().add(p);
        buyer.getProducts().add(p2);

        p2.getBuyers().add(buyer);
        p2.getBuyers().add(buyer2);
        p2.getBuyers().add(buyer3);
        p.getBuyers().add(buyer);
        p.getBuyers().add(buyer2);
        p.getBuyers().add(buyer3);
        m.getBuyers().add(buyer);
        m.getBuyers().add(buyer2);
        m.getBuyers().add(buyer3);

        Card7 c1 = new Card7();

        c1.setCode(1111);
        c1.setScore(200);

        c1.setOwner(buyer);

        buyer.getCards().add(c1);

        VipCard v = new VipCard();

        v.setName("super vip");
        v.setDiscountPercent(99);
        v.getDiscountProducts().add("Milk");
        v.setOwner(buyer);

        buyer.getVipCards().add(v);




        CrudDao crudDao = new CrudDao();



        crudDao.add(buyer);

    }
}
