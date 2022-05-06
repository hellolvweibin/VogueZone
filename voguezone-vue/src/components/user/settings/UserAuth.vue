<!--用户认证-->
<template>
  <div>
    <div class="title">
      <span style="position: relative;margin-left:10px;font-size: 20px;font-weight: bold;font-family: Apple,serif"><strong>身份认证</strong></span><br>
      <el-divider></el-divider>
    </div>

    <div >
      <el-steps :active="active" finish-status="success">
        <el-step title=""></el-step>
        <el-step title="个人信息"></el-step>
        <el-step title="步骤 3"></el-step>
      </el-steps>

      <el-button style="margin-top: 12px;" @click="next">下一步</el-button>
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
    next() {
      if (this.active++ > 2) this.active = 0;
    }
  }
}
</script>

<style scoped>

</style>
