<template>
  <div>
    <el-input v-model="stockInfo.names" @click.native="dataInitialization()" placeholder="点击选择库存物品" />
    <el-input v-model="stockInfo.ids" placeholder="请输入id" v-show="false" />
    <el-dialog title="库存选择" :visible.sync="visible" width="500px" v-if="visible" append-to-body>
      <el-tree
        ref="stockTree"
        :data="data"
        show-checkbox
        default-expand-all
        node-key="id"
        :default-checked-keys="checkedData"
        highlight-current
        :props="defaultProps"
        @check-change="handleClick"
      >
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span :class="data.icon"></span>
        <span>{{ node.label }}</span>
      </span>
      </el-tree>

      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="getCheckedNodes">确 定</el-button>
        <el-button @click="resetChecked">重置</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<script>
import { getStock,getCategoryAndStockTreeList4Borrow,getCategoryAndStockTreeList4Return } from '@/api/assets/stock'


export default {
  name: 'SelectStock',
  props: {
    sBorrow: Number,
    sType: 0,
    id:  [String,Number]
  },
  data() {
    return {
      checkedData: [],
      currentNodeData: {},
      // 是否显示弹出层
      visible: false,
      //是否单选
      isSingle: false,
      stockInfo:{
        ids: '',
        names: ''
      },
      selectedData: {
        ids:'',
        names: '',
        stockList: []
      },
      data: [{
        id: 1,
        label: '一级 1',
        children: [{
          id: 4,
          label: '二级 1-1',
          children: [{
            id: 9,
            label: '三级 1-1-1'
          }, {
            id: 10,
            label: '三级 1-1-2'
          }]
        }]
      }],
      defaultProps: {
        children: 'children',
        label: 'label'
      }
    }
  },
  watch: {
    // 监听id变化，重新渲染后面功能
    id(newValue,oldValue){
      this.$nextTick(()=> {
          this.getStockNames();
        }
      )
    },
    immediate: true,
    deep: true,
  },
  mounted() {
    this.getStockNames();
  },
  methods: {
    getStockNames(){
      this.stockInfo.ids='';
      this.stockInfo.names='';
      if(this.id!=="" && this.id!==undefined){
        this.stockInfo.ids=this.id;
        getStock(this.id).then(res=>{
          this.stockInfo.names=res.data.name;
        })
      }else {
      }
    },
    dataInitialization() {
      if(this.sBorrow === 1){
        // 获取部门和人员的数据
        getCategoryAndStockTreeList4Borrow().then(res => {
          this.data = res.data;
          // 1代表单选，0代表选
          if (this.sType === 1) {
            this.isSingle = true
          }
          let ids=this.stockInfo.ids;
          var dataIntArr = [];
          // 根据主页面传来的id值，进行默认选中设置
          if (ids !== '') {
            if(ids.indexOf(",")>0){
              const dataStrArr = ids.split(',');
              dataStrArr.forEach(function (data, index, arr) {
                dataIntArr.push(+data);
              })
            } else {
              dataIntArr.push(ids);
            }
            this.checkedData = dataIntArr;
          }
          this.visible = true;
        })
      }else{
        // 获取部门和人员的数据
        getCategoryAndStockTreeList4Return().then(res => {
          this.data = res.data;
          // 1代表单选，0代表选
          if (this.sType === 1) {
            this.isSingle = true
          }
          let ids=this.stockInfo.ids;
          var dataIntArr = [];
          // 根据主页面传来的id值，进行默认选中设置
          if (ids !== '') {
            if(ids.indexOf(",")>0){
              const dataStrArr = ids.split(',');
              dataStrArr.forEach(function (data, index, arr) {
                dataIntArr.push(+data);
              })
            } else {
              dataIntArr.push(ids);
            }
            this.checkedData = dataIntArr;
          }
          this.visible = true;
        })
      }

    },
    getCheckedNodes() {
      this.checkChange(this.$refs.stockTree.getCheckedNodes());
    },
    checkChange(List) {
      let ids = '';
      let names = '';
      const that_stock=this;
      List.forEach(function (item) {
        //对选中的数据进行过滤，部门的数据过滤掉，isDept=0（员工）的数据进行id和name的json重构，传给主页面
        if (item.isCategory === 0) {
          ids += item.id + ',';
          names += item.label + ',';
          that_stock.selectedData.stockList.push(item);
        }
      })
      if (ids.length > 0) {
        ids = ids.slice(0, ids.length - 1);
        names = names.slice(0, names.length - 1);
      }
      this.stockInfo.ids = ids;
      this.stockInfo.names = names;
      this.visible = false;
      // 返回值给调用页面的@backEventListen绑定的函数
      this.$emit('callBackEvent', this.selectedData);
      // 直接返回给v-model绑定的值
      this.$emit('input', ids);
    },
    resetChecked() {
      this.$refs.stockTree.setCheckedKeys([]);
      this.checkedData=[];
    },
    // 单选判断，执行操作
    handleClick(data, checked, node) {
      if (this.isSingle) {
        if (checked) {
          this.$refs.stockTree.setCheckedNodes([data]);
        }
      }
    },
  }
}
</script>

<style scoped>

</style>




