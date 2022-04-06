<template>


  <el-card class="admin-header">
    <a href="/index" style="color: black">
      <span style="font-size: 45px;font-weight: bold;position:absolute;left: 50px;top: 35px;font-family:Apple,serif;font-style: italic">ModelTalk.</span>
    </a>
    <el-row>

      <el-dropdown @command="handleCommand" class="icon" style="font-size: 20px;float: right;margin-right:20px">
        <span class="el-dropdown-link">
            <i class="el-icon-more" style="color: #303090"></i>
            </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="a">关于我们</el-dropdown-item>
          <el-dropdown-item command="b">版本</el-dropdown-item>

        </el-dropdown-menu>
      </el-dropdown>
      <!--      </el-button>-->

      <el-dropdown @command="LoginOrResister" class="icon" style="font-size: 20px;float: right;margin-right:20px">
        <span class="el-dropdown-link">
            <i class="el-icon-user-solid" style="color: #020202"></i>
            </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="login">登录</el-dropdown-item>
          <el-dropdown-item command="register">注册</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>


      <el-dropdown class="icon" style="font-size: 20px;float: right;margin-right:20px">
        <span class="el-dropdown-link">
            <i class="el-icon-message-solid" style="color: #100f0f"></i>
            </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="a">系统消息</el-dropdown-item>
          <el-dropdown-item command="b">管理员消息</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <el-button  @click="toWriting" style="color:#fcfbfb; float: right;margin-right:15px;font-weight: bold;background-color: #090505;font-family: Apple,serif">创作中心 </el-button>
    </el-row>

  </el-card>

</template>

<script>
export default {
  name: "Header",
  methods: {
    LoginOrResister(command) {
      if(command==="login"){
        this.$router.replace({path:'/login'})
      }else {
        this.$router.replace({path:'/register'})
      }
    },

    handleCommand(command) {
      this.$message('click on item ' + command);
    },
    toWriting(){
      this.$router.replace({path:'/article/edit'})
    }
  }
}
</script>

<style scoped>
.admin-header {
  height: 80px;
  opacity: 0.85;
  line-height: 40px;
  min-width: 900px;
}

.el-dropdown-link {
  cursor: pointer;
  color: #2d4155;
}

.el-icon-arrow-down {
  font-size: 12px;
}
</style>
