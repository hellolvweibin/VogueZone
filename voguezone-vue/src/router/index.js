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
import ArticleEditor from "@/components/article/ArticleEditor";
import ForumIndex from "@/components/forum/ForumIndex";
import ArticleDetails from "@/components/article/ArticleDetails";
// import MyEditor from "@/components/wangEditor/MyEditor";
import CommentIndex from "@/components/comment/CommentIndex"
Vue.use(Router)

export default new Router({
  //去掉路由中的#
  mode: 'history',
  routes: [
    // 下面都是固定的写法
    //首页
    {
      path: '/',
      name:AppIndex,
      component: AppIndex,
    },
    //注册
    {
      path: '/register',
      name:Register,
      component: Register,
    },
    //登录
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/comment',
      name: 'CommentIndex',
      component: CommentIndex
    },
    {
      path: '/index',
      name: 'AppIndex',
      component: AppIndex,

    },
    {
      path:'/forum',
      name:'ForumIndex',
      component:ForumIndex,

    },
    {
      path:'/user',
      name:'UserIndex',
      component:()=> import('@/components/user/UserIndex'),
      //路由元信息
      meta:{
        title:'用户页面'

      },
      children:[
        {
          path:'/user/mypost',
          name:'UserPost',
          component:()=> import('@/components/user/UserPost'),
        },
        {
          path:'/user/myalbum',
          name:'UserAlbum',
          component:()=> import('@/components/user/UserAlbum'),
        },
        {
          path:'/user/mylike',
          name:'UserLike',
          component:()=> import('@/components/user/UserLike'),
        },
        {
          path:'/user/mycollect',
          name:'UserCollect',
          component:()=> import('@/components/user/UserCollect'),
        },

      ]


    },
    //用户中心
    {
      path:'/user/settings',
      name:'UserProfile',
      component:()=> import('@/components/user/UserSettings'),
      children:[
        {
          path:'/user/settings/profiles',
          name:'UserProfiles',
          component:()=> import('@/components/user/settings/UserProfiles'),
        },
        {
          path:'/user/settings/auth',
          name:'UserAuth',
          component:()=> import('@/components/user/settings/UserAuth'),
        },
        {
          path:'/user/settings/postmanage',
          name:'UserPostManagement',
          component:()=> import('@/components/user/settings/UserPostManagement'),
        },


      ]

    },
    {
      path:'/forum/article',
      name:'ArticleDetails',
      component:ArticleDetails
    },
    {
      path:'/article/edit',
      name:ArticleEditor,
      component:ArticleEditor
    },
    {
      path:'/article/comment',
      name:CommentIndex,
      component:CommentIndex
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
    //访问失败重定向位置
    {
      path: '*',
      component: () => import('../components/error/Error404')
    }

  ]
})

