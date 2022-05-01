<template>

  <div>
    <el-table
        :data="tableData"
        border
        style=" ">
      <el-table-column
          fixed
          prop="username"
          label="用户名"
          width="100">
      </el-table-column>
      <el-table-column
          prop="name"
          label="姓名"
          width="100">
      </el-table-column>
      <el-table-column
          prop="sex"
          label="性别"
          width="100">
      </el-table-column>
      <el-table-column
          prop="age"
          label="年龄"
          width="100">
      </el-table-column>
      <el-table-column
          prop="phone"
          label="电话"
          width="150">
      </el-table-column>
      <el-table-column
          prop="address"
          label="联系地址"
          width="150">
      </el-table-column>
      <el-table-column
          prop="symptom"
          label="病症"
          width="200">
      </el-table-column>
      <el-table-column
          prop="status"
          label="健康情况"
          width="100">
      </el-table-column>

      <el-table-column

          label="操作"
          width="100">
        <template>
          <el-button type="text" size="small" @click="deletePatient">删除</el-button>
          <el-button type="text" size="small">编辑</el-button>
          <el-button type="text" size="small">提醒医生</el-button>
        </template>
      </el-table-column>

    </el-table>


  </div>
  <!-- </el-main>
  </el-container> -->
</template>


<script>


import {getRequest, postRequest} from "@/utils/api";

export default {

  name: "manager_doctor",
  methods: {
    deletePatient(){
      postRequest("/admin/deletePatient",{
        username:888
      }).then(resp=>{
        _this.$alert(resp.data)
      })
    },
    add: function () {
      this.flag = true;
    },
    queryAllDoctors() {
      let _this = this;
      getRequest("/admin/allPatient").then(resp=>{
        _this.tableData = resp.data;
      })
    }
  },
  mounted() {
    this.queryAllDoctors();
  },

  data() {
    return {
      flag: false,
      tableData: []
    }
  }
}
</script>

<style scoped>

</style>