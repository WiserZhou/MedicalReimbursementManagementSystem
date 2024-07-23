// Import necessary API functions
import request from '@/utils/request';

// Get all students
export function getAllStudents() {
  return request({
    url: '/students',
    method: 'get'
  });
}

// 添加学员
export function addStudent(data) {
  return request({
    url: '/students/add',
    method: 'post',
    data
  });
}

//更新学员信息
export function update(data) {
  return request({
    url: '/students/update',
    method: 'put',
    data: data
  })
}

//模糊搜索——学员信息大查询
export function searchStudent(data) {
  return request({
    url: '/students/select',
    method: 'post',
    data
  });
}

// Delete a student by ID
export function deleteStudent(id) {
  return request({
    url: `/students/delete/${id}`,
    method: 'delete'
  });
}

// 违纪处理
export function handleDisciplinary(data) {
  return request({
    url: '/students/disciplinary',
    method: 'put',
    data
  });
}

//获取男女数量、学历统计
export function getStudentStatistics() {
  return request({
    url: '/students/gender_statistics',
    method: 'get'
  });
}
