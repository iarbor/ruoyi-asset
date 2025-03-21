import request from '@/utils/request'

// 查询获取方式列表
export function listObtain(query) {
  return request({
    url: '/assets/obtain/list',
    method: 'get',
    params: query
  })
}

// 查询获取方式详细
export function getObtain(id) {
  return request({
    url: '/assets/obtain/' + id,
    method: 'get'
  })
}

// 新增获取方式
export function addObtain(data) {
  return request({
    url: '/assets/obtain',
    method: 'post',
    data: data
  })
}

// 修改获取方式
export function updateObtain(data) {
  return request({
    url: '/assets/obtain',
    method: 'put',
    data: data
  })
}

// 删除获取方式
export function delObtain(id) {
  return request({
    url: '/assets/obtain/' + id,
    method: 'delete'
  })
}
