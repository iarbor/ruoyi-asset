<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="资产代码" prop="code">
        <el-input
          v-model="queryParams.code"
          placeholder="请输入资产代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入资产名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入库时间" prop="entryTime">
        <el-date-picker clearable
          v-model="queryParams.entryTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择入库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="备注" prop="descript">
        <el-input
          v-model="queryParams.descript"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['assets:stock:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['assets:stock:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['assets:stock:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['assets:stock:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="stockList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="资产代码" align="center" prop="code" />
      <el-table-column label="资产名称" align="center" prop="name" />
      <el-table-column label="类型" align="center" prop="type" >
        <template slot-scope="scope">
          <dict-tag :options="assetsCategory" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="供应商" align="center" prop="supplier" >
      <template slot-scope="scope">
        <dict-tag :options="assetsSupplier" :value="scope.row.supplier"/>
      </template>
      </el-table-column>
      <el-table-column label="存放地点" align="center" prop="location" >
        <template slot-scope="scope">
          <dict-tag :options="assetsLocation" :value="scope.row.location"/>
        </template>
      </el-table-column>
      <el-table-column label="品牌" align="center" prop="brand" >
        <template slot-scope="scope">
          <dict-tag :options="assetsBrand" :value="scope.row.brand"/>
        </template>
      </el-table-column>
      <el-table-column label="取得方式" align="center" prop="method" >
        <template slot-scope="scope">
          <dict-tag :options="assetsMethod" :value="scope.row.method"/>
        </template>
      </el-table-column>
      <el-table-column label="入库时间" align="center" prop="entryTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.entryTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status" >
        <template slot-scope="scope">
          <dict-tag :options="dict.type.assets_stock_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="descript" />
      <el-table-column label="图片" align="center" prop="picture" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.picture" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['assets:stock:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['assets:stock:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改库存清单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="资产代码" prop="code">
          <el-input v-model="form.code" placeholder="请输入资产代码" />
        </el-form-item>
        <el-form-item label="资产名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入资产名称" />
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option
              v-for="dict in assetsCategory"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="品牌" prop="brand">
          <el-select v-model="form.brand" placeholder="请选择品牌">
            <el-option
              v-for="dict in assetsBrand"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="存放地点" prop="location">
          <el-select v-model="form.location" placeholder="请选择存放地点">
            <el-option
              v-for="dict in assetsLocation"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="供应商" prop="supplier">
          <el-select v-model="form.supplier" placeholder="请选择供应商">
            <el-option
              v-for="dict in assetsSupplier"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="取得方式" prop="method">
          <el-select v-model="form.method" placeholder="取得方式">
            <el-option
              v-for="dict in assetsMethod"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="入库时间" prop="entryTime">
          <el-date-picker clearable
            v-model="form.entryTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="descript">
          <el-input v-model="form.descript" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="图片" prop="picture">
          <image-upload v-model="form.picture"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

import { listStock, getStock, delStock, addStock, updateStock } from "@/api/assets/stock";
import { listSupplier } from "@/api/assets/supplier";
import { listMethod } from "@/api/assets/method";
import { listLocation } from "@/api/assets/location";
import { listCategory } from "@/api/assets/category";
import { listBrand } from "@/api/assets/brand";
import DictData from "@/utils/dict/DictData";
import StockAdd from "@/views/assets/stock/add.vue"
import {formatDate} from "@/utils";

export default {
  name: "Stock",
  dicts: ['assets_stock_status'],
  components: { StockAdd },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      assetsCategory: [],
      assetsMethod: [],
      assetsBrand: [],
      assetsSupplier: [],
      assetsLocation: [],

      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 库存清单表格数据
      stockList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        code: null,
        name: null,
        type: null,
        supplier: null,
        location: null,
        brand: null,
        method: null,
        entryTime: null,
        status: null,
        descript: null,
        picture: null,
      },
      // 表单参数
      form: {
        entryTime:formatDate(new Date())
      },
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getBaseData();
    this.getList();
  },
  methods: {
    /** 查询库存清单列表 */
    getList() {
      this.loading = true;
      listStock(this.queryParams).then(response => {
        this.stockList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    /**
     * 获取基础数据
     */
    getBaseData(){
      listBrand().then(response => {
        for(const item of response.rows){
          this.assetsBrand.push(new DictData(item.name, item.id.toString(), {"listClass":"default"}));
        }
      });
      listMethod().then(response => {
        for(const item of response.rows){
          this.assetsMethod.push(new DictData(item.name, item.id.toString(), {"listClass":"default"}));
        }

      });
      listSupplier().then(response => {
        for(const item of response.rows){
          this.assetsSupplier.push(new DictData(item.name, item.id.toString(), {"listClass":"default"}));
        }

      });
      listLocation().then(response => {
        for(const item of response.rows){
          this.assetsLocation.push(new DictData(item.name, item.id.toString(), {"listClass":"default"}));
        }
      });
      listCategory().then(response => {
        for(const item of response.rows){
          this.assetsCategory.push(new DictData(item.name, item.id.toString(), {"listClass":"default"}));
        }
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        code: null,
        name: null,
        type: null,
        supplier: null,
        location: null,
        brand: null,
        method: null,
        entryTime: null,
        status: null,
        descript: null,
        picture: null,
        createTime: null,
        createBy: null,
        updateTime: null,
        updateBy: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加库存清单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getStock(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改库存清单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStock(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStock(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除库存清单编号为"' + ids + '"的数据项？').then(function() {
        return delStock(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('assets/stock/export', {
        ...this.queryParams
      }, `stock_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
