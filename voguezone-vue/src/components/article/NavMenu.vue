<template>
  <el-menu
    :default-active="'/index'"
    router
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="black"
    style="min-width: 1300px">
    <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name"
                  style="font-size: 20px;margin-left: 20px;font-family: Apple,serif">
      {{ item.navItem }}
    </el-menu-item>
    <search-bar
    style="margin-top: 20px;float: right"></search-bar>
  </el-menu>


</template>

<script>
import SearchBar from "@/components/common/SearchBar";

export default {
  name: 'NavMenu',
  components: {SearchBar},
  data() {
    return {
      navList: [
        {name: '/hot', navItem: '热门板块'},
        {name: '/recommend', navItem: '推荐板块'},
        {name: '/idea', navItem: '灵感板块'},
        {name: '/model', navItem: '模特专区'}
      ]
    }
  }
}
</script>

<style scoped>
a {
  text-decoration: none;
}

span {
  pointer-events: none;
}
</style>

