<template>
  <el-tabs tab-position="top" v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="个人信息" name="first">
      <keep-alive>
        <patient_info/>
      </keep-alive>
    </el-tab-pane>
    <el-tab-pane label="我的医生" name="second">
      <patient_doctor ref="doctor"/>
    </el-tab-pane>
    <el-tab-pane label="健康上报" name="third">
      <patient_health ref="health"/>
    </el-tab-pane>
    <el-tab-pane label="消息中心" name="fourth">
      <el-empty description="暂无消息"></el-empty>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import patient_doctor from "@/components/patient_doctor";
import patient_health from "@/components/patient_health";
import patient_info from "@/components/patient_info";

export default {
  name: "patient_home",
  methods: {
    handleClick(e) {
      // console.log(e)
      let _this = this;
      if (e.name == 'first') {
        this.$router.replace({path: '/patient/info'});
      }
      if (e.name == 'second') {
        this.$router.replace({path: '/patient/doctor'});
        this.$refs.doctor.querySelectedDoctor(_this.$root.id);
      }
      if (e.name == 'third') {
        this.$router.replace({path: '/patient/health'});
        this.$refs.health.queryAllHealth();
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
    patient_doctor,
    patient_info,
    patient_health
  }
}
</script>

<style scoped>

</style>