import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AdminPromotions = () => {
  const [promotions, setPromotions] = useState([]);
  const [newPromotion, setNewPromotion] = useState({ title: '', description: '', discount: 0 });
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetchPromotions();
  }, []);

  const fetchPromotions = async () => {
    try {
      const response = await axios.get('/api/admin/promotions');
      setPromotions(response.data);
    } catch (error) {
      setMessage('Error fetching promotions');
    }
  };

  const addPromotion = async () => {
    if (!newPromotion.title || !newPromotion.description) {
      setMessage('Please enter all promotion details');
      return;
    }
    try {
      await axios.post('/api/admin/promotions', newPromotion);
      setMessage('Promotion added');
      setNewPromotion({ title: '', description: '', discount: 0 });
      fetchPromotions();
    } catch (error) {
      setMessage('Error adding promotion');
    }
  };

  return (
    <div>
      <h2>Promotions Management</h2>
      {message && <p>{message}</p>}
      <input
        type="text"
        placeholder="Title"
        value={newPromotion.title}
        onChange={(e) => setNewPromotion({ ...newPromotion, title: e.target.value })}
      />
      <input
        type="text"
        placeholder="Description"
        value={newPromotion.description}
        onChange={(e) => setNewPromotion({ ...newPromotion, description: e.target.value })}
      />
      <input
        type="number"
        placeholder="Discount (%)"
        value={newPromotion.discount}
        onChange={(e) => setNewPromotion({ ...newPromotion, discount: Number(e.target.value) })}
      />
      <button onClick={addPromotion}>Add Promotion</button>
      <ul>
        {promotions.map((promo) => (
          <li key={promo.id}>
            {promo.title} - {promo.description} - {promo.discount}%
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AdminPromotions;
