<template>
  <div>
    <Header/>
    <el-card shadow="never" style="font-weight: bold;font-family: Apple,serif;font-size: 20px">
      <span style="margin-left: 13%">   一切，从这里开始！</span>

      <el-button  @click="saveArticles" ref="imgUpload" style="color:#fcfbfb; float: right;margin-right:-1%;font-weight: bold;background-color: #090505;font-family: Apple,serif">发表</el-button>
      <el-button  @click="dialogVisible = true" style="color:#fcfbfb; float: right;margin-right:15px;font-weight: bold;background-color: #090505;font-family: Apple,serif">添加摘要/封面 </el-button>
    </el-card>
    <el-row>
      <el-input
        v-model="article.articleTitle"
        style="margin: 10px 0px;font-size: 18px;"
        placeholder="请输入标题"></el-input>
    </el-row>
    <el-row style="height: calc(100vh - 140px);">
      <mavon-editor
        v-model="article.articleContentMd"
        style="height: 100%;"
        ref=md
        @save="saveArticles"
        fontSize="16px">
        <button type="button" class="op-icon el-icon-document" :title="'摘要/封面'" slot="left-toolbar-after"
                @click="dialogVisible = true"></button>
        <button type="button" class="op-icon el-icon-video-play" :title="'摘要/封面'" slot="left-toolbar-after"
                @click="dialogVisible = true"></button>
      </mavon-editor>
      <el-dialog
        :visible.sync="dialogVisible"
        width="30%">
        <el-divider content-position="left">摘要</el-divider>
        <el-input
          type="textarea"
          v-model="article.articleAbstract"
          rows="6"
          maxlength="255"
          show-word-limit></el-input>
        <el-divider content-position="left">封面</el-divider>
        <div style="margin-top: 20px">
                    <el-input v-model="article.articleCover" autocomplete="off" placeholder="图片 URL"></el-input>
                    <img-upload @onUpload="uploadImg" ref="imgUpload" style="margin-top: 5px"></img-upload>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button
            style="color:#fcfbfb; float: right;margin-right:15px;font-weight: bold;background-color: #090505;font-family: Apple,serif"
            @click="dialogVisible = false">确 定</el-button>
        </span>
      </el-dialog>
    </el-row>
  </div>
</template>

<script>
import Header from "@/components/common/Header";
import ImgUpload from "@/components/article/ImgUpload";
export default {
  name: 'ArticleEditor',
  components: {Header,ImgUpload},
  data() {
    return {
      article: {},
      dialogVisible: false
    }
  },
  mounted() {
    if (this.$route.params.article) {
      this.article = this.$route.params.article
    }
  },
  methods: {
    saveArticles(value, render) {
      // value 是 md，render 是 html
      this.$confirm('是否保存并发布文章?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
          this.$axios
            .post('/admin/article', {
              id: this.article.id,
              articleTitle: this.article.articleTitle,
              articleContentHtml: render,
              articleContentMd: value,
              status:1,
              articleAbstract: this.article.articleAbstract,
              articleCover: this.article.articleCover,
              articleCreatedTime: this.article.articleCreatedTime
            }).then(resp => {
            if (resp && resp.status === 200) {
              this.$message({
                type: 'info',
                message: '已保存成功'
              })
            }
          })
        }
      ).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消发布'
        })
      })
    },
    uploadImg() {
      this.article.articleCover = this.$refs.imgUpload.url
    }
  }
}
</script>

