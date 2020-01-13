/**
 * DFrame框架核心js
 *
 * 依赖layui
 * author: svenbarnett/3197544360@qq.com
 *
 **/
if (layui == {} || layui == undefined) {
    console.error("请引入layui.js!")
}

;layui.define(['layer'], function (exports) {
    let dui = {};

    exports("dui", dui);
});