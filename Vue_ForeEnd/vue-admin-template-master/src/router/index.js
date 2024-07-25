import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/layout'

// 界面的路由
export const constantRoutes = [

  // 登录
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  // 404
  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  // 首页
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

  // 公共业务
  {
    path: '/publicService',
    component: Layout,
    redirect: '/publicService',
    name: 'PublicService',
    meta: { title: '公共业务', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'unit',
        name: 'Unit',
        component: () => import('@/views/PublicService/unit'),
        meta: { title: '单位基本信息维护 ', icon: 'el-icon-menu' }
      },
      {
        path: 'personal',
        name: 'Personal',
        component: () => import('@/views/PublicService/personal'),
        meta: { title: '个人基本信息维护 ', icon: 'el-icon-user-solid' }
      }
    ]
  },

  // 医疗待遇审批
  {
    path: '/approvalOfMedicalTreatment',
    component: Layout,
    redirect: '/approvalOfMedicalTreatment',
    name: 'ApprovalOfMedicalTreatment',
    meta: { title: '医疗待遇审批', icon: 'el-icon-s-tools' },
    children: [
      {
        path: 'personnelVisitInstitutions',
        name: 'PersonnelVisitInstitutions',
        component: () => import('@/views/ApprovalOfMedicalTreatment/personnelVisitInstitutions'),
        meta: { title: '人员就诊机构审批', icon: 'el-icon-menu' }
      },
      {
        path: 'specialInspectionAndTreatment',
        name: 'SpecialInspectionAndTreatment',
        component: () => import('@/views/ApprovalOfMedicalTreatment/specialInspectionAndTreatment'),
        meta: { title: '特检特治审批', icon: 'el-icon-user-solid' }
      }
    ]
  },
  // 医疗基本信息维护
  {
    path: '/maintenanceOfBasicMedicalInformation',
    component: Layout,
    redirect: '/maintenanceOfBasicMedicalInformation',
    name: 'MaintenanceOfBasicMedicalInformation',
    meta: { title: '医疗基本信息维护', icon: 'el-icon-s-tools' },
    children: [
      {
        path: 'drugInformationMaintenance',
        name: 'DrugInformationMaintenance',
        component: () => import('@/views/MaintenanceOfBasicMedicalInformation/DrugInformationMaintenance'),
        meta: { title: '药品信息维护 ', icon: 'el-icon-s-data' }
      },
      {
        path: 'diagnosisAndTreatmentProjectInformationMaintenance',
        name: 'DiagnosisAndTreatmentProjectInformationMaintenance',
        component: () => import('@/views/MaintenanceOfBasicMedicalInformation/DiagnosisAndTreatmentProjectInformationMaintenance'),
        meta: { title: '诊疗项目信息维护 ', icon: 'el-icon-s-data' }
      },
      {
        path: 'serviceFacilityProjectMaintenance',
        name: 'ServiceFacilityProjectMaintenance',
        component: () => import('@/views/MaintenanceOfBasicMedicalInformation/ServiceFacilityProjectMaintenance/course.vue'),
        meta: { title: '服务设施项目维护', icon: 'el-icon-menu' }
      },
      {
        path: 'InformationOnDesignatedMedicalInstitutions',
        name: 'InformationOnDesignatedMedicalInstitutions',
        component: () => import('@/views/MaintenanceOfBasicMedicalInformation/InformationOnDesignatedMedicalInstitutions/arrangement.vue'),
        meta: { title: '定点医疗机构信息', icon: 'el-icon-date' }
      },
      {
        path: 'ParametersForCalculatingMedicalTreatment',
        name: 'ParametersForCalculatingMedicalTreatment',
        component: () => import('@/views/MaintenanceOfBasicMedicalInformation/InformationOnDesignatedMedicalInstitutions/arrangement.vue'),
        meta: { title: '医疗待遇计算参数', icon: 'el-icon-date' }
      }
    ]
  },
  // 医保中心报销
  {
    path: '/reimbursementByTheHealthInsuranceCenter',
    component: Layout,
    redirect: '/reimbursementByTheHealthInsuranceCenter',
    name: 'ReimbursementByTheHealthInsuranceCenter',
    meta: { title: '医保中心报销 ', icon: 'el-icon-s-management' },
    children: [
      {
        path: 'FinalSystem',
        name: 'FinalSystem',
        component: () => import('@/views/ReimbursementByTheHealthInsuranceCenter/FinalSystem/index.vue'),
        meta: { title: '最终系统', icon: 'el-icon-date' }
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
