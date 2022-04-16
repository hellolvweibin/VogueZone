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
      style="min-width: 1300px;margin-left: 8%">

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
      <el-button class="button_ensure" @click="$router.push({path:'/article/edit'})"
                 style="color:#fcfbfb; position:relative;margin-right:-50%;font-weight: bold;font-family: Apple,serif">
        Create New Post
      </el-button>
    </div>

    <div class="article-area" style="margin-top: 60px">
      <el-row style="position: relative;margin-left: 18%;width: 50%">
        <div v-for="article in articles" >
          <el-card style="margin-bottom: 20px;float: left;margin-right: 15px" class="article"
                   bodyStyle="padding:0px" shadow="hover">
            <div class="cover" >
              <img class="img" :src="article.articleCover" alt="封面" @click="toArticleDetail">
            </div>
            <br>

            <div class="info">
              <div class="title" style="margin-left: 12%;margin-top: 15px">
                <span>{{ article.articleTitle }}</span>
              </div>

            </div>

          </el-card>
        </div>
      </el-row>
    </div>


  </div>


</template>

<script>

import SearchBar from "@/components/common/SearchBar";
import Header from "@/components/common/Header";
// import EditorTest from "@/components/forum/EditorTest"

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
      ],
      articles: [],
      currentPage: 1,
      pagesize: 17,
    }
  },
  //初始化页面完成后，
  mounted: function () {
    this.loadArticles()

  },
  methods: {
    loadArticles() {
      let _this = this
      this.$axios.get('/articles').then(resp => {
        if (resp && resp.status === 200) {
          _this.articles = resp.data.result

        }
      })
    },
    toArticleDetail(){

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


.button_ensure {
  background: #020202;
}

.button_ensure:hover {
  background: #2222db;


}

.article {
  border-width: 1px;
  width: 580px;
  min-height: 419px;



}
.img{
  width: 100%;
  height: 100%;
  object-fit:cover;
}

.cover{

  width: 580px;
  height: 300px;
  display: block;
}
</style>
