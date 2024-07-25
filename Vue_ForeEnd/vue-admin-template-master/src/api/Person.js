import request from '@/utils/request';

// 分页查询
export function page(page, size, personName, personRole) {
  return request({
    url: '/people?page='+page+'&pageSize='+size+'&personName='+personName+'&personRole'+personRole,
    method: 'get',

  });
}

// 添加人员
export function add(person) {
  return request({
    url: '/people',
    method: 'post',
    data: person
  });
}

// 更新人员
export function update(person) {
  return request({
    url: '/people',
    method: 'put',
    data: person
  });
}

// 删除人员
export function deleteById(id) {
  return request({
    url: `/people/${id}`,
    method: 'delete'
  });
}

// 根据ID查询人员
export function selectById(id) {
  return request({
    url: `/people/${id}`,
    method: 'get'
  });
}
