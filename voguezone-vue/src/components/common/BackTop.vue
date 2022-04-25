<template>
  <el-backtop :bottom="60" :right="60" >
    <div title="回到顶部" class="button_ensure"
         style="{
        height: 100%;
        width: 100%;

        box-shadow: 0 1px 0 0;
        border-radius: 30px;
        text-align: center;
        line-height: 40px;

      }"
    >
      <el-icon class="el-icon-caret-top" style="color: white;font-size: 15px"></el-icon>

    </div>
  </el-backtop>
</template>

<script>

export default {
  name: "BackTop"
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
