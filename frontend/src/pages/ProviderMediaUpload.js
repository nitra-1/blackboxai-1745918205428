import React, { useState } from 'react';
import axios from 'axios';

const ProviderMediaUpload = () => {
  const [selectedFiles, setSelectedFiles] = useState([]);
  const [serviceId, setServiceId] = useState('');
  const [message, setMessage] = useState('');

  const handleFileChange = (e) => {
    setSelectedFiles(e.target.files);
  };

  const handleUpload = async () => {
    if (!serviceId) {
      setMessage('Please enter service ID');
      return;
    }
    if (selectedFiles.length === 0) {
      setMessage('Please select files to upload');
      return;
    }
    const formData = new FormData();
    formData.append('serviceId', serviceId);
    for (let i = 0; i < selectedFiles.length; i++) {
      formData.append('files', selectedFiles[i]);
    }
    try {
      const response = await axios.post('/api/provider/media/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });
      setMessage(response.data);
    } catch (error) {
      setMessage('Error uploading files');
    }
  };

  return (
    <div>
      <h2>Upload Service Media</h2>
      <input
        type="text"
        placeholder="Service ID"
        value={serviceId}
        onChange={(e) => setServiceId(e.target.value)}
      />
      <input type="file" multiple onChange={handleFileChange} />
      <button onClick={handleUpload}>Upload</button>
      {message && <p>{message}</p>}
    </div>
  );
};

export default ProviderMediaUpload;
