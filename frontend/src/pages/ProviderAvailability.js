import React, { useEffect, useState } from "react";
import axios from "axios";

const ProviderAvailability = () => {
  const [serviceId, setServiceId] = useState("");
  const [availability, setAvailability] = useState([]);
  const [newDate, setNewDate] = useState("");
  const [newAvailable, setNewAvailable] = useState(true);
  const [message, setMessage] = useState("");

  const fetchAvailability = async () => {
    if (!serviceId) {
      setMessage("Please enter service ID");
      return;
    }
    try {
      const response = await axios.get(`/api/availability/service/${serviceId}`);
      setAvailability(response.data);
      setMessage("");
    } catch (error) {
      setMessage("Error fetching availability");
    }
  };

  const addAvailability = async () => {
    if (!serviceId || !newDate) {
      setMessage("Please enter service ID and date");
      return;
    }
    try {
      await axios.post("/api/availability", {
        service: { id: serviceId },
        availableDate: newDate,
        available: newAvailable,
      });
      setMessage("Availability updated");
      fetchAvailability();
    } catch (error) {
      setMessage("Error updating availability");
    }
  };

  return (
    <div>
      <h2>Manage Availability</h2>
      <input
        type="text"
        placeholder="Service ID"
        value={serviceId}
        onChange={(e) => setServiceId(e.target.value)}
      />
      <button onClick={fetchAvailability}>Load Availability</button>
      <ul>
        {availability.map((item) => (
          <li key={item.id}>
            {item.availableDate} - {item.available ? "Available" : "Unavailable"}
          </li>
        ))}
      </ul>
      <h3>Add / Update Availability</h3>
      <input
        type="date"
        value={newDate}
        onChange={(e) => setNewDate(e.target.value)}
      />
      <select
        value={newAvailable}
        onChange={(e) => setNewAvailable(e.target.value === "true")}
      >
        <option value="true">Available</option>
        <option value="false">Unavailable</option>
      </select>
      <button onClick={addAvailability}>Save</button>
      {message && <p>{message}</p>}
    </div>
  );
};

export default ProviderAvailability;
