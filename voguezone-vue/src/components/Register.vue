<template>
  <body id="paper" style="font-family: Apple,serif;font-size: 16px">
  <div style="height: 40px"></div>
<!--  这里记得写上ref="loginForm"，绑定数据元素，不然无法重置表单-->
  <el-form :model="loginForm" :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading="loading" ref="loginForm">
    <h3 class="login_title">用户注册</h3>
    <el-form-item prop="username">
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码" show-password></el-input>
    </el-form-item>
    <el-form-item prop="check_password">
      <el-input type="password" v-model="loginForm.check_password"
                auto-complete="off" placeholder="确认密码" show-password></el-input>
    </el-form-item>


    <el-form-item>
      <el-input type="text" v-model="loginForm.email"
                auto-complete="off" placeholder="E-Mail"></el-input>
    </el-form-item>

    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 40%;background: #505458;border: none" @click="submitForm('loginForm')">注册</el-button>
      <el-button type="primary" style="width: 40%;background: #505458;border: none" @click="resetForm('loginForm')">重置</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>
<script>
export default{

  data () {

    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.loginForm.check_password !== '') {
          this.$refs.loginForm.validateField('check_password');
        }
        callback();
      }
    };
    let validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.loginForm.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };

    return {
      rules: {
        username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
        password: [{ validator: validatePass,trigger: 'blur'}],
        check_password: [{validator: validatePass2,trigger: 'blur'}],
        email: [{required: true, message: '邮箱不能为空', trigger: 'blur'}]
      },
      checked: true,
      loginForm: {
        username: '',
        password: '',
        check_password:'',
        name: '',

        email: ''
      },

      loading: false
    }
  },
  methods: {
    //重置输入框
    resetForm(forName) {
      this.$refs[forName].resetFields();
    },
    //实现注册功能
    submitForm () {
      var _this = this
      this.$axios
        .post('/register', {
          username: this.loginForm.username,
          password: this.loginForm.password,
          name: this.loginForm.name,
          email: this.loginForm.email
        })
        .then(resp => {
          if (resp.data.code === 200) {
            this.$alert('注册成功', '提示', {
              confirmButtonText: '确定'
            })
            _this.$router.replace('/login')
          } else {
            this.$alert(resp.data.message, '提示', {
              confirmButtonText: '确定'
            })
          }
        })
        .catch(failResponse => {})
    }

  }
}
</script>
<style>
#paper {
  background: url("../assets/image/bg/bg3.jpg") no-repeat center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
  margin-bottom: 0px;
}
body{
  margin: -5px 0px;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
.login_remember {
  margin: 0px 0px 35px 0px;
  text-align: left;
}
</style>
