import request from '@/utils/request'

// 查询资产流转列表
export function listTransfer(query) {
  return request({
    url: '/assets/transfer/list',
    method: 'get',
    params: query
  })
}

// 查询资产流转详细
export function getTransfer(id) {
  return request({
    url: '/assets/transfer/' + id,
    method: 'get'
  })
}

// 新增资产流转
export function addTransfer(data) {
  return request({
    url: '/assets/transfer',
    method: 'post',
    data: data
  })
}

// 修改资产流转
export function updateTransfer(data) {
  return request({
    url: '/assets/transfer',
    method: 'put',
    data: data
  })
}

// 删除资产流转
export function delTransfer(id) {
  return request({
    url: '/assets/transfer/' + id,
    method: 'delete'
  })
}
