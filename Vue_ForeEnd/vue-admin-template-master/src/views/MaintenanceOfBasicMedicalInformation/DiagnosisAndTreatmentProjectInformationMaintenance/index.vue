<template>
    <div class="app-container">
  
      <!--搜索表单-->
       <el-form :inline="true" :model="searchDT" class="demo-form-inline">
         <el-form-item label="项目编码">
          <el-input
            v-model="searchDT.diaId"
            placeholder="项目编码"
          ></el-input>
        </el-form-item>
            
  
        <el-form-item label="项目名称">
          <el-input
            v-model="searchDT.diaName"    
            placeholder="项目名称"
          ></el-input>
        </el-form-item> 
  
  
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
           <el-button type="info" @click="clear">清空</el-button>
        </el-form-item>
      </el-form> 
  
     
  
      <!--按钮-->
      <el-row>
        <el-button type="danger" size="medium" @click="deleteByIds">- 批量删除</el-button>
        <el-button type="primary" size="medium" @click="dialogVisible = true;" >添加诊疗项目</el-button>
      </el-row>
  

  
  
  
      <!--添加数据对话框表单-->
       <el-dialog ref="form" title="添加诊疗项目" :visible.sync="dialogVisible" width="30%">
        <el-form ref="form" :model="t_diagnosis_project" label-width="80px" size="mini">
        
          <el-form-item label="项目编码">
            <el-input v-model="t_diagnosis_project.diaId"></el-input>
          </el-form-item>
  
          <el-form-item label="项目名称">
            <el-input v-model="t_diagnosis_project.diaName"></el-input>
          </el-form-item> 
          
          <el-form-item label="收费类别" >
            <el-select v-model="t_diagnosis_project.diaExpType" placeholder="请选择" style="width:100%" >
               <el-option
                v-for="item in diaExpTypeList"
                :key="item.value"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
          

          <el-form-item label="收费项目等级" >
            <el-select v-model="t_diagnosis_project.diaExpLevel" placeholder="请选择" style="width:100%" >
               <el-option
                v-for="item in diaExpLevelList"
                :key="item.value"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>

        
          <el-form-item label="最高限价">
            <el-input v-model="t_diagnosis_project.medMaxPrize"></el-input>
          </el-form-item> 

             <el-form-item label="审批标志" >
            <el-select v-model="t_diagnosis_project.diaApprovalmark" placeholder="请选择" style="width:100%" >
               <el-option
                v-for="item in diaApprovalmarkList"
                :key="item.value"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>


          <el-form-item label="医院等级">
            <el-select v-model="t_diagnosis_project.diaHosLevel" placeholder="请选择" value-key="student.education" style="width:100%">
              <el-option
                v-for="item in diaHosLevelList"
                :key="item.value"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>   
       
          <el-form-item label="开始日期">
          <el-date-picker
            v-model="t_diagnosis_project.diaStarttime"
            clearable
            type="date"
            placeholder="选择日期"
            size="small"
            style="width:100%"
          ></el-date-picker>
        </el-form-item>

        <el-form-item label="终止日期">
          <el-date-picker
            v-model="t_diagnosis_project.diaEndtime"
            clearable
            type="date"
            placeholder="选择日期"
            size="small"
            style="width:100%"
          ></el-date-picker>
        </el-form-item>

        <el-form-item label="有效标识">
            <el-select v-model="t_diagnosis_project.diaValid" placeholder="请选择" value-key="student.education" style="width:100%">
              <el-option
                v-for="item in diaValidList"
                :key="item.value"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item> 
 

           <el-form-item>
            <el-button type="primary" @click="add">提交</el-button>
            <el-button @click="fun">取消</el-button>
          </el-form-item>
        </el-form> 
      </el-dialog> 
  
      <br>
      <!--表格-->
      <template>
        <el-table :data="tableData" style="width: 100%" border @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="55"  align="center"></el-table-column>
          <el-table-column width="80" prop="diaId"  label="项目编码"  align="center"></el-table-column>
          <el-table-column  prop="diaName" width="120"  label="项目名称"  align="center"></el-table-column>
          <el-table-column   prop="diaExpType" width="80"  label="收费类别"  align="center" :formatter="format">
          </el-table-column>
          
          <el-table-column   prop="diaExpLevel" width="110"  label="收费项目等级"  align="center" :formatter="format">
        </el-table-column>

        <el-table-column width="80" prop="diaMaxPrize"  label="最高限价"  align="center"></el-table-column>
         
          <el-table-column align="center" label="审批标志" width="80" >
            <template slot-scope="scope">
              <span style="margin-right: 10px">
              {{scope.row.diaApprovalmark == "1" ? "是" : "否"}}</span>
            </template>
          </el-table-column>
          
         

          
          <el-table-column  width="77" align="center" label="医院等级">
            <template slot-scope="scope">
              <span style="margin-right: 10px" v-if="scope.row.diaHosLevel == 1">一级</span>
              <span style="margin-right: 10px" v-if="scope.row.diaHosLevel == 2">二级</span>
              <span style="margin-right: 10px" v-if="scope.row.diaHosLevel == 3">三级</span>
            </template>
          </el-table-column>
  
         
          
        <el-table-column align="center" label="开始日期" width="180">
          <template slot-scope="scope">
            {{ scope.row.diaStarttime }}
          </template>
        </el-table-column>

        <el-table-column align="center" label="终止日期">
          <template slot-scope="scope">
            {{ scope.row.diaEndtime }}
          </template>
        </el-table-column>


        <el-table-column  prop="diaValid"  label="有效标志"  align="center"  width="100" ></el-table-column>
       

          <el-table-column  align="center" label="操作">
            <template  slot-scope="scope">
              <el-button  type="primary" size="small" @click="update(scope.row.id)">编辑</el-button>
              <el-button  type="danger" size="small" @click="deleteById(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
  
      <!--分页工具条-->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :background="background"
        :current-page="currentPage"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="5"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalCount">
      </el-pagination>
    </div>
  </template>
  
  <script>
  import { page, add, update, deleteById, selectById, } from "@/api/DiagnosisAndTreatmentProjectInformation.js";
  import { getToken } from '@/utils/auth';
  
  
  export default {
    data() {
      return {
        background: true,
        // 每页显示的条数
        pageSize: 5,
        // 总记录数
        totalCount: 100,
        // 当前页码
        currentPage: 1,
        // 添加数据对话框是否展示的标记
        dialogVisible: false,
        dialogVisible1: false,
        // 品牌模型数据
        searchDT: {
            diaId:"",
            diaName:""
        },
        t_diagnosis_project: {
            diaExpType:"",
            diaExpLevel:"",
            diaStarttime:"",
            diaEndtime:"",
            diaValid:"",
            diaMaxPrize:"",
            diaHosLevel:"",
            diaApprovalmark:"",

        },
        diaApprovalmarkList: [{id: 1,name: "是"},{id: 2,name: "否"}],
        diaValidList: [{id: 1,name: "有效"},{id: 2,name: "无效"}],
        diaHosLevelList: [
          {
            id: 1,
            name: "一级",
          },
          {
            id: 2,
            name: "二级",
          },
          {
            id: 3,
            name: "三级",
          },  
        ],
        diaExpTypeList: [
          {id: 1, name: "床位费",},{id: 2, name: "化验费",},{id: 3, name: "诊查费",},
          {id: 4, name: "护理费",},{id: 5, name: "特殊检查费",},{id: 6, name: "输氧费",},
          {id: 7, name: "治疗费",},{id: 8, name: "输血费",},{id: 9, name: "特殊治疗费",},
          {id: 10, name: "医疗服务费",},{id: 11, name: "手术费",},{id: 12, name: "麻药费",},
          {id: 13, name: "产前检查费",},{id: 14, name: "材料费",},{id: 15, name: "新生儿费",},
          {id: 16, name: "内置材料费",},{id: 17, name: "其他费用",},{id: 18, name: "监护床位费",},
          {id: 19, name: "产前检查费",},{id: 20, name: "材料费",},{id: 21, name: "新生儿费",},
        ],  
        diaExpLevelList: [
          {
            id: 1,
            name: "甲类",
          },
          {
            id: 2,
            name: "乙类",
          },
          {
            id: 3,
            name: "丙类",
          },  
        ],  

        // 被选中的id数组
        selectedIds: [],
        // 复选框选中数据集合
        multipleSelection: [],
        // 表格数据
        tableData: [],
        token: {token: getToken()},
        temp: ""
      };
    },
  
    mounted() {
      this.page(); //当页面加载完成后，发送异步请求，获取数据
        
    },
    
    methods: {
      
  
  
      //对话框取消
      fun(){
        this.dialogVisible = false;
        this.t_diagnosis_project = {};
      },

  
      
      // 查询分页数据
      page() {
        page(
           this.searchDT.diaId,
           this.searchDT.diaName,
           this.currentPage,
           this.pageSize
        ).then((res) => {
          this.totalCount = res.data.data.total;
          this.tableData = res.data.data.rows;
        });
  
      },
  
      // 复选框选中后执行的方法
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
  
      // 查询方法
      onSubmit() {
        this.currentPage = 1;
        this.page();
      },
  
      clear(){
        this.searchDT = {diaId:"",diaName:"",};
        
        this.page();
        
        
      },
      // 添加数据
      add() {
        let operator;
  
        if (this.t_diagnosis_project.id) {
          //修改
          operator = update(this.t_diagnosis_project);
        } else {
          operator = add(this.t_diagnosis_project);
        }
  
        operator.then((resp) => {
          if (resp.data.code == "1") {
            this.dialogVisible = false;
            this.page();
            this.$message({ message: "恭喜你，保存成功", type: "success" });
            this.t_diagnosis_project = { };
            this.page();
          } else {
            this.$message.error(resp.data.msg);
          }
        });
      },
      update(id) {
        //1. 打开窗口
        this.dialogVisible = true;
        //2. 发送请求
  
        selectById(id).then((result) => {
          if (result.data.code == 1) {
            this.t_diagnosis_project = result.data.data;
            this.t_diagnosis_project;
          }
        });
      },
  
      
      //分页
      handleSizeChange(val) {
        // 重新设置每页显示的条数
        this.pageSize = val;
        this.page();
      },
  
      handleCurrentChange(val) {
        // 重新设置当前页码
        this.currentPage = val;
        this.page();
      },
  
   

      
    
  
  
      //删除员工信息
      deleteById(id){
        this.$confirm("此操作将删除该数据, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }).then(() => {
            //2. 发送AJAX请求
            deleteById(id).then((resp) => {
              if (resp.data.code == 1) {
                //删除成功
                this.$message.success("恭喜你，删除成功");
                this.page();
              } else {
                this.$message.error(resp.data.msg);
              }
            });
        }).catch(() => {
            //用户点击取消按钮
            this.$message.info("已取消删除");
          });
      },
  
  
      // 批量删除员工信息
      deleteByIds() {
        // 弹出确认提示框
        this.$confirm("此操作将删除该数据, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        }).then(() => {
            //用户点击确认按钮
            //1. 创建id数组, 从 this.multipleSelection 获取即可
            for (let i = 0; i < this.multipleSelection.length; i++) {
              this.selectedIds[i] = this.multipleSelection[i].id;
            }
  
            //2. 发送AJAX请求
            deleteById(this.selectedIds).then((resp) => {
              if (resp.data.code == "1") {
                //删除成功
                this.$message.success("恭喜你，删除成功");
                this.page();
              } else {
                this.$message.error(resp.data.msg);
              }
            });
        }).catch(() => {
            //用户点击取消按钮
            this.$message.info("已取消删除");
          });
      },
  
  
  
     
    },
  
  
    // watch: {
    //   entrydate(val) {
    //     if (val && val.length >= 2) {
    //       this.beginTime = val[0];
    //       this.endTime = val[1];
    //     } else {
    //       this.beginTime = "";
    //       this.endTime = "";
    //     }
    //   },
    // },
  };
  </script>
  <style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409eff;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 100px;
    height: 100px;
    line-height: 100px;
    text-align: center;
  }
  .avatar {
    width: 100px;
    height: 100px;
    display: block;
  }
  </style>
  