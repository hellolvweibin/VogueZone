<!--文章管理-->
<template>
  <div>
    <div class="title">
      <span style="position: relative;margin-left:10px;font-size: 20px;font-weight: bold;font-family: Apple,serif"><strong>我的文章</strong></span><br>
      <el-divider></el-divider>
    </div>

    <!--增删改查-->
    <div>
<!--      <div style="font-size: 30px;color: salmon">表格案例</div>-->
      <!--按钮、表格-->
      <el-card class="box-card" shadow="never">
<!--        <el-button  size="small" @click="add">去写一篇</el-button>-->
        <el-table :data="tableData" stripe>
          <el-table-column prop="articleTitle" label="文章标题" align="center">
          </el-table-column>
          <el-table-column
            v-if="0===1"
            prop="articleCover"
            label="文章封面"
            align="center">
          </el-table-column>

          <el-table-column
            label="文章封面"
            align="center">
            <template slot-scope="scope">
              <div ><el-image :src="scope.row.articleCover" class="articleCover" :fit="contain"></el-image></div>

            </template>

          </el-table-column>
          <el-table-column prop="status" label="文章状态" align="center">
          </el-table-column>
          <el-table-column prop="creatTime" label="创建时间" align="center">
          </el-table-column>
<!--          <el-table-column prop="updateTime" label="修改时间" align="center">-->
<!--          </el-table-column>-->
          <el-table-column label="操作" fixed="right" align="center">
            <template slot-scope="scope">
              <el-button type="primary" size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button type="danger" size="small" @click="remove(scope.$index, scope.row)">删除</el-button>

            </template>
          </el-table-column>
        </el-table>
      </el-card>
      <!--弹窗-->
<!--      <el-dialog :title="dialogTitle" width="50%" :visible.sync="iconFormVisible">-->
<!--        <el-form :inline="true" :model="userInfo" class="demo-form-inline">-->
<!--          <el-form-item label="文章标题">-->
<!--            <el-input v-model="userInfo.name" placeholder="姓名"></el-input>-->
<!--          </el-form-item>-->
<!--          <el-form-item label="日期">-->
<!--            <el-input v-model="userInfo.date" placeholder="日期"></el-input>-->
<!--          </el-form-item>-->
<!--          <el-form-item label="地址">-->
<!--            <el-input v-model="userInfo.address" placeholder="地址"></el-input>-->
<!--          </el-form-item>-->
<!--          <el-form-item label="年龄">-->
<!--            <el-input v-model="userInfo.age" placeholder="年龄"></el-input>-->
<!--          </el-form-item>-->
<!--        </el-form>-->
<!--        <div slot="footer" class="dialog-footer">-->
<!--          <el-button @click="iconFormVisible = false">取 消</el-button>-->
<!--          <el-button type="primary" @click="submitUser()">确 定</el-button>-->
<!--        </div>-->
<!--      </el-dialog>-->
    </div>
  </div>


</template>

<script>
import * as userData from '@/style/js/userarticledata'
export default {
  name: "UserManagement",
  data() {
    return {
      iconFormVisible: false,
      userInfo: {},
      dialogTitle: '增加',
      rowIndex: null,
      tableData:[{
        articleTitle: '秋季穿搭',
        articleCover: 'https://static.wixstatic.com/media/94e66f_38d2a055626b40069914b0caf08c25cc~mv2_d_2415_1318_s_2.jpg/v1/fill/w_225,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_38d2a055626b40069914b0caf08c25cc~mv2_d_2415_1318_s_2.jpg',
        status: '正常',
        creatTime: '2022-04-22 13:32:50',

      }, {
        articleTitle: '夏季穿搭',
        articleCover: 'https://static.wixstatic.com/media/94e66f_9a3b0c07ff934e1985f88a7a8d0b5498~mv2.jpg/v1/fill/w_225,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_9a3b0c07ff934e1985f88a7a8d0b5498~mv2.jpg',
        status: '正常',
        creatTime: '2022-04-22 13:32:50',
      }, {
        articleTitle: '冬季穿搭',
        articleCover: 'https://static.wixstatic.com/media/94e66f_585b03ed1f994d018a613dee9bf2ddec~mv2_d_2415_1318_s_2.jpg/v1/fill/w_226,h_160,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/94e66f_585b03ed1f994d018a613dee9bf2ddec~mv2_d_2415_1318_s_2.jpg',
        status: '正常',
        creatTime: '2022-04-22 13:32:50',
      }, {
        articleTitle: '春季穿搭',
        articleCover: 'https://raw.githubusercontent.com/hellolvweibin/Typora/main/%E6%88%AA%E5%B1%8F2022-05-08%20%E4%B8%8A%E5%8D%8810.44.28.png',
        status: '正常',
        creatTime: '2022-04-22 13:32:50',
      }],
    };
  },
  // created() {
  //   this.setTable();
  // },
  methods: {

    // ...mapActions([
    //   'setTable',
    // ]),
    // 增加
    // add() {
    //   this.dialogTitle = '增加';
    //   this.userInfo = {};
    //   this.iconFormVisible = true;
    // },
    // 编辑
    handleEdit(index, row) {
      this.dialogTitle = '编辑';
      this.userInfo = row;
      this.iconFormVisible = true;
      this.rowIndex = index;
    },
    // 弹窗确定
    submitUser() {
      if (this.dialogTitle === '编辑') {
        this.tableData.splice(this.rowIndex, 1, this.userInfo);
        this.iconFormVisible = false;
        return;
      }
      this.tableData.splice(0, 0, this.userInfo);
      this.iconFormVisible = false;
    },
    // 删除
    remove(index, row) {
      this.$confirm(`确定删除${row.name}吗?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'error',
      }).then(() => {
        this.tableData.splice(index, 1);
      });
    },
  },
  // computed: {
  //   ...mapGetters({
  //     tableData: 'gettableData',
  //   }),
  // },
};
</script>

<style scoped>

</style>
