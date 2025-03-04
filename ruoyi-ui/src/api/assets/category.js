import request from '@/utils/request'

// 查询资产类别列表
export function listCategory(query) {
  return request({
    url: '/assets/category/list',
    method: 'get',
    params: query
  })
}

// 查询资产类别详细
export function getCategory(id) {
  return request({
    url: '/assets/category/' + id,
    method: 'get'
  })
}

// 新增资产类别
export function addCategory(data) {
  return request({
    url: '/assets/category',
    method: 'post',
    data: data
  })
}

// 修改资产类别
export function updateCategory(data) {
  return request({
    url: '/assets/category',
    method: 'put',
    data: data
  })
}

// 删除资产类别
export function delCategory(id) {
  return request({
    url: '/assets/category/' + id,
    method: 'delete'
  })
}
