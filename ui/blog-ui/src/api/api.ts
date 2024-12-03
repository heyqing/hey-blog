import axios from 'axios'

const BASE_URL = 'http://localhost:8080/'

export default {
  getTopAndFeaturedArticles: () => {
    return axios.get(`${BASE_URL}articles/topAndFeatured`)
  },
  getArticles: (params: any) => {
    return axios.get(`${BASE_URL}articles/all`, { params: params })
  },
  getArticlesByCategoryId: (params: any) => {
    return axios.get(`${BASE_URL}articles/categoryId`, { params: params })
  },
  getArticeById: (articleId: any) => {
    return axios.get(`${BASE_URL}articles/${articleId}`)
  },
  getAllCategories: () => {
    return axios.get(`${BASE_URL}categories/all`)
  },
  getAllTags: () => {
    return axios.get(`${BASE_URL}tags/all`)
  },
  getTopTenTags: () => {
    return axios.get(`${BASE_URL}tags/topTen`)
  },
  getArticlesByTagId: (params: any) => {
    return axios.get(`${BASE_URL}articles/tagId`, { params: params })
  },
  getAllArchives: (params: any) => {
    return axios.get(`${BASE_URL}archives/all`, { params: params })
  },
  login: (params: any) => {
    return axios.post(`${BASE_URL}users/login`, params)
  },
  saveComment: (params: any) => {
    return axios.post(`${BASE_URL}comments/save`, params)
  },
  getComments: (params: any) => {
    return axios.get(`${BASE_URL}comments`, { params: params })
  },
  getTopSixComments: () => {
    return axios.get(`${BASE_URL}comments/topSix`)
  },
  getAbout: () => {
    return axios.get(`${BASE_URL}about`)
  },
  getFriendLink: () => {
    return axios.get(`${BASE_URL}links`)
  },
  submitUserInfo: (params: any) => {
    return axios.put(`${BASE_URL}users/info`, params)
  },
  getUserInfoById: (id: any) => {
    return axios.get(`${BASE_URL}users/info/${id}`)
  },
  updateUserSubscribe: (params: any) => {
    return axios.put(`${BASE_URL}users/subscribe`, params)
  },
  sendValidationCode: (username: any) => {
    return axios.get(`${BASE_URL}users/code`, {
      params: {
        username: username
      }
    })
  },
  bindingEmail: (params: any) => {
    return axios.put(`${BASE_URL}users/email`, params)
  },
  register: (params: any) => {
    return axios.post(`${BASE_URL}users/register`, params)
  },
  searchArticles: (params: any) => {
    return axios.get(`${BASE_URL}articles/search`, {
      params: params
    })
  },
  getAlbums: () => {
    return axios.get(`${BASE_URL}photos/albums`)
  },
  getPhotosBuAlbumId: (albumId: any, params: any) => {
    return axios.get(`${BASE_URL}albums/${albumId}/photos`, {
      params: params
    })
  },
  getWebsiteConfig: () => {
    return axios.get(`${BASE_URL}`)
  },
  qqLogin: (params: any) => {
    return axios.post(`${BASE_URL}users/oauth/qq`, params)
  },
  report: () => {
    axios.post(`${BASE_URL}report`)
  },
  getTalks: (params: any) => {
    return axios.get(`${BASE_URL}talks`, {
      params: params
    })
  },
  getTalkById: (id: any) => {
    return axios.get(`${BASE_URL}talks/${id}`)
  },
  logout: () => {
    return axios.post(`${BASE_URL}users/logout`)
  },
  getRepliesByCommentId: (commentId: any) => {
    return axios.get(`${BASE_URL}comments/${commentId}/replies`)
  },
  updatePassword: (params: any) => {
    return axios.put(`${BASE_URL}users/password`, params)
  },
  accessArticle: (params: any) => {
    return axios.post(`${BASE_URL}articles/access`, params)
  }
}
