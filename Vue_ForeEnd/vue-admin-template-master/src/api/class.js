import request from '@/utils/request';

export function findAll() {
  return request({
    url: '/classes',
    method: 'get'
  });
}

export function add(classInfo) {
  return request({
    url: '/classes/add',
    method: 'post',
    data: classInfo
  });
}

export function update(classInfo) {
  return request({
    url: '/classes/update',
    method: 'put',
    data: classInfo
  });
}

export function deleteById(id) {
  return request({
    url: '/classes/delete/' + id,
    method: 'delete'
  });
}

//根据id查询
export function selectById(id) {
  return request({
    url: '/classes/' + id,
    method: 'get'

  });
}
