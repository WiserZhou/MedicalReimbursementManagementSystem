import request from '@/utils/request';


//查询全部
export function findAll() {
  return request({
    url: '/courses',
    method: 'get'
  });
}


//新增课程
export function add(classInfo) {
  return request({
    url: '/courses/add',
    method: 'post',
    data: classInfo
  });
}

//更新课程
export function update(classInfo) {
  return request({
    url: '/courses/update',
    method: 'put',
    data: classInfo
  });
}

//删除课程
export function deleteById(id) {
  return request({
    url: '/courses/delete/' + id,
    method: 'delete'
  });
}


//TODO
export function selectById(id) {
  return request({
    url: '/courses/' + id,
    method: 'get'
  });
}
