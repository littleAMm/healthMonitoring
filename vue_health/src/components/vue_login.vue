<template>
<div>
<router-link :to="{ path: '/patient' }">进入病人页</router-link>
<router-link :to="{ path: '/doctor' }">进入医生页</router-link>
<router-link :to="{ path: '/manager' }">进入管理员页</router-link>

  <el-form
      :rules="rules"
      class="login-container"
      label-position="left"
      label-width="0px"
  >

    <h3 class="login_title">系统登录</h3>

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
  <el-form-item>
    <el-checkbox class="login_remember" v-model="checked" label-position="left" style="float: left"
    >记住密码
    </el-checkbox
    >
    <el-button type="text" style="float: right" @click="resetClick()">修改密码</el-button>
  </el-form-item>
    <el-form-item style="width: 100%">
      <el-button
          type="primary"
          @click.native.prevent="regClick"
          style="width: 40%"
      >注册
      </el-button>
      <el-button
          type="primary"
          @click.native.prevent="loginClick"
          style="width: 40%"
      >登录
      </el-button>

    </el-form-item>
  </el-form>
</div>
</template>
<script>
import {getRequest} from "../utils/api";

export default {
  data() {
    return {
      rules: {
        account: [{required: true, message: "请输入用户名", trigger: "blur"}],
        checkPass: [{required: true, message: "请输入密码", trigger: "blur"}],
      },
      checked: true,
      loginForm: {
        username: "admin",
        password: "123",
      }
    };
  },
  methods: {
    loginClick: function () {
      let _this = this;
      getRequest("/login/" + this.loginForm.username + "/" + this.loginForm.password
      ).then(resp => {
        if (resp.data === '管理员') {
          _this.$router.replace({path: '/manager'});
          _this.$root.username = this.loginForm.username;
          sessionStorage.setItem("username",this.loginForm.username)
        } else if (resp.data === '患者') {
          _this.$router.replace({path: '/patient'});
          _this.$root.username = this.loginForm.username;
          sessionStorage.setItem("username",this.loginForm.username)
        } else if (resp.data === '医生') {
          _this.$router.replace({path:'/doctor'});
          _this.$root.username=this.loginForm.username;
          sessionStorage.setItem("username",this.loginForm.username)
        } else {
          _this.$alert(resp.data)
        }
      })
    },
    resetClick:function(){
      this.$router.replace({path:'/reset'})
    },
    regClick: function () {
      this.$router.replace({path: '/reg'})
    }
  },
}
</script>
<style>
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

