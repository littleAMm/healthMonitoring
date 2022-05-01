<template>
<div style="display: flex;justify-content: flex-start;flex-wrap: wrap;padding:10px;">


<!--以上全删，然后给下面配置v-for循坏-->

<el-card class="box-card" shadow="hover" v-for="(pa,index) in patientList" :key="index">
  <div slot="header" class="clearfix">
    <span>{{pa.name}}</span>
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
        <el-button type="primary" plain style="float: right" @click="chakanchufang=true,bianjichufang=false,querenchufangchuangeihouduan(id)" >确认</el-button>

      </el-form>
    </div>

    <div v-show="chakanchufang">
<el-descriptions :column="1" border>
  <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            姓名
          </template>
          {{ patientBasic.name }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-male"></i>/<i class="el-icon-female"></i>
            性别
          </template>
          {{ patientBasic.sex }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-thumb"></i>
            年龄
          </template>
          {{ patientBasic.age }}
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
    年龄：{{patientBasic.age}}<br>
    性别：{{patientBasic.sex}}<br>
    症状：{{patientBasic.symptom}}<br>
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
          {{ patientBasic.name }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-male"></i>/<i class="el-icon-female"></i>
            性别
          </template>
          {{ patientBasic.sex }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-thumb"></i>
            年龄
          </template>
          {{ patientBasic.age }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机号
          </template>
          {{ patientBasic.phoneNumber }}
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-office-building"></i>
            联系地址
          </template>
          {{ patientBasic.detailedAddress }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            病症
          </template>
          {{ patientBasic.symptom }}
        </el-descriptions-item>
      </el-descriptions>
  <el-button style="float: right; padding: 3px 0" slot="reference" type="text">查看详情</el-button>
</el-popover>
  </div>

</el-card>

</div>
</template>

<script>


export default {
  name: "doctor_patient",

  data() {
    return {
      patientBasic: {
        name:'病人1号',
        age: '25',
        sex: '女',
        symptom: '睡不着觉',
        phoneNumber:'sauihduagfeydn',
        localAddress:'湖北省',
        detailedAddress:'asuuabbanddiancuhn',
        symptom:'喝不下三杯摇摇奶昔'
      },
      doctorWords:{
        diagnose:'',
        prescription:''
      },
      patientList:[
        {name:"病人1",age:25,sex:"gb"},
         {name:"病人2",age:25,sex:"gb"},
          {name:"病人3",age:25,sex:"gb"}
      ],
      chakanchufang:true,
      bianjichufang:false

    }
  },
  methods:{
    querenchufangchuangeihouduan(id){


    }
  }
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