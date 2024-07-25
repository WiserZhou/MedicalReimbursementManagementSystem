import request from '@/utils/request'


export function page(medId,medName,page,pageSize) {
  return request({
    url: '/t-medicine?medId='+medId+'&medName='+medName+'&page='+page+'&pageSize='+pageSize,
  })
}

// export function page(name,studentId,classId,education,page,pageSize) {
//   return request({
//     url: '/student?name='+name+'&studentId='+studentId+'&classId='+classId+'&education='+education+'&page='+page+'&pageSize='+pageSize,
//   })
// }

export function add(classes) {
  return request({
    url: '/t-medicine',
    method: 'post',
    data: classes
  })
}

export function update(dept) {
  return request({
    url: '/t-medicine',
    method: 'put',
    data: dept
  })
}


export function deleteById(id) {
  return request({
    url: '/t-medicine/'+id,
    method: 'delete',
  })
}


export function selectById(id) {
  return request({
    url: '/t-medicine/'+id,
    method: 'get',
  })
}

