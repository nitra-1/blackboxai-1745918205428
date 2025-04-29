import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api"; // Adjust backend URL as needed

// Service APIs
export const fetchServices = () => {
  return axios.get(\`\${API_BASE_URL}/services\`);
};

// User APIs
export const userLogin = (credentials) => {
  return axios.post(\`\${API_BASE_URL}/users/login\`, credentials);
};

export const fetchUserFavorites = (userId) => {
  return axios.get(\`\${API_BASE_URL}/users/\${userId}/favorites\`);
};

// Provider APIs
export const fetchProviderServices = (providerId) => {
  return axios.get(\`\${API_BASE_URL}/providers/\${providerId}/services\`);
};

// Admin APIs
export const fetchPlatformMetrics = () => {
  return axios.get(\`\${API_BASE_URL}/admin/metrics\`);
};
