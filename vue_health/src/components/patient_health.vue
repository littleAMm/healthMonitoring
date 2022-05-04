<template>
  <div id="table">
    <div>
      <div class="add">
        <!-- 顶部输入框 -->
        <input type="text" placeholder="体温" v-model="healthTable.temp">
        <input type="text" placeholder="脉搏" v-model="healthTable.pulse">
        <input type="date" placeholder="发布时间" v-model="healthTable.date">
        <button @click="addHealth">新增</button>
      </div>
      <!-- 健康信息列表 -->
      <table>
        <thead>
        <tr>
          <th>序号</th>
          <th>体温</th>
          <th>脉搏</th>
          <th>发布时间</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(health,index) in healthList" :key="index">
          <td>{{ health.tableIndex }}</td>
          <td>{{ health.temp }}</td>
          <td>{{ health.pulse }}</td>
          <td>{{ health.date }}</td>
          <td>
            <span class="delete" @click="deleteHealth(health.tableIndex)">删除</span>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import {postRequest, getRequest} from "@/utils/api";

export default {
  name: "patient_health",
  data() {
    return {
      healthTable: {
        temp: '',
        pulse: '',
        date: '',
        tableIndex: ''
      },
      healthList: [],
      id: '',

      flag: false,//弹层的显示隐藏
      editDetail: {},//编辑内容

    }
  },
  methods: {
    addHealth() {
      let _this = this;
      postRequest("/patient/addHealth", {
        id: _this.$root.id,
        temp: _this.healthTable.temp,
        pulse: _this.healthTable.pulse,
        date: _this.healthTable.date.toString(),
      }).then(resp => {
        _this.$alert(resp.data)
      });
      this.queryAllHealth();
    },
    queryAllHealth() {
      let _this = this;
      getRequest("/patient/allHealth/" + _this.$root.id).then(resp => {
        _this.healthList = resp.data
      })
    },
    deleteHealth(tableIndex) {
      let _this = this;
      postRequest("/patient/deleteHealth", {
        id: _this.$root.id * 1,
        index: tableIndex * 1
      }).then(resp => {
        _this.$alert(resp.data)
      });
      this.healthList = this.healthList.filter(item => {
        return item.tableIndex !== tableIndex
      });
    }
  }
}


</script>

<style>
#table table {
  width: 100%;
  font-size: 14px;
  border: 1px solid #eee
}

#table {
  padding: 0 10px;
}

table thead th {
  background: #f5f5f5;
  padding: 10px;
  text-align: left;
}

table tbody td {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid #eee;
  border-right: 1px solid #eee;
}

table tbody td span {
  margin: 0 10px;
  cursor: pointer;
}

.delete {
  color: red;
}

.edit {
  color: #008CD5;
}

.add {
  border: 1px solid #eee;
  margin: 10px 0;
  padding: 15px;
}

input {
  border: 1px solid #ccc;
  padding: 5px;
  border-radius: 3px;
  margin-right: 15px;
}

button {
  background: #008cd5;
  border: 0;
  padding: 4px 15px;
  border-radius: 3px;
  color: #fff;
}

#layer {
  background: rgba(0, 0, 0, .5);
  width: 100%;
  height: 100%;
  position: fixed;
  z-index: 4;
  top: 0;
  left: 0;
  display: none;
}

.mask {
  width: 300px;
  height: 250px;
  background: rgba(255, 255, 255, 1);
  position: absolute;
  left: 0;
  top: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  z-index: 47;
  border-radius: 8px;
}

.title {
  padding: 10px;
  border-bottom: 1px solid #eee;
}
</style>