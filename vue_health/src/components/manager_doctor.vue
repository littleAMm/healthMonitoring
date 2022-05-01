<template>
  <!-- <el-container> -->

  <!--  <el-header> -->
  <!-- <el-popover
    placement="right"
    width="400"
    trigger="click">
    <el-table >
   <input type="text" placeholder="姓名" v-model="">
   <input type="text" placeholder="科室" v-model="">
   <input type="text" placeholder="电话" v-model="">
   <input type="text" placeholder="排班" v-model="">
       <button @click="update()">确认</button>
      <button @click="flag=false">取消</button>
    </el-table>
    <el-button slot="reference">新增</el-button>
  </el-popover> -->
  <!-- </el-header> -->


  <!--  <el-main> -->
  <div>
    <el-table
        :data="tableData"
        border
        style=" ">
      <el-table-column
          fixed
          prop="id"
          label="编号"
          width="100">
      </el-table-column>
      <el-table-column
          prop="name"
          label="姓名"
          width="150">
      </el-table-column>
      <el-table-column
          prop="dep"
          label="科室"
          width="150">
      </el-table-column>
      <el-table-column
          prop="phone"
          label="电话"
          width="200">
      </el-table-column>
      <el-table-column
          prop="work"
          label="排班"
          width="400">
      </el-table-column>

      <el-table-column

          label="操作"
          width="100">
        <template>
          <el-button type="text" size="small">删除</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>

    </el-table>


    <el-popover
        placement="right"
        width="400"
        trigger="click">
      <el-form :label-position="right" label-width="80px">

        <el-form-item label="姓名">
          <el-input type="textarea"></el-input>
        </el-form-item>
        <el-form-item label="科室">
          <el-input type="textarea"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input type="textarea"></el-input>
        </el-form-item>
        <el-form-item label="排班">
          <el-input type="textarea"></el-input>
        </el-form-item>
        <el-button type="primary" plain style="float: right">确认</el-button>

      </el-form>
      <el-button style="float:right" slot="reference">新增</el-button>
    </el-popover>


  </div>
  <!-- </el-main>
  </el-container> -->
</template>


<script>
import {getRequest} from "@/utils/api";

export default {

  name: "manager_doctor",
  methods: {
    handleClick(row) {
      console.log(row);
    },
    add: function () {
      this.flag = true;
    },
    queryAllDoctors(){
      let _this = this;
      getRequest("/admin/addDoctor").then(resp=>{
        _this.tableData = resp.data;
      })
    }

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