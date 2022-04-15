import Vue from 'vue'
import Router from 'vue-router'
import vue_login from "@/components/vue_login";
import vue_reg from "@/components/vue_reg";
import patient_home from "@/components/patient_home";
import patient_info from "@/components/patient_info";
import patient_health from "@/components/patient_health";
import patient_doctor from "@/components/patient_doctor";

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: '登录',
            component: vue_login
        },
        {
            path: '/reg',
            name: '注册',
            component: vue_reg
        },
        {
            path: '/patient',
            name: '患者',
            component: patient_home,
            children: [
                {
                    path: '/patient/info',
                    name: '患者信息',
                    component:patient_info
                },
                {
                    path:'/patient/health',
                    name:'患者健康信息',
                    component:patient_health
                },
                {
                    path:'/patient/doctor',
                    name:'患者以选择的医生',
                    component:patient_doctor
                }
            ]
        }
    ]
})