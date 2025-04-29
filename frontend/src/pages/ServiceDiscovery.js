import React, { useEffect, useState } from 'react';
import { fetchServices } from '../api/api';

const ServiceDiscovery = () => {
  const [services, setServices] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchServices()
      .then(response => {
        setServices(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error('Error fetching services:', error);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <div>Loading services...</div>;
  }

  return (
    <div>
      <h1>Service Discovery</h1>
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

export default ServiceDiscovery;
