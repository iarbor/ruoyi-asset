import request from "@/utils/request";

export function addUser(data) {
  return request({
    url: '/assets/person/list',
    method: 'get'
  })
}

export function getDeptAndUserTreeData() {
  return request({
    url: '/assets/person/listTree',
    method: 'get'
  })
}
