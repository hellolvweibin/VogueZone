<template>

  <div class="body">
    <div class="header">
      <Header/>
    </div>

    <div class="main" style="position:relative;width: 800px;margin-left: 25%;min-height: 150px;margin-top: 20px">


      <el-card class="el-card" v-for="user in users " :key="user.id" >

        <div class="center">
          <el-button @click="$router.push({path:'/models'})" class="button_ensure" icon="el-icon-magic-stick"
                     style="color: white;float: right">
            编辑个人资料
          </el-button>
          <div>
            <el-avatar :size="100" :src="user.avatar" style="float: left"></el-avatar>
          </div>
          <div class="about" style="float: left;margin-left: 5%">

            <span  style="float:left;">用户名：{{ user.alias }} &nbsp;<el-tag type="success"> 模特</el-tag></span><br>

            <span  style="float: left">简介：{{ user.bio }}</span>

          </div>


        </div>



      </el-card>
      <div class="right" style="position:absolute;width: 30%;margin-top: -120px;margin-left: -40%">
        <el-card style="font-size: 16px;font-weight: bold">   <div>
          <span>关注了</span>&nbsp;0
          <el-divider direction="vertical"></el-divider>
          <span>关注者</span>&nbsp;0


        </div></el-card>

      </div>
    </div>

    <div class="footer">
      <Footer/>
    </div>


  </div>
</template>

<script>
import * as userData from '../../style/js/userdata'
import Footer from "@/components/common/Footer";
import Header from "@/components/common/Header";

export default {
  name: "UserIndex",
  components: {Footer, Header},
  data() {
    return {
      users: [],
      choose: ['男', '女']
    }
  },

  methods: {},
  created() {
    this.users = userData.userData.result

  },
}
</script>

<style scoped>

.about {

  font-size: 18px;
  color: #1b1f23;
}
.el-card{
   box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
}

.button_ensure {
  background: #020202;
}

.button_ensure:hover {
  background: #2222db;


}
</style>
