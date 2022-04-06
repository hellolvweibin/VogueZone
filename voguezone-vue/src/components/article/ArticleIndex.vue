<template>
<div>
  <Header/>
  <nav-menu></nav-menu>
  <router-view/>


</div>
</template>

<script>
import Header from "@/components/common/Header";
import NavMenu from "@/components/article/NavMenu";
export default {
  name: "ArticleIndex",
  components:{NavMenu,Header}
}
</script>

<style scoped>

</style>
