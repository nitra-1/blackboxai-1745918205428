import React, { useEffect, useState } from "react";
import axios from "axios";

const ProviderAnalytics = () => {
  const [providerId, setProviderId] = useState("");
  const [analytics, setAnalytics] = useState(null);
  const [message, setMessage] = useState("");

  const fetchAnalytics = async () => {
    if (!providerId) {
      setMessage("Please enter provider ID");
      return;
    }
    try {
      const response = await axios.get(`/api/providers/${providerId}/analytics`);
      setAnalytics(response.data);
      setMessage("");
    } catch (error) {
      setMessage("Error fetching analytics");
    }
  };

  return (
    <div>
      <h2>Provider Analytics</h2>
      <input
        type="text"
        placeholder="Provider ID"
        value={providerId}
        onChange={(e) => setProviderId(e.target.value)}
      />
      <button onClick={fetchAnalytics}>Load Analytics</button>
      {message && <p>{message}</p>}
      {analytics && (
        <div>
          <p>Total Views: {analytics.totalViews}</p>
          <p>Total Leads: {analytics.totalLeads}</p>
          <p>Total Bookings: {analytics.totalBookings}</p>
          {/* Add more analytics display as needed */}
        </div>
      )}
    </div>
  );
};

export default ProviderAnalytics;
