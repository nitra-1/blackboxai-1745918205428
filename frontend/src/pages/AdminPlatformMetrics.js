import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AdminPlatformMetrics = () => {
  const [metrics, setMetrics] = useState(null);
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetchMetrics();
  }, []);

  const fetchMetrics = async () => {
    try {
      const response = await axios.get('/api/admin/metrics');
      setMetrics(response.data);
    } catch (error) {
      setMessage('Error fetching platform metrics');
    }
  };

  return (
    <div>
      <h2>Platform Metrics</h2>
      {message && <p>{message}</p>}
      {metrics ? (
        <div>
          <p>Total Users: {metrics.totalUsers}</p>
          <p>Total Providers: {metrics.totalProviders}</p>
          <p>Total Services: {metrics.totalServices}</p>
          <p>Total Bookings: {metrics.totalBookings}</p>
          {/* Add more metrics display as needed */}
        </div>
      ) : (
        <p>No metrics available.</p>
      )}
    </div>
  );
};

export default AdminPlatformMetrics;
