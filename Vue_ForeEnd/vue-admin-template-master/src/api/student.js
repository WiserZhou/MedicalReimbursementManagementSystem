import request from '@/utils/request'

// export function page(name,studentId,classId,education,page,pageSize) {
//   return request({
//     url: '/student?name='+name+'&student='+studentId+'&classId='+classId+'&education='+education+'&page='+page+'&pageSize='+pageSize,
//   })
// }

export function page(name,studentId,classId,education,page,pageSize) {
  return request({
    url: '/student?name='+name+'&studentId='+studentId+'&classId='+classId+'&education='+education+'&page='+page+'&pageSize='+pageSize,
  })
}

export function add(classes) {
  return request({
    url: '/student',
    method: 'post',
    data: classes
  })
}

export function update(dept) {
  return request({
    url: '/student',
    method: 'put',
    data: dept
  })
}


export function deleteById(id) {
  return request({
    url: '/student/'+id,
    method: 'delete',
  })
}


export function selectById(id) {
  return request({
    url: '/student/'+id,
    method: 'get',
  })
}

export function update1(offp,student) {
  return request({
    url: '/student?offp='+offp,
    method: 'put',
    data: student
  })
}