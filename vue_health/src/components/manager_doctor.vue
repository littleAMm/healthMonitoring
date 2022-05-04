<template>
  <div>
    <el-popover
        placement="right"
        width="400"
        trigger="click">
      <el-form :label-position="right" label-width="80px">
        <el-form-item label="用户名">
          <el-input type="textarea" v-model="addTable.username"></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input type="textarea" v-model="addTable.name"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group v-model="addTable.sex">
            <el-radio label="男">男</el-radio>
            <el-radio label="女">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="工作">
          <el-input type="textarea" v-model="addTable.work"></el-input>
        </el-form-item>
        <el-button type="primary" plain style="float: right" @click="addDoctor">确认</el-button>
      </el-form>
      <el-button style="float:right" slot="reference">新增</el-button>
    </el-popover>
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
          width="150">
      </el-table-column>
      <el-table-column
          prop="work"
          label="科室"
          width="150">
      </el-table-column>
      <el-table-column
          prop="phoneNumber"
          label="电话"
          width="200">
      </el-table-column>
      <el-table-column
          prop="sex"
          label="性别"
          width="50">
      </el-table-column>
      <el-table-column
          prop="workTime"
          label="排班"
          width="400">
      </el-table-column>
      <el-table-column
          label="操作"
          width="200">
        <template #default="scope">
          <el-button type="text" size="small" @click="deleteDoctor(scope.row)">删除</el-button>
          <el-popover
              placement="right"
              width="400"
              trigger="click">
            <el-form :label-position="right" label-width="80px">
              <el-form-item label="科室">
                <el-input v-model="editable.work"></el-input>
              </el-form-item>
              <el-form-item label="电话">
                <el-input v-model="editable.phone"></el-input>
              </el-form-item>
              <el-form-item label="排班">
                <el-input v-model="editable.workTime"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="updateDoctor(scope.row)">立即修改</el-button>
              </el-form-item>
            </el-form>
            <el-button type="text" size="small" slot="reference">编辑</el-button>
          </el-popover>
          <el-button type="primary" @click="updatePwd(scope.row)">初始化密码</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import {getRequest, postRequest} from "@/utils/api";

export default {
  name: "manager_doctor",
  methods: {
    queryAllDoctors() {
      let _this = this;
      getRequest("/admin/allDoctor").then(resp => {
        _this.tableData = resp.data;
      })
    },
    addDoctor() {
      let _this = this;
      postRequest("/admin/addDoctor", {
        username: _this.addTable.username,
        name: _this.addTable.name,
        sex: _this.addTable.sex,
        work: _this.addTable.work
      }).then(resp => {
        _this.$alert(resp.data);
      });
    },
    deleteDoctor(row) {
      let _this = this;
      postRequest("/admin/deleteDoctor", {
        username: row.username
      }).then(resp => {
        _this.$alert(resp.data);
      });
      this.tableData = this.tableData.filter(item => {
        return item.username !== row.username;
      });
    },
    updatePwd(row){
      let _this = this;
      postRequest("/admin/updatePwd",{
        username: row.username
      }).then(resp=>{
        _this.$alert(resp.data)
      });
    },
    updateDoctor(row) {
      let _this = this;
      postRequest("/admin/updateDoctor", {
        username: row.username,
        work: _this.editable.work,
        phone: _this.editable.phone*1,
        workTime: _this.editable.workTime
      }).then(resp => {
        _this.$alert(resp.data);
      });
      row.work = this.editable.work;
      row.phoneNumber = this.editable.phone;
      row.workTime = this.editable.workTime;
    }
  },

  mounted() {
    this.queryAllDoctors();
  },
  data() {
    return {
      flag: false,
      tableData: [],
      addTable: {
        username: '',
        name: '',
        sex: '',
        work: ''
      },
      editable: {
        work: '',
        phone: '',
        workTime: ''
      }
    }
  }
}
</script>

<style scoped>

</style>