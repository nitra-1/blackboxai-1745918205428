import React, { useEffect, useState } from "react";
import axios from "axios";

const AdminModeration = () => {
  const [listings, setListings] = useState([]);
  const [reviews, setReviews] = useState([]);
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetchListings();
    fetchReviews();
  }, []);

  const fetchListings = async () => {
    try {
      const response = await axios.get("/api/admin/listings/pending");
      setListings(response.data);
    } catch (error) {
      setMessage("Error fetching listings");
    }
  };

  const fetchReviews = async () => {
    try {
      const response = await axios.get("/api/admin/reviews/pending");
      setReviews(response.data);
    } catch (error) {
      setMessage("Error fetching reviews");
    }
  };

  const approveListing = async (id) => {
    try {
      await axios.post(`/api/admin/services/${id}/approve`);
      setMessage("Listing approved");
      fetchListings();
    } catch (error) {
      setMessage("Error approving listing");
    }
  };

  const rejectListing = async (id) => {
    try {
      await axios.post(`/api/admin/services/${id}/reject`);
      setMessage("Listing rejected");
      fetchListings();
    } catch (error) {
      setMessage("Error rejecting listing");
    }
  };

  const moderateReview = async (id, approved) => {
    try {
      await axios.post(`/api/admin/reviews/${id}/moderate?approved=${approved}`);
      setMessage("Review moderated");
      fetchReviews();
    } catch (error) {
      setMessage("Error moderating review");
    }
  };

  return (
    <div>
      <h2>Admin Moderation</h2>
      {message && <p>{message}</p>}

      <h3>Pending Listings</h3>
      <ul>
        {listings.map((listing) => (
          <li key={listing.id}>
            {listing.title} - {listing.description}
            <button onClick={() => approveListing(listing.id)}>Approve</button>
            <button onClick={() => rejectListing(listing.id)}>Reject</button>
          </li>
        ))}
      </ul>

      <h3>Pending Reviews</h3>
      <ul>
        {reviews.map((review) => (
          <li key={review.id}>
            {review.comment} - Rating: {review.rating}
            <button onClick={() => moderateReview(review.id, true)}>Approve</button>
            <button onClick={() => moderateReview(review.id, false)}>Reject</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AdminModeration;
