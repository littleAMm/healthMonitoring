import Vue from 'vue'
import Router from 'vue-router'
import vue_login from "@/components/vue_login";
import vue_reg from "@/components/vue_reg";
import patient_home from "@/components/patient_home";
import patient_info from "@/components/patient_info";
import patient_health from "@/components/patient_health";
import patient_doctor from "@/components/patient_doctor";
import doctor_home from "@/components/doctor_home";
import doctor_info from "@/components/doctor_info";
import doctor_message from "@/components/doctor_message";
import doctor_patient from "@/components/doctor_patient";
import manager_home from "@/components/manager_home";
import manager_doctor from "@/components/manager_doctor";
import manager_patient from "@/components/manager_patient";



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
                    name:'患者已选择的医生',
                    component:patient_doctor
                }
            ]
        },
        {
            path: '/doctor',
            name: '医生',
            component: doctor_home,
            children: [
                {
                    path: '/doctor/info',
                    name: '医生信息',
                    component:doctor_info
                },
                {
                    path:'/doctor/patient',
                    name:'医生的患者',
                    component:doctor_patient
                },
                {
                    path:'/doctor/message',
                    name:'医生的消息',
                    component:doctor_message
                }
            ]
        },
        {
            path: '/manager',
            name: '管理员',
            component: manager_home,
            children: [
                {
                    path: '/manager/doctor',
                    name: '管理员查看医生',
                    component:manager_doctor
                },
                {
                    path:'/manager/patient',
                    name:'管理员查看患者',
                    component:manager_patient
                }
            ]
        }
    ]
})