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
            <i class="el-icon-mobile-phone"></i>
            手机号
          </template>
          {{ id }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-location-outline"></i>
            居住地
          </template>
          {{ username }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            联系地址
          </template>
          {{ sex }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            病症
          </template>
          {{ symptom }}
        </el-descriptions-item>
      </el-descriptions>
    </div>
    <div v-show="amend">
      <el-form :label-position="right" label-width="80px">
        <el-form-item label="姓名">
          <el-input v-model="name"></el-input>
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
        <el-form-item label="病症">
          <el-input v-model="symptom"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">立即修改</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {postRequest} from "@/utils/api";

export default {
  name: "patient_info",
  methods: {
    open() {
      this.watch = false,
          this.amend = true,
          this.$alert('请修改你的信息', {
            confirmButtonText: '确定',
          });
    },
    submitForm(formName) {
      this.watch = true,
          this.amend = false,
          this.$refs[formName].validate((valid) => {
            if (valid) {
              alert('submit!');
            } else {
              console.log('error submit!!');
              return false;
            }
          });
    },
    loadPatient() {
      let _this = this
      let localUsername = _this.$root.username
      postRequest('/patient/info', {username:localUsername} ).then(resp => {
        this.name = resp.data.name;
        this.id = resp.data.id;
        _this.$root.id = this.id;
        this.username = resp.data.username;
        this.sex = resp.data.sex;
      })
    }
  },
  mounted() {
    this.loadPatient()
  },
  data() {
    return {
      count: 0,
      watch: true,
      amend: false,
      name: "",
      id: "",
      username: "",
      sex: "",
      symptom: "吃不下睡不着爱喝奶茶可乐方便面",
      formLabelAlign: {
        name: '',
        region: '',
        type: ''
      }
    }
  }
}
</script>

<style scoped>

</style>