import React, { useEffect, useState } from 'react';
import { fetchProviderServices } from '../api/api';

const ProviderDashboard = () => {
  const [services, setServices] = useState([]);
  const [loading, setLoading] = useState(true);
  const providerId = 1; // Replace with actual provider ID from auth context or props

  useEffect(() => {
    fetchProviderServices(providerId)
      .then(response => {
        setServices(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error('Error fetching provider services:', error);
        setLoading(false);
      });
  }, [providerId]);

  if (loading) {
    return <div>Loading your services...</div>;
  }

  return (
    <div>
      <h1>Provider Dashboard</h1>
      <ul>
        {services.map(service => (
          <li key={service.id}>
            <h3>{service.title}</h3>
            <p>{service.description}</p>
            <p>Category: {service.category}</p>
            <p>Price per day: ${service.pricePerDay}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProviderDashboard;
