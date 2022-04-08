<template>

  <div>

    <Header/>
    <el-menu
      class="el-menu"
      router
      mode="horizontal"
      background-color="white"
      text-color="#222"
      active-text-color="black"
      style="min-width: 1300px">

      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name"
                    style="font-size: 20px;margin-left: 20px;font-family: Apple,serif">
        {{ item.navItem }}
      </el-menu-item>
      <search-bar
        style="margin-top: 20px;float: right;margin-right: 10%"></search-bar>
    </el-menu>
    <br><br>

    <div>
      <span style="font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">EXPLORE OUR FORUM</span><br>
      <span style="font-family:Apple,serif;font-size: 30px;font-weight:bold;font-style: italic;margin-top: 40px">加入我们，展示你的美！</span><br><br><br><br><br><br>
    </div>

    <div>
      <el-button  @click="$router.push({path:'/article/edit'})" style="color:#fcfbfb; position:relative;margin-right:-50%;font-weight: bold;background-color: #090505;font-family: Apple,serif">Create New Post</el-button>
    </div>

    <div>

    </div>




  </div>
</template>

<script>
import SearchBar from "@/components/common/SearchBar";
import Header from "@/components/common/Header";

export default {

  name: "ForumIndex",
  components: {
    Header, SearchBar
  },
  data() {
    return {
      navList: [
        {name: '/article/categories', navItem: '分类'},
        {name: '/article/allarticle', navItem: '所有文章'},
        {name: '/article/myarticle', navItem: '我的文章'},

      ]
    }
  }

}
</script>

<style scoped>
.el-menu {
  margin-top: 50px;
  margin-left: 200px;
  margin-right: 100px;
}
</style>
