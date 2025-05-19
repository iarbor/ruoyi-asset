<template>
  <div class="app-container">
    <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      <el-form-item label="资产代码" prop="code">
        <el-input v-model="form.code" placeholder="请输入资产代码"/>
      </el-form-item>
      <el-form-item label="资产名称" prop="name">
        <el-input v-model="form.name" placeholder="请输入资产名称"/>
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
        <el-input v-model="form.descript" placeholder="请输入备注"/>
      </el-form-item>
      <el-form-item label="图片" prop="picture">
        <image-upload v-model="form.picture"/>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="submitForm">确 定</el-button>
      <el-button @click="cancel">取 消</el-button>
    </div>
  </div>
</template>

<script>

import {listStock, getStock, delStock, addStock, updateStock} from "@/api/assets/stock";
import {listSupplier} from "@/api/assets/supplier";
import {listMethod} from "@/api/assets/method";
import {listLocation} from "@/api/assets/location";
import {listCategory} from "@/api/assets/category";
import {listBrand} from "@/api/assets/brand";
import DictData from "@/utils/dict/DictData";

export default {
  name: "Stock",

  data() {
    return {
      // 遮罩层
      loading: true,
      assetsCategory: [],
      assetsMethod: [],
      assetsBrand: [],
      assetsSupplier: [],
      assetsLocation: [],

      // 弹出层标题
      title: "",


      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getBaseData();
  },
  methods: {
    /**
     * 获取基础数据
     */
    getBaseData() {
      listBrand().then(response => {
        for (const item of response.rows) {
          this.assetsBrand.push(new DictData(item.name, item.id.toString(), {"listClass": "default"}));
        }
      });
      listMethod().then(response => {
        for (const item of response.rows) {
          this.assetsMethod.push(new DictData(item.name, item.id.toString(), {"listClass": "default"}));
        }

      });
      listSupplier().then(response => {
        for (const item of response.rows) {
          this.assetsSupplier.push(new DictData(item.name, item.id.toString(), {"listClass": "default"}));
        }

      });
      listLocation().then(response => {
        for (const item of response.rows) {
          this.assetsLocation.push(new DictData(item.name, item.id.toString(), {"listClass": "default"}));
        }
      });
      listCategory().then(response => {
        for (const item of response.rows) {
          this.assetsCategory.push(new DictData(item.name, item.id.toString(), {"listClass": "default"}));
        }
      });
    },
    // 取消按钮
    cancel() {
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
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          addStock(this.form).then(response => {
            this.$modal.msgSuccess("新增成功");
            this.$store.dispatch("tagsView/delView", this.$route);
            this.$router.replace({path: "/stock/stock"});
          });
        }
      });
    },
  }
};
</script>
