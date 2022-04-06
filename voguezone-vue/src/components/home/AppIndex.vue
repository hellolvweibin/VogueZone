<template>
  <div>
    <Header/>
    <div style="height: 20%;width:2000px;border: 1px solid #0c0c0c;"></div>


    <br><br><br><br><br>
    <span
      style="color:black;font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">WELCOME  TO  THE </span><br>
    <span
      style="color:black;font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">MODEL TALK </span><br>
    <span
      style="color:black;font-family:Apple,serif;font-size: 78px;font-weight:bold;font-style: italic;margin-top: 100px">COMMUNITY</span><br><br><br><br>


    <div class="show">
      <div class="a">
        <el-image
          src="https://static.wixstatic.com/media/94e66f_9a3b0c07ff934e1985f88a7a8d0b5498~mv2.jpg/v1/fill/w_225,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_9a3b0c07ff934e1985f88a7a8d0b5498~mv2.jpg"></el-image>
      </div>
      <div class="b">
        <el-image
          src="https://static.wixstatic.com/media/94e66f_38d2a055626b40069914b0caf08c25cc~mv2_d_2415_1318_s_2.jpg/v1/fill/w_225,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_38d2a055626b40069914b0caf08c25cc~mv2_d_2415_1318_s_2.jpg"/>
      </div>
      <div class="c">
        <el-image
          src="https://static.wixstatic.com/media/94e66f_7afb7eb9929346b1b76f0c85f68b68c1~mv2.jpg/v1/fill/w_225,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_7afb7eb9929346b1b76f0c85f68b68c1~mv2.jpg"/>
      </div>
      <div class="d">
        <el-image
          src="https://static.wixstatic.com/media/94e66f_ad162c8305c944a7bd612b47a0f48ea8~mv2.jpg/v1/fill/w_225,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_ad162c8305c944a7bd612b47a0f48ea8~mv2.jpg"/>
      </div>
      <div class="d">
        <el-image
          src="https://static.wixstatic.com/media/94e66f_ad162c8305c944a7bd612b47a0f48ea8~mv2.jpg/v1/fill/w_225,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_ad162c8305c944a7bd612b47a0f48ea8~mv2.jpg"/>
      </div>
      <div class="e">
        <el-image
          src="https://static.wixstatic.com/media/94e66f_65ed3d28691040809210a22072ee509a~mv2.jpg/v1/fill/w_226,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_65ed3d28691040809210a22072ee509a~mv2.jpg"/>
      </div>
      <div class="f">
        <el-image
          src="https://static.wixstatic.com/media/94e66f_dbcfae5a5782430d9882a12a41abb037~mv2.jpg/v1/fill/w_225,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_dbcfae5a5782430d9882a12a41abb037~mv2.jpg"/>
      </div>
      <div class="g">
        <el-image
          src="https://static.wixstatic.com/media/94e66f_585b03ed1f994d018a613dee9bf2ddec~mv2_d_2415_1318_s_2.jpg/v1/fill/w_226,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_585b03ed1f994d018a613dee9bf2ddec~mv2_d_2415_1318_s_2.jpg"/>
      </div>
      <div class="h">
        <el-image
          src="https://static.wixstatic.com/media/5126c084aa754c27a4e7a87629b16cb8.jpg/v1/fill/w_180,h_225,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/5126c084aa754c27a4e7a87629b16cb8.jpg"/>
      </div>
    </div>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

    <span
      style="color:black;font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">EXPLORE  THE </span><br>
    <span
      style="color:black;font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">FORUM </span><br>
    <span style="font-family:Apple,serif;font-size: 30px;font-weight:bold;font-style: italic;margin-top: 40px">加入我们，展示你的美！</span><br><br><br><br><br><br>
    <el-button style="float: right;margin-right: 500px;background-color:#312c2c;color: white ">我也想展示</el-button>


  </div>
</template>

<script>
import Footer from "@/components/common/Footer";
import Header from "@/components/common/Header";
import SearchBar from "@/components/common/SearchBar";

export default {
  name: "AppIndex",
  components: {Footer, Header, SearchBar}
}
</script>

<style scoped>


.a {

  position: absolute;
  z-index: 2;
  left: 1000px;
  top: 660px;

}

.b {
  position: absolute;
  z-index: 1;
  left: 1200px;
  top: 570px;
}

.c {
  position: absolute;
  z-index: 3;
  left: 1250px;
  top: 870px;
}

.d {
  position: absolute;
  z-index: 4;
  left: 1100px;
  top: 800px;
}

.e {
  position: absolute;
  z-index: 5;
  left: 550px;
  top: 800px;
}

.f {
  position: absolute;
  z-index: 6;
  left: 550px;
  top: 580px;
}

.g {
  position: absolute;
  z-index: 7;
  left: 700px;
  top: 890px;
}

.h {
  position: absolute;
  z-index: 8;
  left: 750px;
  top: 600px;
}

</style>
