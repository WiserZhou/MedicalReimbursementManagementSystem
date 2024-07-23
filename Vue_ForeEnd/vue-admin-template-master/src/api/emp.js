import request from '@/utils/request'


//搜索
export function page(name,gender,begin,end,page,pageSize) {
  return request({
    url: '/emps?name='+name+'&gender='+gender+'&begin='+begin+'&end='+end+'&page='+page+'&pageSize='+pageSize,
    method: 'get'
  })
}

//添加
export function add(emp) {
  return request({
    url: '/emps',
    method: 'post',
    data: emp
  })
}

//编辑
export function update(dept) {
  return request({
    url: '/emps',
    method: 'put',
    data: dept
  })
}

//根据id删除
export function deleteById(id) {
  return request({
    url: '/emps/'+id,
    method: 'delete',
  })
}

//根据id查询
export function selectById(id) {
  return request({
    url: '/emps/'+id,
    method: 'get',
  })
}

//获取员工男女数量、职介统计数量
export function getEMPStatistics() {
  return request({
    url: '/employees/gender_job_statistics',
    method: 'get'
  });
}

