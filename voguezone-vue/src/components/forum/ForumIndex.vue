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

    <div style="position: center">
      <span style="font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">EXPLORE OUR FORUM</span><br>
      <span style="font-family:Apple,serif;font-size: 30px;font-weight:bold;font-style: italic;margin-top: 40px">加入我们，展示你的美！</span><br><br><br><br><br><br>
    </div>
    <div style="position: center">
      <el-button class="button_ensure" @click="$router.push({path:'/article/edit'})"
                 style="color:#fcfbfb; font-weight: bold;font-family: Apple,serif">
        Create New Post
      </el-button>

    </div>


    <div class="article-area" style="margin-top: 60px;position: center">

      <el-row style="position: center">
        <el-col style="position: center">
          <div v-for="article in articles" style="position: relative;margin-left: 18%">
            <el-card style="margin-bottom: 20px;float: left;margin-right: 15px" class="article"
                     bodyStyle="padding:0px" shadow="hover">
              <div class="cover" >
                <img @click="toArticleDetail(article.id)" class="img" :src="article.articleCover" alt="封面"  >
              </div><br><br><br>


              <div class="info" style="text-align:center;margin-top: 15px;font-family: Apple,serif;margin-left: 5%;">
                <div class="title" style="float: left;margin-left: 5%;font-size: 20px;font-weight: bold">
                  <router-link class="article-link" :to="{path:'/forum/article',query:{id: article.id}}" style="color: #130d0d"><span><strong>{{article.articleTitle}}</strong></span></router-link>

                </div><br><br>

                <div class="interaction" style="float:left;margin-left: 5%">
                  <Icon type="md-thumbs-up" size="20" />&nbsp;&nbsp;
                  <Icon  type="ios-text" size="20"/>
                </div><br><br>


                <div class="abstract" style="font-family: Apple,serif;font-weight: bold;font-size: 14px;float: left;margin-left: 5%;text-align: left;margin-right: 5%">
                  <span>{{article.articleAbstract}}</span>
                </div>

              </div>

            </el-card>
          </div>
        </el-col>

      </el-row>
    </div>
    <div ><Footer/></div>


  </div>


</template>

<script>

import SearchBar from "@/components/common/SearchBar";
import Header from "@/components/common/Header";
import Footer from "@/components/common/Footer";
// import EditorTest from "@/components/forum/EditorTest"

export default {

  name: "ForumIndex",
  components: {
    Header, SearchBar,Footer
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
    toArticleDetail(id){
      let _this = this
      //获取当前博客的id 传到详情页面
      this.$router.push({path:'/forum/article',query:{id}})

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
  width: 540px;
  height: 520px;
  min-height: 419px;



}
.img{
  width: 100%;
  height: 120%;
  object-fit: cover;

}

.cover{

  width: 580px;
  height: 300px;
  display: block;
}
</style>
