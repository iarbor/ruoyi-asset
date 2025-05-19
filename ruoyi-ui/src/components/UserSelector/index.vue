<template>
  <div>
    <el-input v-model="userInfo.names" @click.native="dataInitialization()" placeholder="点击选择人员" />
    <el-input v-model="userInfo.ids" placeholder="请输入id" v-show="false" />
    <el-dialog title="人员选择" :visible.sync="visible" width="500px" v-if="visible" append-to-body>
      <el-tree
        ref="userTree"
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
import { getDeptAndUserTreeData } from '@/api/assets/dept_user'
import { getUser } from '@/api/system/user'

export default {
  name: 'SelectUser',
  props: {
    sType: 0,
    id:  [String,Number],
  },
  data() {
    return {
      checkedData: [],
      currentNodeData: {},
      // 是否显示弹出层
      visible: false,
      //是否单选
      isSingle: false,
      userInfo:{
        ids: '',
        names: ''
      },
      selectedData: {
        ids:'',
        names: '',
        userList: []
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
          this.getUserNames();
        }
      )
    },
    immediate: true,
    deep: true,
  },
  mounted() {
    this.getUserNames();
  },
  methods: {
    getUserNames(){
      this.userInfo.ids='';
      this.userInfo.names='';
      if(this.id!=="" && this.id!==undefined){
        this.userInfo.ids=this.id;
        getUser(this.id).then(res=>{
          this.userInfo.names=res.data.nickName;
        })
      }else {
      }
    },
    dataInitialization() {
      // 获取部门和人员的数据
      getDeptAndUserTreeData().then(res => {
        this.data = res.data;
        // 1代表单选，0代表选
        if (this.sType === 1) {
          this.isSingle = true
        }
        let ids=this.userInfo.ids;
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
    },
    getCheckedNodes() {
      this.checkChange(this.$refs.userTree.getCheckedNodes());
    },
    checkChange(List) {
      console.log("List")
      console.log(List)
      let ids = '';
      let names = '';
      const that_user=this;
      that_user.selectedData.userList=[];
      List.forEach(function (item) {
        //对选中的数据进行过滤，部门的数据过滤掉，isDept=0（员工）的数据进行id和name的json重构，传给主页面
        if (item.isDept === 0) {
          ids += item.id + ',';
          names += item.label + ',';
          that_user.selectedData.userList.push(item);
        }
      })
      if (ids.length > 0) {
        ids = ids.slice(0, ids.length - 1);
        names = names.slice(0, names.length - 1);
      }
      this.userInfo.ids = ids;
      this.userInfo.names = names;
      this.visible = false;
      // 返回值给调用页面的@backEventListen绑定的函数
      this.$emit('callBackEvent', this.selectedData);
      // 直接返回给v-model绑定的值
      this.$emit('input', ids);
    },
    resetChecked() {
      this.$refs.userTree.setCheckedKeys([]);
      this.checkedData=[];
    },
    // 单选判断，执行操作
    handleClick(data, checked, node) {
      if (this.isSingle) {
        if (checked) {
          this.$refs.userTree.setCheckedNodes([data]);
        }
      }
    },
  }
}
</script>

<style scoped>

</style>




