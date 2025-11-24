import axios from 'axios';

const LIVE_BACKEND_URL = "https://projectmanagement-5.onrender.com";

export const API_BASE_URL = LIVE_BACKEND_URL;

const api = axios.create({
  baseURL: API_BASE_URL,
});

const token = localStorage.getItem('jwt');

api.defaults.headers.common['Authorization'] = `Bearer ${token}`;
api.defaults.headers.post['Content-Type'] = 'application/json';

export default api;
