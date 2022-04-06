<!--侧边栏组件-->
<!--第二次开发：实现点击分类引发查询事件-->
<template>
  <el-menu
    class="categories"
    default-active="0"
    @select="handleSelect"
    active-text-color="black">
    <el-menu-item index="0">
      <i class="el-icon-menu"></i>
      <span class="icon-model" slot="title">全部</span>
    </el-menu-item>
    <el-menu-item index="1">
      <i class="el-icon-male"></i>
      <span slot="title" class="icon-model">Male</span>
    </el-menu-item>
    <el-menu-item index="2">
      <i class="el-icon-female"></i>
      <span slot="title" class="icon-model">Female</span>
    </el-menu-item>
    <el-menu-item index="3">
      <i class="el-icon-brush"></i>
      <span slot="title" class="icon-model">职业</span>
    </el-menu-item>
    <el-menu-item index="4">
      <i class="el-icon-loading"></i>
      <span slot="title" class="icon-model">生活</span>
    </el-menu-item>

  </el-menu>
</template>

<script>
export default {
  name: 'SideMenu',
  data(){
    return{
      cid:''
    }
  },
  methods: {
    handleSelect(key,keyPath){
      this.cid=key
      this.$emit('indexSelect')
    }
  }
}
</script>



<style scoped>
.categories {
  position: fixed;
  margin-left: 50%;
  left: -800px;
  top: 200px;
  width: 150px;
}
.icon-model{
  font-size: 18px;
  font-family: Apple,serif;
}

</style>

