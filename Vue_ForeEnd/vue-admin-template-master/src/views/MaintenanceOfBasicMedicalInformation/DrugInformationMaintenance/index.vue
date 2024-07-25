<template>
    <div class="app-container">
  
      <!--搜索表单-->
       <el-form :inline="true" :model="searchDrug" class="demo-form-inline">
         <el-form-item label="药品编码">
          <el-input
            v-model="searchDrug.medId"
            placeholder="请输入药品编码"
          ></el-input>
        </el-form-item>
            
  
        <el-form-item label="药品名称">
          <el-input
            v-model="searchDrug.medName"    
            placeholder="请输入药品名称"
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
        <el-button type="primary" size="medium" @click="dialogVisible = true;" >添加药品</el-button>
      </el-row>
  

  
  
  
      <!--添加数据对话框表单-->
       <el-dialog ref="form" title="添加药品" :visible.sync="dialogVisible" width="30%">
        <el-form ref="form" :model="t_medicine" label-width="80px" size="mini">
        
          <el-form-item label="药品编码">
            <el-input v-model="t_medicine.medId"></el-input>
          </el-form-item>
  
          <el-form-item label="药品名称">
            <el-input v-model="t_medicine.medName"></el-input>
          </el-form-item> 
          
          <el-form-item label="收费类别" >
            <el-select v-model="t_medicine.medExpType" placeholder="请选择" style="width:100%" >
               <el-option
                v-for="item in medExpTypeList"
                :key="item.value"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
          

          <el-form-item label="收费项目等级" >
            <el-select v-model="t_medicine.medExpLevel" placeholder="请选择" style="width:100%" >
               <el-option
                v-for="item in medExpLevelList"
                :key="item.value"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>



          <el-form-item label="药品剂量单位">
            <el-input v-model="t_medicine.medMeasurement"></el-input>
          </el-form-item> 
        
          <el-form-item label="最高限价">
            <el-input v-model="t_medicine.medMaxPrize"></el-input>
          </el-form-item> 

             <el-form-item label="审批标志" >
            <el-select v-model="t_medicine.medApprovalmark" placeholder="请选择" style="width:100%" >
               <el-option
                v-for="item in medApprovalmarkList"
                :key="item.value"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>


          <el-form-item label="医院等级">
            <el-select v-model="t_medicine.medHosLevel" placeholder="请选择" value-key="student.education" style="width:100%">
              <el-option
                v-for="item in medHosLevelList"
                :key="item.value"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>   
       
          <el-form-item label="规格">
            <el-input v-model="t_medicine.medSize"></el-input>
          </el-form-item> 
     
          <el-form-item label="药品商品名">
            <el-input v-model="t_medicine.medTradename"></el-input>
          </el-form-item> 

          <el-form-item label="开始日期">
          <el-date-picker
            v-model="t_medicine.medStarttime"
            clearable
            type="date"
            placeholder="选择日期"
            size="small"
            style="width:100%"
          ></el-date-picker>
        </el-form-item>

        <el-form-item label="终止日期">
          <el-date-picker
            v-model="t_medicine.medEndtime"
            clearable
            type="date"
            placeholder="选择日期"
            size="small"
            style="width:100%"
          ></el-date-picker>
        </el-form-item>

        <el-form-item label="有效标识">
            <el-select v-model="t_medicine.medValid" placeholder="请选择" value-key="student.education" style="width:100%">
              <el-option
                v-for="item in medValidList"
                :key="item.value"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item> 

          <el-form-item label="特检特制标志">
            <el-select v-model="t_medicine.medValid" placeholder="请选择" value-key="student.education" style="width:100%">
              <el-option
                v-for="item in medSpecialmarkList"
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
          <el-table-column width="80" prop="medId"  label="药品编码"  align="center"></el-table-column>
          <el-table-column  prop="medName" width="120"  label="药品名称"  align="center"></el-table-column>
          <el-table-column   prop="medExpType" width="80"  label="收费类别"  align="center" :formatter="format">
          </el-table-column>
          
          <el-table-column   prop="medExpLevel" width="110"  label="收费项目等级"  align="center" :formatter="format">
        </el-table-column>
        <el-table-column   prop="medMeasurement" width="110"  label="药品剂量单位"  align="center" :formatter="format">
        </el-table-column>
        <el-table-column width="120" prop="medMaxPrize"  label="最高限价"  align="center"></el-table-column>
         
          <el-table-column align="center" label="审批标志" width="80" >
            <template slot-scope="scope">
              <span style="margin-right: 10px">
              {{scope.row.medApprovalmark == "1" ? "是" : "否"}}</span>
            </template>
          </el-table-column>
          
         

          
          <el-table-column  width="77" align="center" label="医院等级">
            <template slot-scope="scope">
              <span style="margin-right: 10px" v-if="scope.row.medHosLevel == 1">一级</span>
              <span style="margin-right: 10px" v-if="scope.row.medHosLevel== 2">二级</span>
              <span style="margin-right: 10px" v-if="scope.row.medHosLevel == 3">三级</span>
            </template>
          </el-table-column>
  
          <el-table-column  prop="medSize"  label="规格"  align="center" width="100" ></el-table-column>
          <el-table-column  prop="medTradename"  label="药品商品名"  align="center"  width="100" ></el-table-column>
          
        <el-table-column align="center" label="开始日期" width="180">
          <template slot-scope="scope">
            {{ scope.row.medStarttime }}
          </template>
        </el-table-column>

        <el-table-column align="center" label="终止日期" width="180">
          <template slot-scope="scope">
            {{ scope.row.medEndtime }}
          </template>
        </el-table-column>


        <el-table-column  prop="medValid"  label="有效标识"  align="center"  width="100" ></el-table-column>
        <el-table-column  prop="medSpecialmark"  label="特检特制标志"  align="center"  width="110" ></el-table-column>

          <el-table-column  align="center" label="操作" width="160">
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
  import { page, add, update, deleteById, selectById, update1 } from "@/api/DrugInformationMaintenance.js";
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
        searchDrug: {
            medId:"",
            medName:""
        },
        t_medicine: {
          medMeasurement:"",
          medSize:"",
          medStarttime:"",
          medEndtime:"",
          medValid:"",
          medExpType:"",
          medExpLevel:"",
          medMaxPrize:"",
          medSpecialmark:"",
          medTradename:"",
          medHosLevel:"",
          medApprovalmark:""

        },
        medApprovalmarkList: [{id: 1,name: "是"},{id: 2,name: "否"}],
        medValidList: [{id: 1,name: "有效"},{id: 2,name: "无效"}],
        medSpecialmarkList: [{id: 1,name: "是"},{id: 2,name: "否"}],
        medHosLevelList: [
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
        medExpTypeList: [
          {
            id: 1,
            name: "西药",
          },
          {
            id: 2,
            name: "中成药",
          },
          {
            id: 3,
            name: "中草药",
          },  
          {
            id: 4,
            name: "处方药",
          }, 
          {
            id: 5,
            name: "非处方药",
          }, 
        ],  
        medExpLevelList: [
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
        this.t_medicine = {};
      },
      
      // 查询分页数据
      page() {
        page(
           this.searchDrug.medId,
           this.searchDrug.medName,
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
        this.searchDrug = {medId:"",medName:"",};
        
        this.page();
        
        
      },
      // 添加数据
      add() {
        let operator;
  
        if (this.t_medicine.id) {
          //修改
          operator = update(this.t_medicine);
        } else {
          operator = add(this.t_medicine);
        }
  
        operator.then((resp) => {
          if (resp.data.code == "1") {
            this.dialogVisible = false;
            this.page();
            this.$message({ message: "恭喜你，保存成功", type: "success" });
            this.t_medicine = { };
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
            this.t_medicine = result.data.data;
            this.t_medicine;
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
  