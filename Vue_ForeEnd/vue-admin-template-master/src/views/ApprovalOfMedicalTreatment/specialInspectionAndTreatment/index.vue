<template>
  <div class="app-container">

    <!--搜索表单-->
    <el-form :inline="true" :model="personID" class="demo-form-inline">
      <el-form-item label="个人编号">
        <el-input
          v-model="personID"
          placeholder="请输入个人编号"
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
      <el-button type="primary" size="medium" @click="dialogVisible = true; company = {};">+ 新增审批</el-button>
    </el-row>

    <!--添加数据对话框表单-->
    <el-dialog ref="form" title="编辑单位" :visible.sync="dialogVisible" width="30%">
      <el-form ref="form" :model="company" label-width="80px" size="mini">
        <el-form-item label="单位名称">
          <el-input v-model="company.companyName"></el-input>
        </el-form-item>
        <el-form-item label="单位类型">
          <el-select v-model="company.companyType" placeholder="请选择" style="width:100%">
            <el-option
              v-for="item in companyTypeList"
              :key="item.value"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="company.address"></el-input>
        </el-form-item>
        <el-form-item label="邮编">
          <el-input v-model="company.postcode"></el-input>
        </el-form-item>
        <el-form-item label="联系电话">
          <el-input v-model="company.phoneNumber"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="add">提交</el-button>
          <el-button @click="dialogVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <br>
    <!--表格-->
    <template>
      <el-table :data="tableData" style="width: 100%" border @selection-change="handleSelectionChange">

        <el-table-column type="selection" width="55" align="center"></el-table-column>
        <el-table-column prop="approvalNumber" label="审批编号" align="center"></el-table-column>
        <el-table-column prop="personID" label="人员ID" align="center"></el-table-column>
        <el-table-column prop="approvalCategory" label="审批类别" align="center">
          <template slot-scope="{ row }">
            <span>{{ getTypeLabel(row.approvalCategory) }}</span>
          </template>
        </el-table-column>
        <el-table-column prop="startDate" label="开始日期" align="center"></el-table-column>
        <el-table-column prop="terminationDate" label="结束日期" align="center"></el-table-column>
        <el-table-column prop="drugCode" label="药品编码" align="center"></el-table-column>
        <el-table-column prop="approvalOpinions" label="审批意见" align="center"></el-table-column>
        <el-table-column prop="approver" label="审批人" align="center"></el-table-column>
        <el-table-column prop="approvalDate" label="审批日期" align="center"></el-table-column>
        <el-table-column prop="approvalFlag" label="审批标志" align="center"></el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <el-button type="primary" size="small" @click="update(scope.row.approvalNumber)">编辑</el-button>
            <el-button type="danger" size="small" @click="deleteById(scope.row.approvalNumber)">删除</el-button>
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
import {page, add, update, deleteById, selectById} from "@/api/special.js";

export default {
  data() {
    return {
      background: true,
      pageSize: 5,
      totalCount: 100,
      currentPage: 1,
      dialogVisible: false,
      personID: "",
      company: {},
      companyTypeList: [
        {id: 0, name: "类型1"},
        {id: 1, name: "类型2"},
        {id: 2, name: "类型3"},
        {id: 3, name: "类型4"}
      ],
      selectedIds: [],
      multipleSelection: [],
      tableData: [],
    };
  },

  mounted() {

    this.page();
  },

  methods: {

// 查询分页数据
    page() {
      page(
        this.currentPage,
        this.pageSize,
        this.personID
      ).then((res) => {
        this.totalCount = res.data.data.total;
        this.tableData = res.data.data.rows;
        console.log(this.tableData)
      });
    },


    handleSelectionChange(val) {
      this.multipleSelection = val;
    },

    onSubmit() {
      this.currentPage = 1;
      this.page();
    },

    clear() {
      this.searchCompany = {companyName: "", companyType: ""};
      this.page();
    },

    add() {
      let operator;

      if (this.company.companyId) {
        operator = update(this.company);
      } else {
        operator = add(this.company);
      }

      operator.then((resp) => {
        if (resp.data.code === "1") {
          this.dialogVisible = false;
          this.page();
          this.$message({message: "恭喜你，保存成功", type: "success"});
          this.company = {};
        } else {
          this.$message.error(resp.data.msg);
        }
      });
      this.page();
    },

    update(id) {
      this.dialogVisible = true;

      selectById(id).then((result) => {
        if (result.data.code === 1) {
          this.company = result.data.data;
        }
      });
    },

    handleSizeChange(val) {
      this.pageSize = val;
      this.page();
    },

    handleCurrentChange(val) {
      this.currentPage = val;
      this.page();
    },

    deleteById(id) {
      this.$confirm("此操作将删除该数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        deleteById(id).then((resp) => {
          if (resp.data.code === 1) {
            this.$message.success("恭喜你，删除成功");
            this.page();
          } else {
            this.$message.error(resp.data.msg);
          }
        });
      }).catch(() => {
        this.$message.info("已取消删除");
      });
    },

    deleteByIds() {
      this.$confirm("此操作将删除该数据, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        this.selectedIds = this.multipleSelection.map(item => item.companyId);

        deleteById(this.selectedIds).then((resp) => {
          if (resp.data.code === "1") {
            this.$message.success("恭喜你，删除成功");
            this.page();
          } else {
            this.$message.error(resp.data.msg);
          }
        });
      }).catch(() => {
        this.$message.info("已取消删除");
      });
    },

    getTypeLabel(type) {
      const typeObj = this.companyTypeList.find(item => item.id === type);
      return typeObj ? typeObj.name : '';
    },
  },
};
</script>





