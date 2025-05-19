<template>
  <div class="app-container">
    <div>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="资产名称" prop="name">
          <select-stock ref="selectStock" v-bind="stockConf" @callBackEvent="callback2" v-model="form.assetsId"
                        :id="form.assetsId"/>
        </el-form-item>
        <el-form-item label="用户名称" prop="userName">
          <select-user ref="selectUser" :sType=1 @callBackEvent="callback" v-model="form.userId" :id="form.userId"/>
        </el-form-item>

        <el-form-item label="归还时间" prop="bizTime">
          <el-date-picker clearable
                          v-model="form.bizTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择归还时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="descript">
          <el-input v-model="form.descript" placeholder="请输入备注"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import {listTransfer, getTransfer, delTransfer, addTransfer, updateTransfer} from "@/api/assets/transfer";
import selectUser from "@/components/UserSelector";
import selectStock from "@/components/StockSelector";

export default {
  name: "Transfer",
  components: {selectUser, selectStock},
  data() {
    return {
      // 表单参数
      form: {bizType: 2},
      // 表单校验
      rules: {},
      stockConf: {
        sType: 1,
        sBorrow: 0,
        id: null
      }
    };
  },
  created() {

  },
  methods: {
    // 取消按钮
    cancel() {
      this.reset();
      this.$store.dispatch("tagsView/delView", this.$route);
      this.$router.replace({path: "/stock/transfer"});
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        assetsId: null,
        name: null,
        userId: null,
        userName: null,
        dept: null,
        bizTime: null,
        bizType: null,
        descript: null,
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
          addTransfer(this.form).then(response => {
            this.$modal.msgSuccess("新增成功");
            this.$store.dispatch("tagsView/delView", this.$route);
            this.$router.replace({path: "/stock/transfer"});
          });

        }
      });
    },
    /** 回调操作 */
    callback(data) {
      console.log(data)
      this.form.dept = data.userList[0].deptId
      this.form.userName = data.userList[0].name
    },
    /** 回调操作 */
    callback2(data) {
      console.log(data)
      this.form.name = data.stockList[0].name

    }
  }
};
</script>
