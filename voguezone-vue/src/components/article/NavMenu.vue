<template>

  <div>
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
      <div style="float: right;margin-right: 100px;margin-top: 15px">

      </div>

    </el-menu>

  </div>






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
        {name: '/models', navItem: '模特专区'}
      ]
    }
  },
  methods:{
    searchResult () {
      var _this = this
      this.$axios
        .get('/search?keywords=' + this.$refs.searchBar.keywords, {
        }).then(resp => {
        if (resp && resp.status === 200) {
          _this.models = resp.data
        }
      })
    },
  }
}
</script>
.line2 {
border-right: #0c0c0c 2px solid;
float: left;
height: 100%;
width: 50%;


}
<style scoped>
a {
  text-decoration: none;
}

span {
  pointer-events: none;
}
</style>

