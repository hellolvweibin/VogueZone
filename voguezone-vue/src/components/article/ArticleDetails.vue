<template>
  <div class="body">
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
    <div>


      <el-card style="text-align: left;width: 990px;margin: 35px auto 0 auto">
        <el-row>
          <el-col>
            <span><Icon type="md-thumbs-up" size="20"/>点赞</span>&nbsp;
            <span @click="showComment"><Icon type="ios-text" size="20"/>
              <span v-if="show===false">查看评论</span>
              <span v-if="show===true">收起评论</span>
            </span>


          </el-col>
          <el-col>
            <div v-if="show">
              <comment :comments="CommentData"></comment>
            </div>
          </el-col>
        </el-row>


      </el-card>

    </div>
    <div>
      <Footer/>
    </div>


  </div>

</template>

<script>
import * as CommentData from '../../style/js/mockdata'
import comment from '../comment/CommentForm'
import Header from "@/components/common/Header";

import Footer from "@/components/common/Footer";

export default {
  name: 'ArticleDetails',
  components: {Header, Footer, comment},
  data() {
    return {
      article: [],
      CommentData: [],
      show: false,
    }
  },
  mounted() {
    this.loadArticle()
  },
  created() {
    this.CommentData = CommentData.comment.data
  },
  methods: {
    loadArticle() {
      let _this = this
      this.$axios.get('/admin/article/' + this.$route.query.id).then(resp => {
        if (resp && resp.status === 200) {
          _this.article = resp.data.result

        }
      })
    },
    showComment: function () {
      this.show = !this.show
    }
  }
}
</script>

<style scoped>

@import "../../style/markdown.css";

.body {
  min-height: 100vh;
}
</style>

