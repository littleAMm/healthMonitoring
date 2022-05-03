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
          prop="phoneNumber"
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
        <template #default="scope">
          <el-button type="text" size="small" @click="handleClickDelete(scope.row)">删除</el-button>
          <el-popover
              placement="right"
              width="400"
              trigger="click">
            <el-form :label-position="right" label-width="80px">
              <el-form-item label="年龄">
                <el-input v-model="editTable.age"></el-input>
              </el-form-item>
              <el-form-item label="电话">
                <el-input v-model="editTable.phone"></el-input>
              </el-form-item>
              <el-form-item label="联系地址">
                <el-input v-model="editTable.address"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="updateInfo(scope.row)">立即修改</el-button>
              </el-form-item>
            </el-form>
            <el-button type="text" size="small" slot="reference">编辑</el-button>
          </el-popover>
          <el-button type="text" size="small" @click="handleClickRemind(scope.row)">提醒医生</el-button>
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
    deletePatient(username) {
      let _this = this;
      postRequest("/admin/deletePatient", {
        username: username
      }).then(resp => {
        _this.$alert(resp.data)
      })
    },
    queryAllPatients() {
      let _this = this;
      getRequest("/admin/allPatient").then(resp => {
        _this.tableData = resp.data;
      })
    },
    handleClickDelete(row) {
      this.deletePatient(row.username);
      this.tableData = this.tableData.filter(patient => {
            return patient.username !== row.username;
          }
      );
    },
    updateInfo(row) {
      console.log(row)
      let _this = this;
      row.age = this.editTable.age;
      row.phoneNumber = this.editTable.phone;
      row.address = this.editTable.address;
      postRequest("/admin/updatePatient", {
        username: row.username,
        age: _this.editTable.age,
        phoneNumber: _this.editTable.phone,
        address: _this.editTable.address
      }).then(resp => {
        _this.$alert(resp.data)
      })
    },
    handleClickRemind(row) {
      console.log(row)
    }
  },
  mounted() {
    this.queryAllPatients();
  },

  data() {
    return {
      flag: false,
      tableData: [],
      editTable: {
        age: '',
        phone: '',
        address: ''
      }
    }
  }
}
</script>

<style scoped>

</style>