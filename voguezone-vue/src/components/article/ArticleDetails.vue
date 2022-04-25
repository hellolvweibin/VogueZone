<template>
  <div>
    <Header style="margin-top: 0%"/>
    <div class="articles-area">
      <el-card style="text-align: left;width: 990px;margin: 35px auto 0 auto">
        <div>
          <span style="font-size: 20px"><strong>{{ article.articleTitle }}</strong></span>
          <!--        <el-divider content-position="left">{{article.articleDate}}</el-divider>-->
          <div class="markdown-body">
            <div v-html="article.articleContentHtml"></div>
          </div>

        </div>
      </el-card>
    </div>
    <div style="position: absolute;bottom: 0;left: 0;height: 20px;width: 100%;">

    </div>

    <Footer/>
  </div>

</template>

<script>
import Header from "@/components/common/Header";

import Footer from "@/components/common/Footer";

export default {
  name: 'ArticleDetails',
  components: {Header, Footer},
  data() {
    return {
      article: []
    }
  },
  mounted() {
    this.loadArticle()
  },
  methods: {
    loadArticle() {
      let _this = this
      this.$axios.get('/admin/article/' + this.$route.query.id).then(resp => {
        if (resp && resp.status === 200) {
          _this.article = resp.data.result

        }
      })
    }
  }
}
</script>

<style scoped>

@import "../../style/markdown.css";
</style>

