<template>
  <div class="model-all" ref="modelAll">

    <div>
      <el-aside style="width: 200px;margin-top: 20px">
        <SideMenu @indexSelect="listByGender" ref="sideMenu" style=" margin-top: 4%"></SideMenu>
      </el-aside>

    </div>

    <br>

    <div style="height: 20px"></div>
    <div class="model-all" ref="modelAll">

      <SearchBar @onSearch="searchResult" ref="searchBar"
                 style="float: right;margin-right: 5%;margin-top: -2%"></SearchBar>
      <div style="height: 70px"></div>

      <el-row style="height: 840px;position: relative;margin-left: 22rem">

        <el-tooltip effect="dark" placement="right"
                    v-for="model in models.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                    :key="model.id">
          <p slot="content" style="font-size: 14px;margin-bottom: 6px;">模特姓名：{{ model.name }}</p>
          <p slot="content" style="font-size: 13px;margin-bottom: 6px">


            <span>国籍：{{ model.nationality }}</span> <br>
            <span v-if="model.gender===1">性别：{{ status[0] }}</span>
            <span v-else-if="model.gender===2">性别：{{ status[1] }}</span>
            <br>
            <span>简介：{{ model.introduction }}</span>
          </p>
          <p slot="content" style="width: 300px" class="abstract">{{ model.introduction }}</p>
          <el-card style="width: 180px;margin-bottom: 20px;height: 290px;float: left;margin-right: 15px" class="model"
                   bodyStyle="padding:10px" shadow="hover">
            <div class="cover" style="margin-left: 12%">
              <img :src="model.image" alt="封面">
            </div>
            <div class="info">
              <div class="title" style="margin-left: 12%">
                <a href="">{{ model.name }}</a>
              </div>
              <i class="el-icon-star-off" style="float: right;"></i>

            </div>

          </el-card>
        </el-tooltip>

      </el-row>

      <el-row>
        <el-pagination
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-size="pagesize"
          :total="models.length">
        </el-pagination>
      </el-row>


    </div>


  </div>
</template>

<script>


import SearchBar from "@/components/common/SearchBar";
import SideMenu from "@/components/article/SideMenu";

export default {
  name: "Model",
  components: {SearchBar, SideMenu},

  data() {
    return {
      models: [],
      currentPage: 1,
      pagesize: 17,
      status: ['男', '女']


    }
  },
  mounted: function () {
    this.loadModels()

  },


  methods: {
    loadModels() {
      let _this = this
      this.$axios.get('/models').then(resp => {
        if (resp && resp.status === 200) {
          _this.models = resp.data.result
        }
      })
    },
    editModel() {

    },
    searchResult() {
      let _this = this
      this.$axios
        .get('/search?keywords=' + this.$refs.searchBar.keywords, {}).then(resp => {
        if (resp && resp.status === 200 && resp.data.result.length !== 0) {
          _this.models = resp.data.result
        } else {
          _this.$notify.error({
            title: '出错啦',
            message: '找不到您想要的信息，再试一下吧🧐',
          });

        }
      })
    },

    listByGender() {
      let _this = this
      let gender = this.$refs.sideMenu.gender
      let url = 'gender/' + gender + '/models'
      this.$axios.get(url).then(resp => {
        if (resp && resp.data.code === 200) {
          _this.models = resp.data.result
          // _this.$refs.modelALl.models = resp.data.result
          // _this.$refs.modelALl.currentPage = 1
        }
      })
    },
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage
      console.log(this.currentPage)
    },


  }
}

</script>

<style scoped>
img {
  width: 120px;
  height: 180px;
  /*margin: 0 auto;*/
}

.title {
  font-size: 14px;
  text-align: left;
}

.author {
  color: #333;
  width: 102px;
  font-size: 13px;
  margin-bottom: 6px;
  text-align: left;
}

.abstract {
  display: block;
  line-height: 17px;
}

.el-icon-delete {
  cursor: pointer;
  float: right;
}

.cover {
  width: 140px;
  height: 190px;
  margin-bottom: 7px;
  overflow: hidden;
  cursor: pointer;
}

a {
  text-decoration: none;
}

a:link, a:visited, a:focus {
  color: #3377aa;
}


</style>
