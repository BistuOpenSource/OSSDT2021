<template>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="图书名称" prop="name">
      <el-input v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="作者" prop="author">
      <el-input v-model="ruleForm.author"></el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
      <el-button @click="test">test</el-button>
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
  created() {
    const _this = this
    axios.get('http://localhost:8181/book/findById/'+_this.$route.query.id).then(function (resp) {
        _this.ruleForm = resp.data
    })
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
          axios.put('http://localhost:8181/book/update',_this.ruleForm).then(function (resp){
            console.log(resp)
              _this.$alert('《'+_this.ruleForm.name+'》修改成功！', '消息', {
                confirmButtonText: '确定',
                callback: action => {
                  _this.$router.push('/BookManage')
                }
              })

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