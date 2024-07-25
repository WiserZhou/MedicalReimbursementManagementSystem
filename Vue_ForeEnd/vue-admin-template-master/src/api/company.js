import request from '@/utils/request'

// export function list(page, size) {
//   return request({
//     url: '/companies',
//     method: 'get',
//     params: { page, size }
//   })
// }

export function page(page, size,company_name,company_type) {
  return request({
    url: '/companies?page='+page+'&pageSize='+size+'&companyName='+company_name+'&companyType'+ company_type,
    method: 'get'
  })
}

//添加：测试通过
export function add(company) {
  return request({
    url: '/companies',
    method: 'post',
    data: company
  })
}

export function update(company) {
  return request({
    url: '/companies',
    method: 'put',
    data: company
  })
}

export function deleteById(id) {
  return request({
    url: `/companies/`+ id,
    method: 'delete'
  })
}

export function selectById(id) {
  return request({
    url: `/companies/` + id,
    method: 'get'
  })
}
