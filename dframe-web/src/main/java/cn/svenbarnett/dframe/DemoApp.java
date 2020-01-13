package cn.svenbarnett.dframe;

import cn.svenbarnett.dframe.core.DFrameApplicationBoot;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * [简单描述]
 *
 * @author svenbarnett/3197544360@qq.com
 * @date [v1, 2020-01-12 17:36]
 */

@SpringBootApplication
@MapperScan(basePackages = {"cn.svenbarnett.dframe.core.mapper"})
public class DemoApp {
    public static void main(String[] args) {
        DFrameApplicationBoot.run(DemoApp.class, args);
    }
}
