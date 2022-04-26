<template>

      <div style="width:800px; margin: 0 auto;">
          <el-collapse v-model="activeName" accordion>
  <el-collapse-item title="病人1号名字" name="1">
    <div>性别：</div>
    <div>年龄：</div>
    <div>联系方式：</div>
    <div>病症：</div>
    <div><el-button type="primary" round>发送提醒</el-button></div>
  </el-collapse-item>
  <el-collapse-item title="病人2号" name="2">
    <div>性别：</div>
    <div>年龄：</div>
    <div>联系方式：</div>
    <div>病症：</div>
  </el-collapse-item>
  <el-collapse-item title="病人3号" name="3">
    <div>性别：</div>
    <div>年龄：</div>
    <div>联系方式：</div>
    <div>病症：</div>
  </el-collapse-item>
  <el-collapse-item title="病人4号" name="4">
    <div>性别：</div>
    <div>年龄：</div>
    <div>联系方式：</div>
    <div>病症：</div>
  </el-collapse-item>
</el-collapse>
      </div>

</template>

<script>


export default {
  name: "manager_patient",

  data() {
      return {
        activeName: '1'
      };
    }
}
</script>

<style scoped>

</style>