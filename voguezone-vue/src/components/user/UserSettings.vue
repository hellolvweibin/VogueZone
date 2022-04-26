<template>
  <div class="body">
    <div class="header">
      <Header/>
    </div>
    <div class="container" style="height: 100%">

      <div style="position: center;margin-top: 20px;margin-left: 15rem">

          <el-page-header title="返回用户主页" @back="goBack" >

          </el-page-header>
<!--        <span style="position:center;font-weight: bold;font-size: 30px;font-family:Apple,serif"><strong>个人中心</strong></span>-->


      </div>


      <div class="info" style="margin-top: 20px;width: 100%">
        <div class="left" style="width: 30%">
          <el-card style="margin-left: 15rem;width: 10.5rem">
            <el-menu
              class="info"
              default-active="/user/settings/profiles"
              router
              @open="handleOpen"
              @close="handleClose"

              active-text-color="0F0F49FF">
              <el-menu-item index="/user/settings/profiles" style="font-size: 15px">

                <i class="el-icon-coordinate"/>
                <span class="icon-model" slot="title">个人资料</span>
              </el-menu-item>
              <el-menu-item index="/user/settings/auth" style="font-size: 15px">
                <i class="el-icon-set-up"/>
                <span slot="title" class="icon-model">我要认证</span>
              </el-menu-item>
              <el-menu-item index="/user/settings/postmanage" style="font-size: 15px">
                <i class="el-icon-edit"/>
                <span slot="title" class="icon-model">文章管理</span>
              </el-menu-item>


            </el-menu>

          </el-card>
        </div>

        <div class="right" style="width: 70%;height: 700px">
          <div>
            <el-card style="margin-left:27rem;margin-top:-13rem;width: 90%">
              <router-view></router-view>
            </el-card>
          </div>

        </div>

        <div style="height: 400px"></div>


      </div>


    </div>

    <div class="footer" style="margin-top:20rem">
      <Footer/>
    </div>
  </div>

</template>

<script>
import Footer from "@/components/common/Footer";
import Header from "@/components/common/Header";

export default {
  name: "UserProfile",
  components: {Footer, Header},
  methods: {
    goBack() {
      this.$router.replace({path: '/user'})
    },

    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    goTo(path) {
      this.$router.replace(path);
    }
  }

}
</script>

<style scoped>
.el-tabs {
  font-size: 16px;
}
</style>
