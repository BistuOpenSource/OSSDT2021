import Vue from 'vue'
import VueRouter from 'vue-router'
import bookManage from "../views/bookManage";
import AddBook from "../views/AddBook";
import BookUpdate from "../views/BookUpdate"
import Index from "../views/Index"


Vue.use(VueRouter)

const routes = [
  {
    path:"/",
    name:"图书管理",
    redirect: '/bookManage',
    show: true,
    component:Index,
    children: [
      {
        path: "/bookManage",
        name: "查询书籍",
        show: true,
        component: bookManage
      },
      {
        path: "/AddBook",
        name:"添加图书",
        show: true,
        component: AddBook
      },
      {
        path: '/update',
        name: "图书修改",
        show: false,
        component: BookUpdate
      }

    ],
  },




]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
