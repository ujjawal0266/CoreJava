package Enum;

import java.util.EnumSet;

public class main {
    enum java{
        springboot,corejava,advanceJava,jdbc,servlet,jsp,spring,hibernate;
    }
    static void main() {

        EnumSet<java> store=EnumSet.allOf(java.class);
        boolean temp=store.add(java.hibernate);
        System.out.println(temp);

    }
}
