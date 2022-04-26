<template>
  <div id="table">
    <div>
      <div class="add">
        <!-- 顶部输入框 -->
        <input type="text" placeholder="体温" v-model="temp">
        <input type="text" placeholder="脉搏" v-model="pulse">
        <input type="date" placeholder="发布时间" v-model="dates">
        <button @click="add()">新增</button>
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
        <tr v-for="(list,index) in lists" :key="index">
          <td>{{index+1}}</td>
          <td>{{list.temp}}</td>
          <td>{{list.pulse}}</td>
          <td>{{list.dates}}</td>
          <td>
            <span class="delete" @click="del(index)">删除</span>
            <span class="edit" @click="edit(list)">编辑</span>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
    <!-- 修改弹窗 -->
    <div id="layer" v-show="flag">

      <div class="mask">
        <div class="title">
          编辑
          <span @click="flag=false">x</span>
        </div>
        <div class="content">
          <input type="text" placeholder="体温" v-model="editDetail.temp">
          <input type="text" placeholder="脉搏" v-model="editDetail.pulse">
          <input type="date" placeholder="日期" v-model="editDetail.dates">
          <button @click="update()">确认</button>
          <button @click="flag=false">取消</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "patient_health",
  data () {
    return {
      temp:'',
      pulse:'',
      dates:'',
      id:'',

      flag:false,//弹层的显示隐藏
      editDetail:{},//编辑内容
      lists:[{temp:'37',pulse:'100',dates:'2022-4-11'}]
    }
  },
  methods:{
    add:function(){
      //必须填写才能新增
      if(!this.temp||!this.pulse||!this.dates)return;
      //   id=Math.max(...this.lists.map(function(item){return item.id}))+1;//扩展运算符
      this.lists.push({//新增
        temp:this.temp,
        pulse:this.pulse,
        dates:this.dates,
        id:this.id
      });
      //新增后清空
      this.temp="";
      this.pulse="";
      this.dates="";
    },
    del:function(index){//删除
      this.lists.splice(index,1);//index位置 1个数

    },
    edit:function(list){//编辑
    this.editDetail={
      title:list.temp,
      user:list.pulse,
      dates:list.dates,
      id:list.id
    }
      this.flag=true;
    },
    update:function(){//更新
      this.flag=false;

    }
  }
}


</script>

<style>
#table table {
		width:100%;
		font-size:14px;
		border:1px solid #eee
	}
	
	#table{
		padding:0 10px;
	}
	table thead th{
		background:#f5f5f5;
		padding:10px;
		text-align:left;
	}
	table tbody td{
		padding:10px;
		text-align:left;
		border-bottom:1px solid #eee;
		border-right:1px solid #eee;
	}
	table tbody td span{
		margin:0 10px;
		cursor:pointer;
	}
	
	.delete{
		color:red;
	}
	
	.edit{
		color:#008CD5;
	}
	
	.add{
		border:1px solid #eee;
		margin:10px 0;
		padding:15px;
	}
	
	input{
		border:1px solid #ccc;
		padding:5px;
		border-radius:3px;
		margin-right:15px;
	}
	
	button{
		background:#008cd5;
		border:0;
		padding:4px 15px;
		border-radius:3px;
		color:#fff;
	}
	
	#layer{
		background:rgba(0,0,0, .5);
		width:100%;
		height:100%;
		position:fixed;
		z-index:4;
		top:0;
		left:0;
		display:none;
	}
	.mask{
		width:300px;
		height:250px;
		background:rgba(255,255,255,1);
		position:absolute;
		left:0;
		top:0;
		right:0;
		bottom:0;
		margin:auto;
		z-index:47;
		border-radius:Spx;
	}
	.title{
		padding:10px;
		border-bottom:1px solid #eee;
	}
</style>