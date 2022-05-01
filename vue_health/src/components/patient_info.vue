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
          {{ patientInfo.name }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-male"></i>/<i class="el-icon-female"></i>
            性别
          </template>
          {{ patientInfo.sex }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-thumb"></i>
            年龄
          </template>
          {{ patientInfo.age }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机号
          </template>
          {{ patientInfo.phoneNumber }}
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            联系地址
          </template>
          {{ patientInfo.detailedAddress }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            病症
          </template>
          {{ patientInfo.symptom }}
        </el-descriptions-item>
      </el-descriptions>
    </div>
    <div v-show="amend">
      <el-form :label-position="right" label-width="80px">

        <el-form-item label="年龄">
          <el-input v-model="patientInfo.age"></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="patientInfo.phoneNumber"></el-input>
        </el-form-item>

        <el-form-item label="联系地址">
          <el-input v-model="patientInfo.detailedAddress"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">立即修改</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {getRequest,postRequest} from "@/utils/api";

export default {
  name: "patient_info",
  methods: {
    open() {
      this.watch = false,
          this.amend = true
    },
    submitForm() {
      this.watch = true,
          this.amend = false;
      this.updateInfo();
    },
    loadPatient() {
      let _this = this
      let localUsername = _this.$root.username
      getRequest('/patient/info/' + localUsername).then(resp => {
        this.patientInfo.name = resp.data.name;
        _this.$root.id = resp.data.id;
        this.patientInfo.username = resp.data.username;
        this.patientInfo.sex = resp.data.sex;
        this.patientInfo.phoneNumber = resp.data.phoneNumber;
        this.patientInfo.age = resp.data.age;
        this.patientInfo.detailedAddress = resp.data.address;
        this.patientInfo.symptom = resp.data.symptom;
      })
    },
    updateInfo() {
      let _this = this;
      postRequest("/patient/updateInfo", {
        id: _this.$root.id,
        age: _this.patientInfo.age,
        phoneNumber: _this.patientInfo.phoneNumber,
        address: _this.patientInfo.detailedAddress,
      }).then(resp => {
        if(resp.data=='success'){
          _this.$alert('success')
        }else{
          _this.$alert('error')
        }
      })

    }
  },
  mounted() {
    this.loadPatient()
  },
  data() {
    return {
      watch: true,
      amend: false,
      patientInfo: {
        name: this.$root.username,
        sex: "女",
        age: "",
        phoneNumber: "",
        detailedAddress: "",
        symptom: ""
      }
    }
  }
}
</script>

<style scoped>

</style>