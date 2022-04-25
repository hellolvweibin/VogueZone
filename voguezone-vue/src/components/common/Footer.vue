<template>
  <footer>
    <div class="footer" style="flex: 0 0 auto">
      <div style="border-top:1px #1F1F1F solid;">
        <p class="alt" style="color:#999; line-height:0">&copy; 版权所有：Levi_Bee👀 &nbsp;
          <span>技术支持：</span>
          <a href="" target="_blank" style="color:#999;">Levi_Bee😊</a>&nbsp;
          <span style="color:#999; line-height:0">特别感谢：🐰🐰</span>
        </p>
      </div>
      <BackTop/>

    </div>
  </footer>

</template>

<script>
import BackTop from "@/components/common/BackTop"
export default {
  name: 'Footer',
  components:{BackTop}
}
</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
  font-family: '微软雅黑', Arial, Helvetica, sans-serif;
}

body {
  font-size: 12px;
}

div {
  font-size: 12px;
}

span {
  font-size: 12px;
}

.footer {
  background: #2b2e33;
  flex: 0;
  margin-top: 120px;
}

.footer .alt {
  overflow: hidden;
  padding: 20px 0;
  width: 1160px;
  margin: auto;
}

.footer .alt .foot {
  width: 138px;
  float: left;
}

.footer .alt .foot p {
  color: #FFF;
  line-height: 28px;
}

a{
  text-decoration: none;
}

.footer .alt .foot a {
  color: #999;
  display: block;
  line-height: 24px;
}
</style>
