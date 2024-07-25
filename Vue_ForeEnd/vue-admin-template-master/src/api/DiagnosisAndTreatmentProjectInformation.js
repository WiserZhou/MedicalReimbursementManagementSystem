import request from '@/utils/request'


export function page(diaId,diaName,page,pageSize) {
  return request({
    url: '/t-diagnosis-project?diaId='+diaId+'&diaName='+diaName+'&page='+page+'&pageSize='+pageSize,
  })
}

export function add(classes) {
  return request({
    url: '/t-diagnosis-project',
    method: 'post',
    data: classes
  })
}

export function update(dept) {
  return request({
    url: '/t-diagnosis-project',
    method: 'put',
    data: dept
  })
}


export function deleteById(id) {
  return request({
    url: '/t-diagnosis-project/'+id,
    method: 'delete',
  })
}


export function selectById(id) {
  return request({
    url: '/t-diagnosis-project/'+id,
    method: 'get',
  })
}

