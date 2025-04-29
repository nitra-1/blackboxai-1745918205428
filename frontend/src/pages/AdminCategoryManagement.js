import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AdminCategoryManagement = () => {
  const [categories, setCategories] = useState([]);
  const [newCategory, setNewCategory] = useState('');
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetchCategories();
  }, []);

  const fetchCategories = async () => {
    try {
      const response = await axios.get('/api/admin/categories');
      setCategories(response.data);
    } catch (error) {
      setMessage('Error fetching categories');
    }
  };

  const addCategory = async () => {
    if (!newCategory) {
      setMessage('Please enter a category name');
      return;
    }
    try {
      await axios.post('/api/admin/categories', { name: newCategory });
      setMessage('Category added');
      setNewCategory('');
      fetchCategories();
    } catch (error) {
      setMessage('Error adding category');
    }
  };

  return (
    <div>
      <h2>Category Management</h2>
      {message && <p>{message}</p>}
      <input
        type="text"
        placeholder="New Category Name"
        value={newCategory}
        onChange={(e) => setNewCategory(e.target.value)}
      />
      <button onClick={addCategory}>Add Category</button>
      <ul>
        {categories.map((cat) => (
          <li key={cat.id}>{cat.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default AdminCategoryManagement;
