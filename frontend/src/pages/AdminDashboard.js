import React, { useEffect, useState } from 'react';
import { fetchPlatformMetrics } from '../api/api';

const AdminDashboard = () => {
  const [metrics, setMetrics] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchPlatformMetrics()
      .then(response => {
        setMetrics(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error('Error fetching platform metrics:', error);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <div>Loading platform metrics...</div>;
  }

  return (
    <div>
      <h1>Admin Dashboard</h1>
      {metrics ? (
        <div>
          <p>Total Traffic: {metrics.traffic}</p>
          <p>Total Listings: {metrics.listings}</p>
          <p>Total Leads: {metrics.leads}</p>
          {/* Add more metrics display as needed */}
        </div>
      ) : (
        <p>No metrics available.</p>
      )}
    </div>
  );
};

export default AdminDashboard;
