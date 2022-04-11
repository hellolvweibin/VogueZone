<template>
  <div class="body">
    <div></div>
    <div>
      <SideMenu ></SideMenu>
    </div>

    <br>
    <div class="model-all">
      <el-row style="height: 840px;position: relative;margin-left: 20%">
        <!--        <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>-->
        <el-tooltip effect="dark" placement="right"
                    v-for="model in models.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                    :key="model.id">
          <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{ model.name }}</p>
          <p slot="content" style="font-size: 13px;margin-bottom: 6px">
            <span>{{ model.gender }}</span> /
            <span>国籍：{{ model.nationality }}</span> /<br>
            <span>简介：{{ model.introduction }}</span>
          </p>
          <p slot="content" style="width: 300px" class="abstract">{{ model.introduction }}</p>
          <el-card style="width: 160px;margin-bottom: 20px;height: 270px;float: left;margin-right: 15px" class="model"
                   bodyStyle="padding:10px" shadow="hover">
            <div class="cover" @click="editModel(model)">
              <img :src="model.image" alt="封面">
            </div>
            <div class="info">
              <div class="title">
                <a href="">{{ model.name }}</a>
              </div>
              <i class="el-icon-delete" @click="deleteModel(model.id)"></i>
            </div>
            <div class="author">{{ model.name }}</div>
          </el-card>
        </el-tooltip>
        <!--        <edit-form @onSubmit="loadBooks()" ref="edit"></edit-form>-->
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
  components: {SideMenu},
  data() {
    return {
      models: [],
      currentPage: 1,
      pagesize: 17
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
    deleteModel() {

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
  width: 115px;
  height: 172px;
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
