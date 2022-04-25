<template>
  <comment :comments="CommentData"></comment>
</template>

<script>
import * as CommentData from '../../style/js/mockdata'
import comment from '../comment/CommentForm'
export default {
  name: "CommentIndex",
  components:{comment},
  data(){
    return {
      CommentData:[],
    }
  },
  created() {
    this.CommentData = CommentData.comment.data
  }
}
</script>

<style scoped>

</style>
