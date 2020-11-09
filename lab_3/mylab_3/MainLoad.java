package mylab_3;

import mylab_3.model.Shop;

/**
 * Пример, демонстрирующий преобразование XML документа в объект
 */
public class MainLoad {

    public static void main(String[] args) {

        Shop shop = XMLService.loadShopFromXML();

        System.out.println(shop);
    }
}

