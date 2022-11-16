/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

import entity.History;
import entity.Worker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPT SHOP
 */
public class Data {

    public static List<Worker> listWorker = new ArrayList() {
        {
            add(new Worker("W1", "Hung", 19, 1500, "Tuyen Quang"));
            add(new Worker("W2", "Huy", 19, 1800, "Thai Binh"));
            add(new Worker("W3", "Quang", 19, 1200, "Ha Noi"));
        }
    };
    public static List<History> listHistory = new ArrayList();
}
