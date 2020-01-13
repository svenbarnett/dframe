package cn.svenbarnett.dframe.core;

import org.springframework.boot.SpringApplication;

/**
 * [简单描述]
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-12 17:36]
 */
public class DFrameApplicationBoot {
    public static void run(Class c, String[] args) {
        SpringApplication.run(c, args);
        System.out.println("" +
                " _____  ______                        \n" +
                "|  __ \\|  ____|                       \n" +
                "| |  | | |__ _ __ __ _ _ __ ___   ___ \n" +
                "| |  | |  __| '__/ _` | '_ ` _ \\ / _ \\\n" +
                "| |__| | |  | | | (_| | | | | | |  __/\n" +
                "|_____/|_|  |_|  \\__,_|_| |_| |_|\\___|\n" +
                " DFrame Framework ::: (v1.0.0.RELEASE)\n");
    }
}
