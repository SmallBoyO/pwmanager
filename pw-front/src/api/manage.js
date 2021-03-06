import {axios,baseurl} from '../api/api.js'
import qs from 'qs';

export const getAccountByPage = (params) => {
  return axios.post(baseurl+`/list_account_bypage`, qs.stringify(params))
    .then(res => res.data)
}
export const addAccount = (params) => {
  return axios.post(baseurl+`/add_account`, qs.stringify(params))
    .then(res => res.data)
}
export const updateAccount = (params) => {
  return axios.post(baseurl+`/update_account`, qs.stringify(params))
    .then(res => res.data)
}

export const checkRoleName = (params) => {
  return axios.post(baseurl+`/ajax/roleManager/checkRoleName`, qs.stringify(params))
    .then(res => res.data)
}

export const getRight = (params) => {
  return axios.post(baseurl+`/ajax/getRight`,qs.stringify(params))
    .then(res => res.data)
}

export const getAllRight = (params) => {
  return axios.post(baseurl+`/ajax/getAllRight`,qs.stringify(params))
    .then(res => res.data)
}

export const getRolePermission = (params) => {
  return axios.post(baseurl+`/ajax/roleManager/getRolePermission`,qs.stringify(params))
    .then(res => res.data)
}

export const roleList = (params) => {
  return axios.post(baseurl+`/ajax/roleManager/roleList`,qs.stringify(params))
    .then(res => res.data)
}

export const addRole = (params) => {
  return axios.post(baseurl+`/ajax/roleManager/addRole`,qs.stringify(params))
    .then(res => res.data)
}

export const editRole = (params) => {
  return axios.post(baseurl+`/ajax/roleManager/editRole`,qs.stringify(params))
    .then(res => res.data)
}
