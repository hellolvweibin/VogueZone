<!--用户基本信息-->
<template>

  <div><el-progress :percentage="50"></el-progress>
    <el-progress :percentage="100" :format="format"></el-progress>
    <el-progress :percentage="100" status="success"></el-progress>
    <el-progress :percentage="100" status="warning"></el-progress>
    <el-progress :percentage="50" status="exception"></el-progress></div>

</template>

<script>
export default {
  name: "UserProfiles"
}
</script>

<style scoped>

</style>
