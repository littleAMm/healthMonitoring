<template>

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
        <el-button type="text" size="small">删除</el-button>
        <el-button type="text" size="small" >编辑</el-button>
        <el-button type="text" size="small" >提醒医生</el-button>
      </template>
    </el-table-column>

  </el-table>







</div>
  <!-- </el-main>
  </el-container> -->
</template>


<script>


export default {

  name: "manager_doctor",
   methods: {
        handleClick(row) {
          console.log(row);
        },
            add:function(){
              this.flag=true;
              }


  },

  data() {
      return {
        flag:false,
      tableData: [{
                id: '01',
                name: '王大头',
                sex:'男',
                age:'54',
                address:'jaisnf',
                phone: '12345678',
                symptom: '肚子痛',


              }, {
               id: '01',
                name: '王大头',
                sex:'男',
                age:'54',
                address:'jaisnf',
                phone: '12345678',
                symptom: '肚子痛',

              }, {
                id: '01',
                name: '王大头',
                sex:'男',
                age:'54',
                address:'jaisnf',
                phone: '12345678',
                symptom: '肚子痛',

              }, {
              id: '01',
                name: '王大头',
                sex:'男',
                age:'54',
                address:'jaisnf',
                phone: '12345678',
                symptom: '肚子痛',

              }]
      }
    }
}
</script>

<style scoped>

</style>