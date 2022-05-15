<template>
  <div>
    <Header/>
    <el-card shadow="never" style="font-weight: bold;font-family: Apple,serif;font-size: 20px">
      <span style="margin-left: 13%">   一切，从这里开始！</span>

      <el-button @click="saveArticles()"
                 style="color:#fcfbfb; float: right;margin-right:-1%;font-weight: bold;background-color: #090505;font-family: Apple,serif">
        发表
      </el-button>
      <el-button @click="dialogVisible = true"
                 style="color:#fcfbfb; float: right;margin-right:15px;font-weight: bold;background-color: #090505;font-family: Apple,serif">
        添加摘要/封面
      </el-button>
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
        ref="md"
        @save="saveArticles"
        fontSize="16px"
        :xssOptions="{
          whiteList: {
            iframe: ['src', 'height', 'width'],
            div: ['style', 'height', 'width', 'align'],
          },
        }"
      >
        <button type="button" class="op-icon el-icon-document" :title="'摘要/封面'" slot="left-toolbar-after"
                @click="dialogVisible = true"></button>

        <template v-slot:left-toolbar-after>
          <!--点击按钮触发的事件是打开表单对话框-->
          <el-button type="text" @click="dialogFormVisible=true" aria-hidden="true" class="op-icon fa" title="插入视频资源">
            <i class="el-icon-video-camera-solid"/>
          </el-button>
        </template>
      </mavon-editor>
<!--      添加摘要和封面-->
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
          <el-button @click="dialogVisible = false" style="font-family: Apple,serif">取 消</el-button>
          <el-button
            style="color:#fcfbfb; float: right;margin-right:15px;font-weight: bold;background-color: #090505;font-family: Apple,serif"
            @click="dialogVisible = false">确 定</el-button>
        </span>
      </el-dialog>
      <!-- 插入视频链接的dialog提示框，表单对话框 -->
      <el-dialog title="插入视频资源" :visible.sync="dialogFormVisible">
        <el-form :model="form">
          <el-form-item label="视频链接" :label-width="formLabelWidth">
            <el-input v-model="form.link" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="链接类型" :label-width="formLabelWidth">
            <el-select v-model="form.region" placeholder="请选择链接类型">
              <el-option label="iframe标签" value="iframe"></el-option>
              <el-option label="url链接" value="url"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false" style="font-family: Apple,serif">取 消</el-button>
          <!--单机确定按钮后触发 videoLink事件函数，开始格式化链接格式并插入到文本域-->
          <el-button style="color:#fcfbfb; float: right;margin-right:15px;font-weight: bold;background-color: #090505;font-family: Apple,serif" @click="videoLink">确 定</el-button>
        </div>
      </el-dialog>
      <!-- 错误提示框 -->
<!--      <el-dialog-->
<!--        title="提示"-->
<!--        :visible.sync="dialogVisible"-->
<!--        width="30%"-->
<!--        id="link-error">-->
<!--        <span>视频链接格式错误，请重新确认后再输入！</span>-->
<!--        <span slot="footer" class="dialog-footer">-->
<!--        <el-button @click="dialogVisible = false">取 消</el-button>-->
<!--        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>-->
<!--      </span>-->
<!--      </el-dialog>-->
    </el-row>
    <br><br>

    <div><Footer/></div>


  </div>
</template>

<script>
import Header from "@/components/common/Header";
import ImgUpload from "@/components/article/ImgUpload";
import Footer from "@/components/common/Footer";

export default {
  name: 'ArticleEditor',
  components: {Header, ImgUpload,Footer},
  data() {
    return {
      article: {

      },
      dialogFormVisible: false,	// 用于控制表单对话框的开启和关闭
      dialogVisible: false,// 用于控制错误提示对话框的开启和关闭
      form: {		// 表单对话框内表单的数据
        link: '',
        region: ''
      },

    }
  },
  mounted() {
    if (this.$route.params.article) {
      this.article = this.$route.params.article
    }
  },
  methods: {
    saveArticles() {
      // value 是 md，render 是 html
      this.$confirm('是否保存并发布文章?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
          this.$axios
            .post('/admin/content/article', {
              id: null,
              articleTitle: this.article.articleTitle,
              articleContentHtml:this.$refs.md.d_render, //获取html文本
              articleContentMd:  this.$refs.md.d_value, //获取text内容
              status: 1,
              articleAbstract: this.article.articleAbstract,
              articleCover: this.article.articleCover,

            }).then(resp => {
            if (resp && resp.status === 200) {
              this.$message({
                type: 'success',
                message: '发表成功'
              })
              this.$router.replace({path:'/forum'})
            }

          })
        }
      ).catch(() => {
        this.$message({
          type: 'warning',
          message: '已取消发布'
        })
      })
    },
    uploadImg() {
      this.article.articleCover = this.$refs.imgUpload.url
    },
    // 格式化视频链接并插入到文本域的函数
    videoLink() {
      // 准备链接模板
      let linkFrame = '';
      let linkFrameStart = "<div align=center width=100%><iframe height=500 width=80% src='"
      let linkFrameEnd = "' frameborder=0 'allowfullscreen'></iframe></div>"
      // 创建一个div盒子，为提取src做准备
      var box = document.createElement("div");
      // 将原始链接插入到盒子中
      box.innerHTML = this.form.link;
      // 判断不同的视频原链接类型
      if (this.form.region == "url") {
        linkFrame = linkFrameStart + this.form.link + linkFrameEnd;
      } else if (this.form.region == "iframe" && box.getElementsByTagName("iframe").length > 0) {
        // 从iframe标签中提取src属性
        linkFrame = linkFrameStart + box.getElementsByTagName("iframe")[0].getAttribute("src") + linkFrameEnd;
      } else {
        // 原始链接格式错误时弹出错误提示
        this.dialogFormVisible = false;
        this.dialogVisible = true;
      }
      // 复原表单文本框内容
      this.form.link = '';
      this.form.region = '';

      // 获取文本域中当前光标起始位置、结束位置以及滚动条位置（滚动条位置我认为没有必要，如有需要可以自己取消注释）
      let textarea = document.getElementsByClassName("auto-textarea-input")[0];
      let posStart = textarea.selectionStart;
      let posEnd = textarea.selectionEnd;
      // let posScroll = document.getElementsByClassName("v-note-edit")[0].scrollTop;
      // 获取文本域中未选中的的前半部分和后半部分，以被选中内容起始和结束位置做分割点
      let subStart = this.$refs.md.d_value.substring(0, posStart);
      let subEnd = this.$refs.md.d_value.substring(posEnd, this.$refs.md.d_value.length);
      // 拼接并替换文本域内容
      this.$refs.md.d_value = subStart + '\n' + linkFrame + '\n' + subEnd;
      // document.getElementsByClassName("v-note-edit")[0].scrollTop = posScroll;

      // 关闭对话框
      this.dialogFormVisible = false;
    }
  },



}
</script>

<style scoped>

@import "../../style/markdown.css";
</style>
