<!--用户基本信息-->
<template>
  <div class="main">
      <span style="position: relative;margin-left:10px;font-size: 20px;font-weight: bold;font-family: Apple,serif;float: left"><strong>个人资料</strong></span><br>

      <el-divider></el-divider>
    <div class="userForm">
      <div style="margin: 20px;"></div>
      <el-form :label-position="left" label-width="auto" :model="formLabelAlign">
        <el-form-item label="昵称" >
          <el-col :span="8">
            <el-input v-model="formLabelAlign.name" maxlength="10" show-word-limit></el-input>
          </el-col>

        </el-form-item>

        <el-form-item label="简介">
          <el-col :span="8">
          <el-input v-model="formLabelAlign.region" maxlength="10" show-word-limit></el-input>
          </el-col>
        </el-form-item>

        <el-form-item label="个人简介">
          <el-col :span="8">
          <el-input type="textarea" :row="4"  v-model="formLabelAlign.textarea" maxlength="50" show-word-limit></el-input>
          </el-col>
        </el-form-item>
      </el-form>

    </div>
    <div class="avatar">

    </div>






  </div>


</template>

<script>
import * as userData from '@/style/js/userdata'
export default {
  name: "UserProfiles",
  data() {
    return {
      users:[],
      labelPosition: 'right',
      formLabelAlign: {
        name: '',
        region: '',
        textarea: ''
      }
    };
  },
  methods: {},
  created() {
    this.users = userData.userData.result

  },
}
</script>

<style scoped>

</style>
