import request from '@/utils/request'

// 查询存放地点列表
export function listLocation(query) {
  return request({
    url: '/assets/location/list',
    method: 'get',
    params: query
  })
}

// 查询存放地点详细
export function getLocation(id) {
  return request({
    url: '/assets/location/' + id,
    method: 'get'
  })
}

// 新增存放地点
export function addLocation(data) {
  return request({
    url: '/assets/location',
    method: 'post',
    data: data
  })
}

// 修改存放地点
export function updateLocation(data) {
  return request({
    url: '/assets/location',
    method: 'put',
    data: data
  })
}

// 删除存放地点
export function delLocation(id) {
  return request({
    url: '/assets/location/' + id,
    method: 'delete'
  })
}

// 查询下拉框中存放地点的值
export function selectPlaceData() {
  return request({
    url: '/assets/location/selectPlaceData',
    method: 'get',
  })
}
