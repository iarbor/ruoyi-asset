import request from '@/utils/request'

// 查询库存清单列表
export function listStock(query) {
  return request({
    url: '/assets/stock/list',
    method: 'get',
    params: query
  })
}

// 查询库存清单详细
export function getStock(id) {
  return request({
    url: '/assets/stock/' + id,
    method: 'get'
  })
}

// 查询未借出库存清单详细
export function getCategoryAndStockTreeList4Borrow() {
  return request({
    url: '/assets/stock/list4Borrow',
    method: 'get'
  })
}

// 查询已经借出清单详细
export function getCategoryAndStockTreeList4Return() {
  return request({
    url: '/assets/stock/list4Return',
    method: 'get'
  })
}

// 新增库存清单
export function addStock(data) {
  return request({
    url: '/assets/stock',
    method: 'post',
    data: data
  })
}

// 修改库存清单
export function updateStock(data) {
  return request({
    url: '/assets/stock',
    method: 'put',
    data: data
  })
}

// 删除库存清单
export function delStock(id) {
  return request({
    url: '/assets/stock/' + id,
    method: 'delete'
  })
}
