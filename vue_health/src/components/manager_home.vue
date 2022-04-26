<template>
  <el-tabs tab-position="top" v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="查看病人" name="first">
      <manager_patient/>
    </el-tab-pane>
    <el-tab-pane label="查看医生" name="second">
      <manager_doctor/>
    </el-tab-pane>

  </el-tabs>
</template>

<script>

import manager_doctor from "@/components/manager_doctor";
import manager_patient from "@/components/manager_patient";

export default {
  name: "manager_home",
  methods: {
    handleClick(e) {
      // console.log(e)
      if (e.name == 'first') {
        this.$router.replace({path:'/manager/patient'});
      }
      if (e.name == 'second') {
        this.$router.replace({path: '/manager/doctor'});
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

    manager_doctor,
    manager_patient
  }
}
</script>

<style scoped>

</style>