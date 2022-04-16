<template>
  <div class="tinymce-editor">
    <Editor
      v-model="tinymceHtml"
      :id="tinymceId"
      :init="init"
      :disabled="disabled"
    ></Editor>
  </div>
</template>
<script>
import tinymce from "tinymce/tinymce"; //tinymce默认hidden，不引入不显示
import Editor from "@tinymce/tinymce-vue"; //编辑器引入
import "tinymce/themes/silver/theme"; //编辑器主题
import "tinymce/plugins/image"; // 插入上传图片插件
import "tinymce/plugins/media"; // 插入视频插件
import "tinymce/plugins/table"; // 插入表格插件c
import "tinymce/plugins/lists"; // 列表插件
import "tinymce/plugins/wordcount"; // 字数统计插件
import "tinymce/plugins/charmap"; // 特殊字符
import "tinymce/plugins/preview"; // 预览
import "tinymce/plugins/hr"; // 水平线
import "tinymce/plugins/imagetools"; // 图片编辑工具
import "tinymce/plugins/code"; // 编辑源码
import "tinymce/plugins/fullscreen"; // 全屏
import "tinymce/plugins/link"; // 超链接
import "tinymce/plugins/paste"; // 粘贴
import "tinymce/plugins/quickbars"; // 快速工具栏
import "tinymce/plugins/searchreplace"; // 查找替换

export default {
  name:'EditorTest',
  components: {
    Editor
  },
  props: {
    //内容
    value: {
      type: String,
      default: ""
    },
    //是否禁用
    disabled: {
      type: Boolean,
      default: false
    },
    triggerChange: {
      type: Boolean,
      default: false,
      required: false
    },
    //插件
    plugins: {
      type: [String, Array],
      default:
        "print preview importcss  searchreplace autolink autosave save directionality  visualblocks visualchars fullscreen image link media  template codesample table charmap hr pagebreak nonbreaking anchor toc insertdatetime advlist lists  wordcount   imagetools textpattern noneditable help    charmap   quickbars  emoticons code"
    },
    toolbar: {
      type: [String, Array],
      default() {
        return [
          "code | undo redo | bold italic underline strikethrough | fontselect fontsizeselect formatselect | alignleft aligncenter alignright alignjustify | outdent indent |  numlist bullist  | forecolor backcolor casechange   removeformat | pagebreak | charmap emoticons | fullscreen  preview save print | insertfile image media  template link anchor codesample | a11ycheck ltr rtl | showcomments addcomment "
        ];
      }
    }
  },
  data() {
    return {
      //初始化配置
      tinymceHtml: "请输入内容",
      tinymceId: "tinymce",
      myValue: this.value,
      mytinymce: tinymce,
      init: {
        images_upload_url: "/demo/upimg.php",//这两行是更改只能上传图片路径的方法，变成可以拖拉上传（此处路径为后端需要上传图片的路径）
        images_upload_base_path: "/demo",//这两行是更改只能上传图片路径的方法，变成可以拖拉上传
        selector: "#tinymce",
        skin_url: "../../static/tinymce/skins/ui/oxide",//自己的static中路径
        content_css: "../../static/tinymce/skins/content/default/content.css",//自己的static中路径
        content_style: "img {max-width:100%;}",//限制图片大小
        plugins: this.plugins, //插件
        menubar: false,//此处设置为false为默认不显示菜单栏，如果需要展示出来可以将此行注释
        //工具栏
        toolbar: this.toolbar,
        height: 500, //高度
        branding: false, //隐藏右下角技术支持
        paste_preprocess: function(plugin, args) {
          console.log(args.content);
        },
        paste_as_text: true,
        //init_instance_callback为回调配置项
        init_instance_callback: editor => {
          // console.log(`回调----`)
          editor.on("input", e => {
            // console.log('文本框input触发')
            this.$emit("input", e.target.innerHTML);
          });
          editor.on("change", e => {
            // console.log('文本框change触发')
            this.$emit("change", e.level.content);
          });
        }
      }
    };
  },
  mounted() {
    tinymce.init({});//初始化编辑器
  },
  methods: {}
};
</script>
<style scoped>
.tox-dialog {
  z-index: 10000;
}
.tox-dialog--width-lg {
  z-index: 10000;
}
</style>

