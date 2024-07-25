import request from '@/utils/request'

// export function list(page, size) {
//   return request({
//     url: '/companies',
//     method: 'get',
//     params: { page, size }
//   })
// }

export function page(page, size, person_ID) {
  return request({
    url: '/special?page=' + page + '&pageSize=' + size + '&personID=' + person_ID,
    method: 'get'
  })
}

//添加：测试通过
export function add(company) {
  return request({
    url: '/special',
    method: 'post',
    data: company
  })
}

export function update(company) {
  return request({
    url: '/special',
    method: 'put',
    data: company
  })
}

export function deleteById(id) {
  return request({
    url: `/special/` + id,
    method: 'delete'
  })
}

export function selectById(id) {
  return request({
    url: `/special/` + id,
    method: 'get'
  })
}
