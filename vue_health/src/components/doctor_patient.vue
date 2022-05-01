<template>
<div style="display: flex;justify-content: flex-start;flex-wrap: wrap;padding:10px;">


<!--以上全删，然后给下面配置v-for循坏-->

<el-card class="box-card" shadow="hover" v-for="(patient,index) in patients" :key="index">
  <div slot="header" class="clearfix">
    <span>{{patient.name}}</span>
    <!--开处方弹窗-->
    <el-popover
  placement="right"
  width="500"
  trigger="click">
  <h2 style="margin: 0 auto; text-align: center">处方笺</h2><br>
  <div>
    <div v-show="bianjichufang">
  <el-form :label-position="right" label-width="80px">

        <el-form-item label="诊断">
          <el-input v-model="doctorWords.diagnose"></el-input>
        </el-form-item>
        <el-form-item label="处方">
           <el-input type="textarea" v-model="doctorWords.prescription"></el-input>
        </el-form-item>
        <el-button type="primary" plain style="float: right" @click="chakanchufang=true,bianjichufang=false,makeSureRx(patient.id,doctorWords.diagnose,doctorWords.prescription)" >确认</el-button>

      </el-form>
    </div>

    <div v-show="chakanchufang">
<el-descriptions :column="1" border>
  <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            姓名
          </template>
          {{ patient.name }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-male"></i>/<i class="el-icon-female"></i>
            性别
          </template>
          {{ patient.sex }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-thumb"></i>
            年龄
          </template>
          {{ patient.age }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-edit"></i>
            诊断
          </template>
          {{ doctorWords.diagnose }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-document-copy"></i>
            处方
          </template>
          {{ doctorWords.prescription }}
        </el-descriptions-item>

      </el-descriptions>
      <el-button type="primary" plain style="float: right" @click="chakanchufang=false,bianjichufang=true">编辑</el-button>
  </div>

  </div>
  <el-button style="float: right; padding: 3px 0" type="text" slot="reference">ta的处方</el-button>
</el-popover>


  </div>
  <div  class="text item" style="text-align:left">
    <!--{{'列表内容 ' + o }}-->
    年龄：{{patient.age}}<br>
    性别：{{patient.sex}}<br>
    症状：{{patient.symptom}}<br>
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
          {{ patient.name }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-male"></i>/<i class="el-icon-female"></i>
            性别
          </template>
          {{ patient.sex }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-thumb"></i>
            年龄
          </template>
          {{ patient.age }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机号
          </template>
          {{ patient.phone_number }}
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            联系地址
          </template>
          {{ patient.address }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            病症
          </template>
          {{ patient.symptom }}
        </el-descriptions-item>
      </el-descriptions>
  <el-button style="float: right; padding: 3px 0" slot="reference" type="text">查看详情</el-button>
</el-popover>
  </div>

</el-card>

</div>
</template>

<script>
import {getRequest, postRequest} from "@/utils/api";

export default {
  name: "doctor_patient",
  watch:{
    id(){

    },
  },
  data() {
    return {
      // patientBasic: {
      //   name: '',
      //   age: '',
      //   sex: '',
      //   phoneNumber: '',
      //   localAddress: '',
      //   detailedAddress: '',
      //   symptom: '',
      // },
      doctorWords: {
        diagnose: '',
        prescription: ''
      },
      patients: [],
      chakanchufang: true,
      bianjichufang: false,
    }
  },
  // watch: {
  //   id(val, oldVal) {
  //     console.log("inputVal = " + val + " , oldValue = " + oldVal)
  //   }
  // },
  //     {
  //   username:'',
  //   id:'',
  //   name:'',
  //   sex:'',
  //   symptom:'',
  //   age:'',
  //   phone_number:'',
  //   address:''
  // }
  methods:{
    makeSureRx(id,diagnose,prescription){
      let _this = this
      postRequest('/doctor/creatRx',{patient_id:id,diagnose:diagnose,content:prescription}).then(resp=>{
        if (resp.data=="ID错误，请检查"){_this.$alert(resp.data)}
        else{_this.$alert(resp.data)}

      })
    },
    loadPatient() {
      let _this = this
      getRequest('/doctor/allPatient?doctorId='+this.$root.id ).then(resp => {
        _this.patients = resp.data;
      })
    }
  },
}
</script>

<style>
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
    line-height:200%;
    background-color:rgb(183, 212, 233);
    /* opacity: 0.5 */
  }
</style>