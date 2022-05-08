<!--用户认证-->
<template>
  <div>
    <div class="title">
      <span
        style="position: relative;margin-left:10px;font-size: 20px;font-weight: bold;font-family: Apple,serif"><strong>身份认证</strong></span><br>
      <el-divider ></el-divider>
      <el-button @click="submitAuth" class="button_ensure"

                 style="color: white;float:right;">
        提交认证
      </el-button>
      <div style="height: 10px"></div>



    </div>

    <div class="main">
<!--      <div style="margin-top: 20px">-->
<!--        <span style="margin-top: 20px;font-family: Apple,serif;font-size: 20px" >-->
<!--         -->
<!--        </span>-->
<!--      </div>-->
<!--      <div style="height: 2rem"></div>-->

      <div style="width: 100%">
        <div class="pdf" style="float:left;margin-left: 10rem;padding-right: 2rem">
          <span style="font-size: 18px;font-family: Apple,serif"><strong>简历认证</strong></span><br><br><br><br>
          <el-upload
            class="upload-demo"
            action="#"
            accept=".pdf"
            :on-preview="handlePreview"
            :before-remove="beforeRemove"
            :on-exceed="handleExceed"
            :on-change="uploadCertificateChange"
            multiple
            :limit="3"
            :file-list="fileList"
            :auto-upload="false"
          >
            <el-button
              size="small"
              class="button_ensure"
              style="color: white;"
              v-loading.fullscreen.lock="fullscreenLoading"
            >点击上传</el-button
            >
            <div slot="tip" class="el-upload__tip">只能上传PDF文件,个数不超过三个</div>
          </el-upload>
        </div>
        <div style="margin-top: 3rem"></div>

        <div class="page" style="float: right;margin-bottom: 50px;margin-right: 10rem;padding-left: 2rem">
          <span style="font-size: 18px;font-family: Apple,serif"><strong>图片认证</strong></span><br><br><br><br>

          <el-upload
            class="upload-demo"
            action="http://localhost:8091/api/admin/article/covers"
            :on-preview="handlePreview_page"
            :on-remove="handleRemove"
            :file-list="fileList"
            list-type="picture">
            <el-button size="small" class="button_ensure" style="color: white;">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
          </el-upload>
        </div>
      </div>







    </div>






  </div>



</template>

<script>
export default {
  name: "UserAuth",
  data() {
    return {
      active: 0
    };
  },

  methods: {

    //保存认证
    submitAuth(){



    },
    next() {
      if (this.active++ > 2) this.active = 0;
    },
    back() {
      if (this.active>0) this.active--;
    },
    //上传
    uploadCertificateChange(file) {

      this.$confirm("上传文件，是否继续？", "提示")
        .then(() => {

          this.fullscreenLoading = true;
          let fd = new FormData();
          fd.append("files", file.raw);
          this.$cm
            .postUploadCertificate(fd)
            .then((res) => {

              console.log(res);
              if (res.ErrorCode == "00000000") {

                this.$message.success("上传成功");
                this.certificatePath = res.Response;
              } else {

                this.$message.warning(res.Message);
                this.fileList.pop();
              }
              this.fullscreenLoading = false;
            })
            .catch((err) => {

              this.fullscreenLoading = false;
              err && this.$message.warning(err);
            });
          return true;
        })
        .catch(() => {

          this.$message.success("取消成功");
          this.fileList = [];
          return false;
        });
    },
    //预览
    handlePreview(file) {

      // axios的基地址和上传文件路径同时存在时可预览
      if (this.$axios.defaults.baseURL && this.certificatePath) {

        window.open(
          this.$axios.defaults.baseURL + this.certificatePath,
          "_blank"
        );
      } else {

        this.$message.warning("暂不支持预览");
      }
    },
    //删除
    beforeRemove(file, fileList) {

      // 移除前
      return this.$confirm(`确定移除 ${
        file.name}？`).then(() => {

        this.$message.success("已移除");
        this.certificatePath = "";
      });
    },
    //超出文件上传个数
    handleExceed(files, fileList) {

      this.$message.warning(
        `当前限制选择 3 个文件，本次选择了 ${
          files.length} 个文件，已上传了 ${
          fileList.length} 个文件`
      );
    },
    //图片上传
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview_page(file) {
      console.log(file);
    }


  }
}
</script>

<style scoped>
.button_ensure {
  background: #020202;
}

.button_ensure:hover {
  background: #2222db;
}
</style>
