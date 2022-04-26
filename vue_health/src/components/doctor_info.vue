<template>
  <div style="width:600px; margin: 0 auto;">
    <div v-show="watch">
      <el-descriptions class="margin-top" title="个人信息查看" :column="1" border>
        <template slot="extra">
          <el-button type="primary" size="small" @click="open">修改</el-button>
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
            <i class="el-icon-location-outline"></i>
            居住地
          </template>
          {{ localAddress }}
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
    </div>
    <div v-show="amend">
      <el-form :label-position="right" label-width="80px">
        <el-form-item label="姓名">
          <el-input v-model="name"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-input v-model="sex"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="age"></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="phoneNumber"></el-input>
        </el-form-item>
        <el-form-item label="居住地">
          <el-input v-model="localAddress"></el-input>
        </el-form-item>
        <el-form-item label="联系地址">
          <el-input v-model="detailedAddress"></el-input>
        </el-form-item>
        <el-form-item label="科室">
          <el-input v-model="office"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">立即修改</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
//import {getRequest} from "@/utils/api";

export default {
  name: "doctor_info",
  methods: {
    open() {
      this.watch = false,
          this.amend = true,
          this.$alert('请修改你的信息', {
            confirmButtonText: '确定',
          });
    },
  //   submitForm(formName) {
  //     this.watch = true,
  //         this.amend = false,
  //         this.$refs[formName].validate((valid) => {
  //           if (valid) {
  //             alert('submit!');
  //           } else {
  //             console.log('error submit!!');
  //             return false;
  //           }
  //         });
  //   },
  //   loadPatient() {
  //     let _this = this
  //     getRequest('/patient/info', ).then(resp => {
  //       console.log('=======>' + resp.data)
  //       _this.name = resp.data.name;
  //     })
  //   }
  // },
  // mounted() {
  //   this.loadPatient()
  // },
  },
  data() {
    return {
      count: 0,
      watch: true,
      amend: false,
      name: this.$root.username,
      sex:"女",
      age:"uahuyuuywif9",
      phoneNumber: "1234554321",
      localAddress: "珞珈山",
      detailedAddress: "大梧桐树上梧桐絮梧桐树下我喘气",
      office: "脑科",

    }
  }
}
</script>

<style scoped>

</style>