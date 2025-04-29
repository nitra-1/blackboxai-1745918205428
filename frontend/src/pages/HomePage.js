import React from 'react';

const HomePage = () => {
  return (
    <div>
      <header style={{ backgroundColor: '#0b3d3b', color: 'white', padding: '1rem 2rem', display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
        <div>
          <img src="/logo.png" alt="UrboLease Logo" style={{ height: '48px' }} />
        </div>
        <nav>
          <a href="#how-it-works" style={{ color: 'white', marginLeft: '2rem', textDecoration: 'none', fontWeight: 500 }}>How It Works</a>
          <a href="#features" style={{ color: 'white', marginLeft: '2rem', textDecoration: 'none', fontWeight: 500 }}>Features</a>
          <a href="#contact" style={{ color: 'white', marginLeft: '2rem', textDecoration: 'none', fontWeight: 500 }}>Contact</a>
        </nav>
      </header>

      <section style={{ backgroundColor: '#e9f1f1', padding: '4rem 2rem', textAlign: 'center' }}>
        <h1 style={{ fontSize: '3rem', marginBottom: '1rem', color: '#0b3d3b' }}>Find Anything on Lease – All in One Place</h1>
        <p style={{ fontSize: '1.2rem', marginBottom: '2rem' }}>From cars and cameras to equipment and buildings, UrboLease connects you to leasing services with ease.</p>
        <button style={{ padding: '1rem 2rem', backgroundColor: '#0b3d3b', color: 'white', border: 'none', borderRadius: '8px', fontSize: '1rem', cursor: 'pointer' }}>Explore Listings</button>
      </section>

      <section id="features" style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(250px, 1fr))', gap: '2rem', padding: '4rem 2rem' }}>
        <div style={{ backgroundColor: 'white', borderRadius: '12px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)', padding: '2rem', textAlign: 'center' }}>
          <img src="https://img.icons8.com/ios-filled/50/0b3d3b/car.png" alt="Vehicles" />
          <h3 style={{ marginTop: '1rem', color: '#0b3d3b' }}>Vehicles</h3>
          <p>Lease cars, trucks, and bikes for personal or business use.</p>
        </div>
        <div style={{ backgroundColor: 'white', borderRadius: '12px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)', padding: '2rem', textAlign: 'center' }}>
          <img src="https://img.icons8.com/ios-filled/50/0b3d3b/camera.png" alt="Electronics" />
          <h3 style={{ marginTop: '1rem', color: '#0b3d3b' }}>Electronics</h3>
          <p>Get cameras, laptops, printers, and more on lease.</p>
        </div>
        <div style={{ backgroundColor: 'white', borderRadius: '12px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)', padding: '2rem', textAlign: 'center' }}>
          <img src="https://img.icons8.com/ios-filled/50/0b3d3b/gear.png" alt="Machinery" />
          <h3 style={{ marginTop: '1rem', color: '#0b3d3b' }}>Machinery</h3>
          <p>Construction and industrial equipment made easy to rent.</p>
        </div>
        <div style={{ backgroundColor: 'white', borderRadius: '12px', boxShadow: '0 4px 8px rgba(0,0,0,0.05)', padding: '2rem', textAlign: 'center' }}>
          <img src="https://img.icons8.com/ios-filled/50/0b3d3b/city-buildings.png" alt="Spaces" />
          <h3 style={{ marginTop: '1rem', color: '#0b3d3b' }}>Spaces</h3>
          <p>Find halls, shops, and offices available for lease near you.</p>
        </div>
      </section>

      <footer style={{ textAlign: 'center', padding: '2rem', backgroundColor: '#0b3d3b', color: 'white' }}>
        <p>© 2025 UrboLease. All rights reserved.</p>
      </footer>
    </div>
  );
};

export default HomePage;
