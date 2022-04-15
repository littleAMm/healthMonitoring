<template>
  <el-form
      :rules="rules"
      class="login-container"
      label-position="left"
      label-width="0px"
      v-loading="loading"
  >
    <h3 class="login_title">患者注册</h3>
    <el-form-item prop="account">
      <el-input
          type="text"
          v-model="loginForm.username"
          auto-complete="off"
          placeholder="账号"
      ></el-input>
    </el-form-item>
    <el-form-item prop="checkPass">
      <el-input
          type="password"
          v-model="loginForm.password"
          auto-complete="off"
          placeholder="密码"
      ></el-input>
    </el-form-item>
    <el-form-item prop="checkName">
      <el-input
          type="text"
          v-model="loginForm.name"
          auto-complete="off"
          placeholder="姓名"
      ></el-input>
    </el-form-item>
    <el-form-item>
      <el-radio-group v-model="loginForm.sex">
        <el-radio
            label="男"
        ></el-radio>
        <el-radio
            label="女"
        ></el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button
          type="primary"
          @click.native.prevent="submitClick"
          style="width: 40%"
      >注册
      </el-button>
      <el-button
          type="primary"
          @click.native.prevent="backClick"
          style="width: 40%"
      >登录
      </el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import {postRequest} from "../utils/api";

export default {
  data() {
    return {
      rules: {
        account: [{required: true, message: "请输入用户名", trigger: "blur"}],
        checkPass: [{required: true, message: "请输入密码", trigger: "blur"}],
        checkName: [{required: true, message: "请输入你的名字", trigger: "blur"}],
      },
      checked: true,
      loginForm: {
        username: "",
        password: "",
        name: "",
        sex: '男'
      }
    };
  },
  methods: {
    submitClick: function () {
      let _this = this
      postRequest("/reg", {
        username: this.loginForm.username,
        password: this.loginForm.password,
        name: this.loginForm.name,
        sex: this.loginForm.sex
      }).then(resp => {
        if (resp.data === "注册成功") {
          _this.$router.replace({path: '/'})
        } else {
          _this.$alert(resp.data)
        }
      })
    },
    backClick() {
      this.$router.replace({path:'/'})
    }
  },
}
</script>

<style scoped>
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}

.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>