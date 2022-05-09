<template>

  <div class="body">
    <div class="header">
      <Header/>
    </div>

    <div class="main"
         style="position:relative;width: 800px;margin-left: 25%;min-height: 150px;margin-top: 20px;height: 100%">


      <el-card class="el-card" v-for="user in users " :key="user.id">

        <div class="center">
          <el-button @click="$router.push({path:'/user/settings/profiles'})" class="button_ensure"
                     icon="el-icon-magic-stick"
                     style="color: white;float: right">
            个人中心
          </el-button>
          <div>
          </div>
          <el-avatar :size="100" :src="user.avatar" style="float: left"></el-avatar>
          <div class="about" style="float: left;margin-left: 5%">

            <span style="float:left;font-size: 20px"><strong>{{ user.alias }} </strong><el-tag type="success"
                                                                                               size="medium"> 模特认证</el-tag></span><br><br>

            <span style="float: left;font-size: 15px"><icon class="el-icon-s-opportunity"></icon> 简介: {{
                user.bio
              }}</span><br><br>
            <span style="float: left;font-size: 15px"><icon class="el-icon-circle-plus"></icon> 加入时间：{{ user.creatTime }}</span><br><br>
            <span style="float: left;font-size: 15px"><icon class="el-icon-s-check"></icon> 性别：{{ choose[0] }}</span><br><br>


          </div>


        </div>


      </el-card>
      <div class="right" style="position:absolute;width: 30%;margin-top: -190px;margin-left: -40%">
        <el-card style="font-size: 16px;font-weight: bold">
          <div>
            <span>关注了</span>&nbsp;0
            <el-divider direction="vertical"></el-divider>
            <span>关注者</span>&nbsp;0


          </div>
        </el-card>

      </div>
    </div>

    <div>
      <el-menu
        :default-active="'/user/mypost'"
        router
        mode="horizontal"
        background-color="white"
        text-color="#222"
        active-text-color="black"
        style="width: 500px;margin-top: 10px;position: relative;margin-left: 25%">
        <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name"
                      style="font-size: 15px;font-weight:bold;margin-left: 20px;font-family: Apple,serif">
          {{ item.navItem }}
        </el-menu-item>


      </el-menu>

      <div style="position:relative;width: 800px;margin-left: 25%;margin-top: 20px;height: 100%">
        <el-card shadow="never" >
          <router-view></router-view>
        </el-card>
      </div>
    </div>






    <div class="footer" style="margin-top:40rem">
      <Footer/>
    </div>


  </div>
</template>

<script>
import * as userData from '@/style/js/userdata'
import Footer from "@/components/common/Footer";
import Header from "@/components/common/Header";

export default {
  name: "UserIndex",
  components: {Footer, Header},
  data() {
    return {
      users: [],
      choose: ['男', '女'],
      navList: [
        {name: '/user/mypost', navItem: '我的文章'},
        {name: '/user/myalbum', navItem: '我的专辑'},
        {name: '/user/mylike', navItem: '我的点赞'},
        {name: '/user/mycollect', navItem: '我的收藏'}
      ]
    }
  },

  methods: {},
  created() {
    this.users = userData.userData.result

  },
}
</script>

<style scoped>


.el-card {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
}

.button_ensure {
  background: #020202;
}

.button_ensure:hover {
  background: #2222db;


}
</style>
