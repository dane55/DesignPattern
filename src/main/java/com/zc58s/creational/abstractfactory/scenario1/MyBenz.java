package com.zc58s.creational.abstractfactory.scenario1;

import com.zc58s.creational.abstractfactory.*;

/*
 * @description :
 *
 *
 * @author      : fjc.dane@gmail.com
 * @create time : 2020/11/24 14:22
 */
public class MyBenz extends Benz {


    public MyBenz() {
        this.brand = Brand.奔驰;
    }

    public Grade createGrade() {
        return Grade.A级;
    }

    public Nature createNature() {
        return Nature.家庭自用汽车;
    }

    public VehicleModel createVehicle() {
        return VehicleModel.SUV车型;
    }


}
