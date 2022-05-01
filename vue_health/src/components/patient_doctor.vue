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
        {{ name }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-male"></i>/<i class="el-icon-female"></i>
          性别
        </template>
        {{ sex }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-thumb"></i>
          年龄
        </template>
        {{ age }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          手机号
        </template>
        {{ phoneNumber }}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-office-building"></i>
          联系地址
        </template>
        {{ detailedAddress }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-tickets"></i>
          科室
        </template>
        {{ office }}
      </el-descriptions-item>
    </el-descriptions>

    <el-drawer
        title="我是标题"
        :visible.sync="drawer"
        :with-header="false" size="60%">
      <div style="display: flex;justify-content: flex-start;flex-wrap: wrap;padding:10px;">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>{{ doctorInfo.name }}</span>
            <el-button style="float: right; padding: 3px 0" type="text" @click="select()">选择</el-button>
            <!--这里button加从数据库调信息的方法-->
          </div>
          <div class="text item" style="text-align:left">

            年龄：{{ doctorInfo.age }}<br>
            性别：{{ doctorInfo.sex }}<br>
            科室：{{ doctorInfo.office }}<br>
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
                  {{ doctorInfo.office }}
                </el-descriptions-item>
              </el-descriptions>
              <el-button style="float: right; padding: 3px 0" slot="reference" type="text">查看详情</el-button>
            </el-popover>
          </div>
        </el-card>

        <!--通过数据库添加v-for循环，以下card全删-->
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>卡片名称</span>
            <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
          </div>
          <div v-for="o in 4" :key="o" class="text item">
            {{ '列表内容 ' + o }}
          </div>
        </el-card>

        <!--够了够了！！！！！!！！！别删超过这条线-->


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
        name: '',
        sex: '',
        age: '',
        phoneNumber: '',
        address: '',
        office: '',
        id: 1,
      },
      doctorList: []
    };
  },
  methods: {
    select: function () {
      let _this = this;
      postRequest("/patient/addDoctor", {
        doctorId: _this.doctorInfo.id,
        patientId: _this.$root.id
      }).then(resp => {
        _this.$alert(resp.data)
      })
    },
    queryAllDoctors() {
      let _this = this;
      getRequest("/patient/allDoctors").then(resp => {
        _this.doctorList = resp.data;
      })
    },
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