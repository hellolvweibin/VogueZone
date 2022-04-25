<template>
  <comment :comments="commentData"></comment>
</template>

<script>
import * as CommentData from '../../style/js/mockdata'
import comment from '../'
export default {
  name: "CommentIndex",
  components:{comment}
}
</script>

<style scoped>

</style>
