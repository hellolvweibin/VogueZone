<!--用户基本信息-->
<template>
  <div class="main" >
    <div class="right">


    </div>
    <span
      style="position: relative;margin-left:10px;font-size: 20px;font-weight: bold;font-family: Apple,serif;"><strong>个人资料</strong></span><br>

    <el-divider></el-divider>
    <div class="userForm" >


      <div style="margin: 20px 0;"></div>
      <el-form v-for="user in users" :key="user.id" :label-position="left" label-width="auto" >
        <el-form-item label="昵称:">
          <el-col :span="8">
            <el-input v-model="user.alias" maxlength="10" show-word-limit placeholder=""></el-input>
          </el-col>

        </el-form-item>

        <!--        <el-form-item label="简介:">-->
        <!--          <el-col :span="8">-->
        <!--            <el-input v-model="formLabelAlign.region" maxlength="10" show-word-limit></el-input>-->
        <!--          </el-col>-->
        <!--        </el-form-item>-->

        <el-form-item label="个人简介:">
          <el-col :span="8">
            <el-input type="textarea" :autosize="{ minRows: 3, maxRows: 5}" v-model="user.bio"
                      maxlength="100" show-word-limit></el-input>
          </el-col>
        </el-form-item>
      </el-form>

    </div>

    <div class="avatar" style="float: left;margin-left: 2.5rem;">
      <el-avatar v-for="user in users" :key="user.id" :src="user.avatar" :size="100">
      </el-avatar>
      <div>
        <el-button type="text" @click="dialogVisible = true">更换头像</el-button>

        <el-dialog
          title="上传头像"
          :visible.sync="dialogVisible"
          width="30%"
          :before-close="handleClose">

          <div style="margin-top: 10px">
            <el-upload
              class="avatar-uploader"
              action="http://localhost:8091/api/admin/article/covers"
              :show-file-list="true"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </div>

          <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
        </el-dialog>


      </div>


    </div>


    <div style="margin-top: 7rem">

      <el-button @click="$router.push({path:'/user/settings/profiles'})" class="button_ensure"

                 style="color: white;position: center;margin-top: 100px;float: left;margin-left: -8.5rem">
        保存修改
      </el-button>


    </div>

    <div style="height: 150px"></div>


  </div>


</template>

<script>
import * as userData from '@/style/js/userdata'

export default {
  name: "UserProfiles",
  data() {
    return {
      // user: {
      //   name: '你在叫什么？',
      //   bio: '改变，就是一种好事',
      //   avatar: 'http://ww4.sinaimg.cn/bmiddle/006DLFVFgy1ft0j2pddjuj30v90uvagf.jpg'
      //
      // },
      users: [],
      dialogVisible: false,
      imageUrl: 'http://ww4.sinaimg.cn/bmiddle/006DLFVFgy1ft0j2pddjuj30v90uvagf.jpg',
      labelPosition: 'right',
      formLabelAlign: {
        name: '',
        region: '',
        textarea: ''
      }
    };
  },
  methods: {
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {
        });
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    },


  },
  created() {
    this.users = userData.userData.result

  },

}
</script>

<style scoped>
.button_ensure {
  background: #020202;
}

.button_ensure:hover {
  background: #2222db;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
