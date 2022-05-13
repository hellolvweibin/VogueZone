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
            <span class="like" :class="{active:isLike}" @click="likeClick()">
              <span v-if="isLike===true"><Icon type="ios-thumbs-up" size="20"/></span>
              <span v-if="isLike===false"><Icon type="ios-thumbs-up-outline" size="20"/></span>
              <span class="like-num"
                    style="cursor: pointer">{{ likeNum > 0 ? likeNum + '人觉得很赞' : '赞' }}</span></span>&nbsp;

            <!--            style="cursor: pointer" 实现悬停是手指-->
            <span style="cursor: pointer" @click="showComment"><Icon type="ios-text" size="20"/>
              <span v-if="show===false">查看评论</span>
              <span v-if="show===true">收起评论</span>&nbsp;
            </span>

            <span style="cursor: pointer" @click="articleCollect">
             <span v-if="collect===false"><Icon type="ios-paw-outline" size="20"/>收藏</span>
              <span v-if="collect===true"><Icon type="ios-paw" size="20"/>已收藏</span>
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
      isLike: false,
      likeNum: 3,
      collect:false,
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
    },
    articleCollect: function () {
      this.collect = !this.collect
    },
    /**
     * 点赞
     */
    likeClick() {
      let _this = this
      if (_this.isLike === null) {
        _this.isLike=true
        _this.likeNum++
      } else {
        if (this.isLike) {
          _this.likeNum--
        } else {
          _this.likeNum++
        }
        _this.isLike = !_this.isLike
      }
    },

  }
}
</script>

<style scoped>

@import "../../style/markdown.css";

.body {
  min-height: 100vh;
}
</style>

