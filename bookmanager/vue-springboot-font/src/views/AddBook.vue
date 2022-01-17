<template>
  <!--  数据绑定用:model=""    数据校验用 :rules=""   ref="" 想当于给这个表单设置了名字，这个名字是绑定给
  后面的函数作为参数formName使用的 -->
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="图书名称" prop="name">
      <el-input v-model="ruleForm.name" style="width: 60%"></el-input>
    </el-form-item>
    <el-form-item label="作者" prop="author">
      <el-input v-model="ruleForm.author" style="width: 60%"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')" >立即创建</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        name: '',
        author:''
      },
      rules: {
        name: [
          { required: true, message: '图书名不能为空', trigger: 'blur' },

        ],
        author: [
          { required: true, message: '作者不能为空', trigger: 'blur' }
        ],
      }
    };
  },
  methods: {
    test(){
      console.log(this.ruleForm)
    },
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          /*
          * post请求传过去的对象用 ，隔开
          * */
          axios.post('http://localhost:8181/book/save',this.ruleForm).then(function (resp){
            if(resp.data == 'success'){
              _this.$alert('《'+_this.ruleForm.name+'》添加成功！', '消息', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/BookManage')
                }
              })
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      /* $refs[formName]获取表单 */
      this.$refs[formName].resetFields();
    }
  }
}
</script>