package com;

import com.Factory.Factory;
import com.Factory.HibernateSessionFactory;
import com.entity.FishingRods;
import com.dao.FishingRodsDAOImpl;
import com.entity.User;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Roman on 06.07.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        FishingRods goods1 = new FishingRods();
        FishingRods goods2 = new FishingRods();
        FishingRods goods3 = new FishingRods();
        FishingRods goods4 = new FishingRods();
        FishingRods goods5 = new FishingRods();
        FishingRods goods6 = new FishingRods();

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setNikName("KaRapuZ");
        user1.setEmail("karapuz@mail.ru");
        user1.setPassword("9379992");

        user2.setNikName("PetyaVasichkin");
        user2.setEmail("petRuha@mail.ua");
        user2.setPassword("911911");

        user3.setNikName("Lenchik");
        user3.setEmail("lenaPuh@mail.ru");
        user3.setPassword("57575757");

        Factory.getInstance().getUserDAO().addUser(user1);
        Factory.getInstance().getUserDAO().addUser(user2);
        Factory.getInstance().getUserDAO().addUser(user3);


        goods1.setType("Спиннинговые");
        goods1.setMaterial("Карбон");
        goods1.setDesign("Штекерная");
        goods1.setCasting(7);
        goods1.setManufacturer("Dragon");
        goods1.setName("Fishmaker Jig");
        goods1.setLength( 2.30);
        goods1.setWeight(113);
        goods1.setSpecializationOfFishingRods("Джиг");
        goods1.setPrice(2340);


        goods2.setType("Спиннинговые");
        goods2.setMaterial("Карбон");
        goods2.setDesign("Штекерная");
        goods2.setCasting(15);
        goods2.setManufacturer("Shimano");
        goods2.setName("Catana DX");
        goods2.setLength(2.40);
        goods2.setWeight(142);
        goods2.setSpecializationOfFishingRods("Воблеры, блесны, Лайт и ультралайт");
        goods2.setPrice(1264);


        goods3.setType("Фидерные");
        goods3.setMaterial("Карбон");
        goods3.setDesign("Штекерная");
        goods3.setCasting(170);
        goods3.setManufacturer("Lineaeffe");
        goods3.setName("TeamSpecialist Impulse Feeder");
        goods3.setLength(3.60);
        goods3.setWeight(320);
        goods3.setSpecializationOfFishingRods(null);
        goods3.setPrice(1940);

        goods4.setType("Спиннинговые");
        goods4.setMaterial("Композит");
        goods4.setDesign("Телескопическая");
        goods4.setCasting(40);
        goods4.setManufacturer("Lineaeffe");
        goods4.setName("Perch Telespin");
        goods4.setLength(2.40);
        goods4.setWeight(140);
        goods4.setSpecializationOfFishingRods("Воблеры, блесны, Троллинг, Джиг");
        goods4.setPrice(717);

        goods5.setType("Спиннинговые");
        goods5.setMaterial("Карбон");
        goods5.setDesign("Одночастная");
        goods5.setCasting(30);
        goods5.setManufacturer("Salmo");
        goods5.setName("Ballist");
        goods5.setLength(1.80);
        goods5.setWeight(103);
        goods5.setSpecializationOfFishingRods("Джерк и твич");
        goods5.setPrice(2784);

        goods6.setType("Спиннинговые");
        goods6.setMaterial("Карбон");
        goods6.setDesign("Штекерная");
        goods6.setCasting(30);
        goods6.setManufacturer("Shimano");
        goods6.setName("Vengeance BX");
        goods6.setLength(2.40);
        goods6.setWeight(172);
        goods6.setSpecializationOfFishingRods("Джерк и твич");
        goods6.setPrice(1114);

        Factory.getInstance().getFishingRodsDAO().addFishingRods(goods1);
        Factory.getInstance().getFishingRodsDAO().addFishingRods(goods2);
        Factory.getInstance().getFishingRodsDAO().addFishingRods(goods3);
        Factory.getInstance().getFishingRodsDAO().addFishingRods(goods4);
        Factory.getInstance().getFishingRodsDAO().addFishingRods(goods5);
        Factory.getInstance().getFishingRodsDAO().addFishingRods(goods6);

        List<FishingRods> fishingRods = Factory.getInstance().getFishingRodsDAO().getAllFishingRods();
        System.out.println("---------------All fishing rods---------------");
        for (int i = 0; i < fishingRods.size(); ++i){
            System.out.println("Id: " + fishingRods.get(i).getFishingRodsId() + " Тип: " + fishingRods.get(i).getType() + " Материал: " + fishingRods.get(i).getMaterial()
            + " Конструкция: " + fishingRods.get(i).getDesign() + " Кастинг: " + fishingRods.get(i).getCasting() + " Производитель: " + fishingRods.get(i).getManufacturer()
            + " Модель: " + fishingRods.get(i).getName() + " Длина: " + fishingRods.get(i).getLength() + " Вес: " + fishingRods.get(i).getWeight()
            + " Специализация: " + fishingRods.get(i).getSpecializationOfFishingRods() + " Цена: " + fishingRods.get(i).getPrice());
            System.out.println("==============================================================");
        }

        List<User> users = Factory.getInstance().getUserDAO().getAllUsersData();
        System.out.println("---------------All users data---------------");
        for (int i = 0; i < users.size(); ++i){
            System.out.println("Id: " + users.get(i).getIdUser() + " Nik-Name: " + users.get(i).getNikName() + " Email: " + users.get(i).getEmail()
                    + " Password: " + users.get(i).getPassword());
            System.out.println("==============================================================");
        }


        FishingRodsDAOImpl fishingRodsDAO = new FishingRodsDAOImpl();
        fishingRodsDAO.getCategory("Fishing Rods");
    }
}
