import request from '@/utils/request'

// 查询入库列表
export function listStorage(query) {
  return request({
    url: '/assets/storage/list',
    method: 'get',
    params: query
  })
}

// 查询入库详细
export function getStorage(id) {
  return request({
    url: '/assets/storage/' + id,
    method: 'get'
  })
}

// 新增入库
export function addStorage(data) {
  return request({
    url: '/assets/storage',
    method: 'post',
    data: data
  })
}

// 修改入库
export function updateStorage(data) {
  return request({
    url: '/assets/storage',
    method: 'put',
    data: data
  })
}

// 删除入库
export function delStorage(id) {
  return request({
    url: '/assets/storage/' + id,
    method: 'delete'
  })
}
