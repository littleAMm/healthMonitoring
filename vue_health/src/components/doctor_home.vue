<template>
  <el-tabs tab-position="top" v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="个人信息" name="first">
      <doctor_info/>
    </el-tab-pane>
    <el-tab-pane label="我的病人" name="second">
      <doctor_patient ref="patient"/>
    </el-tab-pane>
    <el-tab-pane label="消息中心" name="third">
      <doctor_message ref="message"/>
    </el-tab-pane>
  </el-tabs>
</template>

<script>

import doctor_info from "@/components/doctor_info";
import doctor_patient from "@/components/doctor_patient";
import doctor_message from "@/components/doctor_message";
export default {
  name: "doctor_home",
  methods: {
    handleClick(e) {
      // console.log(e)
      if (e.name == 'first') {
        this.$router.replace({path:'/doctor/info'});
      }
      if (e.name == 'second') {
        this.$router.replace({path: '/doctor/patient'});
        this.$refs.patient.loadPatient()
      }
      if (e.name == 'third') {
        this.$router.replace({path: '/doctor/message'});
        //this.$refs.message;
      }
      // if (e.name == 'fourth') {
      //   this.$router.replace({name: 'MessageCenter'});
      // }
    }
  },
  data() {
    return {
      activeName: 'first'
    }
  },
  components: {

    doctor_info,
    doctor_patient,
    doctor_message
  }
}
</script>

<style scoped>

</style>