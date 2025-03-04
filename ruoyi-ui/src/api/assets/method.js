import request from '@/utils/request'

// 查询取得方式列表
export function listMethod(query) {
  return request({
    url: '/assets/method/list',
    method: 'get',
    params: query
  })
}

// 查询取得方式详细
export function getMethod(id) {
  return request({
    url: '/assets/method/' + id,
    method: 'get'
  })
}

// 新增取得方式
export function addMethod(data) {
  return request({
    url: '/assets/method',
    method: 'post',
    data: data
  })
}

// 修改取得方式
export function updateMethod(data) {
  return request({
    url: '/assets/method',
    method: 'put',
    data: data
  })
}

// 删除取得方式
export function delMethod(id) {
  return request({
    url: '/assets/method/' + id,
    method: 'delete'
  })
}
