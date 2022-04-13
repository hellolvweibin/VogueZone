import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import AppIndex from '@/components/home/AppIndex'
import Login from '@/components/Login'
import Register from "@/components/Register";
import ArticleIndex from "@/components/article/ArticleIndex";
import Model from "@/components/article/module/Model";
import Hot from "@/components/article/module/Hot";
import Recommend from "@/components/article/module/Recommend";
import Idea from "@/components/article/module/Idea";
import ArticleEditor from "@/components/article/article/ArticleEditor";
import ForumIndex from "@/components/forum/ForumIndex";
// import MyEditor from "@/components/wangEditor/MyEditor";
Vue.use(Router)

export default new Router({
  //去掉路由中的#
  mode: 'history',
  routes: [
    // 下面都是固定的写法
    {
      path: '/',
      name:AppIndex,
      component: AppIndex,
    },
    {
      path: '/register',
      name:Register,
      component: Register,
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    // {
    //   path: '/myeditor',
    //   name: 'MyEditor',
    //   component: MyEditor
    // },
    {
      path: '/index',
      name: 'AppIndex',
      component: AppIndex,

    },
    {
      path:'/forum',
      name:'ForumIndex',
      component:ForumIndex
    },
    {
      path:'/article/edit',
      name:ArticleEditor,
      component:ArticleEditor
    },

    {
      path:'/article',
      name:'Article',
      component:ArticleIndex,
      children:[
        {
          path:'/models',
          name:'Model',
          component:Model
        },
        {
          path:'/hot',
          name:'Hot',
          component:Hot
        },
        {
          path:'/recommend',
          name:'Recommend',
          component:Recommend
        },
        {
          path:'/idea',
          name:'Idea',
          component:Idea
        },
      ]
    },
    {
      path:'*',
      redirect:'/index'
    }

  ]
})

