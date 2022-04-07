<template>
  <div>
    <Header/>
<!--    <div style="height: 20%;width:2000px;border: 1px solid #0c0c0c;"></div>-->

    <br> <br><br>

    <div class="line2" ><br><br><br><br><br><br><br><br><br><br></div>

    <br><br><br><br><br><br><br><br><br><br>
    <div class="title">
          <span
            style="color:black;font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">WELCOME  TO  THE </span><br>
      <span
        style="color:black;font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">MODEL TALK </span><br>
      <span
        style="color:black;font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">COMMUNITY</span><br>
    </div>
    <br><br>

    <!--    <el-image src="https://raw.githubusercontent.com/hellolvweibin/Typora/main/bg10.png" style="width: auto;height: auto">-->
    <!--    </el-image>-->
    <div class="line2" ><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>
    <div class="image">
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
      <div class="z">
        <el-image
          src="https://static.wixstatic.com/media/0045f2a0edc241a79b76d5cff281d8d9.jpg/v1/fill/w_180,h_225,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/0045f2a0edc241a79b76d5cff281d8d9.jpg"/>
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

    <div class="forum">
      <span
        style="color:black;font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">EXPLORE  THE </span><br>
      <span
        style="color:black;font-family:Apple,serif;font-size: 80px;font-weight:bold;font-style: italic;margin-top: 100px">FORUM </span><br>
      <span
        style="font-family:Apple,serif;font-size: 15px;font-weight:bold;margin-top: 40px;float: right">点击我！从这里开始讲述您与时尚的故事，总有一些</span><br>
      <span style="font-family:Apple,serif;font-size: 15px;font-weight:bold;margin-top: 40px">内容适合您，来让跟多人来了解你吧！</span>
      <br><br>

      <el-button @click="$router.replace({path:'/forum'})" class="button_ensure" icon="el-icon-key"
                 style="color: white">
        加入我们！
      </el-button>

    </div>

    <br><br> <br><br><br><br><br><br><br>

    <div class="vogue">
      <span
        style="color:black;font-family:Apple,serif;font-size: 40px;font-weight:bold;font-style: italic;position: absolute;right: 60%">潮流前线</span><br>

      <span
        style="color:black;font-family:Apple,serif;font-size: 20px;font-weight:bold;font-style: italic;position: absolute;left: 29%;margin-top: 3%">在这里你能看到最新的潮流信息!</span>
      <el-button @click="$router.replace({path:'/forum'})" class="button_ensure" icon="el-icon-thumb"
                 style="color: white;position: absolute;right: 61%;top: 210%">
        立即浏览
      </el-button>
    </div>


    <div class="image1">
      <div class="i">
        <el-image
          src="https://static.wixstatic.com/media/94e66f_d34edcd255794508a058ef7140b9ee49~mv2.jpg/v1/fill/w_370,h_246,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_d34edcd255794508a058ef7140b9ee49~mv2.jpg"/>
      </div>
      <br>

      <div class="j">
        <el-image
          src="https://raw.githubusercontent.com/hellolvweibin/Typora/main/IMG_5494.JPG"/>
      </div>
    </div>
    <br> <br> <br> <br> <br> <br>

    <div class="model">
      <span
        style="color:black;font-family:Apple,serif;font-size: 40px;font-weight:bold;font-style: italic;position: absolute;right: 38%;top:240%">模特之家</span><br>

      <span
        style="color:black;font-family:Apple,serif;font-size: 20px;font-weight:bold;font-style: italic;position: absolute;right: 35%;top:250%">来看看他们是怎么塑造时尚的!</span>
      <el-button @click="$router.replace({path:'/forum'})" class="button_ensure" icon="el-icon-wind-power"
                 style="color: white;position: absolute;left: 55%;top: 265%">
        即刻体验
      </el-button>
    </div>


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

.line {
  border-right: #0c0c0c 3px solid;
}

.line2 {
  border-right: #0c0c0c 2px solid;
  float: left;
  height: 100%;
  width: 50%;


}

.image {
  position: relative;

}

.a {
  position: absolute;
  z-index: 1;
  left: 170px;
  top: 150px;
  width: 100%;
  height: auto;
  max-width: 100%;
  display: block;
}

.b {
  position: absolute;
  z-index: 2;
  left: 350px;
  top: 60px;
  width: 100%;
  height: auto;
  max-width: 100%;
  display: block;
}

.c {
  position: absolute;
  z-index: 3;
  left: 450px;
  top: 350px;
  width: 100%;
  height: auto;
  max-width: 100%;
  display: block;
}

.d {
  position: absolute;
  z-index: 4;
  left: 360px;
  top: 260px;
  width: 100%;
  height: auto;
  max-width: 100%;
  display: block;
}

.e {
  position: absolute;
  z-index: 5;
  left: -200px;
  top:280px;
  width: 100%;
  height: auto;
  max-width: 100%;
  display: block;
}

.f {
  position: absolute;
  z-index: 6;
  left: -150px;
  top: 120px;
  width: 100%;
  height: auto;
  max-width: 100%;
  display: block;
}

.g {
  position: absolute;
  z-index: 7;
  left: -380px;
  top: 380px;
  width: 100%;
  height: auto;
  max-width: 100%;
  display: block;
}

.h {
  position: absolute;
  z-index: 8;
  left: -330px;
  top: 60px;
  width: 100%;
  height: auto;
  max-width: 100%;
  display: block;
}

.i {
  position: relative;
  top: 190%;
  left: 50%;

}

.j {
  position: relative;
  top: 240%;
  right: 55%;
  width: 100%;
  height: auto;
  max-width: 100%;
  display: block;

}

.z {
  position: absolute;
  z-index: 0;
  left: 120px;
  top: 300px;
  width: 100%;
  height: auto;
  max-width: 100%;
  display: block;
}

.button_ensure {
  background: #020202;
}

.button_ensure:hover {
  background: #2222db;


}

</style>
