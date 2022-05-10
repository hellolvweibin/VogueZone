<template>
  <div class="Post">
    <div>
      <!--<el-button @click="addArticle()">添加文章</el-button>-->
      <div class="articles-area">

        <el-divider content-position="center"><span
          style="font-size: 16px;font-weight: bold;font-family: Apple,serif;"><strong>我的文章</strong></span></el-divider>

        <div class="article">
          <el-container>
            <el-main>

              <div v-for="article in articles">


                <div>
                  <el-row>
                    <el-col >
                      <span style="float:left;font-family: Apple,serif;font-size: 22px"><strong>{{article.articleTitle}}</strong></span><br>

                    </el-col>

                  </el-row><br>
                  <el-row>
                    <el-col >
                      <span style="float:left;font-family: Apple,serif;font-size: 14px"><strong>{{article.articleAbstract}}</strong></span>
                    </el-col>

                  </el-row><br>
                  <el-row>
                    <el-col >
                      <span style="float:left;font-family: Apple,serif;font-size: 14px"><strong>发布于:{{article.createTime}}</strong></span>

                    </el-col>

                  </el-row><br>

                  <div>
                    <el-image :src="article.articleCover" style="float: right;margin-top: -130px"></el-image>
                  </div>

                </div>
                <div class="interaction">
                  <el-row >
                    <el-col>
                      <div style="float: left">
                        <div class="like" :class="{active: article.isLike}" @click="likeClick(article)">
                          <Icon type="md-thumbs-up" size="20"/>
                          <span class="like-num">{{article.articleLikeNum > 0 ? article.articleLikeNum + '' : '赞'}}</span>
                          <Icon type="ios-text" size="20"/>
                          <span class="like-num">{{article.articleCommentNum > 0 ? article.articleCommentNum + '' : '评论'}}</span>

                        </div>

                      </div>


                    </el-col>
                  </el-row>
                </div>

                <el-divider></el-divider>

              </div>


            </el-main>
          </el-container>

        </div>

      </div>

    </div>


  </div>

</template>

<script>
export default {
  name: "UserPost",
  data() {
    return {
      articles: [{
        articleId: '1',
        articleTitle: '凉风有兴',
        articleAbstract:'我是摘要',
        articleCover: 'https://static.wixstatic.com/media/94e66f_38d2a055626b40069914b0caf08c25cc~mv2_d_2415_1318_s_2.jpg/v1/fill/w_225,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_38d2a055626b40069914b0caf08c25cc~mv2_d_2415_1318_s_2.jpg',
        createTime:'2022-04-23 16:35:46',
        articleLikeNum: '10',
        articleCommentNum: '15',

      },
        {
          articleId: '2',
          articleTitle: '哈哈哈哈',
          articleAbstract:'哈哈哈哈',
          articleCover: 'https://static.wixstatic.com/media/94e66f_9a3b0c07ff934e1985f88a7a8d0b5498~mv2.jpg/v1/fill/w_225,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_9a3b0c07ff934e1985f88a7a8d0b5498~mv2.jpg',
          createTime:'2022-04-23 16:35:46',
          articleLike: '0',
          articleCollect: '0',

        },
      ],
      pageSize: 4,
      total: ''
    }
  },
  methods:{
    /**
     * 点赞
     */
    likeClick(article) {
      if (article.isLike === null) {
        Vue.$set(article, "isLike", true);
        article.articleLikeNum++
      } else {
        if (article.isLike) {
          article.articleLikeNum--
        } else {
          article.likeNum++
        }
        article.isLike = !article.isLike;
      }
    },
  },
  mounted() {
    this.loadArticles()
  },
}
</script>

<style scoped>

</style>
