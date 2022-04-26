<template>
  <div class="Post">
    <div style="margin-top: 20px">
      <!--<el-button @click="addArticle()">添加文章</el-button>-->
      <div class="articles-area">
        <el-card style="text-align: left">
          <div v-for="article in articles" :key="article.id">
            <div style="float:left;width:85%;height: 150px;">
              <router-link class="article-link" :to="{path:'jotter/article',query:{id: article.id}}"><span style="font-size: 20px"><strong>{{article.articleTitle}}</strong></span></router-link>
              <el-divider content-position="left">{{article.articleDate}}</el-divider>
              <router-link class="article-link" :to="{path:'jotter/article',query:{id: article.id}}"><p>{{article.articleAbstract}}</p></router-link>
            </div>
            <el-image
              style="margin:18px 0 0 30px;width:100px;height: 100px"
              :src="article.articleCover"
              fit="cover"></el-image>
            <el-divider></el-divider>
          </div>
        </el-card>
      </div>
      <el-pagination
        background
        layout="total, prev, pager, next, jumper"
        @current-change="handleCurrentChange"
        :page-size="pageSize"
        :total="total">
      </el-pagination>
    </div>


  </div>

</template>

<script>
export default {
  name: "UserPost",
  data () {
    return {
      articles: [],
      pageSize: 4,
      total: ''
    }
  },
  mounted () {
    this.loadArticles()
  },
}
</script>

<style scoped>

</style>
