<template>
  <div style="width:600px; margin: 0 auto;">
    <el-descriptions class="margin-top" title="医生信息查看" :column="1" border style="width:600px;float:left">
      <template slot="extra">
        <el-button type="primary" size="small" @click="drawer = true,queryAllDoctors()">选择医生</el-button>
      </template>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-user"></i>
          姓名
        </template>
        {{ doctorInfo.name }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-male"></i>/<i class="el-icon-female"></i>
          性别
        </template>
        {{ doctorInfo.sex }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-thumb"></i>
          年龄
        </template>
        {{ doctorInfo.age }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          手机号
        </template>
        {{ doctorInfo.phoneNumber }}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-office-building"></i>
          联系地址
        </template>
        {{ doctorInfo.address }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-tickets"></i>
          科室
        </template>
        {{ doctorInfo.work }}
      </el-descriptions-item>
    </el-descriptions>

    <el-drawer
        title="我是标题"
        :visible.sync="drawer"
        :with-header="false" size="60%">
      <div style="display: flex;justify-content: flex-start;flex-wrap: wrap;padding:10px;">

        <el-card class="box-card" v-for="(doctor,index) in doctorList" :key="index">
          <div slot="header" class="clearfix">
            <span>{{ doctor.name }}</span>
            <el-button style="float: right; padding: 3px 0" type="text" @click="select(doctor.id)">选择</el-button>
            <!--这里button加从数据库调信息的方法-->
          </div>
          <div class="text item" style="text-align:left">
            ID：{{ doctor.id }}<br>
            性别：{{ doctor.sex }}<br>
            科室：{{ doctor.work }}<br>
            <!--查看详情弹窗-->
            <el-popover
                placement="right"
                width="500"
                trigger="click">
              <el-descriptions class="margin-top" title="个人信息查看" :column="1" border>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-user"></i>
                    姓名
                  </template>
                  {{ doctor.name }}
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-male"></i>/<i class="el-icon-female"></i>
                    性别
                  </template>
                  {{ doctor.sex }}
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-thumb"></i>
                    年龄
                  </template>
                  {{ doctor.age }}
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-mobile-phone"></i>
                    手机号
                  </template>
                  {{ doctor.phoneNumber }}
                </el-descriptions-item>

                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    联系地址
                  </template>
                  {{ doctor.address }}
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-tickets"></i>
                    科室
                  </template>
                  {{ doctor.work }}
                </el-descriptions-item>
              </el-descriptions>
              <el-button style="float: right; padding: 3px 0" slot="reference" type="text">查看详情</el-button>
            </el-popover>
          </div>
        </el-card>
      </div>
    </el-drawer>
  </div>
</template>

<script>
import {getRequest, postRequest} from "@/utils/api";

export default {
  name: "patient_doctor",
  data() {
    return {
      drawer: false,
      doctorInfo: {
      },
      doctorList: []
    };
  },
  methods: {
    //选择医生
    select(doctorId) {
      let _this = this;
      postRequest("/patient/addDoctor", {
        doctorId: doctorId,
        patientId: _this.$root.id
      }).then(resp => {
        _this.$alert(resp.data)
      });
    },
    //查询所有医生
    queryAllDoctors() {
      let _this = this;
      getRequest("/patient/allDoctors").then(resp => {
        _this.doctorList = resp.data;
      })
    },
    //查询已经选择的医生
    querySelectedDoctor() {
      let _this = this;
      getRequest("/patient/selectedDoctor/" + _this.$root.id).then(resp => {
        _this.doctorInfo = resp.data;
      })
    }
  }
}
</script>

<style scope>
.text {
  font-size: 16px;
}

.item {
  margin-bottom: 0px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.box-card {
  width: 240px;
  margin: 20px;
  line-height: 200%;
  background-color: rgb(183, 212, 233);
  /* opacity: 0.5 */
}
</style>