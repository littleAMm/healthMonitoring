<template>
  <el-table
      ref="singleTable"
      :data="tableData"
      highlight-current-row
      @current-change="handleCurrentChange"
      style="width: 100%">
    <el-table-column
        type="index"
        width="50">
    </el-table-column>
    <el-table-column
        property="id"
        label="ID号"
        width="120">
    </el-table-column>
    <el-table-column
        property="name"
        label="Name"
        width="120">
    </el-table-column>
    <el-table-column
        property="specialized"
        label="Specialized-In">
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "patient_doctor",
  data() {
    return {
      tableData: [{
        id: '10001',
        name: 'Tom',
        specialized: 'Heart'
      }, {
        id: '10002',
        name: 'Tom',
        specialized: 'ENT'
      }, {
        id: '10003',
        name: 'Tom',
        specialized: 'Heart'
      }, {
        date: '10006',
        name: 'Tom',
        specialized: 'ENT'
      }],
      currentRow: null
    }
  },
  methods: {
    setCurrent(row) {
      this.$refs.singleTable.setCurrentRow(row);
    },
    handleCurrentChange(val) {
      this.currentRow = val;
    }
  }
}
</script>

<style scoped>

</style>