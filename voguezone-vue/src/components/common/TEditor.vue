<template>
  <div class="tinymce-editor">
    <Editor
      :id="tinymceId"
      :init="init"
      :disabled="disabled"
      v-model="myValue"
      @onClick="onClick"
    ></Editor>
  </div>
</template>

<script>
import axios from "axios";
import tinymce from 'tinymce/tinymce' //tinymce默认hidden，不引入不显示
import Editor from '@tinymce/tinymce-vue'//编辑器引入
import 'tinymce/themes/silver/theme'//编辑器主题
import 'tinymce/icons/default'  //引入编辑器图标icon，不引入则不显示对应图标
// 引入编辑器
import 'tinymce/plugins/advlist'  //高级列表
import 'tinymce/plugins/autolink'  //自动链接
import 'tinymce/plugins/link'  //超链接
import 'tinymce/plugins/image'  //插入编辑图片
import 'tinymce/plugins/lists' //列表插件
import 'tinymce/plugins/charmap'  //特殊字符
import 'tinymce/plugins/media' //插入编辑媒体
import 'tinymce/plugins/wordcount'// 字数统计
import Cookies from "js-cookie";

const fonts = [
  "宋体=宋体",
  "微软雅黑=微软雅黑",
  "新宋体=新宋体",
  "黑体=黑体",
  "楷体=楷体",
  "隶书=隶书",
  "Courier New=courier new,courier",
  "AkrutiKndPadmini=Akpdmi-n",
  "Andale Mono=andale mono,times",
  "Arial=arial,helvetica,sans-serif",
  "Arial Black=arial black,avant garde",
  "Book Antiqua=book antiqua,palatino",
  "Comic Sans MS=comic sans ms,sans-serif",
  "Courier New=courier new,courier",
  "Georgia=georgia,palatino",
  "Helvetica=helvetica",
  "Impact=impact,chicago",
  "Symbol=symbol",
  "Tahoma=tahoma,arial,helvetica,sans-serif",
  "Terminal=terminal,monaco",
  "Times New Roman=times new roman,times",
  "Trebuchet MS=trebuchet ms,geneva",
  "Verdana=verdana,geneva",
  "Webdings=webdings",
  "Wingdings=wingdings,zapf dingbats"
];
export default {
  name:'TEditor',
  components: {
    Editor
  },
  props: {
    //内容
    value: {
      type: String,
      default: ''
    },
    //是否禁用
    disabled: {
      type: Boolean,
      default: false
    },
    //插件
    plugins: {
      type: [String, Array],
      default: 'advlist autolink link image lists charmap  media wordcount'
    },
    //工具栏
    toolbar: {
      type: [String, Array],
      default: 'undo redo |  formatselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | lists image media table'
    }
  },
  data() {
    return {
      //初始化配置
      tinymceId: 'tinymce',
      myValue :this.value,
      init: {
        selector: '#tinymce',
        language_url: '../../../static/tinymce/langs/zh_CN.js',//汉化路径是自定义的，一般放在public或static里面
        language: 'zh_CN',
        skin_url: '../../../static/tinymce/skins/ui/oxide',//皮肤
        plugins: this.plugins,//插件
        //工具栏
        toolbar: this.toolbar,
        toolbar_location: '/',
        fontsize_formats: '12px 14px 16px 18px 20px 22px 24px 28px 32px 36px 48px 56px 72px',  //字体大小
        font_formats: fonts.join(";"),

        height: 500,//高度
        placeholder: '在这里输入文字',

        branding: false,//隐藏右下角技术支持
        //图片上传
        images_upload_handler: function (blobInfo, success, failure) {
          //文件上传的formData传递，忘记为什么要用这个了
          const isAccord = blobInfo.blob().type === 'image/jpeg' || blobInfo.blob().type === 'image/png' || blobInfo.blob().type === 'image/GIF' || blobInfo.blob().type === 'image/jpg' || blobInfo.blob().type === 'image/BMP';
          if (blobInfo.blob().size/1024/1024>2) {
            failure("上传失败，图片大小请控制在 2M 以内")
          } else if (blobInfo.blob().type === isAccord) {
            failure('图片格式错误')
          } else {
            let formData = new FormData()
            // 服务端接收文件的参数名，文件数据，文件名
            formData.append('file', blobInfo.blob(), blobInfo.filename())
            axios({
              method: 'POST',
              headers: {
                Authorization: 'bearer ' + Cookies.get('access_token')
              },
              // 这里是你的上传地址
              url:  window.SITE_CONFIG['apiURL'] + '/oss/file/upload',
              data: formData,
            }).then((res) => {
              console.log(res)
              // 这里返回的是你图片的地址
              success(res.data.data.url)
            }).catch(() => {
              failure('上传失败')
            })
          }
        }
      }
    }
  },
  watch: {
    //监听内容变化
    value(newValue) {
      this.myValue = (newValue == null ? '' : newValue)
    },
    myValue (newValue) {
      if(this.triggerChange){
        this.$emit('change', newValue)
      }else{
        this.$emit('input', newValue)
      }
    }
  },
  mounted () {
    tinymce.init({})
    // console.log(this.toolbar,'======')
  },
  methods: {
    onClick(e) {
      this.$emit('onClick', e, tinymce)
    },
    //可以添加一些自己的自定义事件，如清空内容
    clear() {
      this.myValue = ''
    }
  }
}
</script>
