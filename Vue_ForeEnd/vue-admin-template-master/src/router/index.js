import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/layout'



//界面的路由
export const constantRoutes = [

  //登录
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  //404
  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  //首页
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'dashboard' }
    }]
  },

//班级学员管理
  {
    path: '/example',
    component: Layout,
    redirect: '/example',
    name: 'Example',
    meta: { title: '模块1', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'classes',
        name: 'Classes',
        component: () => import('@/views/classes'),
        meta: { title: '模块1——1', icon: 'el-icon-menu' }
      },
      {
        path: 'student',
        name: 'Student',
        component: () => import('@/views/student'),
        meta: { title: '模块1——2', icon: 'el-icon-user-solid' }
      }
    ]
  },

//系统信息管理
  {
    path: '/system',
    component: Layout,
    redirect: '/system',
    name: 'System',
    meta: { title: '模块2', icon: 'el-icon-s-tools' },
    children: [
      {
        path: 'dept',
        name: 'Dept',
        component: () => import('@/views/dept'),
        meta: { title: '模块2-1', icon: 'el-icon-menu' }
      },
      {
        path: 'emp',
        name: 'Emp',
        component: () => import('@/views/emp'),
        meta: { title: '模块2-2', icon: 'el-icon-user-solid' }
      }
    ]
  },

//数据统计管理
  {
    path: '/report',
    component: Layout,
    redirect: '/report',
    name: 'Report',
    meta: { title: '模块3', icon: 'el-icon-s-tools' },
    children: [
      {
        path: 'emp-report',
        name: 'emp-report',
        component: () => import('@/views/emp-report'),
        meta: { title: '模块3-1', icon: 'el-icon-s-data' }
      },
      {
        path: 'student-report',
        name: 'student-report',
        component: () => import('@/views/student-report'),
        meta: { title: '模块3-2', icon: 'el-icon-s-data' }
      }
    ]
  },

  //课程管理

  {
    path: '/course',
    component: Layout,
    redirect: '/course/manage',
    name: 'Course',
    meta: { title: '模块4', icon: 'el-icon-s-management' },
    children: [
      {
        path: 'manage',
        name: 'CourseManage',
        component: () => import('@/views/Course/course.vue'),
        meta: { title: '模块4-1', icon: 'el-icon-menu' }
      },
      {
        path: 'schedule',
        name: 'CourseSchedule',
        component: () => import('@/views/Course/arrangement.vue'),
        meta: { title: '模块4-2', icon: 'el-icon-date' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
